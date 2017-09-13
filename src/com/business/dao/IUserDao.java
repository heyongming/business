package com.business.dao;

import com.business.entitys.user.User;

public interface IUserDao {
	int insertUser(User user);

	User selectByIdCard(String idCard);

	int updateById(User user);
}
