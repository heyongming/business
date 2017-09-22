package com.business.test;

public class Test {
	public static void main(String[] args) {
		String op="/business/upload/goods/1TOVGzdoC/huajie.jpg";
		int index=op.lastIndexOf("/");
		op=op.substring(0, index);
		System.out.println(op);
		index=op.lastIndexOf("/");
		System.out.println(index);
		System.out.println(op.substring(index+1, op.length()));
	}
}
