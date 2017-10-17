package com.business.action.serviceArticle;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.service.ServiceArticle;
import com.business.service.IServiceArticleService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ServiceArticleDeleteAction extends ActionSupport implements ModelDriven<ServiceArticle> {

	private ServiceArticle serviceArticle;
	@Resource
	private IServiceArticleService serviceArticleService;

	@Override
	public ServiceArticle getModel() {
		// TODO Auto-generated method stub
		serviceArticle = new ServiceArticle();
		return serviceArticle;
	}

	public InputStream bis;

	public ServiceArticle getServiceArticle() {
		return serviceArticle;
	}

	public void setServiceArticle(ServiceArticle serviceArticle) {
		this.serviceArticle = serviceArticle;
	}

	public IServiceArticleService getServiceArticleService() {
		return serviceArticleService;
	}

	public void setServiceArticleService(IServiceArticleService serviceArticleService) {
		this.serviceArticleService = serviceArticleService;
	}

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String json=serviceArticleService.delServiceArticle(serviceArticle);
		toJsonSteam(json);
		return super.execute();
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
