package com.business.action.order;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import com.business.entitys.order.OrderForm;
import com.business.service.IOrderService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderAction extends ActionSupport implements ModelDriven<OrderForm> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2258648444083444451L;
	private OrderForm orderForm;
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Resource
	private IOrderService orderService;

	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	public OrderForm getOrderForm() {
		return orderForm;
	}

	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	public String addOrder() throws Exception {

		String jsonText = orderService.addOrder(orderForm);
		toJsonSteam(jsonText);
		return this.SUCCESS;
	}

	public String update() {
		String jsonText = orderService.saveOrderStatus(phone);
		toJsonSteam(jsonText);
		return this.SUCCESS;
	}

	public String getactivationCode() {
		String jsonText = orderService.saveOrderActivationCode(phone);
		toJsonSteam(jsonText);
		return this.SUCCESS;
	}

	public String getActivationCode() throws Exception {

		return super.execute();

	}

	private void toJsonSteam(String text) {
		try {
			bis = new ByteArrayInputStream(text.getBytes("GBK"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			bis = null;
			e.printStackTrace();
		}
	}

	@Override
	public OrderForm getModel() {
		// TODO Auto-generated method stub

		orderForm = new OrderForm();
		System.out.println(orderForm);

		return orderForm;
	}
}
