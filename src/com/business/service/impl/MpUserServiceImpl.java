package com.business.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.business.dao.IMpServiceDao;
import com.business.dao.IMpUserDao;
import com.business.dao.IOrderDao;
import com.business.dao.IUserDao;
import com.business.entitys.ResultMessage;
import com.business.entitys.mp.MpUserEntity;
import com.business.entitys.order.OrderActivationCode;
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
	private IMpServiceDao goodServiceDao;

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
	public String activationService(MpUserEntity mpUserEntity, String code, String idCard) {
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
		
		return JSONObject.toJSONString(resultMessage);
	}

}
