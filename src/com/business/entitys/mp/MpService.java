package com.business.entitys.mp;

public class MpService {
	private int serviceId;
	private String openId;
	private String term;
	private String updateTime;
	private String dateManufacture;
	private String goodsType;
	private String orderSerialNumber;
	private String isFrozen;

	public MpService() {
		super();
	}

	public MpService(int serviceId, String openId, String term, String updateTime, String dateManufacture,
			String goodsType, String orderSerialNumber, String isFrozen) {
		super();
		this.serviceId = serviceId;
		this.openId = openId;
		this.term = term;
		this.updateTime = updateTime;
		this.dateManufacture = dateManufacture;
		this.goodsType = goodsType;
		this.orderSerialNumber = orderSerialNumber;
		this.isFrozen = isFrozen;
	}

	@Override
	public String toString() {
		return "MpService [serviceId=" + serviceId + ", openId=" + openId + ", term=" + term + ", updateTime="
				+ updateTime + ", dateManufacture=" + dateManufacture + ", goodsType=" + goodsType
				+ ", orderSerialNumber=" + orderSerialNumber + ", isFrozen=" + isFrozen + "]";
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getDateManufacture() {
		return dateManufacture;
	}

	public void setDateManufacture(String dateManufacture) {
		this.dateManufacture = dateManufacture;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getOrderSerialNumber() {
		return orderSerialNumber;
	}

	public void setOrderSerialNumber(String orderSerialNumber) {
		this.orderSerialNumber = orderSerialNumber;
	}

	public String getIsFrozen() {
		return isFrozen;
	}

	public void setIsFrozen(String isFrozen) {
		this.isFrozen = isFrozen;
	}
}
