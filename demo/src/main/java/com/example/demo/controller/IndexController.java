package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author HSS
* @version 2021年4月3日 下午11:27:43
* @Description 首页api
*/
@Controller
@RequestMapping("/api/index")
public class IndexController {

	@RequestMapping("toIframe")
	public String toIndexIframe(){
		return "default";
	}
	
	@RequestMapping("toAddMenu")
	public String toAddMenu(){
		return "menuManager/addMenu";
	}
	
	@RequestMapping("toAddRole")
	public String toAddRole(){
		return "roleManager/addRole";
	}
	
	@RequestMapping("toAddUser")
	public String toAddUser(){
		return "userManager/addUser";
	}
}
