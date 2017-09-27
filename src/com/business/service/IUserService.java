package com.business.service;

import com.business.entitys.user.User;

public interface IUserService {
	String saveUser(User user);
	User findByUser(int id);
	
	/**
	 * 用户购买的时候绑定
	 * @param user
	 * @return
	 */
	User checkUser(User user);
}
