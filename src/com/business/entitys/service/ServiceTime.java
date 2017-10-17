package com.business.entitys.service;

import com.business.entitys.goods.GoodsList;
import com.business.entitys.user.User;

public class ServiceTime {
	private int id;
	private int serviceDay;
	private int goodsId;
	private String ServiceTime;
	private int userId;
	private int isActivation = -1;
	private GoodsList goodsList;
	private User user;
	private String agreement;
	private String realAgreement;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getServiceDay() {
		return serviceDay;
	}

	public void setServiceDay(int serviceDay) {
		this.serviceDay = serviceDay;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getServiceTime() {
		return ServiceTime;
	}

	public void setServiceTime(String serviceTime) {
		ServiceTime = serviceTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getIsActivation() {
		return isActivation;
	}

	public void setIsActivation(int isActivation) {
		this.isActivation = isActivation;
	}

	public GoodsList getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(GoodsList goodsList) {
		this.goodsList = goodsList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public String getRealAgreement() {
		return realAgreement;
	}

	public void setRealAgreement(String realAgreement) {
		this.realAgreement = realAgreement;
	}

	@Override
	public String toString() {
		return "ServiceTime [id=" + id + ", serviceDay=" + serviceDay + ", goodsId=" + goodsId + ", ServiceTime="
				+ ServiceTime + ", userId=" + userId + ", isActivation=" + isActivation + ", goodsList=" + goodsList
				+ ", user=" + user + ", agreement=" + agreement + ", realAgreement=" + realAgreement + "]";
	}

	public ServiceTime(int id, int serviceDay, int goodsId, String serviceTime, int userId, int isActivation,
			GoodsList goodsList, User user, String agreement, String realAgreement) {
		super();
		this.id = id;
		this.serviceDay = serviceDay;
		this.goodsId = goodsId;
		ServiceTime = serviceTime;
		this.userId = userId;
		this.isActivation = isActivation;
		this.goodsList = goodsList;
		this.user = user;
		this.agreement = agreement;
		this.realAgreement = realAgreement;
	}

	public ServiceTime() {
		super();
	}

}
