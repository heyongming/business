package com.business.service;

import java.util.List;

import com.business.entitys.autoReply.AutoReply;
import com.business.entitys.autoReply.FixedAnswer;
import com.business.entitys.autoReply.ListUserQuery;
import com.business.entitys.autoReply.MessageManagement;

public interface ICustomerService {
	int saveAutoReply(AutoReply autoReply); // 保存自动回话

	int saveFixedAnswer(FixedAnswer fixedAnswer); // 保存一对一的对话

	int saveListUserQuery(ListUserQuery listUserQuery);// 保存用户的提问

	int saveMessageManagement(MessageManagement management);// 保存用户的留言

	int updateAutoReply(AutoReply autoReply); // 修改自动回话

	int updatefixedAnswer(FixedAnswer fixedAnswer);// 修改一对一的对话

	int delAutoReply(AutoReply autoReply); // 删除相应的自动回话

	int delFixedAnswer(FixedAnswer fixedAnswer);// 删除对应的一问一答

	List<AutoReply> findAutoFullReplyDate();// 给全部的自动回复消息

	List<MessageManagement> findMessageManagementFullDate();// 获得所有留言的消息

	List<MessageManagement> findMessageManagementByTypeData(String typeName);// 获得相关类型留言的消息

	MessageManagement findMessageManagementById(int id);// 获得相关类型留言的消息

	AutoReply findAutoReplyByArID(int arId);// 根据ID 找相关的自动回复消息
	
	List<FixedAnswer> findFixedAnswerFullDate();//拿取固定回答的所以信息
	
	FixedAnswer findFixedAnswerById(int id);//拿取跟固定ID拿取的固定的消息
	
	List<ListUserQuery> findFullUserQueryData();//拿取查询的全部数据
	List<ListUserQuery> findByUSerIdAndIpUserQueryData(int id,String ip);//拿取相关IP和userId的数据
	List<AutoReply> findUserQueryQuestions(String questions);//该问题对应的答案
}
