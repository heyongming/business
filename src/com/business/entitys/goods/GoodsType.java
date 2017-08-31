package com.business.entitys.goods;

public class GoodsType {
	private int goodsTypeId;
	private String goodsTypeName;

	@Override
	public String toString() {
		return "GoodType [goodsTypeId=" + goodsTypeId + ", goodsTypeName=" + goodsTypeName + "]";
	}

	public GoodsType() {
		super();
	}

	public GoodsType(int goodsTypeId, String goodsTypeName) {
		super();
		this.goodsTypeId = goodsTypeId;
		this.goodsTypeName = goodsTypeName;
	}

	public int getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(int goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public String getGoodsTypeName() {
		return goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}
}
