package com.business.entitys.sales;

public class SalesmanAndUser {
	private int id;
	private int userId;
	private int salesmanId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SalesmanAndUser() {
		super();
	}
	public SalesmanAndUser(int id, int userId, int salesmanId) {
		super();
		this.id = id;
		this.userId = userId;
		this.salesmanId = salesmanId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSalesmanId() {
		return salesmanId;
	}
	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}
}
