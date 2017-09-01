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
	public String update()
	{
		return this.SUCCESS;
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
