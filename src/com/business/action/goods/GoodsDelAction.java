package com.business.action.goods;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import com.business.service.IGoodsOperationService;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsDelAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3841533684393147198L;
	@Resource
	private IGoodsOperationService GoodsOperationService;
	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	private int goodsId;

	public IGoodsOperationService getGoodsOperationService() {
		return GoodsOperationService;
	}

	public void setGoodsOperationService(IGoodsOperationService goodsOperationService) {
		GoodsOperationService = goodsOperationService;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String json = GoodsOperationService.deleteGoods(goodsId);
		toJsonSteam(json);
		return super.execute();
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
