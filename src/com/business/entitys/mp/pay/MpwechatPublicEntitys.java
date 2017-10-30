package com.business.entitys.mp.pay;

import com.business.entitys.ResultMessage;
import com.business.job.WxPayConfig;

public class MpwechatPublicEntitys extends ResultMessage {
	private String appId;
	private String timeStamp;
	private String nonceStr;
	private String package_id;
	private String signType;
	private String paySign;

	@Override
	public String toString() {
		return "MpwechatPublicEntitys [appId=" + appId + ", timeStamp=" + timeStamp + ", nonceStr=" + nonceStr
				+ ", package_id=" + package_id + ", signType=" + signType + ", paySign=" + paySign + "]";
	}

	public MpwechatPublicEntitys() {
		appId = WxPayConfig.APPID;
		signType = "MD5";

	}

	public MpwechatPublicEntitys(String appId, String timeStamp, String nonceStr, String package_id, String signType,
			String paySign) {
		super();
		this.appId = appId;
		this.timeStamp = timeStamp;
		this.nonceStr = nonceStr;
		this.package_id = package_id;
		this.signType = signType;
		this.paySign = paySign;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getPackage_id() {
		return package_id;
	}

	public void setPackage_id(String package_id) {
		this.package_id = package_id;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getPaySign() {
		return paySign;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}
}
