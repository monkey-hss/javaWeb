package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @author HSS
* @version 2021年4月3日 上午2:53:47
* @Description 类描述
*/
@Controller
@RequestMapping("/api/test")
public class TestController {

	@RequestMapping("/toIndex")
	public String test(){
		return "index";
	}
	
	@RequestMapping(value="/test2",method=RequestMethod.POST)
	@ResponseBody
	public boolean test2(String str){
		if(str.equals("")){
			return true;
		}else{
			return false;
		}
	}
}
