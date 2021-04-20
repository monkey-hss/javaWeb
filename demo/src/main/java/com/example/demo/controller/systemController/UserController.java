package com.example.demo.controller.systemController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.ResponseVo;
import com.example.demo.pojo.systemPojo.UserInfo;
import com.example.demo.service.systemService.UserService;

/**
* @author HSS
* @version 2021年3月31日 下午3:52:09
* @Description 用户管理
*/
@Controller
@RequestMapping("/api/userController")
public class UserController {

	private ResponseVo  resVo = new ResponseVo();
	@Autowired
	private UserService userService;
	
	/**
	 * 跳转用户注册页
	 * @return
	 */
	@RequestMapping("/toAddUser")
	public String toAddUser(){
		return "userManager/addUser";
	}
	
	/**
	 * 校验用户名
	 * @param userName
	 * @return
	 */
	@RequestMapping(value="/checkUserName",method=RequestMethod.POST)
	@ResponseBody
	public ResponseVo checkUserName(String userName){
		return userService.checkUserName(userName);
	}
	/**
	 * 用户注册
	 * @param user
	 */
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	@ResponseBody
	public ResponseVo addUser(UserInfo user,HttpSession session){
		UserInfo user2 = (UserInfo)session.getAttribute("user");
		user.setCreateBody(user2.getUserName());
		try {
			 resVo = userService.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resVo;
	}
}
