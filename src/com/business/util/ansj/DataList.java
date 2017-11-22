package com.business.util.ansj;

public class DataList {
	private int num;
	private String data;
	/**
	 * 
	 */
	public DataList() {
		super();
	}
	/**
	 * @param num
	 * @param data
	 */
	public DataList(int num, String data) {
		super();
		this.num = num;
		this.data = data;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
