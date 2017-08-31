package com.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.business.dao.ISalesmanDao;
import com.business.entitys.sales.Salesman;
import com.business.service.ISalesmanService;

@Repository("salesmanService")
public class SalesmanServiceImpl implements ISalesmanService {
	@Resource
	ISalesmanDao salesmanDao;

	public ISalesmanDao getSalesmanDao() {
		return salesmanDao;
	}

	public void setSalesmanDao(ISalesmanDao salesmanDao) {
		this.salesmanDao = salesmanDao;
	}

	@Override
	public Salesman queryLogin(Salesman salesman) {
		// TODO Auto-generated method stub
		
		Salesman sale = salesmanDao.selectById(salesman.getUserId());
		if (sale == null) {
			return null;
		}
		if (sale.getPassWord().equals(salesman.getPassWord())) {
			return salesmanDao.selectById(salesman.getUserId());

		}
		return null;
	}

	@Override
	public int saveSalesman(Salesman salesman) {
		// TODO Auto-generated method stub
		int id = salesmanDao.insertSaleSman(salesman);
		return id;
	}

	@Override
	public int delSalesman(int id) {
		// TODO Auto-generated method stub
		return salesmanDao.delSaleSman(id);
	}

	@Override
	public List<Salesman> getAllSalesman() {
		// TODO Auto-generated method stub
		return salesmanDao.getAll();
	}

	@Override
	public Salesman querySalesmanById(int id) {
		// TODO Auto-generated method stub
		return salesmanDao.selectById(id);
	}

	@Override
	public List<Salesman> querySalesmanByName(String name) {
		// TODO Auto-generated method stub
		return salesmanDao.selectByName(name);
	}

}
