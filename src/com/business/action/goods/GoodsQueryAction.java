package com.business.action.goods;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import com.business.entitys.goods.GoodsList;
import com.business.entitys.user.User;
import com.business.service.IGoodsOperationService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GoodsQueryAction extends ActionSupport implements ModelDriven<GoodsList> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private IGoodsOperationService GoodsOperationService;
	private GoodsList goodsList;
	public void setGoodsList(GoodsList goodsList) {
		this.goodsList = goodsList;
	}

	private InputStream bis;
	private int typeId;
	private int goodsId;

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

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
		return Action.SUCCESS;
	}

	public String getTypeData() {
		String json = GoodsOperationService.getTypeData(typeId);
		toJsonSteam(json);
		return Action.SUCCESS;
	}

	public String getTypeGoodsList() {
		String json = GoodsOperationService.querytypeGoodsList(typeId);
		toJsonSteam(json);
		return Action.SUCCESS;
	}

	public String getGoodsList() {
		String json = GoodsOperationService.getAllGoodsList();
		toJsonSteam(json);
		return Action.SUCCESS;
	}

	public String getGoodsListById() {
		String json = GoodsOperationService.queryGoodsListById(goodsList.getGoodsId());
		toJsonSteam(json);
		return Action.SUCCESS;
	}

	public String getHotGoodsList() {
		String json=GoodsOperationService.queryGoodsListWhenHot(goodsList);
		toJsonSteam(json);
		return Action.SUCCESS;
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
		goodsList=new GoodsList();
		
		return goodsList;
	}
}
