package com.business.action.goods;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import com.business.service.IGoodsOperationService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GoodsQueryAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private IGoodsOperationService GoodsOperationService;
	private InputStream bis;
	private int typeId;

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	public IGoodsOperationService getGoodsOperationService() {
		return GoodsOperationService;
	}

	public void setGoodsOperationService(IGoodsOperationService goodsOperationService) {
		GoodsOperationService = goodsOperationService;
	}

	public String getAllType() {
		String json = GoodsOperationService.getAllType();
		toJsonSteam(json);
		return this.SUCCESS;
	}

	public String getTypeData() {
		String json = GoodsOperationService.getTypeData(typeId);
		toJsonSteam(json);
		return this.SUCCESS;
	}

	public String getTypeGoodsList() {
		String json = GoodsOperationService.querytypeGoodsList(typeId);
		toJsonSteam(json);
		return this.SUCCESS;
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
