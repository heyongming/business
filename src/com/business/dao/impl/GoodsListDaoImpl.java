package com.business.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.business.dao.IGoodsListDao;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.goods.GoodsType;
import com.business.entitys.goods.GoodsTypes;

@Repository("goodsListDao")
public class GoodsListDaoImpl implements IGoodsListDao {
	@Resource
	private SqlSessionTemplate sessionTemplate;

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	@Override
	public List<GoodsList> selectGoodsData(String where) {
		// TODO Auto-generated method stub
		List<GoodsList> list = sessionTemplate.selectList("goods.getAllGoods", where);
		return list;
	}

	@Override
	public int addGoodsList(GoodsList goodsList) {
		// TODO Auto-generated method stub

		int flog = sessionTemplate.insert("goods.addGoodsList", goodsList);
		if (flog > 0) {
			return goodsList.getGoodsId();
		}
		return 0;
	}

	@Override
	public int addTypes(GoodsTypes goodsTypes) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("goods.addTypes", goodsTypes);
	}

	@Override
	public GoodsType queryGoodType(String where) {
		// TODO Auto-generated method stub
		System.out.println(where);
		return sessionTemplate.selectOne("goods.queryGoodstype", where);
	}

	@Override
	public List<GoodsType> getWhereGoodsType(String where) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("goods.getWhereGoodsType", where);
	}

	@Override
	public List<GoodsList> queryTypeData(int typeId) {
		// TODO Auto-generated method stub

		return sessionTemplate.selectList("goods.queryTypeData", typeId);
	}

	@Override
	public int updateGoods(GoodsList goodsList) {
		// TODO Auto-generated method stub
		return sessionTemplate.update("goods.updateGoods", goodsList);
	}

	@Override
	public int updateGoodsTypes(GoodsTypes types) {
		// TODO Auto-generated method stub
		return sessionTemplate.update("goods.updateGoodsTypes", types);
	}

	@Override
	public int delGoods(int goodsId) {
		// TODO Auto-generated method stub
		return sessionTemplate.delete("goods.delGoods", goodsId);
	}

	@Override
	public int delGoodsTypes(int goodsId) {
		// TODO Auto-generated method stub
		return sessionTemplate.delete("goods.delGoodsTypes", goodsId);
	}

	@Override
	public GoodsList queryByGoodsId
	(int id) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("goods.queryByGoodsId", id);
	}

	@Override
	public GoodsList queryorderSerialNumberTogoodsId(String orderSerialNumber) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("goods.selectByorderSerialNumber", orderSerialNumber);
	}

}
