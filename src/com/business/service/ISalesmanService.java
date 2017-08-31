package com.business.service ;

import java.util.List;

import com.business.entitys.sales.Salesman;

public interface ISalesmanService {
	Salesman queryLogin(Salesman salesman);

	int saveSalesman(Salesman salesman);

	int delSalesman(int id);

	List<Salesman> getAllSalesman();

	Salesman querySalesmanById(int id);

	List<Salesman> querySalesmanByName(String name);

}
