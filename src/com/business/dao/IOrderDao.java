package com.business.dao;

import com.business.entitys.order.OrderForm;

public interface IOrderDao {
 int insertOrder(OrderForm orderForm);
 int updateOrder(OrderForm orderForm);
}
