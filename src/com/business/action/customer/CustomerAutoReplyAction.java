package com.business.action.customer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.json.JsonObject;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.autoReply.AutoReply;
import com.business.service.ICustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 客服自动回复Action
 * 
 * @ActionSupport 为struts2的提供的上下文的一个类
 * @ModelDriven 该方法返回一个用于接收用户输入数据的模型对象。
 */

public class CustomerAutoReplyAction extends ActionSupport implements ModelDriven<AutoReply> {
	/**
	 * 序列化的UID
	 */
	private static final long serialVersionUID = 5153326258682581235L;

	/*
	 * 自动回答对应的实体类
	 */
	private AutoReply autoReply;

	/*
	 * 注入对应的Service层
	 */
	@Resource
	private ICustomerService customerService;

	public AutoReply getAutoReply() {
		return autoReply;
	}

	public void setAutoReply(AutoReply autoReply) {
		this.autoReply = autoReply;
	}

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
	 * AJAX处理完毕返回的流
	 */
	private InputStream bis;

	/*
	 * @ModelDriven 需要实现的方法
	 * 
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	@Override
	public AutoReply getModel() {
		// TODO Auto-generated method stub
		autoReply = new AutoReply();
		return autoReply;
	}

	/*
	 * 默认的处理的方法 执行添加操作 入口与struts_Customer.xml配置文件对应
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// 调用service层方法
		int flog = customerService.saveAutoReply(autoReply);
		// 返回json的实体类
		ResultMessage resultMessage = null;
		// 判断是否成功
		if (flog > 0) {
			// 成功的返回的结果
			resultMessage = new ResultMessage("1", "true", "插入成功");
		} else {
			// 失败的返回的结果
			resultMessage = new ResultMessage("-1", "false", "插入失败");
		}
		// 把对应的JAVA实体类 转换成json格式最后转成流传给前端
		toJsonSteam(JSONObject.toJSONString(resultMessage));
		// 处理完毕
		return this.SUCCESS;
	}

	/*
	 * 执行查找的操作 根据arId来查询 返回对应的AutoReply类 入口与struts_Customer.xml配置文件对应
	 */
	public String findAutoReplyByArid() {
		// 执行service层返回查询结果
		AutoReply auto = customerService.findAutoReplyByArID(autoReply.getArId());
		// 判断是否查询成功
		if (auto == null) {
			// 查询为空的话 返回空的json数据
			toJsonSteam("{}");
		} else {
			// 返回为查询到相应的实体的类的数据
			toJsonSteam(JSONObject.toJSONString(auto));
		}
		// 处理完毕
		return this.SUCCESS;
	}

	/*
	 * 执行查找的操作 获得AutoReply类的全量数据 入口与struts_Customer.xml配置文件对应
	 */
	public String getFullAutoData() {
		// 执行servic层获得全量数据
		List<AutoReply> list = customerService.findAutoFullReplyDate();
		// 把查询的结果转成json数据后转成流
		toJsonSteam(JSONObject.toJSONString(list));
		// 处理完毕
		return this.SUCCESS;
	}

	/*
	 * 执行修改的操作 入口与struts_Customer.xml配置文件对应
	 */
	public String update() {
		// 执行Service层的修改AutoReply操作
		int flog = customerService.updateAutoReply(autoReply);
		// 返回json的实体类
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "修改成功");
		} else {

			resultMessage = new ResultMessage("-1", "false", "修改失败");
		}
		// 把对应的JAVA实体类 转换成json格式最后转成流传给前端
		toJsonSteam(JSONObject.toJSONString(resultMessage));
		// 执行完毕
		return this.SUCCESS;
	}

	/*
	 * 执行删除的操作 入口与struts_Customer.xml配置文件对应
	 */
	public String delete() {
		// 执行Service层的删除AutoReply操作
		int flog = customerService.delAutoReply(autoReply);
		// 返回json的实体类
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "删除成功");
		} else {
			resultMessage = new ResultMessage("-1", "false", "删除失败");
		}
		// 把对应的JAVA实体类 转换成json格式最后转成流传给前端
		toJsonSteam(JSONObject.toJSONString(resultMessage));
		// 执行完毕
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
}
