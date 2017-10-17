package com.business.entitys.service;

public class ServiceArticleDetailsHelper {
	private int detailsHelpId;
	private int evaluateId;
	private int toevaluateId;
	private String insertTime;

	public int getDetailsHelpId() {
		return detailsHelpId;
	}

	public void setDetailsHelpId(int detailsHelpId) {
		this.detailsHelpId = detailsHelpId;
	}

	public int getEvaluateId() {
		return evaluateId;
	}

	public void setEvaluateId(int evaluateId) {
		this.evaluateId = evaluateId;
	}

	public int getToevaluateId() {
		return toevaluateId;
	}

	public void setToevaluateId(int toevaluateId) {
		this.toevaluateId = toevaluateId;
	}

	public ServiceArticleDetailsHelper() {
		super();
	}

	public ServiceArticleDetailsHelper(int detailsHelpId, int evaluateId, int toevaluateId, String insertTime) {
		super();
		this.detailsHelpId = detailsHelpId;
		this.evaluateId = evaluateId;
		this.toevaluateId = toevaluateId;
		this.insertTime = insertTime;
	}

	public String getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}
}
