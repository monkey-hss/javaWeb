package com.example.demo.mapper.systemMapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.systemPojo.MenuInfo;

/**
* @author HSS
* @version 2021年4月3日 下午11:58:19
* @Description 类描述
*/
@Mapper
public interface MenuMapper {

	//新增菜单
	int addMenu(MenuInfo menu);

	//根据菜单名称查询父菜单id
	MenuInfo getMenuByParentName(String menuParentName);

	//校验菜单名称是否重复
	MenuInfo checkMenuName(String menuName);

}
