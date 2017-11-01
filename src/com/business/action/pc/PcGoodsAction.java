package com.business.action.pc;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.goods.GoodsList;
import com.business.service.IGoodsOperationService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PcGoodsAction extends ActionSupport implements ModelDriven<GoodsList> {
	private GoodsList goodsList;
	@Resource
	private IGoodsOperationService GoodsOperationService;

	public GoodsList getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(GoodsList goodsList) {
		this.goodsList = goodsList;
	}

	public IGoodsOperationService getGoodsOperationService() {
		return GoodsOperationService;
	}

	public void setGoodsOperationService(IGoodsOperationService goodsOperationService) {
		GoodsOperationService = goodsOperationService;
	}

	@Override
	public GoodsList getModel() {
		// TODO Auto-generated method stub
		goodsList = new GoodsList();
		return goodsList;
	}

	public String ChoiceGoodsList() {
		if (goodsList.getGoodsId() == 0) {
			return this.INPUT;
		}
		String goodsListStr = GoodsOperationService.queryGoodsListById(goodsList.getGoodsId());
		if (goodsListStr.length() < 10) {
			return this.INPUT;
		}
		GoodsList buyGoodsList =  JSONObject.parseObject(goodsListStr,GoodsList.class);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("goodsList", buyGoodsList);
		return this.SUCCESS;
	}
}
