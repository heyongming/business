package com.business.action.serviceArticle;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import com.business.entitys.service.ServiceArticle;
import com.business.service.IServiceArticleService;
import com.business.util.PacthUtill;
import com.business.util.RandomUtill;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 微信文章添加
 */
public class ServiceArticleAddAction extends ActionSupport implements ModelDriven<ServiceArticle> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8277931358208446942L;
	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	private ServiceArticle serviceArticle;
	@Resource
	private IServiceArticleService serviceArticleService;

	public IServiceArticleService getServiceArticleService() {
		return serviceArticleService;
	}

	public void setServiceArticleService(IServiceArticleService serviceArticleService) {
		this.serviceArticleService = serviceArticleService;
	}

	public ServiceArticle getServiceArticle() {
		return serviceArticle;
	}

	public void setServiceArticle(ServiceArticle serviceArticle) {
		this.serviceArticle = serviceArticle;
	}

	// 文件相关描述
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String savePath;
	private String fictitiousPath;
	// 文件相关描述

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
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
	public ServiceArticle getModel() {
		// TODO Auto-generated method stub
		serviceArticle = new ServiceArticle();
		return serviceArticle;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		savePath=PacthUtill.getPacthVal("serviceArticlePath");
		fictitiousPath=PacthUtill.getPacthVal("serviceArticlefictitiousPath");
		String random = RandomUtill.randomUtil();
		fictitiousPath = fictitiousPath + serviceArticle.getServiceArticleTitle() + random;
		savePath = savePath + serviceArticle.getServiceArticleTitle() + random;
		String tempPath = "";
		while (!(createDir(savePath))) {

			random = RandomUtill.randomUtil();
			fictitiousPath = fictitiousPath + serviceArticle.getServiceArticleTitle() + random;
			savePath = savePath + serviceArticle.getServiceArticleTitle() + random;

		}
		InputStream is = new FileInputStream(file);
		OutputStream os = new FileOutputStream(new File(savePath, fileFileName));
		byte[] buffer = new byte[500];
		while (-1 != (is.read(buffer, 0, buffer.length))) {

			os.write(buffer);
		}
		os.close();
		is.close();
		tempPath = tempPath + fictitiousPath + "/" + fileFileName;
		serviceArticle.setThumbnail(tempPath);
		String result = serviceArticleService.saveServiceArticle(serviceArticle);
		toJsonSteam(result);
		return super.execute();
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

	private Boolean startTask() {
		
		return true;
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
