package com.business.action.mp;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.mp.temp.ResultMsg;
import com.business.entitys.service.ServiceArticle;
import com.business.entitys.service.ServiceTime;
import com.business.entitys.user.User;
import com.business.service.IGoodsOperationService;
import com.business.service.IMpUserService;
import com.business.service.IServiceArticleService;
import com.business.service.IServiceTimeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MpHistoryAction extends ActionSupport {

	@Resource
	private IMpUserService mpUserService;
	@Resource
	private IGoodsOperationService goodsOperationService;
	@Resource
	private IServiceTimeService serviceTimeService;
	@Resource
	private IServiceArticleService serviceArticleService;
	private String date;
	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	public IServiceArticleService getServiceArticleService() {
		return serviceArticleService;
	}

	public void setServiceArticleService(IServiceArticleService serviceArticleService) {
		this.serviceArticleService = serviceArticleService;
	}

	public IMpUserService getMpUserService() {
		return mpUserService;
	}

	public void setMpUserService(IMpUserService mpUserService) {
		this.mpUserService = mpUserService;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public IGoodsOperationService getGoodsOperationService() {
		return goodsOperationService;
	}

	public void setGoodsOperationService(IGoodsOperationService goodsOperationService) {
		this.goodsOperationService = goodsOperationService;
	}

	public IServiceTimeService getServiceTimeService() {
		return serviceTimeService;
	}

	public void setServiceTimeService(IServiceTimeService serviceTimeService) {
		this.serviceTimeService = serviceTimeService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = ((User) session.get("loginUser"));
		GoodsList goodsList = (GoodsList) session.get("serviceGoodsList");
		if (user == null || goodsList == null) {
			return this.input();
		}
		if (date == null) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd?HH:mm:ss");// 设置日期格式
			String str = df.format(new Date()).toString();
			int index = str.lastIndexOf("?");
			date = str.subSequence(0, index).toString();

		}
		date = date.replaceAll("/", "-");
		List<ServiceArticle> list = serviceArticleService.doHistoryDateData(goodsList.getGoodsId(), date);
		ServiceTime serviceTime = serviceTimeService.findServiceUserEntity(user, goodsList);
		request.setAttribute("zpServiceArticle", list);
		request.setAttribute("currentGoods", goodsList);
		request.setAttribute("currentGoodsDay", serviceTime.getServiceDay());
		request.setAttribute("currentServiceTypeId", serviceTime.getServiceDay());

		return this.SUCCESS;
	}

	public String getHistyData() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = ((User) session.get("loginUser"));
		GoodsList goodsList = (GoodsList) session.get("serviceGoodsList");
		if (user == null || goodsList == null) {
			toJsonSteam("[]");
			return this.SUCCESS;
		}
		if (date == null) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd?HH:mm:ss");// 设置日期格式
			String str = df.format(new Date()).toString();
			int index = str.lastIndexOf("?");
			date = str.subSequence(0, index).toString();

		}
		date = date.replaceAll("/", "-");
		List<ServiceArticle> list = serviceArticleService.doHistoryDateData(goodsList.getGoodsId(), date);
		toJsonSteam(JSONObject.toJSONString(list));
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
