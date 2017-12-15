package com.business.action.order;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.order.OrderActivationCode;
import com.business.entitys.order.OrderForm;
import com.business.entitys.user.User;
import com.business.service.IMpUserService;
import com.business.service.IOrderService;
import com.business.util.CheckErrorQiantaiUtill;
import com.business.util.SendMsg;
import com.cache.OrderCache;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderAction extends ActionSupport implements ModelDriven<OrderForm> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2258648444083444451L;
	private OrderForm orderForm;
	private String phone;
	private String isPc;

	public String getIsPc() {
		return isPc;
	}

	public void setIsPc(String isPc) {
		this.isPc = isPc;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Resource
	private IOrderService orderService;
	@Resource

	private IMpUserService mpUserService;

	public IMpUserService getMpUserService() {
		return mpUserService;
	}

	public void setMpUserService(IMpUserService mpUserService) {
		this.mpUserService = mpUserService;
	}

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

	/*
	 * public String update() { String jsonText =
	 * orderService.saveOrderStatus(phone); toJsonSteam(jsonText); return
	 * this.SUCCESS; }
	 */
	public String getactivationCode() {
		String jsonText = orderService.saveOrderActivationCode(phone);
		toJsonSteam(jsonText);
		return this.SUCCESS;
	}

	// 成功后的处理
	public String orderSuccess() {

		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		Map request = (Map) ActionContext.getContext().get("request");
		if (!CheckErrorQiantaiUtill.checkSession(session)) {
			if (isPc != null) {
				return "pcInput";
			}
			return this.INPUT;
		}
		GoodsList buyGoodsList = (GoodsList) session.get("buyGoodsList");
		User userEntitys = (User) session.get("buyuser");// 购买者
		OrderForm orderForm = (OrderForm) session.get("buyOrderResult");
		session.clear(); // 清理缓存

		OrderActivationCode orderActivationCode = orderService.doClosingTheDeal(orderForm);
		int flog = mpUserService.doActivationService(userEntitys, orderActivationCode);
		if (flog == 1) {
			if (isPc == null) {
				return Action.SUCCESS;
			} else {
				return Action.LOGIN;
			}

		} else {
			return this.INPUT;
		}
		

	}

	public String clearData() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session1 = request.getSession();
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		User user = (User) session.get("buyuser");
		String key = user.getUserId() + "";
		OrderCache.buyOrderResult.remove(key);
		OrderCache.buyuser.remove(key);
		OrderCache.goodsListMap.remove(key);
		OrderCache.msg.remove(key);
		OrderCache.orderFromMap.remove(key);
		OrderCache.upGoodsList.remove(key);

		session1.invalidate();
		ResultMessage resultMessage = new ResultMessage("1", "ture", "清理成功");
		toJsonSteam(JSONObject.toJSONString(resultMessage));
		return Action.SUCCESS;
	}

	public String getActivationCode() throws Exception {

		return super.execute();

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
