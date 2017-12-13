package com.business.job;

import com.alibaba.fastjson.JSONObject;
import com.business.util.HttpClientUtil;

public class AccessTokenManager {
	public static final String APPID = "wxaf9208856d550d06";
	public static final String AppSecret = "ca46edf66cc057941962edd6d20fb4d9";
	public static String Access_Token = "rkfr26jqLFang7Ao8AjALC3VAdiKVmYHhHtZrVxF0DbStgm3bLroDFL1QQpkFSGGb4KcuTBgjVO3TP-IszWiJvA5Lu1IeLWzvdB_GzWCRbq5qKik9WQg00RqtUFkJLcCSZMaAEAZGT";

	public void execute() {
			/*
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		url = url.replace("APPID", AccessTokenManager.APPID);
		url = url.replace("APPSECRET", AccessTokenManager.AppSecret);
		String json = HttpClientUtil.httpGet(url);
		AccessToken accessToken = JSONObject.parseObject(json, AccessToken.class);
		Access_Token = accessToken.getAccess_token();
	
		*/
	}
}
