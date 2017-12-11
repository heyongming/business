package com.business.util;

import java.io.FileReader;
import java.util.Properties;

public class PacthUtill {
private final static String path = PacthUtill.class.getResource("/configs/pacth.properties").getPath();
	public static String getPacthVal(String key) {
		try {
		
			// 读取配置文件
			
			Properties props = new Properties();
			// props.load(PropertiesTest.class.getClassLoader().getResourceAsStream(fileName));//如果配置文件放在类目录下，可以直接通过类加载器读取
			props.load(new FileReader(path));

			// 获取属性值
			String val = props.getProperty(key);
			return val;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
