package com.business.action.order;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.user.User;
import com.business.job.MsgMeesage;
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
		if (userEntitys.equals(user.getUserName())) {
			ResultMessage resultMessage = new ResultMessage("-3", "false", "该用户不存在，请检查姓名或者请联系客服");
			String json = JSONObject.toJSONString(resultMessage);
			toJsonSteam(json);
			return Action.SUCCESS;
		}
		

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
