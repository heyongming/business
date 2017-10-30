package com.business.action.user;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.user.User;
import com.business.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserCurdAction extends ActionSupport implements ModelDriven<User> {
	@Resource
	private IUserService userService;
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

	public String update() {
		if (user == null) {
			toJsonSteam("[]");
			return this.SUCCESS;
		}
		User findUser = userService.findByUser(user.getUserId());
		if(findUser==null)
		{
			toJsonSteam("[]");
			return this.SUCCESS;
		}
		findUser.setUserName(user.getUserName());
		findUser.setIdCard(user.getIdCard());
		int flog = userService.updateUser(findUser);
		ResultMessage message = null;

		if (flog > 0) {
			message = new ResultMessage("1", "true", "update Success");
		} else {
			message = new ResultMessage("-1", "false", "update over");
		}
		String json = JSONObject.toJSONString(message);
		toJsonSteam(json);
		return this.SUCCESS;
	}
	public String delete()
	{
		if (user == null) {
			toJsonSteam("[]");
			return this.SUCCESS;
		}
		User findUser = userService.findByUser(user.getUserId());
		if(findUser==null)
		{
			toJsonSteam("[]");
			return this.SUCCESS;
		}
		
		int flog = userService.delUser(findUser);
		ResultMessage message = null;

		if (flog > 0) {
			message = new ResultMessage("1", "true", "delete Success");
		} else {
			message = new ResultMessage("-1", "false", "delete over");
		}
		String json = JSONObject.toJSONString(message);
		toJsonSteam(json);
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
