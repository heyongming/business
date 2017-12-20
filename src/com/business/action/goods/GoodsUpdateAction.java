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
import com.business.util.PacthUtill;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 商品修改Action
 * 
 * @ActionSupport 为struts2的提供的上下文的一个类
 * @ModelDriven 该方法返回一个用于接收用户输入数据的模型对象。
 */
public class GoodsUpdateAction extends ActionSupport implements ModelDriven<GoodsList> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 注入service层
	@Resource
	private IGoodsOperationService GoodsOperationService;
	/*
	 * AJAX处理完毕返回的流
	 */
	private InputStream bis;
	/*
	 * 商品的实体类
	 */
	private GoodsList goodsList;
	/*
	 * 用于接收用户的用户的输入
	 */
	private String goodsTypeName;
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

	// 文件描述
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// String json = GoodsOperationService.updateGoods(goodsList);
		// toJsonSteam(json);
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

	/*
	 * 修改商品类型，根据名字修改！！！！
	 */
	public String updateGoodstypes() throws Exception {
		String json = GoodsOperationService.updateGoodsTypes(goodsList, goodsTypeName);
		toJsonSteam(json);
		return super.execute();
	}

	/*
	 * 修改商品
	 */
	public String updateGoodsImage() throws Exception {
		savePath = PacthUtill.getPacthVal("goodsListImageSavePath");
		// 从配置中获得web根访问路径
		fictitiousPath = PacthUtill.getPacthVal("goodsListImageFictitiousPath");
		//获得修改前图片路径
		String op = goodsList.getImageUrl();
		//拿到出文件名以外的路径位置
		int index = op.lastIndexOf("/");
		//拿到出文件名以外的路径
		op = op.substring(0, index);
		//如果文件为空 则不对文件进行读写
		if (file == null) {
			// GoodsOperationService.updateGoodsTypes(goodsList, goodsTypeName);
			//更新
			String flog = GoodsOperationService.updateGoods(goodsList, goodsTypeName);

			if (flog != null) {
				//拉取全量数据
				String json = GoodsOperationService.getAllGoodsList();
				//返回数据
				toJsonSteam(json);

			} else {
				//异常
				bis = null;
			}
		} else {
			//拿到生成的随机数的位置
			index = op.lastIndexOf("/");
			//拿到生成的随机数
			op = op.substring(index + 1, op.length());
			InputStream is = new FileInputStream(file);
			//对文件的读写的操作
			OutputStream os = new FileOutputStream(new File(savePath + op, fileFileName));
			byte[] buffer = new byte[500];
			while (-1 != (is.read(buffer, 0, buffer.length))) {

				os.write(buffer);
			}
			os.close();
			is.close();
			
			goodsList.setImageUrl(fictitiousPath + op + "/" + fileFileName);
			//更新
			String flog = GoodsOperationService.updateGoods(goodsList, goodsTypeName);

			if (flog != null) {
				//拉取全量数据
				String json = GoodsOperationService.getAllGoodsList();
				
				toJsonSteam(json);

			} else {
				bis = null;
			}
		}

		return Action.SUCCESS;
	}
	/*
	 * 已丢弃接口
	 */
	public String switchGoodsHot() throws Exception {
		String json = GoodsOperationService.updateGoodsHot(goodsList.getGoodsId());
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
}
