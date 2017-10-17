package com.business.dao;

import java.util.List;
import java.util.Map;

import com.business.entitys.user.User;
import com.business.entitys.user.UserBuyTemp;

public interface IUserDao {
	int insertUser(User user);

	/**
	 * @param idCard
	 *            封装后的身份证和账单流水号
	 * 
	 * @return 返回对应的拥有者
	 */
	User selectByIdCard(UserBuyTemp idCard);

	int updateById(User user);

	User findByRdcode(String rdCode);

	User findById(int id);
	List<User> selectBywhere(Map<String, Object> map);
}
