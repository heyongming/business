package com.business.dao;

import java.util.List;

import com.business.entitys.goods.GoodsList;
import com.business.entitys.goods.GoodsType;
import com.business.entitys.goods.GoodsTypes;

public interface IGoodsListDao {
	List<GoodsList> selectGoodsData(String where);

	int addGoodsList(GoodsList goodsList);

	GoodsType queryGoodType(String where);

	List<GoodsType> getWhereGoodsType(String where);

	int addTypes(GoodsTypes goodsTypes);

	List<GoodsList> queryTypeData(int typeId);

	int updateGoods(GoodsList goodsList);

	int updateGoodsTypes(GoodsTypes types);

	int delGoods(int goodsId);

	int delGoodsTypes(int goodsId);

	GoodsList queryByGoodsId(int id);

	/**
	 * @param orderSerialNumber
	 *            通过订单流水号获得相应的产品实体
	 * @return 	      对应的产品的实体
	 */
	GoodsList queryorderSerialNumberTogoodsId(String orderSerialNumber);
}
