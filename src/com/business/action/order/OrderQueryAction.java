package com.business.action.order;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.order.OrderForm;
import com.business.service.IOrderService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderQueryAction extends ActionSupport implements ModelDriven<OrderForm> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7021836652001755033L;
	@Resource
	private IOrderService orderService;
	private OrderForm orderForm;
	private InputStream bis;

	public OrderForm getOrderForm() {
		return orderForm;
	}

	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}

	private void toJsonSteam(String text) {
		try {
			bis = new ByteArrayInputStream(text.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			bis = null;
			e.printStackTrace();
		}
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	/**
	 * 拿取全部数据
	 * 
	 * @return
	 */
	public String getAllData() {
		String json = orderService.findData();

		toJsonSteam(json);
		return Action.SUCCESS;
	}

	public String getWhereData() {
		System.out.println(orderForm);
		String json = orderService.findDataBywhere(orderForm);
		System.out.println(json + "!!!!");
		toJsonSteam(json);
		return Action.SUCCESS;
	}

	@Override
	public OrderForm getModel() {
		// TODO Auto-generated method stub
		orderForm = new OrderForm();
		return orderForm;
	}
}
