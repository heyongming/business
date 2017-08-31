package com.business.entitys;

public class ResultMessage {
		private String code;

	@Override
	public String toString() {
		return "ResultMessage [code=" + code + ", success=" + success + ", errMsg=" + errMsg + "]";
	}

	public ResultMessage() {
		super();
	}

	public ResultMessage(String code, String success, String errMsg) {
		super();
		this.code = code;
		this.success = success;
		this.errMsg = errMsg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	private String success;
	private String errMsg;
}
