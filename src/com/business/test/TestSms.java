package com.business.test;

import java.util.Random;

import javax.swing.JOptionPane;

import com.business.util.RandomUtill;
import com.business.util.SendMsg;

public class TestSms {
	public static void main(String[] args) {
	//	String op = "1=D,2=C,3=A,4=C,5=B,6=D,7=D,8=A E ,9=E,10=C,11=A E ,12=A,13=D,14=D,15=D,16=E,17=D,18=D,19=E,20=C";
	//	getRiskLevel(op);
		int res=JOptionPane.showConfirmDialog(null, "输入为空是否继续", "是否继续", JOptionPane.YES_NO_OPTION);
        if(res==JOptionPane.YES_OPTION){ 
            System.out.println("选择是后执行的代码");    //点击“是”后执行这个代码块
        }else{
            System.out.println("选择否后执行的代码");    //点击“否”后执行这个代码块
            return;
        }
	}

	private  static String getRiskLevel(String answers) {
		String answer[] = answers.split(",");
		int result = 0;
		String lv = "";
	
		for (int i = 0; i < answer.length; i++) {
			String tempStr=answer[i].replaceAll(" ", "");
			int index=tempStr.indexOf("=");
			tempStr=tempStr.substring(index+1, tempStr.length());
		
			String fist =  tempStr.substring(tempStr.length()-1, tempStr.length());
		
			if (fist.equals("E")) {
				result = result + 5;
			} else if (fist.equals("D")) {
				result = result + 4;
			} else if (fist.equals("C")) {
				result = result + 3;
			} else if (fist.equals("B")) {
				result = result + 2;
			} else if (fist.equals("A")) {
				result = result + 1;
			}

		}
		if (result >= 0 && result <= 25) {
			lv = "保守型,C1";
		} else if (result <= 40) {
			lv = "稳健型,C2";
		} else if (result <= 60) {
			lv = "成长型,C3";
		} else if (result <= 80) {
			lv = "积极型,C4";
		} else {
			lv = "激进型,C5";
		}
		System.out.println(lv);
		return lv;
	}
}
