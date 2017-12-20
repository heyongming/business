package com.business.action.order;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.order.OrderForm;
import com.business.entitys.user.User;
import com.business.service.IGoodsOperationService;
import com.business.service.IOrderService;
import com.business.service.IUserService;
import com.business.temp.ResultOrderActivationCodeEntitys;
import com.business.util.RandomUtill;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//线下支付
public class OfflinePaymentAction extends ActionSupport implements ModelDriven<OrderForm> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3562007631340174867L;
	private OrderForm orderForm;

	public OrderForm getOrderForm() {
		return orderForm;
	}

	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}

	@Resource
	private IOrderService orderService;
	@Resource
	private IUserService userService;
	@Resource
	private IGoodsOperationService goodsOperationService;
	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IGoodsOperationService getGoodsOperationService() {
		return goodsOperationService;
	}

	public void setGoodsOperationService(IGoodsOperationService goodsOperationService) {
		this.goodsOperationService = goodsOperationService;
	}

	@Override
	public OrderForm getModel() {
		// TODO Auto-generated method stub
		orderForm = new OrderForm();
		return orderForm;
	}
	/*
	 * 线下支付
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//根据推荐码获得对应user实体
		User user = userService.selectByRdCode(orderForm.getRdCode());
		//根据ID获得对应的商品实体
		String goodsListStr = goodsOperationService.queryGoodsListById(orderForm.getGoodsId());
		ResultMessage message = null;
		if (goodsListStr.length() < 10 || user == null) {
			message = new ResultMessage("-10", "false", "参数不合法");
			String json = JSONObject.toJSONString(message);
			toJsonSteam(json);
			return this.SUCCESS;
		}
		//PaymentMethod 为标志位 3 为线下支付 2 为在线支付
		orderForm.setPaymentMethod(3 + "");
		//这里的openId不是微信相关的 仅仅是作为流水号处理，以后会有用的
		orderForm.setOpenId(
				RandomUtill.randomNumUtil() + "" + RandomUtill.randomNumUtil() + "" + RandomUtill.randomNumUtil());
		//考虑到接口问题 暂时只有此类方法 把JSON转为对象
		GoodsList buyGoodsList = JSONObject.parseObject(goodsListStr, GoodsList.class);
		 //保存账单 返回map
		Map<String, Object> map = orderService.saveBuyoeder(buyGoodsList, orderForm, user, null);
		//激活码 前期需要用户自己去激活考虑到各种问题 后期 决定使用自动激活 ，所以激活码暂时用不到传递出去
		ResultOrderActivationCodeEntitys activationCodeEntitys = (ResultOrderActivationCodeEntitys) map.get("msg");
		//对应的账单
		OrderForm tempOrder = (OrderForm) map.get("buyOrder");
		if (tempOrder == null || tempOrder == null) {
			message = new ResultMessage("-6", "false", "账单生成失败,请联系管理员");
			String json = JSONObject.toJSONString(message);
			toJsonSteam(json);
			return this.SUCCESS;
		}
		message = new ResultMessage("1", "true", "生成账单成功");
		String json = JSONObject.toJSONString(message);
		toJsonSteam(json);
		return this.SUCCESS;
	}
	/*
	 * 获得所有线下支付的数据
	 */
	public String getOffPayFullData() {
		List<OrderForm> list = orderService.findOffLinePayAll();
		String msg = "";
		if (list == null) {
			msg = "[]";
		} else {
			msg = JSONObject.toJSONString(list);
		}
		toJsonSteam(msg);
		return this.SUCCESS;
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
