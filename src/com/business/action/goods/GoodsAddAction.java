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
import com.business.util.PacthUtill;
import com.business.util.RandomUtill;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 商品添加Action
 * 
 * @ActionSupport 为struts2的提供的上下文的一个类
 * @ModelDriven 该方法返回一个用于接收用户输入数据的模型对象。
 */
public class GoodsAddAction extends ActionSupport implements ModelDriven<GoodsList> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3841533684393147198L;
	// 注入Serivce层
	@Resource
	private IGoodsOperationService GoodsOperationService;

	public IGoodsOperationService getGoodsOperationService() {
		return GoodsOperationService;
	}

	public void setGoodsOperationService(IGoodsOperationService goodsOperationService) {
		GoodsOperationService = goodsOperationService;
	}

	// 商品的实体类 用于接收用户的用户的输入
	private GoodsList goodsList;
	// 商品的类型名字 用于接收用户的用户的输入
	private String goodsTypeName;
	// 商品的类型ID 用于接收用户的用户的输入
	private String goodsTypeId;

	public String getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	/*
	 * AJAX处理完毕返回的流
	 */
	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	// 上传的文件
	private File file;
	// 上传的文件 的文件名
	private String fileFileName;
	// 上传文件的类型
	private String fileContentType;
	// 保存本地的路径 在项目的路径下面的/configs/pacth.properties里面配置
	private String savePath;
	// web访问的路径 在项目的路径下面的/configs/pacth.properties里面配置
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
	
		// 从配置文件获得商品上传文件的根保存路径
		savePath=PacthUtill.getPacthVal("goodsListImageSavePath");
		// 从配置中获得web根访问路径
		fictitiousPath=PacthUtill.getPacthVal("goodsListImageFictitiousPath");
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
		byte[] buffer = new byte[500];
		while (-1 != (is.read(buffer, 0, buffer.length))) {

			os.write(buffer);
		}
		os.close();
		is.close();
		tempPath = tempPath + fictitiousPath + "/" + fileFileName;
		goodsList.setImageUrl(tempPath);
		/*
		 * 以上为文件操作 详情注释请看com.business.action.customer里的MessageManagementAction类
		 */
		String result = GoodsOperationService.saveGoods(goodsList, goodsTypeName);
		toJsonSteam(result);
		return super.execute();
	}
	// 把JSON字符串转换成流
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
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {// 结尾是否以"/"结束
			destDirName = destDirName + File.separator;
		}
		if (dir.mkdirs()) {// 创建目标目录
			return true;
		} else {
			return false;
		}

	}
}
