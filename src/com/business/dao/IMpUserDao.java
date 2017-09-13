package com.business.dao;

import com.business.entitys.mp.MpUserEntity;

public interface IMpUserDao {
	int insertMpUser(MpUserEntity mpUserEntity);

	MpUserEntity selectUserById(String openid);
}
