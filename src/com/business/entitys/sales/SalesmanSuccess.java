package com.business.entitys.sales;

import com.business.entitys.goods.GoodsList;

public class SalesmanSuccess {
	private int successId;
	private String customerName;
	private String customerPhone;
	private String customerPhoneRdCode;
	private String serviceManager;
	private int serviceSalesman;
	private String orderPhone;
	private String orderWxId;
	private String orderDate;
	private int goodsId;
	private int allPrice;
	private String payMthod;
	private String payVoucher;
	private String orderNumber;
	private String isUpgrade;
	private String isInvoice;
	private GoodsList goodsList;
	private Salesman salesman;
	public int getSuccessId() {
		return successId;
	}
	public void setSuccessId(int successId) {
		this.successId = successId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerPhoneRdCode() {
		return customerPhoneRdCode;
	}
	public void setCustomerPhoneRdCode(String customerPhoneRdCode) {
		this.customerPhoneRdCode = customerPhoneRdCode;
	}
	public String getServiceManager() {
		return serviceManager;
	}
	public void setServiceManager(String serviceManager) {
		this.serviceManager = serviceManager;
	}
	public int getServiceSalesman() {
		return serviceSalesman;
	}
	public void setServiceSalesman(int serviceSalesman) {
		this.serviceSalesman = serviceSalesman;
	}
	public String getOrderPhone() {
		return orderPhone;
	}
	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}
	public String getOrderWxId() {
		return orderWxId;
	}
	public void setOrderWxId(String orderWxId) {
		this.orderWxId = orderWxId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getAllPrice() {
		return allPrice;
	}
	public void setAllPrice(int allPrice) {
		this.allPrice = allPrice;
	}
	public String getPayMthod() {
		return payMthod;
	}
	public void setPayMthod(String payMthod) {
		this.payMthod = payMthod;
	}
	public String getPayVoucher() {
		return payVoucher;
	}
	public void setPayVoucher(String payVoucher) {
		this.payVoucher = payVoucher;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getIsUpgrade() {
		return isUpgrade;
	}
	public void setIsUpgrade(String isUpgrade) {
		this.isUpgrade = isUpgrade;
	}
	public String getIsInvoice() {
		return isInvoice;
	}
	public void setIsInvoice(String isInvoice) {
		this.isInvoice = isInvoice;
	}
	public GoodsList getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(GoodsList goodsList) {
		this.goodsList = goodsList;
	}
	public Salesman getSalesman() {
		return salesman;
	}
	public void setSalesman(Salesman salesman) {
		this.salesman = salesman;
	}
	@Override
	public String toString() {
		return "SalesmanSuccess [successId=" + successId + ", customerName=" + customerName + ", customerPhone="
				+ customerPhone + ", customerPhoneRdCode=" + customerPhoneRdCode + ", serviceManager=" + serviceManager
				+ ", serviceSalesman=" + serviceSalesman + ", orderPhone=" + orderPhone + ", orderWxId=" + orderWxId
				+ ", orderDate=" + orderDate + ", goodsId=" + goodsId + ", allPrice=" + allPrice + ", payMthod="
				+ payMthod + ", payVoucher=" + payVoucher + ", orderNumber=" + orderNumber + ", isUpgrade=" + isUpgrade
				+ ", isInvoice=" + isInvoice + ", goodsList=" + goodsList + ", salesman=" + salesman + "]";
	}
	public SalesmanSuccess(int successId, String customerName, String customerPhone, String customerPhoneRdCode,
			String serviceManager, int serviceSalesman, String orderPhone, String orderWxId, String orderDate,
			int goodsId, int allPrice, String payMthod, String payVoucher, String orderNumber, String isUpgrade,
			String isInvoice, GoodsList goodsList, Salesman salesman) {
		super();
		this.successId = successId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerPhoneRdCode = customerPhoneRdCode;
		this.serviceManager = serviceManager;
		this.serviceSalesman = serviceSalesman;
		this.orderPhone = orderPhone;
		this.orderWxId = orderWxId;
		this.orderDate = orderDate;
		this.goodsId = goodsId;
		this.allPrice = allPrice;
		this.payMthod = payMthod;
		this.payVoucher = payVoucher;
		this.orderNumber = orderNumber;
		this.isUpgrade = isUpgrade;
		this.isInvoice = isInvoice;
		this.goodsList = goodsList;
		this.salesman = salesman;
	}
	public SalesmanSuccess() {
		super();
	}
	

}
