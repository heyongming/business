package com.business.dao;

import java.util.List;
import java.util.Map;

import com.business.entitys.order.OrderActivationCode;
import com.business.entitys.order.OrderForm;

public interface IOrderDao {
	int insertOrder(OrderForm orderForm);

	int updateOrder(OrderForm orderForm);

	OrderForm selectByphone(String phone);

	/**
	 * @param orderActivationCode
	 * @return
	 */
	List<OrderForm> getAllData();

	/**
	 * @param orderActivationCode
	 * @return
	 */
	List<OrderForm> getDataByWhere(Map<String, Object> orderForm);

	int addOrderActivationCode(OrderActivationCode orderActivationCode);

	int checkActivationCode(String ActivationCode);

	OrderActivationCode checkActivationCodeApply(String ActivationCode);

	/**
	 * @param orderSerialNumber
	 *            传入即将被使用的激活码
	 * @return 是否修改成功
	 */
	int updatecheckStatus(String orderSerialNumber);
}
