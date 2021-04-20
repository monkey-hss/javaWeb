package com.example.demo.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.pojo.systemPojo.UserInfo;

/**
* @author HSS
* @version 2021年4月1日 下午5:52:33
* @Description 用户上下文对象，设置和获取httpSession中登录的用户
* Conmpont注解用于将普通pojo实例化到spring容器中
*/
@Component
public class UserContextUtil {

	private static final String LOGIN_USER = "user";
	
	public static void setUser(UserInfo sysUser,HttpSession session){
		session.setAttribute(LOGIN_USER, sysUser);
	}
	
	public static UserInfo getUser(HttpSession session){
		return (UserInfo)session.getAttribute(LOGIN_USER);
	}
	
	public static HttpServletRequest getRequest(){
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		return requestAttributes.getRequest();
	}
	
	public static HttpSession getSession(){
		return getRequest().getSession();
	}
	
	public static UserInfo getUser(){
		return (UserInfo)getSession().getAttribute(LOGIN_USER);
	}
	
	public static void removeUser(){
		getSession().setAttribute(LOGIN_USER, null);
	}
}
