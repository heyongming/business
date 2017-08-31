package com.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.business.dao.IGoodsListDao;
import com.business.entitys.ResultMessage;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.goods.GoodsType;
import com.business.entitys.goods.GoodsTypes;
import com.business.service.IGoodsOperationService;

@Repository("GoodsOperationService")
public class GoodsOperationServiceImpl implements IGoodsOperationService {
	@Resource
	private IGoodsListDao goodsListDao;

	public IGoodsListDao getGoodsListDao() {
		return goodsListDao;
	}

	public void setGoodsListDao(IGoodsListDao goodsListDao) {
		this.goodsListDao = goodsListDao;
	}

	@Override
	public String getAllGoodsList() {
		// TODO Auto-generated method stub
		String where = "1=1";
		List<GoodsList> goodsList = goodsListDao.selectGoodsData(where);
		String result = JSONObject.toJSONString(goodsList);
		System.out.println(result);
		return result;
	}

	@Override
	public String getTypeData(int typeId) {
		// TODO Auto-generated method stub
		String where = "gt.`goodsTypeId`=" + typeId;
		List<GoodsList> goodsList = goodsListDao.selectGoodsData(where);
		String result = JSONObject.toJSONString(goodsList);
		System.out.println(result);
		return result;
	}

	@Override
	public String saveGoods(GoodsList good, String typeName) {
		// TODO Auto-generated method stub
		good.setIsShelves(0);
		int goodsId = goodsListDao.addGoodsList(good);
		GoodsType goodsType = goodsListDao.queryGoodType(typeName);
		System.out.println(goodsType);

		int flog = goodsListDao.addTypes(new GoodsTypes(goodsId, goodsType.getGoodsTypeId()));
		ResultMessage message = null;
		if (flog > 0) {
			message = new ResultMessage("1", "true", "insert Success");
		} else {
			message = new ResultMessage("-1", "false", "insert fail");

		}
		String resString = JSONObject.toJSONString(message);
		System.out.println(resString);
		return resString;
	}

	@Override
	public String getAllType() {
		// TODO Auto-generated method stub

		List<GoodsType> list = goodsListDao.getWhereGoodsType(" 1=1");
		String result = JSONObject.toJSONString(list);
		System.out.println(result);
		return result;
	}

	@Override
	public String querytypeGoodsList(int typeId) {
		// TODO Auto-generated method stub
		List<GoodsList> list = goodsListDao.queryTypeData(typeId);
		String result = JSONObject.toJSONString(list);
		System.out.println(result);
		return result;
	}

	@Override
	public String updateGoods(GoodsList goodsList) {
		// TODO Auto-generated method stub
		int flog = goodsListDao.updateGoods(goodsList);
		String result = null;
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "update Success ");
		} else {
			resultMessage = new ResultMessage("-1", "false", "update fail");
		}
		result = JSONObject.toJSONString(resultMessage);
		return result;
	}

	@Override
	public String updateGoodsTypes(GoodsList goodsList, String typeName) {
		// TODO Auto-generated method stub
		GoodsType goodsType = goodsListDao.queryGoodType(typeName);
		int flog = goodsListDao.updateGoodsTypes(new GoodsTypes(goodsList.getGoodsId(), goodsType.getGoodsTypeId()));
		String result = null;
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "update Success ");
		} else {
			resultMessage = new ResultMessage("-1", "false", "update fail");
		}
		result = JSONObject.toJSONString(resultMessage);
		return result;
	}

	@Override
	public String deleteGoods(int goodsId) {
		// TODO Auto-generated method stub
		int flog = goodsListDao.delGoods(goodsId);
		int goodstypesFlog = goodsListDao.delGoodsTypes(goodsId);
		String result = null;
		ResultMessage resultMessage = null;
		if (flog > 0 && goodstypesFlog > 0) {
			resultMessage = new ResultMessage("1", "true", "delete Success ");
		} else {
			resultMessage = new ResultMessage("-1", "false", "delete fail");
		}
		result = JSONObject.toJSONString(resultMessage);
		return result;
	}

	@Override
	public String updateGoodsHot(int goodsId) {
		// TODO Auto-generated method stub
		int goodstypesFlog = goodsListDao.delGoodsTypes(goodsId);
		String result = null;
		ResultMessage resultMessage = null;
		if(goodstypesFlog > 0)
		{
			resultMessage = new ResultMessage("1", "true", "switch Success");	
		}
		else
		{
		int flog=goodsListDao.addTypes(new GoodsTypes(goodsId,1));
				if(flog>0)
				{
					resultMessage = new ResultMessage("1", "true", "switch Success");	
				}
				else
				{
					resultMessage = new ResultMessage("-1", "true", "switch fail");	
				}
		}
		result = JSONObject.toJSONString(resultMessage);
		return result;
	}

}
