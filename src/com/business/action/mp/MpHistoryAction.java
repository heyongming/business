package com.business.action.mp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.business.entitys.goods.GoodsList;
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

public class MpHistoryAction extends ActionSupport  {
	
	@Resource
	private IMpUserService mpUserService;
	@Resource
	private IGoodsOperationService goodsOperationService;
	@Resource
	private IServiceTimeService serviceTimeService;
	@Resource
	private IServiceArticleService serviceArticleService;
	private int serviceTypeId=0;

	public int getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(int serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
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
		if(serviceTypeId==0)
		{
			serviceTypeId=1;
		}
		List<ServiceArticle> list = serviceArticleService.doHistoryData(goodsList.getGoodsId(), serviceTypeId);
		ServiceTime serviceTime = serviceTimeService.findServiceUserEntity(user, goodsList);
		request.setAttribute("zpServiceArticle", list);
		request.setAttribute("currentGoods", goodsList);
		request.setAttribute("currentGoodsDay", serviceTime.getServiceDay());
		request.setAttribute("currentServiceTypeId", serviceTime.getServiceDay());
		
		return this.SUCCESS;
	}

}
