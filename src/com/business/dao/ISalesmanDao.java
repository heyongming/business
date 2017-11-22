package com.business.dao;

import java.util.List;
import java.util.Map;

import com.business.entitys.sales.Salesman;
import com.business.entitys.sales.SalesmanAndUser;
import com.business.entitys.sales.SalesmanSuccess;

public interface ISalesmanDao {
	int insertSaleSman(Salesman salesman);
	int delSaleSman(int salesmanId);
	Salesman selectById(int salesmanId);
	List<Salesman> getAll();
	List<Salesman> selectByName(String name);
	int insertSalesmanId(SalesmanAndUser salesmanAndUser);
	int update(Salesman salesman);
	int insertSuccesSalesMan(SalesmanSuccess salesmanSuccess);
	List<SalesmanSuccess> selectBySalesmanSuccessWhere(Map<String, Object> map);
}
