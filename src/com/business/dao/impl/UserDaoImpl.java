package com.business.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.business.dao.IUserDao;
import com.business.entitys.user.User;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	@Resource
	private SqlSessionTemplate sessionTemplate;

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		System.out.println(user);
		int flog = sessionTemplate.insert("user.addUser", user);
		if (flog > 0) {
			return user.getUserId();
		}
		return 0;
	}

}
