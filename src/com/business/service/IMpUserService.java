package com.business.service;

import java.util.List;

import com.business.entitys.goods.GoodsList;
import com.business.entitys.mp.MpUserEntity;
import com.business.entitys.user.User;

/**
 * @author 何永明
 *
 */
/**
 * @author user
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
	public String doActivationService(MpUserEntity mpUserEntity, String code, String idCard);

	/**
	 * @param user
	 *            用户购买过的产品
	 * @return 购买的商品列表
	 */
	public List<GoodsList> findGetUserBuyGoodsList(User user);
	
	/**
	 * @param mpUserEntity 需要跟user对应微信用户
	 * @return 与之对应的user
	 */
	public User findOpenIdToUser(MpUserEntity mpUserEntity);
}
