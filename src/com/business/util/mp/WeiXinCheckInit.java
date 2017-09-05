package com.business.util.mp;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.business.entitys.mp.WeiXinVerification;

//微信初始化工具类
public class WeiXinCheckInit {
	private static final String token = "hym74561314";

	public static Boolean checkSignature(WeiXinVerification weiXinVerification) {

		String[] arr = new String[] { token, weiXinVerification.getTimestamp(), weiXinVerification.getNonce() };
		// 排序
		Arrays.sort(arr);
		// 把所微信所需要的东西合成一个字符串
		StringBuffer content = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}
		// 加密后的字符串
		String encryptionStr = getSha1(content.toString());

		return encryptionStr.equals(weiXinVerification.getSignature());
	}

	public static String getSha1(String str) {
		if (null == str || 0 == str.length()) {
			return null;
		}
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes("UTF-8"));

			byte[] md = mdTemp.digest();
			int j = md.length;
			char[] buf = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
