package com.business.entitys.service;

import com.business.entitys.goods.GoodsList;

public class ServiceTime {
	private int id;
	private int serviceDay;
	private int goodsId;
	private String ServiceTime;
	private GoodsList goodsList;

	public ServiceTime() {
		super();
	}

	public ServiceTime(int id, int serviceDay, int goodsId, String serviceTime, GoodsList goodsList) {
		super();
		this.id = id;
		this.serviceDay = serviceDay;
		this.goodsId = goodsId;
		ServiceTime = serviceTime;
		this.goodsList = goodsList;
	}

	@Override
	public String toString() {
		return "ServiceTime [id=" + id + ", serviceDay=" + serviceDay + ", goodsId=" + goodsId + ", ServiceTime="
				+ ServiceTime + ", goodsList=" + goodsList + "]";
	}

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

	public GoodsList getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(GoodsList goodsList) {
		this.goodsList = goodsList;
	}
}
