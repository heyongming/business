package com.business.util;

public class SendMsg {
	public static String url = "http://sapi.253.com/msg/";
	public static String account = "Shzy-888";
	public static String pwd = "Adminzy888";
	public static boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
	public static String extno = null;

	public static String sendMsg(String phone, String cont) {

		String url = "http://localhost/businessHelp/SmsSender?phone=" + phone + "&ctent=" + cont;

		return HttpClientUtil.httpGet(url);

	}
}
