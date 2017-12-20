package com.business.action.goods;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.user.User;
import com.business.service.IGoodsOperationService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 商品查询Action
 * 
 * @ActionSupport 为struts2的提供的上下文的一个类
 * @ModelDriven 该方法返回一个用于接收用户输入数据的模型对象。
 */
public class GoodsQueryAction extends ActionSupport implements ModelDriven<GoodsList> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//注入service层
	@Resource
	private IGoodsOperationService GoodsOperationService;
	//商品实体
	private GoodsList goodsList;

	public void setGoodsList(GoodsList goodsList) {
		this.goodsList = goodsList;
	}
	/*
	 * AJAX处理完毕返回的流
	 */
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
	/*
	 * 返回所有的商品类型
	 */
	public String getAllType() {
		String json = GoodsOperationService.getAllType();
		toJsonSteam(json);
		return Action.SUCCESS;
	}
	/*
	 * 返回指定ID的商品类型
	 */
	public String getTypeData() {
		String json = GoodsOperationService.getTypeData(typeId);
		toJsonSteam(json);
		return Action.SUCCESS;
	}
	/*
	 * 返回指定ID的商品类型,复用接口
	 */
	public String getTypeGoodsList() {
		String json = GoodsOperationService.querytypeGoodsList(typeId);
		toJsonSteam(json);
		return Action.SUCCESS;
	}
	/*
	 * 返回所有商品
	 */
	public String getGoodsList() {
		String json = GoodsOperationService.getAllGoodsList();
		toJsonSteam(json);
		return Action.SUCCESS;
	}
	/*
	 * 根据商品ID返回对应的商品
	 */
	public String getGoodsListById() {
		String json = GoodsOperationService.queryGoodsListById(goodsList.getGoodsId());
		toJsonSteam(json);
		return Action.SUCCESS;
	}
	/*
	 * 已丢弃，不用处理
	 */
	public String getHotGoodsList() {
		String json = GoodsOperationService.queryGoodsListWhenHot(goodsList);
		toJsonSteam(json);
		return Action.SUCCESS;
	}
	/*
	 * 返回商品详情
	 */
	public String getdetailsById() throws Exception {

		Map request = (Map) ActionContext.getContext().get("request");
		String json = GoodsOperationService.queryGoodsListById(goodsList.getGoodsId());
		if (json.length() < 10) {
			return this.input();
		}
		GoodsList goodsList = JSONObject.parseObject(json, GoodsList.class);
		request.put("details", goodsList);
		return Action.SUCCESS;
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
