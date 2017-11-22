package com.business.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.business.dao.ICustomerDao;
import com.business.entitys.autoReply.AutoReply;
import com.business.entitys.autoReply.FixedAnswer;
import com.business.entitys.autoReply.ListUserQuery;
import com.business.entitys.autoReply.MessageManagement;

@Repository("customerDao")
public class CustomerDaoImpl implements ICustomerDao {
	@Resource
	private SqlSessionTemplate sessionTemplate;

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	@Override
	public int insertAutoReply(AutoReply autoReply) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("autoReply.addAutoReply", autoReply);
	}

	@Override
	public int insertListUserQuery(ListUserQuery listUserQuery) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("autoReply.inertListUserQuery", listUserQuery);
	}

	@Override
	public int insertFixedAnswer(FixedAnswer fixedAnswer) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("autoReply.inertfixedAnswer", fixedAnswer);
	}

	@Override
	public int insertMessageManagement(MessageManagement messageManagement) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("autoReply.inertMessageManagement", messageManagement);
	}

	@Override
	public int updateAutoReply(AutoReply autoReply) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("autoReply.updateAutoReply", autoReply);
	}

	@Override
	public int updateFixedAnswer(FixedAnswer fixedAnswer) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("autoReply.updatefixedAnswer", fixedAnswer);
	}

	@Override
	public int delAutoReply(int id) {
		// TODO Auto-generated method stub
		return sessionTemplate.delete("autoReply.delAutoReply", id);
	}

	@Override
	public int delFixedAnswer(int id) {
		// TODO Auto-generated method stub
		return sessionTemplate.delete("autoReply.delfixedAnswer", id);
	}

	@Override
	public List<AutoReply> selectAutoReplyBywhere(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("autoReply.selectAutoReplyByWhere", map);
	}

	@Override
	public List<ListUserQuery> selectListUserQueryBywhere(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("autoReply.selectListUserQueryByWhere", map);
	}

	@Override
	public List<FixedAnswer> selectFixedAnswerBywhere(Map<String, Object> map) {
		// TODO Auto-generated method stub autoReply
		return sessionTemplate.selectList("autoReply.selectFixedAnswerByWhere", map);
	}

	@Override
	public List<MessageManagement> selectMessageManagementBywhere(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("autoReply.selectMessageManagementByWhere", map);
	}

	@Override
	public List<ListUserQuery> selectListUserQueryIpUserBywhere(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("autoReply.selectListUserQueryIPWhere", map);
	}

}
