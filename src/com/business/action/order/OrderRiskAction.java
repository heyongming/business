package com.business.action.order;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.json.JsonObject;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.order.OrderForm;
import com.business.entitys.service.ServiceTime;
import com.business.entitys.user.User;
import com.business.service.IGoodsOperationService;
import com.business.service.IOrderService;
import com.business.service.IServiceTimeService;
import com.business.service.IUserService;
import com.business.util.CheckErrorQiantaiUtill;
import com.business.util.HtmlToPdf;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderRiskAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8524709512637662219L;
	private String inputPath;

	// 下载文件的文件名
	private String fileName;

	// 读取下载文件的输入流
	private InputStream inputStream;

	// 下载文件的类型
	private String conetntType;

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getConetntType() {
		return conetntType;
	}

	public void setConetntType(String conetntType) {
		this.conetntType = conetntType;
	}

	private int userId;
	private int goodsId;
	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	private String oderId;
	@Resource
	private IOrderService orderService;
	@Resource
	private IGoodsOperationService GoodsOperationService;
	@Resource
	private IUserService userService;
	@Resource
	private IServiceTimeService serviceTimeService;

	public IServiceTimeService getServiceTimeService() {
		return serviceTimeService;
	}

	public void setServiceTimeService(IServiceTimeService serviceTimeService) {
		this.serviceTimeService = serviceTimeService;
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	public IGoodsOperationService getGoodsOperationService() {
		return GoodsOperationService;
	}

	public void setGoodsOperationService(IGoodsOperationService goodsOperationService) {
		GoodsOperationService = goodsOperationService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getOderId() {
		return oderId;
	}

	public void setOderId(String oderId) {
		this.oderId = oderId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		try {
			ActionContext actionContext = ActionContext.getContext();
			Map session = actionContext.getSession();
			GoodsList buyGoodsList = (GoodsList) session.get("buyGoodsList");
			User userEntitys = (User) session.get("buyuser");// 购买者
			OrderForm orderForm = (OrderForm) session.get("buyOrderResult");
			if (!CheckErrorQiantaiUtill.checkSession(session)) {
				ResultMessage resultMessage = new ResultMessage("-6", "false", "system all");

				String json = JSONObject.toJSONString(resultMessage);
				toJsonSteam(json);
				return this.SUCCESS;
			}
			orderService.saveOrderStatus(userEntitys.getPhone());
			orderForm.setOrderStatus(orderForm.getOrderStatus() + 1);
			session.put("buyOrderResult", orderForm);
			System.out.println("进来了");
			String json = serviceTimeService.savePdf(userEntitys, orderForm, buyGoodsList, null);
			toJsonSteam(json);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return super.execute();
	}

	public String topdfFx() throws Exception {

		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		if (!CheckErrorQiantaiUtill.checkSession(session)) {
			ResultMessage resultMessage = new ResultMessage("-6", "false", "system all");

			String json = JSONObject.toJSONString(resultMessage);
			toJsonSteam(json);
			return this.SUCCESS;
		}
		GoodsList buyGoodsList = (GoodsList) session.get("buyGoodsList");
		User userEntitys = (User) session.get("buyuser");// 购买者
		OrderForm orderForm = (OrderForm) session.get("buyOrderResult");
		orderService.saveOrderStatus(userEntitys.getPhone());

		orderForm.setOrderStatus(orderForm.getOrderStatus() + 1);
		session.put("buyOrderResult", orderForm);
		String json = serviceTimeService.savePdf(userEntitys, orderForm, buyGoodsList, "");
		toJsonSteam(json);

		return this.SUCCESS;
	}

	public String toPdfData() throws Exception {

		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		User user = userService.findByUser(userId);
		String goodsListStr = GoodsOperationService.queryGoodsListById(goodsId);
		System.out.println(goodsListStr);
		GoodsList goodsList = JSONObject.parseObject(goodsListStr, GoodsList.class);
		System.out.println("!!" + "userId" + userId + "goodsId" + goodsId + "orderNum" + oderId);
		System.out.println("chengong" + user);
		System.out.println("chengong" + goodsList);
		OrderForm tempForm = new OrderForm();
		tempForm.setOrderSerialNumber(oderId);
		String orderFormstr = orderService.findDataBywhere(tempForm);
		List<OrderForm> list = JSONObject.parseObject(orderFormstr, List.class);
		session.put("buyOderForm", list.get(0));

		session.put("buyuser", user);

		session.put("buyGoodsList", goodsList);

		return super.execute();
	}

	// 文件下载
	public InputStream getInputStream() throws Exception {

		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		GoodsList buyGoodsList = (GoodsList) session.get("buyGoodsList");
		User userEntitys = (User) session.get("buyuser");// 购买者
		OrderForm orderForm = (OrderForm) session.get("buyOrderResult");
		ServiceTime serviceTime = serviceTimeService.findServiceTimeEntity(userEntitys, buyGoodsList);
		System.out.println(serviceTime + "????");
		String path = serviceTime.getRealAgreement();
		fileName = orderForm.getOrderSerialNumber() + ".pdf";
		System.out.println("到了" + path);
		InputStream is = new FileInputStream(new File(path));
		System.out.println(is + "应该不为空");
		return is;
	}

	/**
	 * @return
	 */
	public String getPdfPath() {
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		if (!CheckErrorQiantaiUtill.checkSession(session)) {
			ResultMessage resultMessage = new ResultMessage("-6", "false", "system all");

			String json = JSONObject.toJSONString(resultMessage);
			toJsonSteam(json);
			return this.SUCCESS;
		}
		GoodsList buyGoodsList = (GoodsList) session.get("buyGoodsList");
		User userEntitys = (User) session.get("buyuser");// 购买者
		OrderForm orderForm = (OrderForm) session.get("buyOrderResult");

		orderService.saveOrderStatus(userEntitys.getPhone());
		orderForm.setOrderStatus(orderForm.getOrderStatus() + 1);
		session.put("buyOrderResult", orderForm);
		ServiceTime serviceTime = serviceTimeService.findServiceTimeEntity(userEntitys, buyGoodsList);
		String json = JSONObject.toJSONString(serviceTime);
		toJsonSteam(json);

		return this.SUCCESS;
	}

	public String downloadPdf() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		if (!CheckErrorQiantaiUtill.checkSession(session)) {
			return this.INPUT;
		}
		GoodsList buyGoodsList = (GoodsList) session.get("buyGoodsList");
		User userEntitys = (User) session.get("buyuser");// 购买者
		OrderForm orderForm = (OrderForm) session.get("buyOrderResult");

		orderService.saveOrderStatus(userEntitys.getPhone());
		orderForm.setOrderStatus(orderForm.getOrderStatus() + 1);
		session.put("buyOrderResult", orderForm);
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
