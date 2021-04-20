package com.example.demo.pojo.systemPojo;

import java.io.Serializable;
import java.math.BigInteger;

import lombok.Data;

/**
* @author HSS
* @version 2021年4月3日 下午6:01:26
* @Description 角色实体类
*/
@SuppressWarnings("serial")
@Data
public class RoleInfo implements Serializable{

	@SuppressWarnings("unused")
	private static final long SERIALVERSIONUID = 1L;
	private BigInteger id;
	private String ruuid;
	private String roleName;
}
