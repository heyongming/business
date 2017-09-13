package com.business.action.mp;

import javax.annotation.Resource;

import com.business.dao.IMpUserDao;
import com.business.service.IMpUserService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hym {@code} 微信服务
 */
public class MpServiceAction extends ActionSupport {

	/**
	 * 
	 */
	@Resource
	private IMpUserService mpUserService;

	public IMpUserService getMpUserService() {
		return mpUserService;
	}

	public void setMpUserService(IMpUserService mpUserService) {
		this.mpUserService = mpUserService;
	}

	private static final long serialVersionUID = 4702874975944077584L;

	public String activation() {

		return Action.SUCCESS;
	}
}
