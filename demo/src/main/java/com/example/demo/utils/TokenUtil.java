package com.example.demo.utils;

import org.springframework.util.DigestUtils;

/**
* @author HSS
* @version 2021年4月7日 下午6:13:16
* @Description 单例模式生成token工具类
* DigestUtils 算法工具类
*/
public class TokenUtil {

	//构造器私有化
	private TokenUtil(){}
	
	private static final TokenUtil token = new TokenUtil();
	
	public static TokenUtil getInstance(){
		return token;
	}
	
	public String getToken(String...strings){
		long timestamp = System.currentTimeMillis();
		String tokenMeta = "";
		for(String s : strings){
			tokenMeta = tokenMeta + s;
		}
		tokenMeta = tokenMeta + timestamp;
		String token = DigestUtils.md5DigestAsHex(tokenMeta.getBytes());
		return token;
	}
}
