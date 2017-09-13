package com.business.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.business.dao.IMpServiceDao;
import com.business.dao.IMpUserDao;
import com.business.entitys.mp.MpService;
import com.business.entitys.mp.MpUserEntity;

@Repository("mpServiceDao")
public class MpServiceDaoImpl implements IMpServiceDao {
	@Resource
	private SqlSessionTemplate sessionTemplate;

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	@Override
	public int insertMpSerVice(MpService mpService) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("mpService.addMpService", mpService);
	}

}
