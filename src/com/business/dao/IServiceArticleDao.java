package com.business.dao;

import java.util.List;
import java.util.Map;

import com.business.entitys.service.ServiceArticle;

public interface IServiceArticleDao {
	int insert(ServiceArticle serviceArticle);

	int delete(ServiceArticle serviceArticle);

	int update(ServiceArticle serviceArticle);

	List<ServiceArticle> selectBywhere(Map<String, Object> map);
}
