package com.business.entitys.autoReply;

import com.business.entitys.user.User;

public class ListUserQuery {
	private int luqId;
	private int userId;
	private String ip;
	private String questions;
	private String QueryTime;
	private User user;

	@Override
	public String toString() {
		return "ListUserQuery [luqId=" + luqId + ", userId=" + userId + ", ip=" + ip + ", questions=" + questions
				+ ", QueryTime=" + QueryTime + ", user=" + user + "]";
	}

	/**
	 * 
	 */
	public ListUserQuery() {
		super();
	}

	/**
	 * @param luqId
	 * @param userId
	 * @param ip
	 * @param questions
	 * @param queryTime
	 * @param user
	 */
	public ListUserQuery(int luqId, int userId, String ip, String questions, String queryTime, User user) {
		super();
		this.luqId = luqId;
		this.userId = userId;
		this.ip = ip;
		this.questions = questions;
		QueryTime = queryTime;
		this.user = user;
	}

	public int getLuqId() {
		return luqId;
	}

	public void setLuqId(int luqId) {
		this.luqId = luqId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getQueryTime() {
		return QueryTime;
	}

	public void setQueryTime(String queryTime) {
		QueryTime = queryTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
