package com.business.entitys.goods;

import java.util.List;

public class GoodsTypes {
	private int autoId;
	private int goodsId;
	private int goodsTypeId;
	private GoodsList goodsList;

	@Override
	public String toString() {
		return "GoodsTypes [autoId=" + autoId + ", goodsId=" + goodsId + ", goodsTypeId=" + goodsTypeId + ", goodsList="
				+ goodsList + ", goodType=" + goodType + "]";
	}

	public GoodsTypes(int goodsId, int goodsTypeId) {
		super();
		this.goodsId = goodsId;
		this.goodsTypeId = goodsTypeId;
	}

	public GoodsTypes() {
		super();
	}

	public GoodsTypes(int autoId, int goodsId, int goodsTypeId, GoodsList goodsList, List<GoodsType> goodType) {
		super();
		this.autoId = autoId;
		this.goodsId = goodsId;
		this.goodsTypeId = goodsTypeId;
		this.goodsList = goodsList;
		this.goodType = goodType;
	}

	public int getAutoId() {
		return autoId;
	}

	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(int goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public GoodsList getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(GoodsList goodsList) {
		this.goodsList = goodsList;
	}

	public List<GoodsType> getGoodType() {
		return goodType;
	}

	public void setGoodType(List<GoodsType> goodType) {
		this.goodType = goodType;
	}

	private List<GoodsType> goodType;

}
