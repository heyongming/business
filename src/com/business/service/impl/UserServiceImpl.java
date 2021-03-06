package com.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		User tempUser = userDao.findByRdcode(user.getRdCode());
		if (tempUser == null) {
			return null;
		}
		tempUser.setPhone(user.getPhone());
		userDao.updateById(tempUser);
		return tempUser;
	}

	@Override
	public User selectByRdCode(String rdCode) {
		// TODO Auto-generated method stub
		return userDao.findByRdcode(rdCode);
	}

	@Override
	public List<User> getFullData() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();

		return userDao.selectBywhere(map);

	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub

		return userDao.updateById(user);
	}

	@Override
	public int delUser(User user) {
		// TODO Auto-generated method stub
		return userDao.delete(user);
	}

	@Override
	public User findOpenIdToUser(String openId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("findOpenIdToService", "检测改用户是否可以享有该服务");
		map.put("findOpenId", openId);

		List<User> list = userDao.selectBywhere(map);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public User fingUserByIdcard(String idCard) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("findUserByIdcard", "查找身份证对应的User");
		map.put("findIdcard", idCard);
		List<User> list = userDao.selectBywhere(map);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
