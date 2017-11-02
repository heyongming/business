package com.business.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.business.util.mpPay.MpPayUtill;

public class Test {
	public static void main(String[] args) {
		/*
		 * String op = "/business/upload/goods/1TOVGzdoC/huajie.jpg"; int index
		 * = op.lastIndexOf("/"); op = op.substring(0, index);
		 * System.out.println(op); index = op.lastIndexOf("/");
		 * System.out.println(index); System.out.println(op.substring(index + 1,
		 * op.length()));
		 * 
		 * SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd?HH:mm:ss");//
		 * 设置日期格式 System.out.println(df.format(new Date()));// new
		 * Date()为获取当前系统时间 op=df.format(new Date()).toString(); int index1 =
		 * op.lastIndexOf("?"); System.out.println(index1);
		 * System.out.println(op.subSequence(0, index1)); SimpleDateFormat df1 =
		 * new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss"); op=df1.format(new
		 * Date()).toString(); int endIndex=index1 = op.lastIndexOf("日");
		 * System.out.println(op.substring(5, endIndex+1));
		 */
		/*
		 * String key = MpPayUtill.CreateNoncestr() +
		 * MpPayUtill.CreateNoncestr();
		 * 
		 * System.out.println(key+"位数为"+key.length()); String
		 * index="106.17.176.34, 103.44.145.245"; int
		 * indexOf=index.indexOf(","); System.out.println(index.substring(0,
		 * indexOf));
		 */
		// PdfToImageUtill.pdf2multiImage("D:/upload/pdf/4/367307429366464512.pdf",
		// "D:/bbbbb.jpg", 4);
		/*
		Date today = new Date();
		String time = today.getTime() + "";
		time = time.substring(4, time.length());
		time = 3110 + time;
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			time += random.nextInt(10);
		}
		Long.parseLong(time);
	*/
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		System.out.println("当前时间：" + sdf.format(d));
	}
}
