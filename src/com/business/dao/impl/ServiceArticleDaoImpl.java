package com.business.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.business.dao.IServiceArticleDao;
import com.business.entitys.service.ServiceArticle;

@Repository("serviceArticleDao")
public class ServiceArticleDaoImpl implements IServiceArticleDao {
	@Resource
	private SqlSessionTemplate sessionTemplate;

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	@Override
	public int insert(ServiceArticle serviceArticle) {
		// TODO Auto-generated method stub
		int flog = sessionTemplate.insert("serviceArticle.insertServiceArticle", serviceArticle);
		if (flog > 0) {
			return serviceArticle.getServiceArticleNum();
		}
		return 0;
	}

	@Override
	public int delete(ServiceArticle serviceArticle) {
		// TODO Auto-generated method stub
		return sessionTemplate.delete("serviceArticle.deleteServiceArticle", serviceArticle.getServiceArticleNum());
	}

	@Override
	public int update(ServiceArticle serviceArticle) {
		// TODO Auto-generated method stub

		return sessionTemplate.update("serviceArticle.updateServiceArticle", serviceArticle);
	}

	@Override
	public List<ServiceArticle> selectBywhere(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("serviceArticle.selectBywehere", map);
	}

}
