package com.business.action.customer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;

import com.business.entitys.autoReply.FixedAnswer;
import com.business.service.ICustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * 固定回答的Action
 * 
 * @ActionSupport 为struts2的提供的上下文的一个类
 * @ModelDriven 该方法返回一个用于接收用户输入数据的模型对象。
 */
public class FixedAnswerAction extends ActionSupport implements ModelDriven<FixedAnswer> {
	/**
	 * 序列化的UID
	 */
	private static final long serialVersionUID = 5153326258682581235L;
	
	/*
	 * 固定回答对应的实体类
	 */
	private FixedAnswer fixedAnswer;
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
	 * AJAX处理完毕返回的流
	 */
	private InputStream bis;
	/*
	 * @ModelDriven 需要实现的方法
	 * 
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	@Override
	public FixedAnswer getModel() {
		// TODO Auto-generated method stub
		fixedAnswer = new FixedAnswer();
		return fixedAnswer;
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
		int flog = customerService.saveFixedAnswer(fixedAnswer);
		// 返回json的实体类
		ResultMessage resultMessage = null;
		//判断
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "插入成功");
		} else {
			resultMessage = new ResultMessage("-1", "false", "插入失败");
		}
		// 把对应的JAVA实体类 转换成json格式最后转成流传给前端
		toJsonSteam(JSONObject.toJSONString(resultMessage));
		// 处理完毕
		return this.SUCCESS;
	}
	/*
	 * 执行查找的操作 根据fdId来查询 返回对应的FixedAnswer类 入口与struts_Customer.xml配置文件对应
	 */
	public String findFixFdid() {
		// 执行service层返回查询结果
		FixedAnswer Answer= customerService.findFixedAnswerById(fixedAnswer.getFdid());
		// 判断是否查询成功
		if (Answer == null) {
			// 查询为空的话 返回空的json数据
			toJsonSteam("{}");
		} else {
			// 返回为查询到相应的实体的类的数据
			toJsonSteam(JSONObject.toJSONString(Answer));
		}
		// 处理完毕
		return this.SUCCESS;
	}
	/*
	 * 执行查找的操作 获得FixedAnswer类的全量数据 入口与struts_Customer.xml配置文件对应
	 */
	public String getFullFixData() {
		// 执行servic层获得全量数据
		List<FixedAnswer> list = customerService.findFixedAnswerFullDate();
		// 把查询的结果转成json数据后转成流
		toJsonSteam(JSONObject.toJSONString(list));
		// 处理完毕
		return this.SUCCESS;
	}
	/*
	 * 执行修改的操作 入口与struts_Customer.xml配置文件对应
	 */
	public String update() {
		// 执行Service层的修改fixedAnswer操作
		int flog = customerService.updatefixedAnswer(fixedAnswer);
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
		//执行Service层的删除fixedAnswer操作
		int flog = customerService.delFixedAnswer(fixedAnswer);
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "删除成功");
		} else {
			resultMessage = new ResultMessage("-1", "false", "删除失败");
		}
		// 把对应的JAVA实体类 转换成json格式最后转成流传给前端
		toJsonSteam(JSONObject.toJSONString(resultMessage));
		//执行完毕
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
