package com.business.dao;

import java.util.List;
import java.util.Map;

import com.business.entitys.redDot.ProductOperationReport;

public interface IRedDotDao {
	int insertProductOperationReport(ProductOperationReport productOperationReport);
	int updateProductOperationReport(ProductOperationReport productOperationReport);
	List<ProductOperationReport> selectWhere(Map<String, Object> map);
}
