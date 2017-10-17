package com.business.action.order;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
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
		OrderForm buyorderForm = (OrderForm) session.get("buyOderForm");// 购买的时候的账单
		User userEntitys = (User) session.get("buyuser");// 购买者
		GoodsList upGoodsList = (GoodsList) session.get("upGoodsList");// 升级前的商品假如有的话
		Map<String, Object> map = orderService.saveBuyoeder(buyGoodsList, buyorderForm, userEntitys, upGoodsList);
		ResultMessage resultMessage = null;

		if (map != null) {
			session.put("msg", map.get("msg"));
			session.put("buyOrderResult", map.get("buyOrder"));
			resultMessage = new ResultMessage("1", "true", "成功");

		} else {
			resultMessage = new ResultMessage("-1", "false", "失败");

		}
		toJsonSteam(JSONObject.toJSONString(resultMessage));

		return super.execute();
	}

	private void toJsonSteam(String text) {
		try {
			bis = new ByteArrayInputStream(text.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			bis = null;
			e.printStackTrace();
		}
	}
}
