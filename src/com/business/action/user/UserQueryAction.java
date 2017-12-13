package com.business.action.user;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.json.JsonObject;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.service.ServiceTime;
import com.business.entitys.user.User;
import com.business.service.IServiceTimeService;
import com.business.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserQueryAction extends ActionSupport implements ModelDriven<User> {
	@Resource
	private IUserService userService;
	@Resource
	private IServiceTimeService serviceTimeService;

	public IServiceTimeService getServiceTimeService() {
		return serviceTimeService;
	}

	public void setServiceTimeService(IServiceTimeService serviceTimeService) {
		this.serviceTimeService = serviceTimeService;
	}

	private InputStream bis;

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

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		user = new User();
		return user;
	}

	public String getAllData() {
		List<User> list = userService.getFullData();
		String json = JSONObject.toJSONString(list);
		toJsonSteam(json);
		return this.SUCCESS;
	}

	public String getUserById() {
		if (user == null) {
			toJsonSteam("[]");
			return this.SUCCESS;
		}
		User findUser = userService.findByUser(user.getUserId());
		toJsonSteam(JSONObject.toJSONString(findUser));
		return this.SUCCESS;
	}

	public String getUserData() {
		if (user == null) {

			return this.INPUT;
		}
		Map request = (Map) ActionContext.getContext().get("request");
		User findUser = userService.findByUser(user.getUserId());
		List<ServiceTime> list = serviceTimeService.findServiceUserEntityByUser(findUser);
		if (findUser == null) {
			return this.INPUT;
		}

		request.put("user", findUser);
		request.put("serviceList", list);

		return this.SUCCESS;
	}

	private int goodsId;

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getBuyGoodsUser() {
		List<User> list=serviceTimeService.findBuyGoodsUser(goodsId);
		if(list==null)
		{
			toJsonSteam("[]");
		}
		else
		{
			toJsonSteam(JSONObject.toJSONString(list));
		}
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
