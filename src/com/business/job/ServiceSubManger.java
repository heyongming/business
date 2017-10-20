package com.business.job;

import javax.annotation.Resource;

import com.business.service.IServiceTimeService;

public class ServiceSubManger {
	@Resource
	private IServiceTimeService serviceTimeService;

	public IServiceTimeService getServiceTimeService() {
		return serviceTimeService;
	}

	public void setServiceTimeService(IServiceTimeService serviceTimeService) {
		this.serviceTimeService = serviceTimeService;
	}

	public void subService() {
		int num = serviceTimeService.subSertviceTime();
		System.out.println("更新了" + num + "个用户");
	}
}
