package com.business.service;

import java.util.List;

import com.business.entitys.redDot.ProductOperationReport;

public interface IRedDotService {
	int insertRemindingPrice(ProductOperationReport productOperationReport);

	int updateRemindingPrice(ProductOperationReport productOperationReport);

	List<ProductOperationReport> selectAllDate(String tempId);

	ProductOperationReport selectDataById(String tempId, int porId);

	ProductOperationReport selectCtentById( int porId);

	int insertRunningReport(ProductOperationReport productOperationReport, List<Integer> list);

	int updateRunningReport(ProductOperationReport productOperationReport);

}
