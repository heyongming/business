package com.business.service;

import com.business.entitys.order.OrderForm;

public interface IOrderService {
	String addOrder(OrderForm orderForm);

	String saveOrder(OrderForm orderForm);
}
