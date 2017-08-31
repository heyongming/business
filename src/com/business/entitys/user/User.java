package com.business.entitys.user;

public class User {
	private int userId;
	private String passWord="0";
	private String createTime;
	private int type=0;
	private String userName;
	private String Email="0";
	private String openId="0";
	private String phone;
	private String addRess="0";
	private String integral="0";
	private String Grade="0";
	private String userStatus="0";
	private String idCard;
	private String rdCode;

	public User() {
		super();
	}

	public User(int userId, String passWord, String userName, String openId, String phone, String userStatus,
			String idCard, String rdCode) {
		super();
		this.userId = userId;
		this.passWord = passWord;
		this.userName = userName;
		this.openId = openId;
		this.phone = phone;
		this.userStatus = userStatus;
		this.idCard = idCard;
		this.rdCode = rdCode;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", passWord=" + passWord + ", createTime=" + createTime + ", type=" + type
				+ ", userName=" + userName + ", Email=" + Email + ", openId=" + openId + ", phone=" + phone
				+ ", addRess=" + addRess + ", integral=" + integral + ", Grade=" + Grade + ", userStatus=" + userStatus
				+ ", idCard=" + idCard + ", rdCode=" + rdCode + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddRess() {
		return addRess;
	}

	public void setAddRess(String addRess) {
		this.addRess = addRess;
	}

	public String getIntegral() {
		return integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public String getGrade() {
		return Grade;
	}

	public void setGrade(String grade) {
		Grade = grade;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getRdCode() {
		return rdCode;
	}

	public void setRdCode(String rdCode) {
		this.rdCode = rdCode;
	}

}