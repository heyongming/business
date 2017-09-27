package com.business.entitys.goods;

public class GoodsListUpgrade {
	private int id;
	private int goodsId;
	private int UpgradeGoodsId;
	private String dateManufacture;
	private GoodsList goodsList;
	private GoodsList UpgradeGoodsList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getUpgradeGoodsId() {
		return UpgradeGoodsId;
	}

	public void setUpgradeGoodsId(int upgradeGoodsId) {
		UpgradeGoodsId = upgradeGoodsId;
	}

	public String getDateManufacture() {
		return dateManufacture;
	}

	public void setDateManufacture(String dateManufacture) {
		this.dateManufacture = dateManufacture;
	}

	public GoodsList getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(GoodsList goodsList) {
		this.goodsList = goodsList;
	}

	public GoodsList getUpgradeGoodsList() {
		return UpgradeGoodsList;
	}

	public void setUpgradeGoodsList(GoodsList upgradeGoodsList) {
		UpgradeGoodsList = upgradeGoodsList;
	}

	public GoodsListUpgrade(int id, int goodsId, int upgradeGoodsId, String dateManufacture, GoodsList goodsList,
			GoodsList upgradeGoodsList) {
		super();
		this.id = id;
		this.goodsId = goodsId;
		UpgradeGoodsId = upgradeGoodsId;
		this.dateManufacture = dateManufacture;
		this.goodsList = goodsList;
		UpgradeGoodsList = upgradeGoodsList;
	}

	public GoodsListUpgrade() {
		super();
	}

	@Override
	public String toString() {
		return "GoodslistUpgrade [id=" + id + ", goodsId=" + goodsId + ", UpgradeGoodsId=" + UpgradeGoodsId
				+ ", dateManufacture=" + dateManufacture + ", goodsList=" + goodsList + ", UpgradeGoodsList="
				+ UpgradeGoodsList + "]";
	}

}
