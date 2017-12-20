package com.business.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.ansj.domain.Term;

import org.ansj.splitWord.analysis.ToAnalysis;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.business.dao.ICustomerDao;
import com.business.entitys.autoReply.AutoReply;
import com.business.entitys.autoReply.FixedAnswer;
import com.business.entitys.autoReply.ListUserQuery;
import com.business.entitys.autoReply.MessageManagement;
import com.business.service.ICustomerService;
import com.business.util.ansj.DataList;
import com.business.util.ansj.SendAnsj;
import com.business.util.fenci.WordSpilt;

@Repository("customerService")
public class CustomerServiceImpl implements ICustomerService {

	@Resource
	private ICustomerDao customerDao;

	public ICustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public int saveAutoReply(AutoReply autoReply) {
		// TODO Auto-generated method stub
		return customerDao.insertAutoReply(autoReply);
	}

	@Override
	public int saveFixedAnswer(FixedAnswer fixedAnswer) {
		// TODO Auto-generated method stub
		return customerDao.insertFixedAnswer(fixedAnswer);
	}

	@Override
	public int saveListUserQuery(ListUserQuery listUserQuery) {
		// TODO Auto-generated method stub
		return customerDao.insertListUserQuery(listUserQuery);
	}

	@Override
	public int saveMessageManagement(MessageManagement management) {
		// TODO Auto-generated method stub
		return customerDao.insertMessageManagement(management);
	}

	@Override
	public int updateAutoReply(AutoReply autoReply) {
		// TODO Auto-generated method stub
		return customerDao.updateAutoReply(autoReply);
	}

	@Override
	public int updatefixedAnswer(FixedAnswer fixedAnswer) {
		// TODO Auto-generated method stub
		return customerDao.updateFixedAnswer(fixedAnswer);
	}

	@Override
	public int delAutoReply(AutoReply autoReply) {
		// TODO Auto-generated method stub
		return customerDao.delAutoReply(autoReply.getArId());
	}

	@Override
	public int delFixedAnswer(FixedAnswer fixedAnswer) {
		// TODO Auto-generated method stub
		return customerDao.delFixedAnswer(fixedAnswer.getFdid());
	}

	@Override
	public List<AutoReply> findAutoFullReplyDate() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		return customerDao.selectAutoReplyBywhere(map);

	}

	@Override
	public AutoReply findAutoReplyByArID(int arId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("findByArIdEntity", "找这个的相关ID的信息");
		map.put("findByArId", arId);
		List<AutoReply> list = customerDao.selectAutoReplyBywhere(map);
		if (list != null) {
			if (list.size() > 0) {
				return list.get(0);
			}
		}
		return null;

	}

	@Override
	public List<MessageManagement> findMessageManagementFullDate() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		return customerDao.selectMessageManagementBywhere(map);
	}

	@Override
	public List<MessageManagement> findMessageManagementByTypeData(String typeName) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("findByTypeDate", "找相关的类型的留言");
		map.put("findByType", typeName);
		return customerDao.selectMessageManagementBywhere(map);
	}

	@Override
	public MessageManagement findMessageManagementById(int id) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("findByIdDate", "找相关的Id的留言");
		map.put("findById", id);

		List<MessageManagement> list = customerDao.selectMessageManagementBywhere(map);
		if (list != null) {
			if (list.size() > 0) {
				return list.get(0);
			}
		}
		return null;
	}

	@Override
	public List<FixedAnswer> findFixedAnswerFullDate() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		return customerDao.selectFixedAnswerBywhere(map);
	}

	@Override
	public FixedAnswer findFixedAnswerById(int id) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("findByIdDate", "找相关的固定Id的回答");
		map.put("findById", id);

		List<FixedAnswer> list = customerDao.selectFixedAnswerBywhere(map);
		if (list != null) {
			if (list.size() > 0) {
				return list.get(0);
			}
		}
		return null;
	}

	@Override
	public List<ListUserQuery> findFullUserQueryData() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<ListUserQuery> list = customerDao.selectListUserQueryIpUserBywhere(map);
		return list;
	}

	@Override
	public List<ListUserQuery> findByUSerIdAndIpUserQueryData(int id, String ip) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("findByUSerIdAndIpUserQueryData", "拿到对应IP和userID的数据");
		map.put("findIp", ip);
		map.put("findUserId", id);
		List<ListUserQuery> list = customerDao.selectListUserQueryBywhere(map);
		if (list != null) {
			if (list.size() > 0) {
				return list;
			}
		}
		return null;
	}

	@Override
	public List<AutoReply> findUserQueryQuestions(String questions) {
		// TODO Auto-generated method stub

		WordSpilt wordSpilt = null;
		try {
			wordSpilt = new WordSpilt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//访问分组框架 返回解析内容
		String json=SendAnsj.sendMsg(questions);
		//生成对应内容
		List<DataList> parse=JSONObject.parseArray(json, DataList.class);
		
		List<AutoReply> list = new ArrayList<AutoReply>();
	
		//根据分词内容进行查询相关内容
		for (DataList	 term : parse) {
			
			String que = term.getData();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("findByquestionsQueryData", "拿到该关键字对应的问题");
			map.put("findquestions", que);
			System.out.println(que);
			List<AutoReply> questionslist = customerDao.selectAutoReplyBywhere(map);
			if (questionslist != null) {
				if (questionslist.size() > 0) {
					for (AutoReply autoReply : questionslist) {
						int flog = 0;
						for (AutoReply temp : list) {
							if (temp.getArId() == autoReply.getArId()) {
								flog = 1;
							}
						}
						if (flog == 0) {
							list.add(autoReply);
						}

					}
				}
			}
		}
		return list;
	}

}
