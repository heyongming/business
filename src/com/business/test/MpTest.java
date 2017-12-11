package com.business.test;

import com.alibaba.fastjson.JSONObject;
import com.business.job.AccessToken;
import com.business.job.AccessTokenManager;
import com.business.util.HttpClientUtil;
import com.business.util.mp.MessAgeUtil;
import com.business.util.mp.WeiXinUtil;

public class MpTest {
	public static void main(String[] args) {
		/*
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		url = url.replace("APPID", AccessTokenManager.APPID);
		url = url.replace("APPSECRET", AccessTokenManager.AppSecret);
		String json = HttpClientUtil.httpGet(url);
		AccessToken accessToken = JSONObject.parseObject(json, AccessToken.class);
		System.out.println(accessToken.getAccess_token());
		*/
		
		String menu = WeiXinUtil.initMenu();
		String msg = WeiXinUtil.sendMenu(AccessTokenManager.Access_Token, menu);
		System.out.println(msg);
	
		/*
		 * String urlAddr = "http://m.mbimc.com/business/mp/oauthLogin";
		 * urlAddr=MessAgeUtil.webLicensingnSapi_userinfo("urlAddr");
		 */
	}
}
