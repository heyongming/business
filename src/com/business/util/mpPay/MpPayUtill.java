package com.business.util.mpPay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.business.job.WxPayConfig;

public class MpPayUtill {
	public static boolean IsNumeric(String str) {
		if (str.matches("\\d *")) {
			return true;
		} else {
			return false;
		}
	}

	// map转成xml
	public static String MapToXml(HashMap<String, Object> arr) {
		String xml = "<xml>";

		Iterator<Entry<String, Object>> iter = arr.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, Object> entry = iter.next();
			String key = entry.getKey();
			String val = entry.getValue() + "";
			if (IsNumeric(val)) {
				xml += "<" + key + ">" + val + "</" + key + ">";

			} else
				xml += "<" + key + "><![CDATA[" + val + "]]></" + key + ">";
		}

		xml += "</xml>";
		return xml;
	}

	// xml转成map
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXml(String xml) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		Document document = DocumentHelper.parseText(xml);
		Element root = document.getRootElement();
		List<Element> elementList = root.elements();
		for (Element e : elementList) {
			map.put(e.getName(), e.getText());
		}
		return map;
	}

	public static String FormatParamMap(HashMap<String, Object> parameters) throws Exception {
		String buff = "";
		try {
			List<Map.Entry<String, Object>> infoIds = new ArrayList<Map.Entry<String, Object>>(parameters.entrySet());
			Collections.sort(infoIds, new Comparator<Map.Entry<String, Object>>() {
				public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
					return (o1.getKey()).toString().compareTo(o2.getKey());
				}
			});

			for (int i = 0; i < infoIds.size(); i++) {
				Map.Entry<String, Object> item = infoIds.get(i);
				if (item.getKey() != "") {
					buff += item.getKey() + "=" + URLEncoder.encode(item.getValue() + "", "utf-8") + "&";
				}
			}
			if (buff.isEmpty() == false) {
				buff = buff.substring(0, buff.length() - 1);
			}
		} catch (Exception e) {
			// throw new SDKRuntimeException(e.getMessage());
		}
		return buff;
	}

	public static String CreateNoncestr() {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String res = "";
		for (int i = 0; i < 16; i++) {
			Random rd = new Random();
			res += chars.charAt(rd.nextInt(chars.length() - 1));
		}
		return res;
	}

	/////
	public static String getSign(HashMap<String, Object> param) {
		String bizString = FormatBizQueryParaMap(param, false);
		return sign(bizString, WxPayConfig.KEY);
	}

	public static String sign(String content, String key) {
		String signStr = content + "&key=" + key;
		return MD5(signStr).toUpperCase();
	}

	public static String FormatBizQueryParaMap(Map paraMap, boolean urlencode) {
		String sf = "";

		try {
			List<Entry> infoIds = new ArrayList<Entry>(paraMap.entrySet());
			Collections.sort(infoIds, new Comparator<Entry>() {
				public int compare(Map.Entry o1, Map.Entry o2) {
					return (o1.getKey().toString().compareTo(o2.getKey().toString()));
				}
			});
			for (int i = 0; i < infoIds.size(); i++) {
				Map.Entry entryItem = infoIds.get(i);
				if (entryItem.getKey() != "") {
					String key = (String) entryItem.getKey();
					
					String value = (String) (entryItem.getValue()+"");
					
					if (urlencode) {
						value = URLEncoder.encode(value, "utf-8");
					}
					sf += key + "=" + value + "&";
				}
			}
			if (sf.isEmpty() == false) {
				sf = sf.substring(0, sf.length() - 1);
			}
		} catch (Exception e) {
			// throw new Exception(e.getMessage());
			e.printStackTrace();
		}

		return sf;
	}

	public static String Sign(String content, String key) {
		String signStr = "";
		if ("" == key) {

		}
		if ("" == content) {

		}
		signStr = content + "&key=" + key;
		return MD5(signStr).toUpperCase();
	}

	public final static String MD5(String str) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		try {
			byte[] btInput = str.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			int j = md.length;
			char str2[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str2[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str2[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String sendPost(String url, String param, String charset) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(new String(param.getBytes(), charset));
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	public static String getRandomString() {
		Random random = new Random();
		StringBuffer nonceStrSf = new StringBuffer();
		for (int i = 0; i < 32; i++) {
			nonceStrSf.append(nonceStrSf.charAt(random.nextInt(nonceStrSf.length() - 1)));
		}
		return nonceStrSf.toString();
	}
}
