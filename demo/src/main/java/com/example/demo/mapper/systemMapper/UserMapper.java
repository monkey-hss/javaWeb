package com.example.demo.mapper.systemMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.systemPojo.UserInfo;

/**
* @author HSS
* @version 2021年3月31日 下午5:59:49
* @Description 用户管理持久层接口
*/
@Mapper
public interface UserMapper {

	//新增用户
	int addUser(UserInfo user);

	//用户登录
	UserInfo login(@Param("userName") String userName,@Param("password") String password);

	//校验用户名
	UserInfo checkUserName(String userName);

}
