package com.business.entitys.autoReply;

import com.business.entitys.user.User;

public class MessageManagement {
	private int mmId;
	private String messageTime;
	private String phone;
	private String messageType;
	private String ip;
	private int userId;
	private String messageContent;
	private String messageImage;

	/**
	 * 
	 */
	public MessageManagement() {
		super();
	}

	private User user;

	/**
	 * @param mmId
	 * @param messageTime
	 * @param phone
	 * @param messageType
	 * @param ip
	 * @param userId
	 * @param messageContent
	 * @param messageImage
	 * @param user
	 */
	public MessageManagement(int mmId, String messageTime, String phone, String messageType, String ip, int userId,
			String messageContent, String messageImage, User user) {
		super();
		this.mmId = mmId;
		this.messageTime = messageTime;
		this.phone = phone;
		this.messageType = messageType;
		this.ip = ip;
		this.userId = userId;
		this.messageContent = messageContent;
		this.messageImage = messageImage;
		this.user = user;
	}

	@Override
	public String toString() {
		return "MessageManagement [mmId=" + mmId + ", messageTime=" + messageTime + ", phone=" + phone
				+ ", messageType=" + messageType + ", ip=" + ip + ", userId=" + userId + ", messageContent="
				+ messageContent + ", messageImage=" + messageImage + ", user=" + user + "]";
	}

	public int getMmId() {
		return mmId;
	}

	public void setMmId(int mmId) {
		this.mmId = mmId;
	}

	public String getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageImage() {
		return messageImage;
	}

	public void setMessageImage(String messageImage) {
		this.messageImage = messageImage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
