package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.pojo.systemPojo.UserInfo;
import com.example.demo.utils.UserContextUtil;

/**
* @author HSS
* @version 2021年4月1日 下午5:30:14
* @Description 登录页过滤器
* 思路：获取请求路径，如果在路径数组内的不过滤
*/
public class AdminManagerFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String notFilter [] = {"/api/loginController/toLogin","/api/img/checkCode","/api/img/getCode",
				"/api/userController/toAddUser","/api/userController/addUser",
				"/api/loginController/login","/api/userController/checkUserName"};
		String url = request.getRequestURI();
		boolean flag = checkUrl(notFilter,url);
		if(flag){
			UserInfo user = UserContextUtil.getUser();
			if(user == null){
				response.sendRedirect("/api/loginController/toLogin");
				return;
			}else{
				filterChain.doFilter(request, response);
			}
		}else{
			filterChain.doFilter(request, response);
		}
	}

	private boolean checkUrl(String[] notFilter, String url) {
		if(url.endsWith(".css") || url.endsWith(".js") || url.endsWith(".png") 
				|| url.endsWith(".gif") || url.endsWith(".jpg")){
			return false;
		}
		for(String str : notFilter){
			if(url.contains(str)){
				return false;
			}
		}
		return true;
	}

}
