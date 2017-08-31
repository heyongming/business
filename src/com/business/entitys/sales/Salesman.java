package com.business.entitys.sales;

public class Salesman {
private int userId;
private String userName;
private String phone;
private String type;
private String insertTime;
	private String passWord;

	public Salesman() {
		super();
	}

	public Salesman(int userId, String userName, String phone, String type, String insertTime, String passWord) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phone = phone;
		this.type = type;
		this.insertTime = insertTime;
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "Salesman [userId=" + userId + ", userName=" + userName + ", phone=" + phone + ", type=" + type
				+ ", insertTime=" + insertTime + ", passWord=" + passWord + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
