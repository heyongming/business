package com.business.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.business.dao.IGoodsListDao;
import com.business.dao.IOrderDao;
import com.business.entitys.ResultMessage;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.order.OrderActivationCode;
import com.business.entitys.order.OrderForm;
import com.business.service.IOrderService;
import com.business.temp.ResultOrderActivationCodeEntitys;
import com.business.util.RandomUtill;
import com.business.util.SnowflakeIdWorker;

@Repository("orderService")
public class OrderServiceImpl implements IOrderService {
	@Resource
	private IOrderDao orderDao;
	@Resource
	private IGoodsListDao goodsListDao;

	public IGoodsListDao getGoodsListDao() {
		return goodsListDao;
	}

	public void setGoodsListDao(IGoodsListDao goodsListDao) {
		this.goodsListDao = goodsListDao;
	}

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

			message = new ResultMessage("1", "true", "insert Success");
		} else {

			message = new ResultMessage("-1", "false", "insert fail");
		}
		result = JSONObject.toJSONString(message);
		return result;
	}

	@Override
	public String saveOrderStatus(String phone) {
		// TODO Auto-generated method stub
		OrderForm orderForm = orderDao.selectByphone(phone);
		System.out.println(orderForm);
		orderForm.setOrderStatus(orderForm.getOrderStatus() + 1);
		int flog = orderDao.updateOrder(orderForm);
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
	public boolean findIsbuy(String phone) {
		// TODO Auto-generated method stub
		OrderForm orderForm = orderDao.selectByphone(phone);
		if (orderForm == null) {
			return false;
		}
		return true;
	}

	@Override
	public String saveOrderActivationCode(String phone) {
		// TODO Auto-generated method stub
		OrderForm orderForm = orderDao.selectByphone(phone);
		orderForm.setOrderStatus(-1);
		orderDao.updateOrder(orderForm);
		OrderActivationCode orderActivationCode = new OrderActivationCode();
		orderActivationCode.setOrderSerialNumber(orderForm.getOrderSerialNumber());
		String activationCode = RandomUtill.randomUtil();
		int checkFlog = orderDao.checkActivationCode(activationCode);
		while (checkFlog != 0) {
			activationCode = RandomUtill.randomUtil();
			checkFlog = orderDao.checkActivationCode(activationCode);
		}

		orderActivationCode.setActivationCode(activationCode);
		orderActivationCode.setIsActivation("false");
		int flog = orderDao.addOrderActivationCode(orderActivationCode);
		String result = null;
		ResultOrderActivationCodeEntitys message = null;
		if (flog > 0) {
			GoodsList goodsList = goodsListDao.queryByGoodsId(orderForm.getGoodsId());
			message = new ResultOrderActivationCodeEntitys(orderForm.getOrderSerialNumber(), goodsList.getGoodsName(),
					activationCode);
			message.setSuccess("true");
			message.setErrMsg("insert success");
			message.setCode("1");
		} else {
			message = new ResultOrderActivationCodeEntitys();
			message.setSuccess("false");
			message.setErrMsg("insert fail");
			message.setCode("-1");
		}
		result = JSONObject.toJSONString(message);
		return result;
	}

}
