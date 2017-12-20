package com.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.business.dao.IGoodsListDao;
import com.business.entitys.ResultMessage;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.goods.GoodsListUpgrade;
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
		return result;
	}

	@Override
	public String getTypeData(int typeId) {
		// TODO Auto-generated method stub
		String where = "gt.`goodsTypeId`=" + typeId;
		List<GoodsList> goodsList = goodsListDao.selectGoodsData(where);
		String result = JSONObject.toJSONString(goodsList);
		return result;
	}

	@Override
	public String saveGoods(GoodsList good, String typeName) {
		// TODO Auto-generated method stub

		int goodsId = goodsListDao.addGoodsList(good);
		GoodsType goodsType = goodsListDao.queryGoodType(typeName);

		int flog = goodsListDao.addTypes(new GoodsTypes(goodsId, goodsType.getGoodsTypeId()));

		GoodsList list = goodsListDao.queryByGoodsId(goodsId);
		String resString = JSONObject.toJSONString(list);
		return resString;
	}

	@Override
	public String getAllType() {
		// TODO Auto-generated method stub

		List<GoodsType> list = goodsListDao.getWhereGoodsType(" 1=1");
		String result = JSONObject.toJSONString(list);
		return result;
	}

	@Override
	public String querytypeGoodsList(int typeId) {
		// TODO Auto-generated method stub
		List<GoodsList> list = goodsListDao.queryTypeData(typeId);
		String result = JSONObject.toJSONString(list);
		return result;
	}

	@Override
	public String updateGoods(GoodsList goodsList, String typeName) {
		// TODO Auto-generated method stub
		GoodsType goodsType = goodsListDao.queryGoodType(typeName);
		int flog = goodsListDao.updateGoodsTypes(new GoodsTypes(goodsList.getGoodsId(), goodsType.getGoodsTypeId()));
		int flog1 = goodsListDao.updateGoods(goodsList);
		String result = null;

		if (flog > 0 || flog1 > 0) {
			return "1";
		}

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
		if (goodstypesFlog > 0) {
			resultMessage = new ResultMessage("1", "true", "switch Success");
		} else {
			int flog = goodsListDao.addTypes(new GoodsTypes(goodsId, 1));
			if (flog > 0) {
				resultMessage = new ResultMessage("1", "true", "switch Success");
			} else {
				resultMessage = new ResultMessage("-1", "true", "switch fail");
			}
		}
		result = JSONObject.toJSONString(resultMessage);
		return result;
	}

	@Override
	public String queryGoodsListById(int id) {
		// TODO Auto-generated method stub

		GoodsList goodsList = goodsListDao.queryByGoodsId(id);

		return JSONObject.toJSONString(goodsList);

	}

	@Override
	public String queryGoodsListWhenHot(GoodsList goodsList) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("hotGoods", 1);
		List<GoodsList> list = goodsListDao.selectByWhere(map);
		return JSONObject.toJSONString(list);

	}

	@Override
	public String getAllgoodsUpgradeList() {
		// TODO Auto-generated method stub
		List<GoodsListUpgrade> list = goodsListDao.getAllGoodsListUpgrade();
		String json = JSONObject.toJSONString(list);
		return json;
	}

	@Override
	public String delgoodslistUpgradeById(int id) {
		// TODO Auto-generated method stub
		int flog = goodsListDao.delGoodslistUpgradeById(id);
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "成功");

		} else {
			resultMessage = new ResultMessage("-1", "false", "失败");

		}
		return JSONObject.toJSONString(resultMessage);
	}

	@Override
	public String savegoodslistUpgrade(GoodsListUpgrade goodsListUpgrade) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goodsId", goodsListUpgrade.getGoodsId());
		map.put("UpgradeGoodsId", goodsListUpgrade.getUpgradeGoodsId());
		ResultMessage resultMessage = null;
		List<GoodsListUpgrade> list = goodsListDao.selectUpgradeByWhere(map);
		if (list.size() >0) {
			resultMessage = new ResultMessage("-1", "false", "失败");
			return JSONObject.toJSONString(resultMessage);
		}
		int flog = goodsListDao.insertGoodsListUpgrade(goodsListUpgrade);
	
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "成功");

		} else {
			resultMessage = new ResultMessage("-1", "false", "失败");

		}
		return JSONObject.toJSONString(resultMessage);
	}

}
