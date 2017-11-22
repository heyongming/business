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

public class CustomerAutoReplyAction extends ActionSupport implements ModelDriven<AutoReply> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5153326258682581235L;

	private AutoReply autoReply;
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

	private InputStream bis;

	@Override
	public AutoReply getModel() {
		// TODO Auto-generated method stub
		autoReply = new AutoReply();
		return autoReply;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		int flog = customerService.saveAutoReply(autoReply);
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "插入成功");
		} else {
			resultMessage = new ResultMessage("-1", "false", "插入失败");
		}
		toJsonSteam(JSONObject.toJSONString(resultMessage));
		return this.SUCCESS;
	}

	public String findAutoReplyByArid() {
		AutoReply auto = customerService.findAutoReplyByArID(autoReply.getArId());
		if (auto == null) {
			toJsonSteam("{}");
		} else {
			toJsonSteam(JSONObject.toJSONString(auto));
		}

		return this.SUCCESS;
	}

	public String getFullAutoData() {
		List<AutoReply> list = customerService.findAutoFullReplyDate();
		toJsonSteam(JSONObject.toJSONString(list));
		return this.SUCCESS;
	}

	public String update() {
		int flog = customerService.updateAutoReply(autoReply);
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
		int flog = customerService.delAutoReply(autoReply);
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
