package com.business.job;

import com.alibaba.fastjson.JSONObject;
import com.business.util.HttpClientUtil;

public class AccessTokenManager {
	public static final String APPID = "wxaf9208856d550d06";
	public static final String AppSecret = "ca46edf66cc057941962edd6d20fb4d9";
	public static String Access_Token = "wtCtYeKxt-UMFyiI_VZLtb4_TRkERM6eMa9Rgqg8lAsHqPcBS1O53m4GyQfjFJRRCbNO1pQqO5OUup2ETWxNdZQWtxgT65y8WGrDuV9YMJlrP8fxOMT7PB8HnGsPK_e3PPRcAIAEEG";

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
