package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.interceptor.AuthenticationInterceptor;

/**
* @author HSS
* @version 2021年4月5日 下午5:29:59
* @Description webMvc配置类
*/
@SuppressWarnings("deprecation")
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	private AuthenticationInterceptor authenInterceptor;

	//添加拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authenInterceptor)
				.addPathPatterns("/api/**");
	}

	//配置跨域
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")//根据该字段判断是否允许该请求访问
				.allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
				.allowCredentials(true)//用户是否可以发送、处理cookie
				.maxAge(3600);
	}

	
}
