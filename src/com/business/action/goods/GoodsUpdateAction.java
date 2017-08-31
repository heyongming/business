package com.business.action.goods;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import com.business.entitys.goods.GoodsList;
import com.business.service.IGoodsOperationService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GoodsUpdateAction extends ActionSupport implements ModelDriven<GoodsList> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private IGoodsOperationService GoodsOperationService;
	private InputStream bis;
	private GoodsList goodsList;
	private String goodsTypeName;
	// 文件描述
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String savePath;
	private String fictitiousPath;

	// 文件描述
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String json = GoodsOperationService.updateGoods(goodsList);
		toJsonSteam(json);
		return super.execute();
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

	public String updateGoodstypes() throws Exception {
		String json = GoodsOperationService.updateGoodsTypes(goodsList, goodsTypeName);
		toJsonSteam(json);
		return super.execute();
	}

	public String updateGoodsImage() throws Exception {
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
		goodsList.setImageUrl(fictitiousPath + fileFileName);
		String json = GoodsOperationService.updateGoods(goodsList);
		toJsonSteam(json);
		return super.execute();
	}
	public String switchGoodsHot() throws Exception
	{
		String json=GoodsOperationService.updateGoodsHot(goodsList.getGoodsId());
		toJsonSteam(json);
		return super.execute();
	}
	public String getGoodsTypeName() {
		return goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}

	public IGoodsOperationService getGoodsOperationService() {
		return GoodsOperationService;
	}

	public void setGoodsOperationService(IGoodsOperationService goodsOperationService) {
		GoodsOperationService = goodsOperationService;
	}

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	public GoodsList getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(GoodsList goodsList) {
		this.goodsList = goodsList;
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

	@Override
	public GoodsList getModel() {
		// TODO Auto-generated method stub
		goodsList = new GoodsList();
		return goodsList;
	}
}
