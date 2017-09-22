package com.business.action.user;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;
import javax.json.JsonObject;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.alibaba.fastjson.JSONObject;
import com.business.entitys.sales.Salesman;
import com.business.entitys.user.User;
import com.business.service.ISalesmanService;
import com.business.util.RandomUtill;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SalesmanAddUserAction extends ActionSupport implements ModelDriven<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5902852507517026309L;
	private User user;
	@Resource
	private ISalesmanService salesmanService;
	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	// 文件相关描述
	private File[] file;
	private String[] fileFileName;
	private String[] fileContentType;
	private String savePath;
	private String fictitiousPath;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ISalesmanService getSalesmanService() {
		return salesmanService;
	}

	public void setSalesmanService(ISalesmanService salesmanService) {
		this.salesmanService = salesmanService;
	}

	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getFictitiousPath() {
		return fictitiousPath;
	}

	public void setFictitiousPath(String fictitiousPath) {
		this.fictitiousPath = fictitiousPath;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		user = new User();

		return user;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		// Map request = (Map) ActionContext.getContext().get("request");
		String random = RandomUtill.randomUtil();

		fictitiousPath = fictitiousPath + user.getUserName() + random;
		savePath = savePath + user.getUserName() + random;
		String tempPath = "";
		while (!(createDir(savePath))) {
			random = RandomUtill.randomUtil();

			fictitiousPath = fictitiousPath + user.getUserName() + random;
			savePath = savePath + user.getUserName() + random;

		}

		for (int i = 0; i < file.length; i++) {
			InputStream is = new FileInputStream(file[i]);
			OutputStream os = new FileOutputStream(new File(savePath, fileFileName[i]));
			//
			// System.out.println("fileFileName: " + fileFileName[i]);
			// System.out.println("file: " + file[i].getName());
			// System.out.println("file: " + file[i].getPath());
			//
			byte[] buffer = new byte[500];
			while (-1 != (is.read(buffer, 0, buffer.length))) {

				os.write(buffer);
			}
			os.close();
			is.close();
			tempPath = tempPath + fictitiousPath +"/"+ fileFileName[i] + ",";
		}
		user.setIdImage(tempPath);
		user.setGrade(getRiskLevel(user.getAnswer()));

		Salesman salesman = (Salesman) session.get("salesmanUser");
		if (salesman == null) {
			bis = null;
			return Action.INPUT;
		}
		User requsetUser = salesmanService.saveUser(user, salesman.getUserId());
		String json = JSONObject.toJSONString(requsetUser);
		toJsonSteam(json);
		return Action.SUCCESS;

	}

	private boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {// 判断目录是否存在
			System.out.println("创建目录失败，目标目录已存在！");
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {// 结尾是否以"/"结束
			destDirName = destDirName + File.separator;
		}
		if (dir.mkdirs()) {// 创建目标目录
			System.out.println("创建目录成功！" + destDirName);
			return true;
		} else {
			System.out.println("创建目录失败！");
			return false;
		}

	}

	private static String getRiskLevel(String answers) {
		String answer[] = answers.split(",");
		int result = 0;
		String lv = "";

		for (int i = 0; i < answer.length; i++) {
			String tempStr = answer[i].replaceAll(" ", "");
			int index = tempStr.indexOf("=");
			tempStr = tempStr.substring(index + 1, tempStr.length());

			String fist = tempStr.substring(tempStr.length() - 1, tempStr.length());

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

	private void toJsonSteam(String text) {
		try {
			bis = new ByteArrayInputStream(text.getBytes("GBK"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			bis = null;
			e.printStackTrace();
		}
	}
}
