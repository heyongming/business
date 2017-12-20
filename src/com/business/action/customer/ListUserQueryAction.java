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

/**
 * 用户自助列表的Action
 * 
 * @ActionSupport 为struts2的提供的上下文的一个类
 * @ModelDriven 该方法返回一个用于接收用户输入数据的模型对象。
 */
public class ListUserQueryAction extends ActionSupport implements ModelDriven<ListUserQuery> {
	/**
	 * 序列化的UID
	 */
	private static final long serialVersionUID = 5153326258682581235L;
	// 用户自助列表的对应的实体类
	private ListUserQuery listUserQuery;
	/*
	 * 注入对应的Service层
	 */
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

	/*
	 * @ModelDriven 需要实现的方法
	 * 
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	@Override
	public ListUserQuery getModel() {
		// TODO Auto-generated method stub
		listUserQuery = new ListUserQuery();
		return listUserQuery;
	}

	/*
	 * AJAX处理完毕返回的流
	 */
	private InputStream bis;

	/*
	 * 默认的处理的方法 执行添加操作 入口与struts_Customer.xml配置文件对应
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//拿到struts2的上下文配置
		ActionContext actionContext = ActionContext.getContext();  
		//拿到session(解耦)
		Map session = actionContext.getSession();				
		//拿到request(耦合)
		HttpServletRequest request = ServletActionContext.getRequest(); 
		//拿到request(耦合)
		User user = (User) session.get("loginUser");                  
		//拿到用户的真实IP
		String ip = getIpAddr(request);								
		listUserQuery.setIp(ip);
		if (user != null) {							
			//把登录后的用户做记录
			listUserQuery.setUserId(user.getUserId());				
		}
		//执行service的保存操作
		int flog = customerService.saveListUserQuery(listUserQuery);
		// 返回json的实体类
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "插入成功");
		} else {
			resultMessage = new ResultMessage("-1", "false", "插入失败");
		}
		// 把对应的JAVA实体类 转换成json格式最后转成流传给前端
		toJsonSteam(JSONObject.toJSONString(resultMessage));
		//处理完毕
		return this.SUCCESS;
	}

	public String findAutoReplyByTypeName() {
		/*
		 * List<MessageManagement> list = customerService
		 * .findMessageManagementByTypeData(messageManagement.getMessageType());
		 * 
		 * if (list == null) { toJsonSteam("[]"); } else {
		 * toJsonSteam(JSONObject.toJSONString(list)); }
		 */
		return this.SUCCESS;
	}
	/*
	 * 执行查找的操作 获得ListUserQuery类的全量数据 入口与struts_Customer.xml配置文件对应
	 */
	public String getFullAutoData() {
		//执行相关的Service的操作
		List<ListUserQuery> list = customerService.findFullUserQueryData();
		// 把对应的JAVA实体类 转换成json格式最后转成流传给前端
		toJsonSteam(JSONObject.toJSONString(list));
		//执行完毕
		return this.SUCCESS;
	}
	/*
	 * 执行查找的操作 获得ListUserQuery类的是一个用户在某一IP查询的相关的消息   入口与struts_Customer.xml配置文件对应
	 */
	public String getFullMsgDataByIdAndIp() {
		//执行相关的操作
		List<ListUserQuery> list = customerService.findByUSerIdAndIpUserQueryData(listUserQuery.getUserId(),
				listUserQuery.getIp());
		if (list == null) {
			toJsonSteam("[]");
		} else {
			toJsonSteam(JSONObject.toJSONString(list));
		}
		//执行完毕
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
	// 把JSON字符串转换成流
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
		int indexOf = ip.indexOf(",");
		if (indexOf > 0) {
			return ip.substring(0, indexOf);
		}
		return ip;

	}

}
