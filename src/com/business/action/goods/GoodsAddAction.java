package com.business.action.goods;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.business.entitys.goods.GoodsList;
import com.business.service.IGoodsOperationService;
import com.business.util.RandomUtill;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GoodsAddAction extends ActionSupport implements ModelDriven<GoodsList> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3841533684393147198L;
	@Resource
	private IGoodsOperationService GoodsOperationService;

	public IGoodsOperationService getGoodsOperationService() {
		return GoodsOperationService;
	}

	public void setGoodsOperationService(IGoodsOperationService goodsOperationService) {
		GoodsOperationService = goodsOperationService;
	}

	private GoodsList goodsList;
	private String goodsTypeName;
	private String goodsTypeId;

	public String getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	// 文件相关描述
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String savePath;
	private String fictitiousPath;

	public String getFictitiousPath() {
		return fictitiousPath;
	}

	public void setFictitiousPath(String fictitiousPath) {
		this.fictitiousPath = fictitiousPath;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	// 文件相关描述

	public String getGoodsTypeName() {
		return goodsTypeName;
	}

	public GoodsList getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(GoodsList goodsList) {
		this.goodsList = goodsList;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}

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

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// String root =
		// ServletActionContext.getServletContext().getRealPath("/upload/");
		String random = RandomUtill.randomUtil();
		fictitiousPath = fictitiousPath + goodsList.getGoodsName() + random;
		savePath = savePath + goodsList.getGoodsName() + random;
		String tempPath = "";
		while (!(createDir(savePath))) {

			random = RandomUtill.randomUtil();
			fictitiousPath = fictitiousPath + goodsList.getGoodsName() + random;
			savePath = savePath + goodsList.getGoodsName() + random;

		}
		InputStream is = new FileInputStream(file);
		OutputStream os = new FileOutputStream(new File(savePath, fileFileName));
		System.out.println("fileFileName: " + fileFileName);
		System.out.println("file: " + file.getName());
		System.out.println("file: " + file.getPath());

		byte[] buffer = new byte[500];
		while (-1 != (is.read(buffer, 0, buffer.length))) {

			os.write(buffer);
		}
		os.close();
		is.close();
		tempPath = tempPath + fictitiousPath + "/" + fileFileName;
		goodsList.setImageUrl(tempPath);

		String result = GoodsOperationService.saveGoods(goodsList, goodsTypeName);
		System.out.println(result+"joooo");
		toJsonSteam(result);
		return super.execute();
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

	@Override
	public GoodsList getModel() {
		// TODO Auto-generated method stub
		goodsList = new GoodsList();
		return goodsList;
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
}
