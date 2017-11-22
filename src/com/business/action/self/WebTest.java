package com.business.action.self;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.web.context.ContextLoader;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.autoReply.AutoReply;
import com.business.entitys.autoReply.DataAndResult;
import com.business.entitys.autoReply.FixedAnswer;
import com.business.entitys.autoReply.ListUserQuery;
import com.business.entitys.user.User;
import com.business.service.ICustomerService;

@ServerEndpoint(value = "/testws",configurator=GetHttpSessionConfigurator.class)
public class WebTest  {

	@Resource
	 private ICustomerService customerService=(ICustomerService) ContextLoader.getCurrentWebApplicationContext().getBean("customerService");
	public ICustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}
	private HttpSession httpSession;
	@OnOpen
	public void open(Session session,EndpointConfig config) {
		System.out.println(session.getPathParameters());
		try
		{
		 httpSession= (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		map.put(session.getId(), session);
	}

	private static Map<String, Session> map = new HashMap<String, Session>();

	@OnMessage
	public void receive(Session session, String msg) {
		DataAndResult dataAndResult = null;
		System.out.println(session);
		try {
			dataAndResult = JSONObject.parseObject(msg, DataAndResult.class);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				session.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return;
			}
		}
		String resultJson = null;

		if (dataAndResult.getMethod() == 1) {
			String result = getWelcome();
			DataAndResult resultObj = null;
			ResultMessage message = null;
			if (result == null) {
				message = new ResultMessage("-1", "false", "后台没有设置接入语，或者系统错误");
			} else {
				message = new ResultMessage("1", "true", result);
			}
			resultObj = new DataAndResult(1, null, JSONObject.toJSONString(message));
			resultJson = JSONObject.toJSONString(resultObj);
		}
		if (dataAndResult.getMethod() == 2) {
			List<FixedAnswer> list = customerService.findFixedAnswerFullDate();
			ResultMessage message = null;
			DataAndResult resultObj = null;
			if (list != null) {
				if (list.size() > 0) {
					String str = JSONObject.toJSONString(list);
					message = new ResultMessage("1", "true", str);
				} else {
					message = new ResultMessage("-1", "false", "后台没有设置问题列表，或者系统错误");
				}
			} else {
				message = new ResultMessage("-2", "false", "后台没有设置问题列表，或者系统错误");
			}
			resultObj = new DataAndResult(2, null, JSONObject.toJSONString(message));
			resultJson = JSONObject.toJSONString(resultObj);
		}
		if (dataAndResult.getMethod() == 3) {
			int id = 0;
			ResultMessage message = null;
			DataAndResult resultObj = null;
			try {
				id = Integer.parseInt(dataAndResult.getData());
			} catch (Exception e) {
				// TODO: handle exception
				message = new ResultMessage("-1", "false", "后台相应的固定回答，或者系统错误");
			}
			FixedAnswer fixedAnswer = customerService.findFixedAnswerById(id);
			if (fixedAnswer == null) {
				message = new ResultMessage("-2", "false", "后台相应的固定回答，或者系统错误");
			} else {
				String str = JSONObject.toJSONString(fixedAnswer);
				message = new ResultMessage("1", "true", str);
			}
			resultObj = new DataAndResult(3, null, JSONObject.toJSONString(message));
			resultJson = JSONObject.toJSONString(resultObj);
		}
		if (dataAndResult.getMethod() == 4) {
			
			
			ResultMessage message = null;
			DataAndResult resultObj = null;
			ListUserQuery data = null;
			try {
				
				data=JSONObject.parseObject(dataAndResult.getData(),ListUserQuery.class);
					
			} catch (Exception e) {
				// TODO: handle exception
				message = new ResultMessage("-1", "false", "后台相应的固定回答，或者系统错误");
			}
			if(httpSession!=null)
			{
				User user=(User) httpSession.getAttribute("mpuser");
				data.setUserId(user.getUserId());
			}
			customerService.saveListUserQuery(data);
			List<AutoReply> tempAuto=customerService.findUserQueryQuestions(data.getQuestions());
			if(tempAuto.size()>0)
			{
				String str=JSONObject.toJSONString(tempAuto);
				message = new ResultMessage("1", "true", str);
			}
			else
			{
				message = new ResultMessage("-2", "false", "你的问题我们已经收到，我们的客服稍后会和你联系");
			}
			resultObj = new DataAndResult(4, null, JSONObject.toJSONString(message));
			resultJson = JSONObject.toJSONString(resultObj);
			
		}
		System.out.println(resultJson);
		try {

			session.getBasicRemote().sendText(resultJson);

		} catch (IOException e) {

		}

	}

	@OnClose
	public void close(Session session) {
		System.out.println(session.getId() + " session 关闭");
	}

	/*
	 * 
	 * 
	 */
	private String getWelcome() {
		BufferedReader bufferedReader = null;
		ResultMessage message = null;
		String path = "D:/upload/";
		String str = "";
		try {
			// 读取文件内容 (输入流)
			File file = new File(path, "Welcome.txt");
			FileInputStream out = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(out);
			bufferedReader = new BufferedReader(isr);

			String temp = null;
			while (true) {

				temp = bufferedReader.readLine();
				if (temp == null) {
					break;
				}

				str += temp;

			}
		} catch (Exception e) {
			// TODO: handle exception

			return null;
		}

		return str;
	}
}
