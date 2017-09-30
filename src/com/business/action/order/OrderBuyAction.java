package com.business.action.order;

import java.util.Map;

import javax.annotation.Resource;

import com.business.entitys.goods.GoodsList;
import com.business.entitys.order.OrderForm;
import com.business.entitys.user.User;
import com.business.service.IOrderService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderBuyAction extends ActionSupport implements ModelDriven<OrderForm> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6207567020223225360L;
	private OrderForm orderForm;
	@Resource
	private IOrderService orderService;

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

	@Override
	public OrderForm getModel() {
		// TODO Auto-generated method stub
		orderForm = new OrderForm();
		return orderForm;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		GoodsList buyGoodsList = (GoodsList) session.get("buyGoodsList"); // 购买的商品
		OrderForm buyorderForm = (OrderForm) session.get("buyOrder");// 购买的时候的账单
		User userEntitys = (User) session.get("buyuser");// 购买者
		GoodsList upGoodsList = (GoodsList) session.get("upGoodsList");// 升级前的商品假如有的话
		String json = orderService.saveBuyoeder(buyGoodsList, buyorderForm, userEntitys, upGoodsList);
		System.out.println(json);
		return super.execute();
	}
}
