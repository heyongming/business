package com.business.util.ansj;

import com.business.util.HttpClientUtil;

public class SendAnsj {
	

	public static String sendMsg(String conten) {

		String url = "http://localhost/ansjHelpEr/AsnjServlet?problem=" + conten ;
		return HttpClientUtil.httpGet(url);

	}
}
