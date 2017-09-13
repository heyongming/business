package com.business.job;

import com.alibaba.fastjson.JSONObject;

public class AccessTokenManager {
	public static final String APPID = "wxaf9208856d550d06";
	public static final String AppSecret = "ca46edf66cc057941962edd6d20fb4d9";
	public static String Access_Token = "zP_mFkLqFNPyQXmE1U_76BDxld5v_65jbVNx3Xdjv0Z4r5t-zDKns4TVvCfSEemXjNU9r-uXAXKOadu2q_LR3ahohYSSJ52YiTnwP5km151F7OD65t57Y7X_h-R5EhaTLTDhAHAAIS";

	public void execute() {
		/*
		 * String url =
		 * "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		 * url = url.replace("APPID", AccessTokenManager.APPID); url =
		 * url.replace("APPSECRET", AccessTokenManager.AppSecret); String json =
		 * HttpClientUtil.httpGet(url); AccessToken accessToken =
		 * JSONObject.parseObject(json, AccessToken.class); Access_Token =
		 * accessToken.getAccess_token();
		 */
	}
}
