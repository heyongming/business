package com.business.test;

import java.util.Random;

import javax.swing.JOptionPane;

import com.business.util.RandomUtill;
import com.business.util.SendMsg;

public class TestSms {
	public static void main(String[] args) {
		 String result= SendMsg.sendMsg("18175596465", "您好的的验证码是" + 44554);
		 System.out.println(result);
	}

}
