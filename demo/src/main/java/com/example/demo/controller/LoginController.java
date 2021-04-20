package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.ResponseVo;
import com.example.demo.pojo.systemPojo.UserInfo;
import com.example.demo.service.systemService.UserService;
import com.example.demo.utils.UserContextUtil;

/**
* @author HSS
* @version 2021年3月30日 下午9:20:54
* @Description 登录功能接口
*/
@Controller
@RequestMapping("/api/loginController")
public class LoginController {

	@Autowired
	private UserService UserService;
	
	/**
	 * 跳转登录页
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "login";
	}
	
	/**
	 * 用户登录接口
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public ResponseVo login(String userName,String password,HttpSession session){
		ResponseVo rv = new ResponseVo();
		try{
			rv = UserService.login(userName, password);
			UserContextUtil.setUser((UserInfo)rv.getObj(), session);
		}catch(Exception e){
			e.printStackTrace();
			rv.setFlag(false);
			rv.setResult("登录失败");
			return rv;
		}
		return rv;	
	}
	
	/**
	 * 用户退出登录
	 * @return
	 */
	@RequestMapping("/logOut")
	public String logOut(){
		UserContextUtil.removeUser();
		return "login";
	}
}
