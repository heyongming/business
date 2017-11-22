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

public class FixedAnswerAction extends ActionSupport implements ModelDriven<FixedAnswer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5153326258682581235L;

	private FixedAnswer fixedAnswer;
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
	public FixedAnswer getModel() {
		// TODO Auto-generated method stub
		fixedAnswer = new FixedAnswer();
		return fixedAnswer;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		int flog = customerService.saveFixedAnswer(fixedAnswer);
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "插入成功");
		} else {
			resultMessage = new ResultMessage("-1", "false", "插入失败");
		}
		toJsonSteam(JSONObject.toJSONString(resultMessage));
		return this.SUCCESS;
	}

	public String findFixFdid() {
		FixedAnswer Answer= customerService.findFixedAnswerById(fixedAnswer.getFdid());
		if (Answer == null) {
			toJsonSteam("{}");
		} else {
			toJsonSteam(JSONObject.toJSONString(Answer));
		}

		return this.SUCCESS;
	}

	public String getFullFixData() {
		List<FixedAnswer> list = customerService.findFixedAnswerFullDate();
		toJsonSteam(JSONObject.toJSONString(list));
		return this.SUCCESS;
	}

	public String update() {
		int flog = customerService.updatefixedAnswer(fixedAnswer);
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "修改成功");
		} else {
			resultMessage = new ResultMessage("-1", "false", "修改失败");
		}
		toJsonSteam(JSONObject.toJSONString(resultMessage));
		return this.SUCCESS;
	}

	public String delete() {
		int flog = customerService.delFixedAnswer(fixedAnswer);
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "删除成功");
		} else {
			resultMessage = new ResultMessage("-1", "false", "删除失败");
		}
		toJsonSteam(JSONObject.toJSONString(resultMessage));
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
