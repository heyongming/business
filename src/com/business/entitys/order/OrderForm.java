package com.business.entitys.order;

import com.business.entitys.goods.GoodsList;
import com.business.entitys.user.User;

public class OrderForm {
	private String orderSerialNumber;
	private int goodsId;
	private String purchaseTime;
	private String memberDiscount = "1";
	private String actualPurchasePriceGoods = "1";
	private int orderStatus;
	private int userId;
	private String openId = "1";
	private String paymentMethod = "1";
	private String rdCode;
	private String invoiceInformation;
	private String integral = "1";
	private String paymentNumber;
	private GoodsList goodsList;
	private User user;
	private OrderActivationCode activationCode;

	public OrderForm(String orderSerialNumber, int goodsId, String purchaseTime, String memberDiscount,
			String actualPurchasePriceGoods, int orderStatus, int userId, String openId, String paymentMethod,
			String rdCode, String invoiceInformation, String integral, String paymentNumber, GoodsList goodsList,
			User user, OrderActivationCode activationCode) {
		super();
		this.orderSerialNumber = orderSerialNumber;
		this.goodsId = goodsId;
		this.purchaseTime = purchaseTime;
		this.memberDiscount = memberDiscount;
		this.actualPurchasePriceGoods = actualPurchasePriceGoods;
		this.orderStatus = orderStatus;
		this.userId = userId;
		this.openId = openId;
		this.paymentMethod = paymentMethod;
		this.rdCode = rdCode;
		this.invoiceInformation = invoiceInformation;
		this.integral = integral;
		this.paymentNumber = paymentNumber;
		this.goodsList = goodsList;
		this.user = user;
		this.activationCode = activationCode;
	}

	public OrderActivationCode getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(OrderActivationCode activationCode) {
		this.activationCode = activationCode;
	}

	public String getOrderSerialNumber() {
		return orderSerialNumber;
	}

	public void setOrderSerialNumber(String orderSerialNumber) {
		this.orderSerialNumber = orderSerialNumber;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(String purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	@Override
	public String toString() {
		return "OrderForm [orderSerialNumber=" + orderSerialNumber + ", goodsId=" + goodsId + ", purchaseTime="
				+ purchaseTime + ", memberDiscount=" + memberDiscount + ", actualPurchasePriceGoods="
				+ actualPurchasePriceGoods + ", orderStatus=" + orderStatus + ", userId=" + userId + ", openId="
				+ openId + ", paymentMethod=" + paymentMethod + ", rdCode=" + rdCode + ", invoiceInformation="
				+ invoiceInformation + ", integral=" + integral + ", paymentNumber=" + paymentNumber + ", goodsList="
				+ goodsList + ", user=" + user + ", activationCode=" + activationCode + ", getActivationCode()="
				+ getActivationCode() + ", getOrderSerialNumber()=" + getOrderSerialNumber() + ", getGoodsId()="
				+ getGoodsId() + ", getPurchaseTime()=" + getPurchaseTime() + ", getMemberDiscount()="
				+ getMemberDiscount() + ", getActualPurchasePriceGoods()=" + getActualPurchasePriceGoods()
				+ ", getOrderStatus()=" + getOrderStatus() + ", getUserId()=" + getUserId() + ", getOpenId()="
				+ getOpenId() + ", getPaymentMethod()=" + getPaymentMethod() + ", getRdCode()=" + getRdCode()
				+ ", getInvoiceInformation()=" + getInvoiceInformation() + ", getIntegral()=" + getIntegral()
				+ ", getPaymentNumber()=" + getPaymentNumber() + ", getGoodsList()=" + getGoodsList() + ", getUser()="
				+ getUser() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public OrderForm() {
		super();
	}

	public OrderForm(String orderSerialNumber, int goodsId, String purchaseTime, String memberDiscount,
			String actualPurchasePriceGoods, int orderStatus, int userId, String openId, String paymentMethod,
			String rdCode, String invoiceInformation, String integral, String paymentNumber, GoodsList goodsList,
			User user) {
		super();
		this.orderSerialNumber = orderSerialNumber;
		this.goodsId = goodsId;
		this.purchaseTime = purchaseTime;
		this.memberDiscount = memberDiscount;
		this.actualPurchasePriceGoods = actualPurchasePriceGoods;
		this.orderStatus = orderStatus;
		this.userId = userId;
		this.openId = openId;
		this.paymentMethod = paymentMethod;
		this.rdCode = rdCode;
		this.invoiceInformation = invoiceInformation;
		this.integral = integral;
		this.paymentNumber = paymentNumber;
		this.goodsList = goodsList;
		this.user = user;
	}

	public String getMemberDiscount() {
		return memberDiscount;
	}

	public void setMemberDiscount(String memberDiscount) {
		this.memberDiscount = memberDiscount;
	}

	public String getActualPurchasePriceGoods() {
		return actualPurchasePriceGoods;
	}

	public void setActualPurchasePriceGoods(String actualPurchasePriceGoods) {
		this.actualPurchasePriceGoods = actualPurchasePriceGoods;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getRdCode() {
		return rdCode;
	}

	public void setRdCode(String rdCode) {
		this.rdCode = rdCode;
	}

	public String getInvoiceInformation() {
		return invoiceInformation;
	}

	public void setInvoiceInformation(String invoiceInformation) {
		this.invoiceInformation = invoiceInformation;
	}

	public String getIntegral() {
		return integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public String getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(String paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public GoodsList getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(GoodsList goodsList) {
		this.goodsList = goodsList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
