package com.business.entitys.order;

public class OrderActivationCode {
	private int activationCodeId;
	private String orderSerialNumber;
	private String activationCode;
	private String dateManufacture;
	private String isActivation;

	public String getIsActivation() {
		return isActivation;
	}

	public void setIsActivation(String isActivation) {
		this.isActivation = isActivation;
	}

	@Override
	public String toString() {
		return "OrderActivationCode [activationCodeId=" + activationCodeId + ", orderSerialNumber=" + orderSerialNumber
				+ ", activationCode=" + activationCode + ", dateManufacture=" + dateManufacture + "]";
	}

	public OrderActivationCode() {
		super();
	}

	public OrderActivationCode(int activationCodeId, String orderSerialNumber, String activationCode,
			String dateManufacture) {
		super();
		this.activationCodeId = activationCodeId;
		this.orderSerialNumber = orderSerialNumber;
		this.activationCode = activationCode;
		this.dateManufacture = dateManufacture;
	}

	public int getActivationCodeId() {
		return activationCodeId;
	}

	public void setActivationCodeId(int activationCodeId) {
		this.activationCodeId = activationCodeId;
	}

	public String getOrderSerialNumber() {
		return orderSerialNumber;
	}

	public void setOrderSerialNumber(String orderSerialNumber) {
		this.orderSerialNumber = orderSerialNumber;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public String getDateManufacture() {
		return dateManufacture;
	}

	public void setDateManufacture(String dateManufacture) {
		this.dateManufacture = dateManufacture;
	}
}
