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
import com.business.job.MsgMeesage;
import com.business.service.IOrderService;
import com.business.service.IUserService;
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
		String sessionVcKey = (String) session.get("vc_key");
		sessionVcKey = "";
		if (sessionVcKey == null) {
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
		// 拿取购买时的商品和购买的数量
		GoodsList goodsList = (GoodsList) session.get("buyGoodsList");
		OrderForm orderForm = (OrderForm) session.get("buyOrderFrom");

		String resultMsg = orderService.CheckGoodListAndOrderFrom(goodsList, orderForm, userEntitys);
		ResultMessage message = (ResultMessage) JSONObject.parseObject(resultMsg, ResultMessage.class);
		System.out.println(message);
		if (message.getSuccess().equals("false")) {
			System.out.println("进来了");
			toJsonSteam(resultMsg);
			return Action.SUCCESS;
		}
		Map<String, Object> map = orderService.generateOrder(goodsList, orderForm, userEntitys);
		System.out.println("生成的账单是" + map.get("buyOrder"));
		session.put("buyOderForm", (OrderForm) map.get("buyOrder"));	
		session.put("upGoodsList", (GoodsList) map.get("upGoodsList"));
		session.put("buyuser", userEntitys);
		ResultMessage resultMessage = new ResultMessage("100", "ok", "生成账单成功");
		String json = JSONObject.toJSONString(resultMessage);
		toJsonSteam(json);
		return super.execute();
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		user = new User();
		return user;
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
