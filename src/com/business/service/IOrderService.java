package com.business.service;

import com.business.entitys.order.OrderForm;

public interface IOrderService {
	String addOrder(OrderForm orderForm); //添加订单

	String saveOrderStatus(String phone); //更改状态
	
	boolean findIsbuy(String phone);//是否购买了商品
	String  saveOrderActivationCode(String phone); //保存激活码 并且返回对应的激活码
}
