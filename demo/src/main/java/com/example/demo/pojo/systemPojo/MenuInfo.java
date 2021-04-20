package com.example.demo.pojo.systemPojo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import lombok.Data;

/**
* @author HSS
* @version 2021年4月3日 下午2:42:31
* @Description 功能菜单实体类
*/
@SuppressWarnings("serial")
@Data
public class MenuInfo implements Serializable{
	
	@SuppressWarnings("unused")
	private static final long SERIALVERSIONUID = 1L;

	private BigInteger id;
	private String muuid;//uuid
	private String menuName;//菜单名称
	private String menuType;//菜单类型
	private String menuLevel;//菜单层级
	private String menuUrl;//菜单路径
	private String menuOrder;//菜单顺序
	private String isDelete;//是否删除
	private String menuParentId;//父菜单id
	private String menuParentName;//父菜单名称
	private List<MenuInfo> menuChildList;//子节点菜单
	private String createDate;//创建日期
	private String createBody;
	private String updateDate;//修改日期
}
