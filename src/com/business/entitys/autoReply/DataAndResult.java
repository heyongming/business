package com.business.entitys.autoReply;


/*
 * method="前台传来的那个方法"
 * data="前台传来的数据"
 * result="返回给前台相应的数据"
 */

public class DataAndResult {
	private int method;
	private String data;
	private String result;

	@Override
	public String toString() {
		return "DataAndResult [method=" + method + ", data=" + data + ", result=" + result + "]";
	}

	/**
	 * @param method
	 * @param data
	 * @param result
	 */
	public DataAndResult(int method, String data, String result) {
		super();
		this.method = method;
		this.data = data;
		this.result = result;
	}

	/**
	 * 
	 */
	public DataAndResult() {
		super();
	}

	public int getMethod() {
		return method;
	}

	public void setMethod(int method) {
		this.method = method;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


}
