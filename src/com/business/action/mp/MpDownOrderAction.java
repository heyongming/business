package com.business.action.mp;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.mp.pay.PayEntitys;
import com.business.entitys.order.OrderForm;
import com.business.entitys.user.User;
import com.business.job.WxPayConfig;
import com.business.util.SnowflakeIdWorker;
import com.business.util.mpPay.MpPayUtill;
import com.cache.OrderCache;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/*
 * 微信下单Action 不明白可以查看微信下单的API
 */
public class MpDownOrderAction extends ActionSupport implements ModelDriven<PayEntitys> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7977336536036587084L;
	private PayEntitys payEntitys;
	private InputStream bis;

	public PayEntitys getPayEntitys() {
		return payEntitys;
	}

	public void setPayEntitys(PayEntitys payEntitys) {
		this.payEntitys = payEntitys;
	}

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	@Override
	public PayEntitys getModel() {
		// TODO Auto-generated method stub
		payEntitys = new PayEntitys();
		return payEntitys;
	}
	//注入SnowflakeIdWorker算法
	@Resource
	private SnowflakeIdWorker snowflakeIdWorker;

	public SnowflakeIdWorker getSnowflakeIdWorker() {
		return snowflakeIdWorker;
	}

	public void setSnowflakeIdWorker(SnowflakeIdWorker snowflakeIdWorker) {
		this.snowflakeIdWorker = snowflakeIdWorker;
	}
	
	public String downOrder() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		GoodsList buyGoodsList = (GoodsList) session.get("buyGoodsList"); 
		// 购买的商品
		OrderForm buyorderForm = (OrderForm) session.get("buyOderForm");//

		long id = snowflakeIdWorker.nextId();
		buyorderForm.setOrderSerialNumber(id + "");
		// 购买的时候的账单
		User userEntitys = (User) session.get("buyuser");// 购买者
		GoodsList upGoodsList = (GoodsList) session.get("upGoodsList");//
		// 升级前的商品假如有的话 
		// 检测代码
		User checkUserEntitys = OrderCache.buyuser.get(userEntitys.getUserId());
		GoodsList checkBuyGoodsList = OrderCache.goodsListMap.get(userEntitys.getUserId());
		OrderForm checkBuyorderForm = OrderCache.orderFromMap.get(userEntitys.getUserId());
		GoodsList checkupGoodsList = OrderCache.upGoodsList.get(userEntitys.getUserId());
		if (userEntitys == null || buyGoodsList == null || buyorderForm == null) {
			ResultMessage resultMessage = new ResultMessage("-3", "false", "支付已过期");
			toJsonSteam(JSONObject.toJSONString(resultMessage));

			return this.SUCCESS;
		}
		// 检测代码
		HttpServletRequest request = ServletActionContext.getRequest(); // 获得requst对象

		String result = SUCCESS;
		String message = "";
		int code = 0;
		// 获得客服端ip
		// = request.getRemoteAddr();
		String ip = getIpAddr(request);
		// 获得当前时间的字符串格式
		String outTradeNo = new SimpleDateFormat("YYYYMMDDHHmmssSSS").format(new Date()) + "-wap";
		// 初始化
		String param = CreateWapUrl(outTradeNo, ip, userEntitys, buyGoodsList, buyorderForm);
		// 与微信的接口进行对接
		String resp = MpPayUtill.sendPost(WxPayConfig.UNIFIEDORDER_INTERFACE, param, "utf-8");
		Map<String, String> res = MpPayUtill.parseXml(resp);

		if (res.get("return_code").equals("SUCCESS")) {
			if (res.get("result_code").equals("SUCCESS")) {
				message = res.get("mweb_url");
			} else {
				code = -1;
				message = res.get("err_code_des");
				/*
				System.out.println(
						"wxWapPay error code" + res.get("err_code") + ", reason is " + res.get("err_code_des"));
				*/
			}
		} else {
			code = -1;
			message = res.get("return_msg");
		//	System.out.println("wxWapPay error reason is " + res.get("return_msg"));
		}
		ResultMessage resultMessage = new ResultMessage(code + "", result, message);

		String json = JSONObject.toJSONString(resultMessage);
		toJsonSteam(json);
		return this.SUCCESS;

	}

	// 统一下单接口
	public String CreateWapUrl(String outTradeNo, String ip, User user, GoodsList goodsList, OrderForm form) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		// 微信分配的公众账号ID（企业号corpid即为此appId）
		param.put("appid", WxPayConfig.APPID);
		// 微信支付分配的商户号
		param.put("mch_id", WxPayConfig.MCHID);
		// 随机字符串，不长于32位
		param.put("nonce_str", MpPayUtill.CreateNoncestr());
		// 商品简单描述
		param.put("body", goodsList.getGoodsName());
		// 商户系统内部的订单号
		param.put("out_trade_no", form.getOrderSerialNumber());
		// 订单总金额
		param.put("total_fee", 1);
		// 用户的IP
		param.put("spbill_create_ip", ip);
		// 支付成功回调地址
		param.put("notify_url", WxPayConfig.NOTIFYURL);
		// 用户自定义数据
		ResultMessage op = new ResultMessage();

		op.setErrMsg(form.getOrderSerialNumber());
		op.setSuccess(user.getUserId() + "");

		param.put("attach", JSONObject.toJSONString(op));

		// 交易类型
		param.put("trade_type", "MWEB");
		// 微信签名
		param.put("sign", MpPayUtill.getSign(param));
		return MpPayUtill.MapToXml(param);
	}

	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		int indexOf = ip.indexOf(",");
		if (indexOf > 0) {
			return ip.substring(0, indexOf);
		}
		return ip;

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
