package com.business.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.business.dao.IUserDao;
import com.business.entitys.ResultMessage;
import com.business.entitys.user.User;
import com.business.service.IUserService;

@Repository("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;

	@Override
	public String saveUser(User user) {
		// TODO Auto-generated method stub
		int id = userDao.insertUser(user);
		
		ResultMessage message = null;
		if (id > 0) {
			message = new ResultMessage("1", "true", "insert Success");
		} else {
			message = new ResultMessage("-1", "false", "insert fail");
		}
	
		String resString = JSONObject.toJSONString(message);
		
		return resString;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findByUser(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
		
	}

	@Override
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		User tempUser=userDao.findByRdcode(user.getRdCode());
		if(tempUser==null)
		{
			return null;
		}
		tempUser.setPhone(user.getPhone());
		userDao.updateById(tempUser);
		return tempUser;
	}

}
