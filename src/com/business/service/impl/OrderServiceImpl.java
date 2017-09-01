package com.business.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.business.dao.IOrderDao;
import com.business.entitys.ResultMessage;
import com.business.entitys.order.OrderForm;
import com.business.service.IOrderService;
import com.business.util.SnowflakeIdWorker;

@Repository("orderService")
public class OrderServiceImpl implements IOrderService {
	@Resource
	private IOrderDao orderDao;
	// 生成账单号
	@Resource
	private SnowflakeIdWorker snowflakeIdWorker;

	public SnowflakeIdWorker getSnowflakeIdWorker() {
		return snowflakeIdWorker;
	}

	public void setSnowflakeIdWorker(SnowflakeIdWorker snowflakeIdWorker) {
		this.snowflakeIdWorker = snowflakeIdWorker;
	}

	public IOrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public String addOrder(OrderForm orderForm) {
		// TODO Auto-generated method stub
		long id = snowflakeIdWorker.nextId();
		orderForm.setOrderSerialNumber(id + "");
		orderForm.setOrderStatus(1);
		System.out.println(orderForm);
		int flog = orderDao.insertOrder(orderForm);
		String result = null;
		ResultMessage message = null;
		if (flog > 0) {
			message = new ResultMessage("1", "true", "update Success");
		} else {
			message = new ResultMessage("-1", "false", "update fail");
		}
		result = JSONObject.toJSONString(message);
		return result;
	}

	@Override
	public String saveOrder(OrderForm orderForm) {
		// TODO Auto-generated method stub
		int flog = orderDao.updateOrder(orderForm);
		String result = null;
		ResultMessage message = null;
		if (flog > 0) {
			message = new ResultMessage("1", "true", "insert Success");
		} else {
			message = new ResultMessage("-1", "false", "insert fail");
		}
		result = JSONObject.toJSONString(message);
		return result;
	}

}
