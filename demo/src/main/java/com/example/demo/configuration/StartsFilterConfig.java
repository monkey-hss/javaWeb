package com.example.demo.configuration;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.filter.AdminManagerFilter;

/**
* @author HSS
* @version 2021年4月1日 下午8:55:09
* @Description 过滤器配置
* Configuration 标签标识该类是一个配置类，说明该类相当于一个xml文件
* 如果有多个过滤器依次如下方式配置，只需把setOrder的值修改即可
*/
@Configuration
public class StartsFilterConfig {

	/**
	 * 配置过滤器
	 * @return
	 * FilterRegistrationBean 用来添加过滤器及配置过滤器的路径、执行顺序等
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean someFilterRegistration(){
		FilterRegistrationBean frb = new FilterRegistrationBean<>();
		frb.addUrlPatterns("/*");//配置该过滤器需要过滤的路径，/*说明所有路径都过滤
		frb.setFilter(backFilter());//添加写好的过滤器
		frb.setOrder(1);//说明各个过滤器的执行顺序
		return frb;
	}
	
	/**
	 * 系统后台过滤器
	 * @return
	 */
	public Filter backFilter(){
		return new AdminManagerFilter();
	}
}
