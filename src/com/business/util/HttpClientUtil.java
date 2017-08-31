package com.business.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
	// 发送httpGet请求
	public static String httpGet(String url) {
		String result = null;
		DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		try {
			HttpResponse response = defaultHttpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, "utf-8");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	// 发送httpPost请求
	public static String httpPost(String url, String data) {
		String result = null;
		DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
		
		HttpPost httpPost = new HttpPost(url);
		try {
			httpPost.setEntity(new StringEntity(data,"utf-8"));
		//	System.out.println(httpPost.getEntity());
			HttpResponse response = defaultHttpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, "utf-8");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
}
