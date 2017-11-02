package com.business.action.mp;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.service.ServiceArticle;
import com.business.entitys.service.ServiceArticleDetails;
import com.business.entitys.user.User;
import com.business.service.IGoodsOperationService;
import com.business.service.IMpUserService;
import com.business.service.IServiceArticleService;
import com.business.service.IServiceTimeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MpServiceArticleAction extends ActionSupport implements ModelDriven<ServiceArticle> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8577634608817232839L;

	private ServiceArticle serviceArticle;

	@Resource
	private IMpUserService mpUserService;
	@Resource
	private IGoodsOperationService goodsOperationService;
	@Resource
	private IServiceTimeService serviceTimeService;
	@Resource
	private IServiceArticleService serviceArticleService;
	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
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

	public IServiceArticleService getServiceArticleService() {
		return serviceArticleService;
	}

	public void setServiceArticleService(IServiceArticleService serviceArticleService) {
		this.serviceArticleService = serviceArticleService;
	}

	public ServiceArticle getServiceArticle() {
		return serviceArticle;
	}

	public void setServiceArticle(ServiceArticle serviceArticle) {
		this.serviceArticle = serviceArticle;
	}

	@Override
	public ServiceArticle getModel() {
		// TODO Auto-generated method stub
		serviceArticle = new ServiceArticle();
		return serviceArticle;
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
		ServiceArticle article = serviceArticleService.findByServiceArticleNum(serviceArticle.getServiceArticleNum());
		List<ServiceArticleDetails> det = serviceArticleService.doDetailsToServiceArticle(article);
		
		request.setAttribute("loginServiceArticle", article);
		request.setAttribute("loginServiceArticleDetails", det);
		int index = serviceArticleService.isDoThumbsUp(user, article);
		request.setAttribute("isDoThumbsUp", index);
		return this.SUCCESS;
	}

	/**
	 * 点赞
	 * 
	 * @return
	 */
	public String thumbsUp() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();

		User user = ((User) session.get("loginUser"));
		GoodsList goodsList = (GoodsList) session.get("serviceGoodsList");
		if (user == null || goodsList == null) {
			ResultMessage message = new ResultMessage("-1", "fasle", "你需要登录");
			toJsonSteam(JSONObject.toJSONString(message));
			return this.SUCCESS;
		}

		ResultMessage message = serviceArticleService.doThumbsUp(user, serviceArticle);
		toJsonSteam(JSONObject.toJSONString(message));
		return this.SUCCESS;
	}

	private String evaluateCent;

	public String getEvaluateCent() {
		return evaluateCent;
	}

	public void setEvaluateCent(String evaluateCent) {
		this.evaluateCent = evaluateCent;
	}

	public String comment() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();

		User user = ((User) session.get("loginUser"));
		GoodsList goodsList = (GoodsList) session.get("serviceGoodsList");
		if (user == null || goodsList == null) {
			ResultMessage message = new ResultMessage("-1", "fasle", "你需要登录");
			toJsonSteam(JSONObject.toJSONString(message));
			return this.SUCCESS;
		}
		ServiceArticleDetails serviceArticleDetails = new ServiceArticleDetails();
		serviceArticleDetails.setServiceArticleNum(serviceArticle.getServiceArticleNum());
		serviceArticleDetails.setEvaluateId(user.getUserId());
		serviceArticleDetails.setEvaluateCent(evaluateCent);
		ResultMessage message = serviceArticleService.doComment(serviceArticleDetails);
		toJsonSteam(JSONObject.toJSONString(message));
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
