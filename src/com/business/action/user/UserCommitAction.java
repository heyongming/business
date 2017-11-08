package com.business.action.user;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.mp.temp.ResultMsg;
import com.business.entitys.user.User;
import com.business.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserCommitAction extends ActionSupport implements ModelDriven<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6127586091093168486L;
	@Resource
	private IUserService userService;
	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		user = new User();
		return user;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ResultMessage resultMessage = null;
		if (user.getIdCard() == null || user.getAnswer() == null) {
			resultMessage = new ResultMessage("-1", "false", "用户信息填写错误");
			toJsonSteam(JSONObject.toJSONString(resultMessage));
			return this.SUCCESS;
		}
		User idUser = userService.fingUserByIdcard(user.getIdCard());
		if (idUser == null) {
			resultMessage = new ResultMessage("-2", "false", "您还没通过销售的审核，请与销售联系");
			toJsonSteam(JSONObject.toJSONString(resultMessage));
			return this.SUCCESS;
		}
		idUser.setAnswer(user.getAnswer());
		idUser.setGrade(getRiskLevel(user.getAnswer()));
		int flog=userService.updateUser(idUser);
		if(flog>0)
		{
			resultMessage=new ResultMessage("1","true","你的风险的等级是:"+idUser.getGrade());
			toJsonSteam(JSONObject.toJSONString(resultMessage));
			return this.SUCCESS;
		}
		else
		{
			resultMessage=new ResultMessage("-3","false","操作失败");
			toJsonSteam(JSONObject.toJSONString(resultMessage));
			return this.SUCCESS;
		}
		
	}

	private void toJsonSteam(String text) {
		try {
			bis = new ByteArrayInputStream(text.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			bis = null;
			e.printStackTrace();
		}
	}

	private static String getRiskLevel(String answers) {
		String answer[] = answers.split(",");
		int result = 0;
		String lv = "";

		for (int i = 0; i < answer.length; i++) {
			String tempStr = answer[i].replaceAll(" ", "");
			int index = tempStr.indexOf("=");
			tempStr = tempStr.substring(index + 1, tempStr.length());

			String fist = tempStr.substring(tempStr.length() - 1, tempStr.length());

			if (fist.equals("E")) {
				result = result + 5;
			} else if (fist.equals("D")) {
				result = result + 4;
			} else if (fist.equals("C")) {
				result = result + 3;
			} else if (fist.equals("B")) {
				result = result + 2;
			} else if (fist.equals("A")) {
				result = result + 1;
			}

		}
		if (result >= 0 && result <= 25) {
			lv = "保守型,C1";
		} else if (result <= 40) {
			lv = "稳健型,C2";
		} else if (result <= 60) {
			lv = "成长型,C3";
		} else if (result <= 80) {
			lv = "积极型,C4";
		} else {
			lv = "激进型,C5";
		}

		return lv;
	}

}
