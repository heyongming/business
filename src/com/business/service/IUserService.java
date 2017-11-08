package com.business.service;

import java.util.List;

import com.business.entitys.user.User;

public interface IUserService {
	String saveUser(User user);

	User findByUser(int id);

	/**
	 * 用户购买的时候绑定	
	 * 
	 * @param user
	 * @return
	 */
	User checkUser(User user);

	/*
	 * 
	 * 根据相关推荐码获得与其对应用户的实体
	 * 
	 */
	User selectByRdCode(String rdCode);

	/*
	 * 获得全量数据
	 */

	List<User> getFullData();
	int updateUser(User user);
	int delUser(User user);
	User findOpenIdToUser(String openId);
	User fingUserByIdcard(String idCard);
}
