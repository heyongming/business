package com.business.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.business.dao.ISalesmanDao;
import com.business.entitys.sales.Salesman;
import com.business.entitys.sales.SalesmanAndUser;

@Repository("salesmanDao")
public class SalesmanDaoImpl implements ISalesmanDao {
	@Resource
	private SqlSessionTemplate sessionTemplate;

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	@Override
	public int insertSaleSman(Salesman salesman) {
		// TODO Auto-generated method stub
		int id = sessionTemplate.insert("salesman.insert", salesman);

		return salesman.getUserId();
	}

	@Override
	public int delSaleSman(int salesmanId) {
		// TODO Auto-generated method stub
		return sessionTemplate.delete("salesman.delById", salesmanId);
	}

	@Override
	public Salesman selectById(int salesmanId) {
		// TODO Auto-generated method stub

		return sessionTemplate.selectOne("salesman.selectById", salesmanId);
	}

	@Override
	public List<Salesman> getAll() {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("salesman.getAll");
	}

	@Override
	public List<Salesman> selectByName(String name) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("salesman.selectByName", name);
	}

	@Override
	public int insertSalesmanId(SalesmanAndUser salesmanAndUser) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("salesman.insertSalesmanAndUser", salesmanAndUser);
	}

	@Override
	public int update(Salesman salesman) {
		// TODO Auto-generated method stub
		return sessionTemplate.update("salesman.update", salesman);
	}

}
