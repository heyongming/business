package com.business.action.order;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.mp.MpUserEntity;
import com.business.entitys.order.OrderActivationCode;
import com.business.entitys.order.OrderForm;
import com.business.entitys.user.User;
import com.business.job.MsgMeesage;
import com.business.service.IGoodsOperationService;
import com.business.service.IOrderService;
import com.business.service.IUserService;
import com.cache.OrderCache;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderUserServiceAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -83190256848978555L;
	private User user;
	private InputStream bis;
	@Resource
	private IUserService userService;
	@Resource
	private IOrderService orderService;
	@Resource
	private IGoodsOperationService goodsOperationService;

	public IGoodsOperationService getGoodsOperationService() {
		return goodsOperationService;
	}

	public void setGoodsOperationService(IGoodsOperationService goodsOperationService) {
		this.goodsOperationService = goodsOperationService;
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

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		MpUserEntity mpUser = (MpUserEntity) session.get("mpUser");
		String sessionVcKey = (String) session.get("vc_key"); //验证码
		if (mpUser == null) {
			ResultMessage resultMessage = new ResultMessage("-4", "false", "微信拉取错误");
			String json = JSONObject.toJSONString(resultMessage);
			toJsonSteam(json);
			return Action.SUCCESS;
		}
		if (!(sessionVcKey.equals(user.getPassWord()))) {
			ResultMessage resultMessage = new ResultMessage("-1", "false", "验证码错误或者超时了");
			String json = JSONObject.toJSONString(resultMessage);
			toJsonSteam(json);
			return Action.SUCCESS;
		}
		User userEntitys = userService.checkUser(user);
		if (userEntitys == null) {
			ResultMessage resultMessage = new ResultMessage("-2", "false", "该推荐码不存在，有疑问请联系客服");
			String json = JSONObject.toJSONString(resultMessage);
			toJsonSteam(json);
			return Action.SUCCESS;
		}
		if (!(userEntitys.getUserName().equals(user.getUserName()))) {
			ResultMessage resultMessage = new ResultMessage("-3", "false", "该用户不存在，请检查姓名或者请联系客服");
			String json = JSONObject.toJSONString(resultMessage);
			toJsonSteam(json);
			return Action.SUCCESS;
		}
		userEntitys.setOpenId(mpUser.getOpenid());
		userService.updateUser(userEntitys);
		//检查是否是线下支付
		if (checkIsOffLinePay(userEntitys)) { 
			ResultMessage resultMessage = new ResultMessage("101", "ok", "该用户为线下支付用户");
			String json = JSONObject.toJSONString(resultMessage);
			toJsonSteam(json);
			return this.SUCCESS;
		}
		// 拿取购买时的商品和购买的数量
		GoodsList goodsList = (GoodsList) session.get("buyGoodsList");
		OrderForm orderForm = (OrderForm) session.get("buyOrderFrom");

		String resultMsg = orderService.CheckGoodListAndOrderFrom(goodsList, orderForm, userEntitys);
		ResultMessage message = (ResultMessage) JSONObject.parseObject(resultMsg, ResultMessage.class);
		if (message.getSuccess().equals("false")) {
			toJsonSteam(resultMsg);
			return Action.SUCCESS;
		}
		Map<String, Object> map = orderService.generateOrder(goodsList, orderForm, userEntitys);
		session.put("buyOderForm", (OrderForm) map.get("buyOrder"));
		session.put("upGoodsList", (GoodsList) map.get("upGoodsList"));
		session.put("buyuser", userEntitys);
		OrderCache.buyuser.put(userEntitys.getUserId() + "", userEntitys); // 存储到换成处
		OrderCache.goodsListMap.put(userEntitys.getUserId() + "", goodsList);// 存储到换成处
		OrderCache.orderFromMap.put(userEntitys.getUserId() + "", (OrderForm) map.get("buyOrder"));// 存储到换成处
		OrderCache.upGoodsList.put(userEntitys.getUserId() + "", (GoodsList) map.get("upGoodsList"));// 存储到换成处

		ResultMessage resultMessage = new ResultMessage("100", "ok", "生成账单成功");
		String json = JSONObject.toJSONString(resultMessage);
		toJsonSteam(json);
		return this.SUCCESS;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		user = new User();
		return user;
	}

	private boolean checkIsOffLinePay(User user) {
		OrderForm orderForm = orderService.findOffLinePayUser(user);
		if (orderForm != null) {
			ActionContext actionContext = ActionContext.getContext();
			Map session = actionContext.getSession();
			OrderActivationCode code = orderService.findActivaTionCode(orderForm.getOrderSerialNumber());
			GoodsList goodsList = JSONObject.parseObject(
					goodsOperationService.queryGoodsListById(orderForm.getGoodsList().getGoodsId()), GoodsList.class);
			if (user == null || goodsList == null || orderForm == null || code == null) {
				return false;
			}
			session.put("buyuser", user);
			session.put("buyGoodsList", goodsList);
			session.put("buyOrderResult", orderForm);
			session.put("msg", code);
			return true;
		}
		return false;
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
