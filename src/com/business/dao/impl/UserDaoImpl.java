package com.business.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.business.dao.IUserDao;
import com.business.entitys.user.User;
import com.business.entitys.user.UserBuyTemp;

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

	@Override
	public User selectByIdCard(UserBuyTemp idCard) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("user.selectByIdCard", idCard);
	}

	@Override
	public int updateById(User user) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("user.updateByid", user);
	}

	@Override
	public User findByRdcode(String rdCode) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("user.selectRdCode", rdCode);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("user.selectById", id);
	}

}
