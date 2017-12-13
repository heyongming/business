package com.business.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.business.dao.IRedDotDao;
import com.business.entitys.redDot.ProductOperationReport;
@Repository("redDotDao")
public class RedDotDaoImpl implements IRedDotDao {

	@Resource
	private SqlSessionTemplate sessionTemplate;

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	@Override
	public int insertProductOperationReport(ProductOperationReport productOperationReport) {
		// TODO Auto-generated method stub
		
		 sessionTemplate.insert("redDot.insertProductOperationReport", productOperationReport);
		 return productOperationReport.getPorId();
	}

	@Override
	public int updateProductOperationReport(ProductOperationReport productOperationReport) {
		// TODO Auto-generated method stub
		return sessionTemplate.update("redDot.updateProductOperationReport", productOperationReport);
	}

	@Override
	public List<ProductOperationReport> selectWhere(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("redDot.selectWhere", map);
	}

}
