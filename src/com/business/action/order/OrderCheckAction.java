package com.business.action.order;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.order.OrderForm;
import com.business.entitys.user.User;
import com.business.job.MsgMeesage;
import com.business.temp.ResultOrderActivationCodeEntitys;
import com.business.util.CheckErrorQiantaiUtill;
import com.cache.OrderCache;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/*
 * 交易检查Action
 */
public class OrderCheckAction extends ActionSupport {
	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}
	//检查交易是否结束，可以参考下单的逻辑方便理解
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		if (!CheckErrorQiantaiUtill.checkSession(session)) {
			ResultMessage resultMessage = new ResultMessage("-6", "false", "system all");

			String json = JSONObject.toJSONString(resultMessage);
			toJsonSteam(json);
			return this.SUCCESS;
		}
		User userEntitys = (User) session.get("buyuser");
		ResultMessage resultMessage = null;
		if (userEntitys != null) {

			//微信回调会清除缓存，判断缓存即可知道交易是否结束
			ResultOrderActivationCodeEntitys msg = OrderCache.msg.get(userEntitys.getUserId() + "");
			OrderForm orderForm = OrderCache.buyOrderResult.get(userEntitys.getUserId() + "");
			if (orderForm == null || msg == null) {
				msg = (ResultOrderActivationCodeEntitys) session.get("msg");
				orderForm = (OrderForm) session.get("buyOrderResult");
				if (orderForm == null || msg == null) {
					resultMessage = new ResultMessage("-4", "false", "请先交易");
				} else {
					resultMessage = new ResultMessage("2", "true", "交易已经结束");
				}
			} else {
				resultMessage = new ResultMessage("1", "true", "跳");
				OrderCache.msg.remove(userEntitys.getUserId()+"");
				OrderCache.buyOrderResult.remove(userEntitys.getUserId()+"");
				session.put("msg", resultMessage);
				session.put("buyOrderResult", orderForm);

			}
		} else {
			resultMessage = new ResultMessage("-3", "false", "登录超时");
		}
		String json = JSONObject.toJSONString(resultMessage);
		toJsonSteam(json);
		return this.SUCCESS;
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
}
