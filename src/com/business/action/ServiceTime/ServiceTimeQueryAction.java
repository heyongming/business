package com.business.action.ServiceTime;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.service.ServiceTime;
import com.business.service.IServiceTimeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ServiceTimeQueryAction extends ActionSupport implements ModelDriven<ServiceTime> {
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

	public String getAllData() {
		List<ServiceTime> list = serviceTimeService.findAllData();
		String json = JSONObject.toJSONString(list);
		toJsonSteam(json);
		return this.SUCCESS;
	}
	public String getDataById()
	{
		ServiceTime tempserviceTime=serviceTimeService.findDataById(serviceTime.getId());
		String msg="";
		if(serviceTime==null)
		{
			msg="[]";
		}
		else
		{
			msg=JSONObject.toJSONString(tempserviceTime);
		}
		toJsonSteam(msg);
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
