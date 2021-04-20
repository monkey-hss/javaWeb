package com.example.demo.service.systemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.kit.Constant;
import com.example.demo.mapper.systemMapper.UserMapper;
import com.example.demo.pojo.ResponseVo;
import com.example.demo.pojo.systemPojo.UserInfo;
import com.example.demo.utils.CommonUtils;

/**
* @author HSS
* @version 2021年3月31日 下午4:15:55
* @Description 用户类服务层
*/
@Service
@Transactional
public class UserService {
	
	private ResponseVo resVo = new ResponseVo();

	@Autowired
	private UserMapper userMapper;
	/**
	 * 新建用户信息
	 * @param user
	 * @return
	 */
	public ResponseVo addUser(UserInfo user) throws Exception{
		user.setUid(CommonUtils.getUUID());
		user.setCreateDate(CommonUtils.getDate());
		user.setStatus(Constant.USER_STATUS);//默认状态正常
		int addUser = userMapper.addUser(user);
		if(addUser > 0){
			resVo.setFlag(true);
			resVo.setResult("注册成功");
		}else{
			resVo.setFlag(false);
			resVo.setResult("注册失败");
		}
		return resVo;
	}
	
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @return
	 */
	public ResponseVo login(String userName, String password) {
		UserInfo user = userMapper.login(userName,password);
		if(user != null){
			resVo.setFlag(true);
			resVo.setObj(user);
			resVo.setResult("登录成功");
		}else{
			resVo.setFlag(false);
			resVo.setResult("登录失败");
			resVo.setObj(user);
		}
		return resVo;
	}

	/**
	 * 校验用户名
	 * @param userName
	 * @return
	 */
	public ResponseVo checkUserName(String userName) {
		UserInfo user = userMapper.checkUserName(userName);
		if(user == null){
			resVo.setFlag(true);
		}else{
			resVo.setFlag(false);
			resVo.setResult("用户名已存在");
		}
		return resVo;
	}

}
