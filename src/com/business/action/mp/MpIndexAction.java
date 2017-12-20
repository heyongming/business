package com.business.action.mp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.business.entitys.goods.GoodsList;
import com.business.entitys.mp.MpUserEntity;
import com.business.entitys.user.User;
import com.business.service.IMpUserService;
import com.business.temp.MpCodeEntitys;
import com.business.util.mp.CodeHelpEr;
import com.business.util.mp.MessAgeUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/*
 * 用户微信入口
 */
public class MpIndexAction extends ActionSupport {
	private String code;
	@Resource
	private IMpUserService mpUserService;

	public IMpUserService getMpUserService() {
		return mpUserService;
	}

	public void setMpUserService(IMpUserService mpUserService) {
		this.mpUserService = mpUserService;
	}

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
		//缓存是否存在用户
		MpUserEntity entity = (MpUserEntity) session.get("mpUser");
		//不存在,则拉取用户数据
		if (entity == null) {
			
			HttpServletRequest request = ServletActionContext.getRequest();

			MpCodeEntitys mpCodeEntitys = null;
			Boolean isover = true;

			if (CodeHelpEr.map.get(code) != null) {
				isover = false;
				mpCodeEntitys = (MpCodeEntitys) CodeHelpEr.map.get(code);
			} else {
				mpCodeEntitys = MessAgeUtil.GetwebpagesCode(code);
				CodeHelpEr.map.put(code, mpCodeEntitys);
			}

			entity = mpUserService.findUserInfo(mpCodeEntitys.getOpenid());
			if (entity == null && isover) {

				entity = MessAgeUtil.getMpUserEntity(mpCodeEntitys.getAccess_token(), mpCodeEntitys.getOpenid());
				mpUserService.addMpUser(entity);
			}
			
			//登录公众号的相关微信信息
			session.put("mpUser", entity);
		}
		//该用户是否是已经绑定了微信的，是的话 就把用户存在缓存中
		User user = mpUserService.findOpenIdToUser(entity);
		if (user != null) {
			session.put("loginUser", user);
		}

		return this.SUCCESS;
	}

	public String oauthLogin() {
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		MpUserEntity entity = (MpUserEntity) session.get("mpUser");
		if (entity == null) {
			HttpServletRequest request = ServletActionContext.getRequest();

			MpCodeEntitys mpCodeEntitys = null;
			Boolean isover = true;

			if (CodeHelpEr.map.get(code) != null) {
				isover = false;
				mpCodeEntitys = (MpCodeEntitys) CodeHelpEr.map.get(code);
			} else {
				mpCodeEntitys = MessAgeUtil.GetwebpagesCode(code);
				CodeHelpEr.map.put(code, mpCodeEntitys);
			}

			entity = mpUserService.findUserInfo(mpCodeEntitys.getOpenid());
			// System.out.println(isover + "判断！！" + code);
			if (entity == null && isover) {

				entity = MessAgeUtil.getMpUserEntity(mpCodeEntitys.getAccess_token(), mpCodeEntitys.getOpenid());
				mpUserService.addMpUser(entity);
			}
			session.put("mpUser", entity);
		}
		if (entity == null) {
			return this.INPUT;
		}
		System.out.println(entity);
		User user = mpUserService.findOpenIdToUser(entity);
		if (user != null) {
			session.put("loginUser", user);
		}

		return this.SUCCESS;

	}
}
