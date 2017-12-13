package com.business.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.business.dao.IGoodsListDao;
import com.business.dao.IRedDotDao;
import com.business.dao.IUserDao;
import com.business.entitys.ResultMessage;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.mp.template.Template;
import com.business.entitys.redDot.ProductOperationReport;
import com.business.entitys.user.User;
import com.business.service.IGoodsOperationService;
import com.business.service.IRedDotService;
import com.business.util.SenMsgThread;

@Repository("redDotService")
public class RedDotServiceImpl implements IRedDotService {
	@Resource
	private IRedDotDao redDotDao;
	@Resource
	private IGoodsListDao goodsListDao;
	@Resource
	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public IGoodsListDao getGoodsListDao() {
		return goodsListDao;
	}

	public void setGoodsListDao(IGoodsListDao goodsListDao) {
		this.goodsListDao = goodsListDao;
	}

	public IRedDotDao getRedDotDao() {
		return redDotDao;
	}

	public void setRedDotDao(IRedDotDao redDotDao) {
		this.redDotDao = redDotDao;
	}

	@Override
	public int insertRemindingPrice(ProductOperationReport productOperationReport) {
		// TODO Auto-generated method stub
		int flog = redDotDao.insertProductOperationReport(productOperationReport);
		ResultMessage resultMessage = null;

		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "添加成功");
			productOperationReport.setPorId(flog); // 拿到返回的I
			int goodsId = productOperationReport.getGoodsId();
			GoodsList goodsList = goodsListDao.queryByGoodsId(goodsId);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("haveGoodsIdUser", "获得用户拥有此商品的LIST");
			map.put("haveGoodsId", goodsId);
			List<User> list = userDao.selectBywhere(map);
			List<String> openIdList = new ArrayList<String>();
			for (User user : list) {
				if (user.getMpUserEntity() != null) {
					if ((user.getMpUserEntity().getOpenid()).length() > 5) {
						openIdList.add(user.getMpUserEntity().getOpenid());
					}
				}

			}
			SenMsgThread senMsgThread = new SenMsgThread(0, new Template(), productOperationReport.getTemplateID(),
					productOperationReport, openIdList, goodsList);
			senMsgThread.start();
		} else {
			resultMessage = new ResultMessage("-1", "false", "添加失败,请及时联系管理员");
		}
		return flog;
	}

	@Override
	public int updateRemindingPrice(ProductOperationReport productOperationReport) {
		// TODO Auto-generated method stub
		return redDotDao.updateProductOperationReport(productOperationReport);
	}

	@Override
	public List<ProductOperationReport> selectAllDate(String tempId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tempDataList", "获得该模板所有的列表下所有的");
		map.put("tempDataId", tempId);

		List<ProductOperationReport> list = redDotDao.selectWhere(map);
		if (list != null) {
			if (list.size() > 0) {
				return list;
			}
		}
		return null;
	}

	@Override
	public ProductOperationReport selectDataById(String tempId, int porId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tempDataList", "获得该模板所有的列表下所有的");
		map.put("tempDataId", tempId);
		map.put("tempDataByIdEntity", "在此模板下的固定ID数据");
		map.put("tempDataById", porId);

		List<ProductOperationReport> list = redDotDao.selectWhere(map);
		if (list != null) {
			if (list.size() > 0) {
				return list.get(0);
			}
		}
		return null;
	}

	@Override
	public int insertRunningReport(ProductOperationReport productOperationReport, List<Integer> list) {
		// TODO Auto-generated method stub
		String linkStr="";
		List<String> openIdList = new ArrayList<String>();
		for (int index:list) {
			linkStr=linkStr+","+index;
			openIdList.add(userDao.findById(index).getOpenId());
		}
		productOperationReport.setUserList(linkStr);
		int flog = redDotDao.insertProductOperationReport(productOperationReport);

		if (flog > 0) {
			productOperationReport.setPorId(flog); // 拿到返回的I
			System.out.println(productOperationReport);
			int goodsId = productOperationReport.getGoodsId();
			GoodsList goodsList = goodsListDao.queryByGoodsId(goodsId);
			
			
			SenMsgThread senMsgThread = new SenMsgThread(0, new Template(), productOperationReport.getTemplateID(),
					productOperationReport, openIdList, goodsList);
			senMsgThread.start();
		} else {
		}
		return flog;
	}

	@Override
	public int updateRunningReport(ProductOperationReport productOperationReport) {
		// TODO Auto-generated method stub
		return redDotDao.updateProductOperationReport(productOperationReport);
	}

	@Override
	public ProductOperationReport selectCtentById(int porId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
	
		map.put("tempDataByIdEntity", "在此模板下的固定ID数据");
		map.put("tempDataById", porId);

		List<ProductOperationReport> list = redDotDao.selectWhere(map);
		if (list != null) {
			if (list.size() > 0) {
				return list.get(0);
			}
		}
		return null;
	}

}
