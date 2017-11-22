package com.business.action.customer;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.opensymphony.xwork2.ActionSupport;

public class WeclomeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8936917140788580504L;
	private String path;
	private String title;
	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ResultMessage message = null;
		File file = new File(path, "Welcome.txt");
		try {
			file.createNewFile(); // 创建文件
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 向文件写入内容(输出流)
		String str = title;
		byte bt[] = new byte[1024];
		bt = str.getBytes();
		try {
			FileOutputStream in = new FileOutputStream(file);
			try {
				in.write(bt, 0, bt.length);
				in.close();
				// boolean success=true;
				// System.out.println("写入文件成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				message = new ResultMessage("-1", "false", "设置失败");
				toJsonSteam(JSONObject.toJSONString(message));

				return this.SUCCESS;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			message = new ResultMessage("-1", "false", "设置失败");
			toJsonSteam(JSONObject.toJSONString(message));

			return this.SUCCESS;
		}
		message = new ResultMessage("1", "true", "设置成功");
		toJsonSteam(JSONObject.toJSONString(message));

		return this.SUCCESS;
	}

	public String getWelcome() {
		BufferedReader bufferedReader = null;
		ResultMessage message = null;
		String str = "";
		try {
			// 读取文件内容 (输入流)
			File file = new File(path, "Welcome.txt");
			FileInputStream out = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(out);
			bufferedReader = new BufferedReader(isr);

			String temp = null;
			while (true) {

				temp = bufferedReader.readLine();
				if (temp == null) {
					break;
				}

				str += temp;

			}
		} catch (Exception e) {
			// TODO: handle exception

			message = new ResultMessage("-1", "false", "读取失败");
			toJsonSteam(JSONObject.toJSONString(message));

			return this.SUCCESS;
		}
		System.out.println(str);
		message = new ResultMessage("1", "true", str);
		toJsonSteam(JSONObject.toJSONString(message));

		return this.SUCCESS;
	}

	private void toJsonSteam(String text) {
		try {
			bis = new ByteArrayInputStream(text.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			bis = null;
			e.printStackTrace();
		}
	}

}
