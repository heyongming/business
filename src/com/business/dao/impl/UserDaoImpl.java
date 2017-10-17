package com.business.dao.impl;

import java.util.List;
import java.util.Map;

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

		return sessionTemplate.update("user.updateByid", user);
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

	@Override
	public List<User> selectBywhere(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("user.selectUserByWhere", map);
	}

}
