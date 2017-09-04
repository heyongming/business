package com.business.temp;

import com.business.entitys.ResultMessage;

public class ResultOrderActivationCodeEntitys extends ResultMessage {
	private String orderSerialNumber;
	private String goodsName;
	private String activationCode;

	@Override
	public String toString() {
		return super.toString() + "ResultOrderActivationCodeEntitys [orderSerialNumber=" + orderSerialNumber
				+ ", goodsName=" + goodsName + ", activationCode=" + activationCode + "]";
	}

	public ResultOrderActivationCodeEntitys() {
		super();
	}

	public ResultOrderActivationCodeEntitys(String orderSerialNumber, String goodsName, String activationCode) {
		super();
		this.orderSerialNumber = orderSerialNumber;
		this.goodsName = goodsName;
		this.activationCode = activationCode;
	}

	public String getOrderSerialNumber() {
		return orderSerialNumber;
	}

	public void setOrderSerialNumber(String orderSerialNumber) {
		this.orderSerialNumber = orderSerialNumber;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
}
