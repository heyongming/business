package com.business.entitys.service;

public class ServiceArticleType {
	private int serviceTypeId;
	private String serviceTypeName;
	private String serviceTypeImage;

	public int getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(int serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public String getServiceTypeName() {
		return serviceTypeName;
	}

	@Override
	public String toString() {
		return "ServiceArticleType [serviceTypeId=" + serviceTypeId + ", serviceTypeName=" + serviceTypeName
				+ ", serviceTypeImage=" + serviceTypeImage + "]";
	}

	public ServiceArticleType() {
		super();
	}

	public ServiceArticleType(int serviceTypeId, String serviceTypeName, String serviceTypeImage) {
		super();
		this.serviceTypeId = serviceTypeId;
		this.serviceTypeName = serviceTypeName;
		this.serviceTypeImage = serviceTypeImage;
	}

	public void setServiceTypeName(String serviceTypeName) {
		this.serviceTypeName = serviceTypeName;
	}

	public String getServiceTypeImage() {
		return serviceTypeImage;
	}

	public void setServiceTypeImage(String serviceTypeImage) {
		this.serviceTypeImage = serviceTypeImage;
	}
}
