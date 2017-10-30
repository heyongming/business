package com.business.job;

import com.alibaba.fastjson.JSONObject;
import com.business.util.HttpClientUtil;

public class AccessTokenManager {
	public static final String APPID = "wxaf9208856d550d06";
	public static final String AppSecret = "ca46edf66cc057941962edd6d20fb4d9";
	public static String Access_Token = "fmT5w5YMgTPthCm-IhchwwgxHw9XjeFcLvz9aCtkAM8zfGR83nJ_xM2I8bampvofjnloETjr8JuYjH6oC_v7S1ItBz_3mlZZYo-n9l8fEipj4CSqS77_dLglIRW5Sr3FPKVeADAEZK";

	public void execute() {

	/*	String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		url = url.replace("APPID", AccessTokenManager.APPID);
		url = url.replace("APPSECRET", AccessTokenManager.AppSecret);
		String json = HttpClientUtil.httpGet(url);
		AccessToken accessToken = JSONObject.parseObject(json, AccessToken.class);
		Access_Token = accessToken.getAccess_token();
	*/

	}
}
