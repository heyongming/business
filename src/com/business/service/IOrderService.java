package com.business.service;

import java.util.Map;

import com.business.entitys.goods.GoodsList;
import com.business.entitys.order.OrderActivationCode;
import com.business.entitys.order.OrderForm;
import com.business.entitys.user.User;

public interface IOrderService {
	String addOrder(OrderForm orderForm); // 添加订单

	String saveOrderStatus(String phone); // 更改状态

	boolean findIsbuy(String phone);// 是否购买了商品

	String saveOrderActivationCode(String phone); // 保存激活码 并且返回对应的激活码

	String findData();// 获取全部数据

	String findDataBywhere(OrderForm orderForm);// 条件查询数据

	/**
	 * 此方法是用来购买商品检测用户购买是否达到上限，或者没到下限
	 * 
	 * @param goodsList
	 *            购买的商品信息
	 * @param orderForm
	 *            购买时商品信息
	 * @param user
	 *            购买书的用户信息
	 * @return 相关提示
	 */
	String CheckGoodListAndOrderFrom(GoodsList goodsList, OrderForm orderForm, User user);

	/**
	 * 此方法是用来购买商品检测用户购买的商品是否可以升级并且生成相应的订单
	 * 
	 * @param goodsList
	 *            购买的商品信息
	 * @param orderForm
	 *            购买时商品信息
	 * @param user
	 *            购买书的用户信息
	 * @return 相关提示
	 */
	Map<String, Object> generateOrder(GoodsList goodsList, OrderForm orderForm, User user);

	/**
	 * 生成对应的详细订单做准备
	 * 
	 * @param buyGoodsList
	 *            购买的商品
	 * @param buyorderForm
	 *            购买的时候的账单
	 * @param userEntitys
	 *            购买者
	 * @param upGoodsList
	 *            升级前的商品 假如有的话
	 * @return
	 */
	Map<String, Object> UpgradeGoodListAndchekOrder(GoodsList goodsList, OrderForm orderForm, User user);

	/**
	 * @param buyGoodsList
	 *            购买的商品
	 * @param buyorderForm
	 *            购买的时候的账单
	 * @param userEntitys
	 *            购买者
	 * @param upGoodsList
	 *            升级前的商品 假如有的话
	 * @return
	 */
	Map<String, Object> saveBuyoeder(GoodsList buyGoodsList, OrderForm buyorderForm, User userEntitys, GoodsList upGoodsList);
	
	OrderActivationCode doClosingTheDeal(OrderForm orderForm);
}
