package com.business.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestDate {
public static void main(String[] args) {
	   java.util.Calendar rightNow = java.util.Calendar.getInstance();
       java.text.SimpleDateFormat sim = new java.text.SimpleDateFormat("yyyy-MM-dd ");
       //得到当前时间，+3天
       rightNow.add(java.util.Calendar.DAY_OF_MONTH, 1987);   

       String date = sim.format(rightNow.getTime()); 
       System.out.println(date);
}
}
