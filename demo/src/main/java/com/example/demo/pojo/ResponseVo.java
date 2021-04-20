package com.example.demo.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
* @author HSS
* @version 2021年3月31日 下午4:01:17
* @Description 返回结果封装实体类
*/
@SuppressWarnings("serial")
@Data
public class ResponseVo implements Serializable{
	
	@SuppressWarnings("unused")
	private static final long SERIALVERSIONUID = 1L;

	private String message;//返回信息
	private String result;//返回结果
	private boolean flag;//返回状态
	private Object obj;//返回对象
	private List<?> list;//返回对象集合
	private List<String> strList;//返回信息集合
}
