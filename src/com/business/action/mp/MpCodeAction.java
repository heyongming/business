package com.business.action.mp;

import java.util.Map;

import javax.annotation.Resource;

import com.business.entitys.mp.MpUserEntity;
import com.business.service.IMpUserService;
import com.business.temp.MpCodeEntitys;
import com.business.util.mp.MessAgeUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MpCodeAction extends ActionSupport {
	@Resource
	private IMpUserService mpUserService;

	public IMpUserService getMpUserService() {
		return mpUserService;
	}

	public void setMpUserService(IMpUserService mpUserService) {
		this.mpUserService = mpUserService;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4880072400565176353L;
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		MpCodeEntitys mpCodeEntitys = MessAgeUtil.GetwebpagesCode(code);
		MpUserEntity entity = mpUserService.findUserInfo(mpCodeEntitys.getOpenid());
		if (entity == null) {
			entity = MessAgeUtil.getMpUserEntity(mpCodeEntitys.getAccess_token(), mpCodeEntitys.getOpenid());
			mpUserService.addMpUser(entity);
		}
		session.put("mpUser", entity);
		return super.execute();
	}
}