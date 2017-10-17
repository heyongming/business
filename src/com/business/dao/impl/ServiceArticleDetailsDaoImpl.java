package com.business.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.business.dao.IServiceArticleDetailsDao;
import com.business.entitys.service.ServiceArticleDetails;
import com.business.entitys.service.ServiceArticleDetailsHelper;
import com.business.entitys.service.ServiceArticleHelper;

@Repository("serviceArticleDetailsDao")
public class ServiceArticleDetailsDaoImpl implements IServiceArticleDetailsDao {
	@Resource
	private SqlSessionTemplate sessionTemplate;

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	@Override
	public int insertServiceArticleDetail(ServiceArticleDetails serviceArticleDetails) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("serviceArticleDetails.insertServiceArticleDetails", serviceArticleDetails);
	}

	@Override
	public int updateServiceArticleDetail(ServiceArticleDetails serviceArticleDetails) {
		// TODO Auto-generated method stub
		return sessionTemplate.update("serviceArticleDetails.updateServiceArticleDetails", serviceArticleDetails);
	}

	@Override
	public int deleteServiceArticleDetail(ServiceArticleDetails serviceArticleDetails) {
		// TODO Auto-generated method stub
		return sessionTemplate.update("serviceArticleDetails.deleteServiceArticle", serviceArticleDetails);
	}

	@Override
	public int insertServiceArticleHelper(ServiceArticleHelper serviceArticleHelper) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("serviceArticleDetails.insertServiceArticleHelper", serviceArticleHelper);
	}

	@Override
	public int insertServiceArticleDetailsHelper(ServiceArticleDetailsHelper serviceArticleHelper) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("serviceArticleDetails.insertServiceArticleDetailsHelper", serviceArticleHelper);
	}

	@Override
	public ServiceArticleHelper selectServiceArticleHelper(ServiceArticleHelper serviceArticleHelper) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("serviceArticleDetails.selectServiceArticleHelper", serviceArticleHelper);
	}

	@Override
	public ServiceArticleDetailsHelper selectServiceArticleDetailsHelper(
			ServiceArticleDetailsHelper serviceArticleHelper) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("serviceArticleDetails.selectServiceArticleDetailsHelper",
				serviceArticleHelper);
	}

	@Override
	public List<ServiceArticleDetails> selectBywhere(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("serviceArticleDetails.selectBywehere", map);
	}

}
