package com.business.action.ServiceTime;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.service.ServiceTime;
import com.business.service.IServiceTimeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ServiceTimeDmmAction extends ActionSupport implements ModelDriven<ServiceTime> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5452975031790834047L;
	private ServiceTime serviceTime;
	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	public ServiceTime getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(ServiceTime serviceTime) {
		this.serviceTime = serviceTime;
	}

	public IServiceTimeService getServiceTimeService() {
		return serviceTimeService;
	}

	public void setServiceTimeService(IServiceTimeService serviceTimeService) {
		this.serviceTimeService = serviceTimeService;
	}

	@Resource
	private IServiceTimeService serviceTimeService;

	@Override
	public ServiceTime getModel() {
		// TODO Auto-generated method stub
		serviceTime = new ServiceTime();
		return serviceTime;
	}

	public String update() {
		ServiceTime tempServiceTime = serviceTimeService.findDataById(serviceTime.getId());
		if (tempServiceTime == null) {
			ResultMessage msg = new ResultMessage("-2", "false", "用户不存在");
			String json = JSONObject.toJSONString(msg);
			toJsonSteam(json);
		}
		tempServiceTime.setServiceDay(serviceTime.getServiceDay());
		int flog = serviceTimeService.updateServiceTime(tempServiceTime);
		ResultMessage msg = null;
		if (flog > 0) {
			msg = new ResultMessage("1", "true", "修改成功");
		} else {
			msg = new ResultMessage("-1", "false", "修改失败");
		}
		String json = JSONObject.toJSONString(msg);
		toJsonSteam(json);
		return this.SUCCESS;
	}

	public String delete() {
		int flog = serviceTimeService.deleteServiceTime(serviceTime.getId());
		ResultMessage msg = null;
		if (flog > 0) {
			msg = new ResultMessage("1", "true", "删除成功");
		} else {
			msg = new ResultMessage("-1", "false", "删除失败");
		}
		String json = JSONObject.toJSONString(msg);
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
