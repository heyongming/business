package com.business.action.mp;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.mp.MpUserEntity;
import com.business.service.IMpUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MpActivationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -530243844438335944L;
	@Resource
	private IMpUserService mpUserService;
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

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	private String idCard;
	private String activationCode;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();

		MpUserEntity mpUserEntity = (MpUserEntity) session.get("mpUser");
//		mpUserEntity=new MpUserEntity("oEMmVuOtjSjRmjL6E1Szv6lKrvUY", "月光的指引", "0", "", "", "", "http://wx.qlogo.cn/mmopen/vi_32/31QVdlsGfaAIEBVQgFibkqG2N1zuUJCCe8a9det1D84JxAQ9REB2ZQuQrQCytY0TSgtficrgcPmyhVvu5wY0dJUA/0", "[]", "");
		if (mpUserEntity == null) {
			ResultMessage message = new ResultMessage("-4", "false", "您没有权限");
			String json = JSONObject.toJSONString(message);
			toJsonSteam(json);
			return this.SUCCESS;
		}
		String json = mpUserService.doActivationService(mpUserEntity, activationCode, idCard);
		toJsonSteam(json);
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
