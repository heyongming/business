package com.business.service;

import com.business.entitys.mp.MpUserEntity;

public interface IMpUserService {
	public boolean addMpUser(MpUserEntity entity);

	public MpUserEntity findUserInfo(String openId);

	public String activationService(MpUserEntity mpUserEntity, String code, String idCard);
}
