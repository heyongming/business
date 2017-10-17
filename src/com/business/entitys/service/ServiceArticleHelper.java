package com.business.entitys.service;

public class ServiceArticleHelper {
	private  int helpId;
	private  int serviceArticleDetailsId;
	private  int userId;
	private String insertTime;
	public ServiceArticleHelper() {
		super();
	}
	public ServiceArticleHelper(int helpId, int serviceArticleDetailsId, int userId, String insertTime) {
		super();
		this.helpId = helpId;
		this.serviceArticleDetailsId = serviceArticleDetailsId;
		this.userId = userId;
		this.insertTime = insertTime;
	}
	@Override
	public String toString() {
		return "ServiceArticleHelper [helpId=" + helpId + ", serviceArticleDetailsId=" + serviceArticleDetailsId
				+ ", userId=" + userId + ", insertTime=" + insertTime + "]";
	}
	public int getHelpId() {
		return helpId;
	}
	public void setHelpId(int helpId) {
		this.helpId = helpId;
	}
	public int getServiceArticleDetailsId() {
		return serviceArticleDetailsId;
	}
	public void setServiceArticleDetailsId(int serviceArticleDetailsId) {
		this.serviceArticleDetailsId = serviceArticleDetailsId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}
}
