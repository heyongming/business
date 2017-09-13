package com.business.entitys.user;

public class UserBuyTemp {
	private String orderSerialNumber;
	private String idCard;

	public UserBuyTemp() {
		super();
	}

	public UserBuyTemp(String orderSerialNumber, String idCard) {
		super();
		this.orderSerialNumber = orderSerialNumber;
		this.idCard = idCard;
	}

	public String getOrderSerialNumber() {
		return orderSerialNumber;
	}

	public void setOrderSerialNumber(String orderSerialNumber) {
		this.orderSerialNumber = orderSerialNumber;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
}
