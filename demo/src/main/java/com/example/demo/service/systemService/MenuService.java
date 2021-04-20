package com.example.demo.service.systemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.kit.Constant;
import com.example.demo.mapper.systemMapper.MenuMapper;
import com.example.demo.pojo.ResponseVo;
import com.example.demo.pojo.systemPojo.MenuInfo;
import com.example.demo.utils.CommonUtils;

/**
* @author HSS
* @version 2021年4月3日 下午11:55:07
* @Description 菜单功能服务类
*/
@Service
@Transactional
public class MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	/**
	 * 新建功能菜单
	 * @param menu
	 * @return
	 */
	public ResponseVo addMenu(MenuInfo menu) {
		ResponseVo rv = new ResponseVo();
		menu.setCreateDate(CommonUtils.getDate());
		menu.setMuuid(CommonUtils.getUUID());
		menu.setIsDelete(Constant.UN_DELETE);
		int n = menuMapper.addMenu(menu);
		if(n > 0){
			rv.setFlag(true);
			rv.setResult("新建成功");
		}else{
			rv.setFlag(false);
			rv.setResult("新建失败");
		}
		return rv;
	}

	/**
	 * 根据菜单名称查询父菜单id
	 * @param menuParentName
	 * @return
	 */
	public MenuInfo getMenuByParentName(String menuParentName) {
		return menuMapper.getMenuByParentName(menuParentName);
	}

	/**
	 * 校验菜单名称是否存在
	 * @param menuName
	 * @return
	 */
	public MenuInfo checkMenuName(String menuName) {
		return menuMapper.checkMenuName(menuName);
	}

}
