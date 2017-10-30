package com.business.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.business.dao.IServiceTimeDao;
import com.business.entitys.service.ServiceTime;

@Repository("serviceTimeDao")
public class ServiceTimeDaoImpl implements IServiceTimeDao {
	@Resource
	private SqlSessionTemplate sessionTemplate;

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	@Override
	public int insert(ServiceTime serviceTime) {
		// TODO Auto-generated method stub
		int id = sessionTemplate.insert("service.insertServiceTime", serviceTime);
		return id;
	}

	@Override
	public List<ServiceTime> selectByWhere(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("service.selectBywehre", map);

	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return sessionTemplate.delete("service.delete", id);
	}

	@Override
	public int update(ServiceTime serviceTime) {
		// TODO Auto-generated method stub
		return sessionTemplate.update("service.updateServiceTime", serviceTime);
	}

	@Override
	public int updateBySubService() {
		// TODO Auto-generated method stub
		return sessionTemplate.update("service.updateBySubService");
	}

}
