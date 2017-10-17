package com.business.dao;

import java.util.List;
import java.util.Map;

import com.business.entitys.service.ServiceArticleDetails;
import com.business.entitys.service.ServiceArticleDetailsHelper;
import com.business.entitys.service.ServiceArticleHelper;

public interface IServiceArticleDetailsDao {
	int insertServiceArticleDetail(ServiceArticleDetails serviceArticleDetails);

	int updateServiceArticleDetail(ServiceArticleDetails serviceArticleDetails);

	int deleteServiceArticleDetail(ServiceArticleDetails serviceArticleDetails);

	int insertServiceArticleHelper(ServiceArticleHelper serviceArticleHelper);

	int insertServiceArticleDetailsHelper(ServiceArticleDetailsHelper serviceArticleHelper);

	ServiceArticleHelper selectServiceArticleHelper(ServiceArticleHelper serviceArticleHelper);

	ServiceArticleDetailsHelper selectServiceArticleDetailsHelper(ServiceArticleDetailsHelper serviceArticleHelper);

	List<ServiceArticleDetails> selectBywhere(Map<String, Object> map);
}
