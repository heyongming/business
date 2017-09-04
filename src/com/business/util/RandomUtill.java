package com.business.util;

import java.util.Random;

public class RandomUtill {
	public static String randomUtil() {
		Random r = new Random();
		String code = "";
		for (int i = 0; i < 8; ++i) {
			int temp = r.nextInt(52);
			char x = (char) (temp < 26 ? temp + 97 : (temp % 26) + 65);
			code += x;
		}
		return code;
	}
}
