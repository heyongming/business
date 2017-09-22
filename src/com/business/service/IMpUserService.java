package com.business.service;

import com.business.entitys.mp.MpUserEntity;

/**
 * @author 何永明
 *
 */
public interface IMpUserService {
	/**
	 * @param entity
	 *            添加的微信实体
	 * @return 添加是否成功
	 */
	public boolean addMpUser(MpUserEntity entity);

	/**
	 * @param openId
	 *            要查找的微信的openID
	 * @return 返回被找到的OpenId所对应的实体
	 */
	public MpUserEntity findUserInfo(String openId);

	/**
	 * @param mpUserEntity
	 *            要被激活的实体
	 * @param code
	 *            激活码
	 * @param idCard
	 *            身份证后6位数
	 * @return 激活是否成功
	 */
	public String activationService(MpUserEntity mpUserEntity, String code, String idCard);
}
