package com.business.dao;

import java.util.List;
import java.util.Map;

import com.business.entitys.autoReply.AutoReply;
import com.business.entitys.autoReply.FixedAnswer;
import com.business.entitys.autoReply.ListUserQuery;
import com.business.entitys.autoReply.MessageManagement;

/*
 * 
 * 客服的DAO层
 * 
 */
public interface ICustomerDao {
	int insertAutoReply(AutoReply autoReply); // 插入自动回复的消息

	int insertListUserQuery(ListUserQuery listUserQuery); // 插入用户提问列表

	int insertFixedAnswer(FixedAnswer fixedAnswer);// 插入一问一答的

	int insertMessageManagement(MessageManagement messageManagement);// 插入留言信息

	int updateAutoReply(AutoReply autoReply);// 修改自动回复

	int updateFixedAnswer(FixedAnswer fixedAnswer);// 修改一问一答

	int delAutoReply(int id); // 删除自动回复的规则

	int delFixedAnswer(int id);// 删除一问一答回复的规则

	List<AutoReply> selectAutoReplyBywhere(Map<String, Object> map);// 根据不同的查询信息返回不同的自动回复消息

	List<ListUserQuery> selectListUserQueryBywhere(Map<String, Object> map);// 根据不同的查询信息返回不同的用户回复消息
	
	List<ListUserQuery> selectListUserQueryIpUserBywhere(Map<String, Object> map);// 根据不同的查询信息返回不同的用户回复消息

	List<FixedAnswer> selectFixedAnswerBywhere(Map<String, Object> map);// 根据不同的查询信息返回不同的一对一消息

	List<MessageManagement> selectMessageManagementBywhere(Map<String, Object> map);// 根据不同的查询信息返回不同的留言

}
