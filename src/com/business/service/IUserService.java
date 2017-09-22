package com.business.service;

import com.business.entitys.user.User;

public interface IUserService {
	String saveUser(User user);
	User findByUser(int id);
}
