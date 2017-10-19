package com.business.dao.impl;

import java.util.List;
import java.util.Map;

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
		List<OrderForm> list=sessionTemplate.selectList("order.selectByphone", phone);
		if(list.size()>0)
		{
			return list.get(0);
		}
		return null;
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

	@Override
	public OrderActivationCode checkActivationCodeApply(String ActivationCode) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("order.checkActivationCodeApply", ActivationCode);
	}

	@Override
	public int updatecheckStatus(String orderSerialNumber) {
		// TODO Auto-generated method stub
		return sessionTemplate.update("order.updatecheckStatus", orderSerialNumber);
	}

	@Override
	public List<OrderForm> getAllData() {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("order.byAlldata");
	}

	@Override
	public List<OrderForm> getDataByWhere(Map<String, Object> orderForm) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("order.selectByWhere", orderForm);
	}

	@Override
	public List<OrderActivationCode> selectActivationCodeBywhere(Map<String, Object> map) {
		// TODO Auto-generated method stub

		return sessionTemplate.selectList("order.selectActivationCodeBywhere", map);
	}

}
