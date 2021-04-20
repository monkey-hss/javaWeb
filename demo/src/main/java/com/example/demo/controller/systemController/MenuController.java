package com.example.demo.controller.systemController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.ResponseVo;
import com.example.demo.pojo.systemPojo.MenuInfo;
import com.example.demo.service.systemService.MenuService;
import com.example.demo.utils.UserContextUtil;

/**
* @author HSS
* @version 2021年4月3日 下午2:41:15
* @Description 功能菜单api
*/
@Controller
@RequestMapping("/api/menuController")
public class MenuController {
	
	private ResponseVo rv = new ResponseVo();
	@Autowired
	private MenuService menuService;

	/**
	 * 校验菜单名是否重复
	 * @param menuName
	 * @return
	 */
	@RequestMapping("/checkMenuName")
	@ResponseBody
	public ResponseVo checkMenuName(String menuName){
		MenuInfo menu = menuService.checkMenuName(menuName);
		if(menu != null){
			rv.setFlag(false);
			rv.setResult("菜单名称已存在");
		}else{
			rv.setFlag(true);
		}
		return rv;
	}
	
	/**
	 * 新增菜单
	 * @param menu
	 * @return
	 */
	@RequestMapping("/addMenu")
	@ResponseBody
	public ResponseVo addFunction(MenuInfo menu){
		menu.setCreateBody(UserContextUtil.getUser().getUserName());
		try {
			//新增前根据父菜单名称查询父菜单id
			MenuInfo menu2 = menuService.getMenuByParentName(menu.getMenuParentName());
			if(menu2 != null){
				menu.setMenuParentId(menu2.getMuuid());
			}
			rv = menuService.addMenu(menu);
		} catch (Exception e) {
			e.printStackTrace();
			rv.setFlag(false);
			rv.setResult("创建失败");
		}
		return rv;
	}
	
	/**
	 * 根据用户权限查询功能菜单列表
	 * @return
	 */
	@RequestMapping("/getMenuList")
	@ResponseBody
	public ResponseVo getMenuList(){
		//获取当前登录用户名
		String userName = UserContextUtil.getUser().getUserName();
		if("admin".equals(userName)){
			//menuService.getMenuList();
		}else{
			//menuService.getMenuByUserName(userName);
		}
		return rv;
	}
}
