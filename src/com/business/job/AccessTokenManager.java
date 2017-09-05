package com.business.job;

import com.alibaba.fastjson.JSONObject;


public class AccessTokenManager {
	public static final String APPID = "wx1c2dbcd95b0928f5";
	public static final String AppSecret = "bc97d82fe8918e02c911f253929c8fa4";
	public static String Access_Token = "8kgl3LkFAhrX1aujTRWoX0P1Hzh322_jJLIMZ5nZDhz7ltTv7XUEsUmP92GnErQ2vZ7XVyc25LMtRww5WyWzhndCqM2lIiEUiO45yUJjyX2PVv1mEH1N5K9oVrkD1xRuVFObAEAEOX";


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
