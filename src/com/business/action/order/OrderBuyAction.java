package com.business.action.order;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.mp.pay.PayResult;
import com.business.entitys.order.OrderForm;
import com.business.entitys.user.User;
import com.business.service.IOrderService;
import com.business.temp.ResultOrderActivationCodeEntitys;
import com.business.util.mpPay.MpPayUtill;
import com.cache.OrderCache;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderBuyAction extends ActionSupport implements ModelDriven<PayResult> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6207567020223225360L;
	private PayResult PayResult;
	@Resource
	private IOrderService orderService;

	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		HttpServletRequest request = ServletActionContext.getRequest();

		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		Map<String, String> data = parseXml(request);
		for (Entry<String, String> entry : data.entrySet()) {

			// System.out.println("Key = " + entry.getKey() + ", Value = " +
			// entry.getValue());

		}
		ResultMessage result = JSONObject.parseObject(data.get("attach"), ResultMessage.class);
		String key = result.getSuccess();
		User userEntitys = OrderCache.buyuser.get(key);
		GoodsList buyGoodsList = OrderCache.goodsListMap.get(key);
		OrderForm buyorderForm = OrderCache.orderFromMap.get(key);
		GoodsList upGoodsList = OrderCache.upGoodsList.get(key);
		if (userEntitys == null || buyGoodsList == null || buyorderForm == null) {
			HashMap<String, Object> objMap = new HashMap<String, Object>();
			objMap.put("return_code", "SUCCESS");
			String xml = MpPayUtill.MapToXml(objMap);
			toJsonSteam(JSONObject.toJSONString(xml));

			return this.SUCCESS;
		}
		// GoodsList buyGoodsList = (GoodsList) session.get("buyGoodsList"); //
		// 购买的商品
		// OrderForm buyorderForm = (OrderForm) session.get("buyOderForm");//
		// 购买的时候的账单
		// User userEntitys = (User) session.get("buyuser");// 购买者
		// GoodsList upGoodsList = (GoodsList) session.get("upGoodsList");//
		// 升级前的商品假如有的话
		Map<String, Object> map = orderService.saveBuyoeder(buyGoodsList, buyorderForm, userEntitys, upGoodsList);
		HashMap<String, Object> objMap = new HashMap<String, Object>();
		
		if (map != null) {
			// session.put("msg", map.get("msg"));
			// session.put("buyOrderResult", map.get("buyOrder"));
			OrderCache.msg.put(userEntitys.getUserId() + "", (ResultOrderActivationCodeEntitys) map.get("msg"));
			OrderForm tempOrder = (OrderForm) map.get("buyOrder");
			tempOrder.setOpenId(data.get("transaction_id"));
										  
			OrderCache.buyOrderResult.put(userEntitys.getUserId() + "", tempOrder);
			objMap.put("return_code", "SUCCESS");

		} else {
			objMap.put("return_code", "FAIL");

		}
		OrderCache.buyuser.remove(key);
		OrderCache.goodsListMap.remove(key);
		OrderCache.orderFromMap.remove(key);
		OrderCache.upGoodsList.remove(key);
		String xml = MpPayUtill.MapToXml(objMap);
		System.out.println(xml);
		toJsonSteam(JSONObject.toJSONString(xml));

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

	@Override
	public com.business.entitys.mp.pay.PayResult getModel() {
		// TODO Auto-generated method stub
		PayResult = new PayResult();
		return PayResult;
	}

	public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
		// 解析结果存储在HashMap
		Map<String, String> map = new HashMap<String, String>();
		InputStream inputStream = request.getInputStream();
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		List<Element> elementList = root.elements();

		// 遍历所有子节点
		for (Element e : elementList)
			map.put(e.getName(), e.getText());

		// 释放资源
		inputStream.close();
		inputStream = null;

		return map;
	}
}
