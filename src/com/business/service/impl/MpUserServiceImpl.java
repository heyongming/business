package com.business.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.business.dao.IGoodsListDao;
import com.business.dao.IMpServiceDao;
import com.business.dao.IMpUserDao;
import com.business.dao.IOrderDao;
import com.business.dao.IServiceTimeDao;
import com.business.dao.IUserDao;
import com.business.entitys.ResultMessage;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.mp.MpUserEntity;
import com.business.entitys.order.OrderActivationCode;
import com.business.entitys.order.OrderForm;
import com.business.entitys.service.ServiceTime;
import com.business.entitys.user.User;
import com.business.entitys.user.UserBuyTemp;
import com.business.job.MsgMeesage;
import com.business.service.IMpUserService;

@Repository("mpUserService")
public class MpUserServiceImpl implements IMpUserService {
	@Resource
	private IMpUserDao mpUserDao;
	@Resource
	private IOrderDao orderDao;
	@Resource
	private IUserDao userDao;
	@Resource
	private IMpServiceDao mpServiceDao;
	@Resource
	private IGoodsListDao goodsListDao;

	public IGoodsListDao getGoodsListDao() {
		return goodsListDao;
	}

	public void setGoodsListDao(IGoodsListDao goodsListDao) {
		this.goodsListDao = goodsListDao;
	}

	@Resource
	private IServiceTimeDao serviceTimeDao;

	public IServiceTimeDao getServiceTimeDao() {
		return serviceTimeDao;
	}

	public void setServiceTimeDao(IServiceTimeDao serviceTimeDao) {
		this.serviceTimeDao = serviceTimeDao;
	}

	public IMpServiceDao getMpServiceDao() {
		return mpServiceDao;
	}

	public void setMpServiceDao(IMpServiceDao mpServiceDao) {
		this.mpServiceDao = mpServiceDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public IOrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public IMpUserDao getMpUserDao() {
		return mpUserDao;
	}

	public void setMpUserDao(IMpUserDao mpUserDao) {
		this.mpUserDao = mpUserDao;
	}

	@Override
	public boolean addMpUser(MpUserEntity entity) {
		// TODO Auto-generated method stub
		int flog = mpUserDao.insertMpUser(entity);
		if (flog > 0) {
			return true;
		}

		return false;
	}

	@Override
	public MpUserEntity findUserInfo(String openId) {
		// TODO Auto-generated method stub
		MpUserEntity entity = mpUserDao.selectUserById(openId);

		return entity;
	}

	@Override
	public String doActivationService(MpUserEntity mpUserEntity, String code, String idCard) {
		// TODO Auto-generated method stub
		OrderActivationCode checkApply = orderDao.checkActivationCodeApply(code);
		ResultMessage resultMessage = null;
		if (checkApply == null) {
			resultMessage = new ResultMessage("-1", "false", "该激活码已被使用或者不存在");

			return JSONObject.toJSONString(resultMessage);
		}
		UserBuyTemp userBuyTemp = new UserBuyTemp(checkApply.getOrderSerialNumber(), idCard);
		User user = userDao.selectByIdCard(userBuyTemp);
		if (user == null) {
			resultMessage = new ResultMessage("-2", "false", "这个激活码不是您的。");
			return JSONObject.toJSONString(resultMessage);
		}
		orderDao.updatecheckStatus(checkApply.getOrderSerialNumber());

		if (user.getOpenId().length() < 5) {
			user.setOpenId(mpUserEntity.getOpenid());
			userDao.updateById(user);
		}
		Map<String, Object> orderForm = new HashMap<String, Object>();
		orderForm.put("orderSerialNumber", checkApply.getOrderSerialNumber());

		List<OrderForm> list = orderDao.getDataByWhere(orderForm);
		if (list.size() > 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			System.out.println("得到的实体是" + list.get(0));
			map.put("serviceUserId", user.getUserId());
			map.put("serviceGoodsId", list.get(0).getGoodsList().getGoodsId());

			List<ServiceTime> tagerServiceTime = serviceTimeDao.selectByWhere(map);
			ServiceTime sv = tagerServiceTime.get(0);
			sv.setIsActivation(1);
			serviceTimeDao.update(sv);
			resultMessage = new ResultMessage("1", "true", "激活成功");
		} else {
			resultMessage = new ResultMessage("-999", "false", "系统错误，请联系客服");

		}

		return JSONObject.toJSONString(resultMessage);
	}

	@Override
	public List<GoodsList> findGetUserBuyGoodsList(User user) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serviceGoodsIdList", "这条语句是查询用户拥有什么产品");
		map.put("serviceUserId", user.getUserId());
		List<ServiceTime> list = serviceTimeDao.selectByWhere(map);
		List<GoodsList> goodsList = new ArrayList<GoodsList>();
		for (ServiceTime serviceTime : list) {
			GoodsList goodsListEntity = goodsListDao.queryByGoodsId(serviceTime.getGoodsId());
			goodsList.add(goodsListEntity);

		}
		if (goodsList.size() > 0) {
			return goodsList;
		}
		return null;
	}

	@Override
	public User findOpenIdToUser(MpUserEntity mpUserEntity) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("getUserDataByOpenId", "根据传入的openID对应起来user的实体");
		map.put("findOpenId", mpUserEntity.getOpenid());
		List<User> list = userDao.selectBywhere(map);
		if (list.size() > 0)
			return list.get(0);
		return null;

	}

	@Override
	public int doActivationService(User user, OrderActivationCode code) {
		// TODO Auto-generated method stub

		orderDao.updatecheckStatus(code.getOrderSerialNumber());

		Map<String, Object> orderForm = new HashMap<String, Object>();
		orderForm.put("orderSerialNumber", code.getOrderSerialNumber());

		List<OrderForm> list = orderDao.getDataByWhere(orderForm);
		if (list.size() > 0) {
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("serviceUserId", user.getUserId());
			map.put("serviceGoodsId", list.get(0).getGoodsList().getGoodsId());

			List<ServiceTime> tagerServiceTime = serviceTimeDao.selectByWhere(map);
			ServiceTime sv = tagerServiceTime.get(0);
			sv.setIsActivation(1);

			return serviceTimeDao.update(sv);
		}

		return 0;
	}

}
