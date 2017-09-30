package com.business.entitys.goods;

import java.util.List;

public class GoodsList {
	private int goodsId;

	private int goodsPrice;
	private String goodsName;
	private String imageUrl;
	private String dateManufacture;
	private int inventory;
	private int salesVolume;
	private int isShelves;
	private int hotGoods;
	private int weight;
	private int effectiveTime;
	private int minMon;
	private int maxMon;
	private int isBlend;

	public GoodsList() {
		super();
	}

	public GoodsList(int goodsId, int goodsPrice, String goodsName, String imageUrl, String dateManufacture,
			int inventory, int salesVolume, int isShelves, int hotGoods, int weight, int effectiveTime, int minMon,
			int maxMon, int isBlend, List<GoodsType> goodTypes) {
		super();
		this.goodsId = goodsId;
		this.goodsPrice = goodsPrice;
		this.goodsName = goodsName;
		this.imageUrl = imageUrl;
		this.dateManufacture = dateManufacture;
		this.inventory = inventory;
		this.salesVolume = salesVolume;
		this.isShelves = isShelves;
		this.hotGoods = hotGoods;
		this.weight = weight;
		this.effectiveTime = effectiveTime;
		this.minMon = minMon;
		this.maxMon = maxMon;
		this.isBlend = isBlend;
		this.goodTypes = goodTypes;
	}

	@Override
	public String toString() {
		return "GoodsList [goodsId=" + goodsId + ", goodsPrice=" + goodsPrice + ", goodsName=" + goodsName
				+ ", imageUrl=" + imageUrl + ", dateManufacture=" + dateManufacture + ", inventory=" + inventory
				+ ", salesVolume=" + salesVolume + ", isShelves=" + isShelves + ", hotGoods=" + hotGoods + ", weight="
				+ weight + ", effectiveTime=" + effectiveTime + ", minMon=" + minMon + ", maxMon=" + maxMon
				+ ", isBlend=" + isBlend + ", goodTypes=" + goodTypes + "]";
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDateManufacture() {
		return dateManufacture;
	}

	public void setDateManufacture(String dateManufacture) {
		this.dateManufacture = dateManufacture;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public int getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
	}

	public int getIsShelves() {
		return isShelves;
	}

	public void setIsShelves(int isShelves) {
		this.isShelves = isShelves;
	}

	public int getHotGoods() {
		return hotGoods;
	}

	public void setHotGoods(int hotGoods) {
		this.hotGoods = hotGoods;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getEffectiveTime() {
		return effectiveTime;
	}

	public void setEffectiveTime(int effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	public int getMinMon() {
		return minMon;
	}

	public void setMinMon(int minMon) {
		this.minMon = minMon;
	}

	public int getMaxMon() {
		return maxMon;
	}

	public void setMaxMon(int maxMon) {
		this.maxMon = maxMon;
	}

	public int getIsBlend() {
		return isBlend;
	}

	public void setIsBlend(int isBlend) {
		this.isBlend = isBlend;
	}

	public List<GoodsType> getGoodTypes() {
		return goodTypes;
	}

	public void setGoodTypes(List<GoodsType> goodTypes) {
		this.goodTypes = goodTypes;
	}

	private List<GoodsType> goodTypes;

}
