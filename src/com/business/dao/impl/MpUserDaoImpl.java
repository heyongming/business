package com.business.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.business.dao.IMpUserDao;
import com.business.entitys.mp.MpUserEntity;

@Repository("mpUserDao")
public class MpUserDaoImpl implements IMpUserDao {
	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	@Resource
	private SqlSessionTemplate sessionTemplate;

	@Override
	public int insertMpUser(MpUserEntity mpUserEntity) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("mpUser.addUser", mpUserEntity);
	}

	@Override
	public MpUserEntity selectUserById(String openid) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("mpUser.byOpenId", openid);
	}

}
