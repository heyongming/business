package com.business.action.mp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.business.entitys.mp.MpUserEntity;
import com.business.entitys.service.ServiceArticle;
import com.business.entitys.service.ServiceArticleDetails;
import com.business.entitys.user.User;
import com.business.service.IServiceArticleService;
import com.business.service.IUserService;
import com.business.temp.MpCodeEntitys;
import com.business.util.mp.MessAgeUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MpCheckServiceArticleAction extends ActionSupport implements ModelDriven<ServiceArticle> {

	/**
	 * 微信文章详情页处理Action
	 */
	@Resource
	private IUserService userService;
	@Resource
	private IServiceArticleService serviceArticleService;

	public IServiceArticleService getServiceArticleService() {
		return serviceArticleService;
	}

	public void setServiceArticleService(IServiceArticleService serviceArticleService) {
		this.serviceArticleService = serviceArticleService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	private static final long serialVersionUID = 7230390217199748269L;
	private ServiceArticle serviceArticle;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private String code;

	public ServiceArticle getServiceArticle() {
		return serviceArticle;
	}

	public void setServiceArticle(ServiceArticle serviceArticle) {
		this.serviceArticle = serviceArticle;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		MpCodeEntitys mpCodeEntitys = MessAgeUtil.GetwebpagesCode(code);
		if (mpCodeEntitys == null) {
			return this.input();
		}
		User user = userService.findOpenIdToUser(mpCodeEntitys.getOpenid());
		if (user == null) {
			return this.input();
		}
		if (serviceArticle.getServiceArticleNum() == 0) {
			return this.input();
		}
		ServiceArticle findserviceArticle = serviceArticleService
				.findByServiceArticleNum(serviceArticle.getServiceArticleNum());
		List<ServiceArticleDetails> det = serviceArticleService.doDetailsToServiceArticle(findserviceArticle);
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.put("loginUser", user);
		request.setAttribute("loginServiceArticle", findserviceArticle); //文章
		request.setAttribute("loginServiceArticleDetails", det); //评论
		int index = serviceArticleService.isDoThumbsUp(user, findserviceArticle);
		request.setAttribute("isDoThumbsUp", index); //点赞数
		return this.SUCCESS;
	}

	@Override
	public ServiceArticle getModel() {
		// TODO Auto-generated method stub
		serviceArticle = new ServiceArticle();
		return serviceArticle;
	}

}
