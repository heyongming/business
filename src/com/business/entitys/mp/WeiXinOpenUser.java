package com.business.entitys.mp;

import java.util.Arrays;
import java.util.List;

public class WeiXinOpenUser {
private String total;
private String count;
private OpenList data;
public String getTotal() {
	return total;
}
public void setTotal(String total) {
	this.total = total;
}
public String getCount() {
	return count;
}
public void setCount(String count) {
	this.count = count;
}
public OpenList getData() {
	return data;
}
public void setData(OpenList data) {
	this.data = data;
}
public String getNext_openid() {
	return next_openid;
}
public void setNext_openid(String next_openid) {
	this.next_openid = next_openid;
}
private String next_openid;
}

