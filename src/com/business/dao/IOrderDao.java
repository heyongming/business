package com.business.dao;

import com.business.entitys.order.OrderActivationCode;
import com.business.entitys.order.OrderForm;

public interface IOrderDao {
	int insertOrder(OrderForm orderForm);

	int updateOrder(OrderForm orderForm);

	OrderForm selectByphone(String phone);

	int addOrderActivationCode(OrderActivationCode orderActivationCode);

	int checkActivationCode(String ActivationCode);

	OrderActivationCode checkActivationCodeApply(String ActivationCode);

	int updatecheckStatus(String orderSerialNumber);
}
