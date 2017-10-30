package com.business.service;

import java.util.List;

import com.business.entitys.goods.GoodsList;
import com.business.entitys.order.OrderForm;
import com.business.entitys.service.ServiceTime;
import com.business.entitys.user.User;

public interface IServiceTimeService {

	/**
	 * @param user
	 *            购买的用户
	 * @param orderForm
	 *            当前订单
	 * @param goodsList
	 *            购买的物品
	 * @param isDanger
	 *            是否是高危物品
	 * @return
	 */
	String savePdf(User user, OrderForm orderForm, GoodsList goodsList, String isDanger);

	ServiceTime findServiceTimeEntity(User user, GoodsList goodsList);

	/**
	 * @param user
	 *            查询的用户
	 * @param goodsList
	 *            查询的商品
	 * @return 对应的时间
	 */
	ServiceTime findServiceUserEntity(User user, GoodsList goodsList);

	/**
	 * @param user
	 *            查询的用户
	 * 
	 * @return 对应的时间
	 */
	List<ServiceTime> findServiceUserEntityByUser(User user);

	/*
	 * 购买服务后每天减去一天的使用时间
	 * 
	 */
	int subSertviceTime();

	/*
	 * 修改服务期限
	 */
	int updateServiceTime(ServiceTime serviceTime);

	/*
	 * 获得全量数据
	 * 
	 */
	List<ServiceTime> findAllData();

	/*
	 * 根据主键获得相关数据
	 * 
	 */
	ServiceTime findDataById(int id);
	
	int deleteServiceTime(int id);
}
