package com.business.service;

import java.util.List;

import com.business.entitys.sales.Salesman;
import com.business.entitys.user.User;

public interface ISalesmanService {
	Salesman queryLogin(Salesman salesman);

	int saveSalesman(Salesman salesman);

	int delSalesman(int id);

	int updateSaleman(Salesman salesman);

	List<Salesman> getAllSalesman();

	Salesman querySalesmanById(int id);

	List<Salesman> querySalesmanByName(String name);

	User saveUser(User user, int salesmanId);
}
