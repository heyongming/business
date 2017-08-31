package com.business.util;

import com.business.temp.SmsEntitys;

public class SendMsg {
	public static String url="http://sapi.253.com/msg/";
	public static String account = "Shzy-888";
	public static String pwd="Adminzy888";
	public static boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
	public static String extno = null;

	public static String sendMsg(String phone,String cont)
	{
		String result=null;
		try {
			result=HttpSender.batchSend(url, account, pwd, phone, cont, needstatus, extno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
}
