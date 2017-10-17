package com.business.entitys.service;

import com.business.entitys.user.User;

public class ServiceArticleDetails {
	private int serviceArticleDetailsId;
	private int serviceArticleNum;
	private int evaluateId;
	private String evaluateCent;
	private int pointNumber;

	public ServiceArticleDetails() {
		super();
	}

	public ServiceArticleDetails(int serviceArticleDetailsId, int serviceArticleNum, int evaluateId,
			String evaluateCent, int pointNumber, int issecondary, int isOk, String currentDate, User user) {
		super();
		this.serviceArticleDetailsId = serviceArticleDetailsId;
		this.serviceArticleNum = serviceArticleNum;
		this.evaluateId = evaluateId;
		this.evaluateCent = evaluateCent;
		this.pointNumber = pointNumber;
		this.issecondary = issecondary;
		this.isOk = isOk;
		this.currentDate = currentDate;
		this.user = user;
	}

	@Override
	public String toString() {
		return "ServiceArticleDetails [serviceArticleDetailsId=" + serviceArticleDetailsId + ", serviceArticleNum="
				+ serviceArticleNum + ", evaluateId=" + evaluateId + ", evaluateCent=" + evaluateCent + ", pointNumber="
				+ pointNumber + ", issecondary=" + issecondary + ", isOk=" + isOk + ", currentDate=" + currentDate
				+ ", user=" + user + "]";
	}

	private int issecondary;
	private int isOk;
	private String currentDate;
	private User user;

	public int getServiceArticleDetailsId() {
		return serviceArticleDetailsId;
	}

	public void setServiceArticleDetailsId(int serviceArticleDetailsId) {
		this.serviceArticleDetailsId = serviceArticleDetailsId;
	}

	public int getServiceArticleNum() {
		return serviceArticleNum;
	}

	public void setServiceArticleNum(int serviceArticleNum) {
		this.serviceArticleNum = serviceArticleNum;
	}

	public int getEvaluateId() {
		return evaluateId;
	}

	public void setEvaluateId(int evaluateId) {
		this.evaluateId = evaluateId;
	}

	public String getEvaluateCent() {
		return evaluateCent;
	}

	public void setEvaluateCent(String evaluateCent) {
		this.evaluateCent = evaluateCent;
	}

	public int getPointNumber() {
		return pointNumber;
	}

	public void setPointNumber(int pointNumber) {
		this.pointNumber = pointNumber;
	}

	public int getIssecondary() {
		return issecondary;
	}

	public void setIssecondary(int issecondary) {
		this.issecondary = issecondary;
	}

	public int getIsOk() {
		return isOk;
	}

	public void setIsOk(int isOk) {
		this.isOk = isOk;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
