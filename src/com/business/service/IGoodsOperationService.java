package com.business.service;

import java.util.List;

import com.business.entitys.goods.GoodsList;
import com.business.entitys.goods.GoodsTypes;

public interface IGoodsOperationService {

	String getAllGoodsList();

	String getTypeData(int typeId);

	String saveGoods(GoodsList good, String typeName);

	String getAllType();

	String querytypeGoodsList(int typeId);

	String updateGoods(GoodsList goodsList);

	String updateGoodsTypes(GoodsList goodsList, String typeName);

	String deleteGoods(int goodsId);
	
	String updateGoodsHot(int goodsId);

}
