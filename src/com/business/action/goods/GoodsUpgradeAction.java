package com.business.action.goods;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import com.business.entitys.goods.GoodsListUpgrade;
import com.business.service.IGoodsOperationService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GoodsUpgradeAction extends ActionSupport implements ModelDriven<GoodsListUpgrade> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6787537866640466536L;
	private GoodsListUpgrade goodsListUpgrade;
	
	
	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}
	@Resource
	private IGoodsOperationService GoodsOperationService;

	public IGoodsOperationService getGoodsOperationService() {
		return GoodsOperationService;
	}

	public void setGoodsOperationService(IGoodsOperationService goodsOperationService) {
		GoodsOperationService = goodsOperationService;
	}

	@Override
	public GoodsListUpgrade getModel() {
		// TODO Auto-generated method stub
		goodsListUpgrade = new GoodsListUpgrade();
		return goodsListUpgrade;
	}

	public GoodsListUpgrade getGoodsListUpgrade() {
		return goodsListUpgrade;
	}

	public void setGoodsListUpgrade(GoodsListUpgrade goodsListUpgrade) {
		this.goodsListUpgrade = goodsListUpgrade;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String json = GoodsOperationService.getAllgoodsUpgradeList();
		toJsonSteam(json);
		return super.execute();
	}

	public String delGoodslistUpgrade() throws Exception {
		String flog = GoodsOperationService.delgoodslistUpgradeById(goodsListUpgrade.getId());
		toJsonSteam(flog);
		return super.execute();
	}

	public String insertGoodslistUpgrade() throws Exception {
		String flog = GoodsOperationService.savegoodslistUpgrade(goodsListUpgrade);
		toJsonSteam(flog);
		return super.execute();
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
}
