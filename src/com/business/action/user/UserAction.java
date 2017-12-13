package com.business.action.user;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.channels.SeekableByteChannel;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.sales.Salesman;
import com.business.entitys.user.User;
import com.business.service.IUserService;
import com.business.util.SendMsg;
import com.business.util.TimerAdministration;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2409005323921470632L;
	@Resource
	private IUserService userService;
	private InputStream bis;
	private Timer timer;
	private long overTime;
	private String vcode;

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public long getOverTime() {
		return overTime;
	}

	public void setOverTime(long overTime) {
		this.overTime = overTime;
	}

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		String sessionVcKey = (String) session.get("vc_key");
		if (vcode.equals(sessionVcKey)) {
			String json = userService.saveUser(user);
			System.out.println("wtf?" + json);
			toJsonSteam(json);

		} else {
			ResultMessage message = new ResultMessage("-2", "false", "验证码错误");
			String json = JSONObject.toJSONString(message);
			toJsonSteam(json);
		}
		return super.execute();

	}
	
	public String getUserEntity() {
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		Map request = (Map) ActionContext.getContext().get("request");
		User findUser = userService.findByUser(user.getUserId());
		Salesman man = (Salesman) session.get("salesmanUser");
		if (man == null || user == null) {
			return Action.INPUT;
		} else {
			
			request.put("user", findUser);
			return Action.SUCCESS;
		}

	}

	/**/
	/**
	 * @return 验证码
	 * @throws Exception
	 */
	public String sendVcode() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		String sessionId = request.getSession().getId();
		timer = TimerAdministration.timerMap.get(sessionId);
		System.out.println(timer);
		if (timer == null) {
			clearSession(sessionId);

		} else {
			System.out.println("销毁旧的");
			timer.cancel();
			clearSession(sessionId);
		}
		String num = (int) ((Math.random() * 9 + 1) * 100000) + "";
		System.out.println(user.getPhone());
		 String result = SendMsg.sendMsg(user.getPhone(),  num+"");
		session.put("vc_key", num);
		System.out.println("num"+num);
		System.out.println(session.get("vc_key"));
		toJsonSteam("[]");
		return super.execute();
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		user = new User();
		return user;
	}

	private void toJsonSteam(String text) {
		try {
			bis = new ByteArrayInputStream(text.getBytes("GBK"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			bis = null;
			e.printStackTrace();
		}
	}

	private void clearSession(final String sessionId) {
		timer = new Timer();
		TimerAdministration.timerMap.put(sessionId, timer);
		ActionContext actionContext = ActionContext.getContext();
		final Map session = actionContext.getSession();

		class MyTask extends TimerTask {

			@Override
			public void run() {

				// System.out.println(session.get("vc_key"));
				// System.out.println("清空");
				session.put("vc_key", null);
				TimerAdministration.timerMap.remove(sessionId);
				// System.out.println(session.get("vc_key"));
				timer = null;
			}

		}
		timer.schedule(new MyTask(), overTime);

	}
}