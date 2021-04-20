package com.example.demo.pojo.systemPojo;

import java.io.Serializable;
import java.math.BigInteger;

import lombok.Data;

/**
* @author HSS
* @version 2021年3月30日 下午9:08:39
* @Description 用户实体类
*/
@SuppressWarnings("serial")
@Data
public class UserInfo implements Serializable{

	@SuppressWarnings("unused")
	private static final long SERIALVERSIONUID = 1L;
	private BigInteger id;
	private String uid;
	private String userName;
	private String password;
	private String sex;
	private String age;
	private String name;
	private String createDate;
	private String createBody;
	private String updateDate;
	private String status;//账号状态
}
