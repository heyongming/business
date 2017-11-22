package com.business.action.customer;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.autoReply.ListUserQuery;
import com.business.entitys.autoReply.MessageManagement;
import com.business.entitys.user.User;
import com.business.service.ICustomerService;
import com.business.util.RandomUtill;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ListUserQueryAction extends ActionSupport implements ModelDriven<ListUserQuery> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5153326258682581235L;

	private ListUserQuery listUserQuery;
	@Resource
	private ICustomerService customerService;

	public ICustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	private InputStream bis;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) session.get("loginUser");

		String ip = getIpAddr(request);
		System.out.println(ip);
		listUserQuery.setIp(ip);
		if (user != null) {
			listUserQuery.setUserId(user.getUserId());
		}
		int flog = customerService.saveListUserQuery(listUserQuery);
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "插入成功");
		} else {
			resultMessage = new ResultMessage("-1", "false", "插入失败");
		}
		toJsonSteam(JSONObject.toJSONString(resultMessage));
		return this.SUCCESS;
	}

	public String findAutoReplyByTypeName() {
		/*
		List<MessageManagement> list = customerService
				.findMessageManagementByTypeData(messageManagement.getMessageType());

		if (list == null) {
			toJsonSteam("[]");
		} else {
			toJsonSteam(JSONObject.toJSONString(list));
		}
		*/
		return this.SUCCESS;
	}

	public String getFullAutoData() {
		List<ListUserQuery> list = customerService.findFullUserQueryData();
		toJsonSteam(JSONObject.toJSONString(list));
		return this.SUCCESS;
	}

	public String getFullMsgDataByIdAndIp() {
		List<ListUserQuery> list = customerService.findByUSerIdAndIpUserQueryData(listUserQuery.getUserId(),
				listUserQuery.getIp());
		if (list == null) {
			toJsonSteam("[]");
		} else {
			toJsonSteam(JSONObject.toJSONString(list));
		}

		return this.SUCCESS;
	}

	public String update() {
		/*
		 * int flog = customerService.updateAutoReply(autoReply); ResultMessage
		 * resultMessage = null; if (flog > 0) { resultMessage = new
		 * ResultMessage("1", "true", "修改成功"); } else { resultMessage = new
		 * ResultMessage("-1", "false", "修改失败"); }
		 * toJsonSteam(JSONObject.toJSONString(resultMessage));
		 */
		return this.SUCCESS;
	}

	public String delete() {
		/*
		 * int flog = customerService.delAutoReply(autoReply); ResultMessage
		 * resultMessage = null; if (flog > 0) { resultMessage = new
		 * ResultMessage("1", "true", "删除成功"); } else { resultMessage = new
		 * ResultMessage("-1", "false", "删除失败"); }
		 * toJsonSteam(JSONObject.toJSONString(resultMessage));
		 */
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

	// 拿到用户的真实IP地址
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		// System.out.println(ip);
		int indexOf = ip.indexOf(",");
		if (indexOf > 0) {
			return ip.substring(0, indexOf);
		}
		return ip;

	}

	@Override
	public ListUserQuery getModel() {
		// TODO Auto-generated method stub
		listUserQuery = new ListUserQuery();
		return listUserQuery;
	}

}
