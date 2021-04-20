package com.example.demo.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.annotation.AuthToken;
import com.example.demo.kit.Constant;

/**
* @author HSS
* @version 2021年4月5日 下午5:15:24
* @Description token鉴权拦截器
*/
@Component
public class AuthenticationInterceptor implements HandlerInterceptor{
	
	//存放鉴权信息头名称
	private String httpHeaderName = "Authorization";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		//如果不是映射的方法直接返回
		if(!(handler instanceof HandlerMethod)){
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		Method method = handlerMethod.getMethod();
		//校验方法上是否打上token注解
		if(method.getAnnotation(AuthToken.class) != null
				|| handlerMethod.getBeanType().getAnnotation(AuthToken.class) != null){
			//校验token
			//String token = request.getHeader(Constant.HEAD_TOKEN);
			System.out.println("ssssss");
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
