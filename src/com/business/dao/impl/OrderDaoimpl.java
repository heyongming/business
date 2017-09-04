package com.business.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.business.dao.IOrderDao;
import com.business.entitys.order.OrderActivationCode;
import com.business.entitys.order.OrderForm;

@Repository("orderDao")
public class OrderDaoimpl implements IOrderDao {
	@Resource
	private SqlSessionTemplate sessionTemplate;

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	@Override
	public int insertOrder(OrderForm orderForm) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("order.addOrder", orderForm);
	}

	@Override
	public int updateOrder(OrderForm orderForm) {
		// TODO Auto-generated method stub
		return sessionTemplate.update("order.updateOrder", orderForm);
	}

	@Override
	public OrderForm selectByphone(String phone) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("order.selectByphone", phone);
	}

	@Override
	public int addOrderActivationCode(OrderActivationCode orderActivationCode) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("order.addActivationCode", orderActivationCode);
	}

	@Override
	public int checkActivationCode(String ActivationCode) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("order.checkActivationCode", ActivationCode);
	}

}
