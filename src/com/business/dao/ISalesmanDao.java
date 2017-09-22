package com.business.dao;

import java.util.List;

import com.business.entitys.sales.Salesman;
import com.business.entitys.sales.SalesmanAndUser;

public interface ISalesmanDao {
	int insertSaleSman(Salesman salesman);
	int delSaleSman(int salesmanId);
	Salesman selectById(int salesmanId);
	List<Salesman> getAll();
	List<Salesman> selectByName(String name);
	int insertSalesmanId(SalesmanAndUser salesmanAndUser);
}
