package com.business.temp;

public class SmsEntitys {
	private String account;
	private String pswd;
	private String mobile;
	private String msg;
	private boolean needstatus;
	private String extno;

	@Override
	public String toString() {
		return "SmsEntitys [account=" + account + ", pswd=" + pswd + ", mobile=" + mobile + ", msg=" + msg
				+ ", needstatus=" + needstatus + ", extno=" + extno + "]";
	}

	public SmsEntitys() {
		super();
	}

	public SmsEntitys(String account, String pswd, String mobile, String msg, boolean needstatus, String extno) {
		super();
		this.account = account;
		this.pswd = pswd;
		this.mobile = mobile;
		this.msg = msg;
		this.needstatus = needstatus;
		this.extno = extno;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isNeedstatus() {
		return needstatus;
	}

	public void setNeedstatus(boolean needstatus) {
		this.needstatus = needstatus;
	}

	public String getExtno() {
		return extno;
	}

	public void setExtno(String extno) {
		this.extno = extno;
	}
}
