package com.business.service;

import java.util.List;

import com.business.entitys.ResultMessage;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.service.ServiceArticle;
import com.business.entitys.service.ServiceArticleDetails;
import com.business.entitys.user.User;

public interface IServiceArticleService {
	String saveServiceArticle(ServiceArticle serviceArticle);

	String updateServiceArticle(ServiceArticle serviceArticle);

	String delServiceArticle(ServiceArticle serviceArticle);

	/**
	 * @return 全量数据
	 */
	List<ServiceArticle> getFullData();

	ServiceArticle findByServiceArticleNum(int serviceArticleNum);

	/**
	 * @param goodsId
	 *            获得当天信息的商品ID
	 * @return 该ID 对应的商品信息
	 */
	List<ServiceArticle> doCurrentData(int goodsId);

	/**
	 * @param goodsId
	 *            获得历史信息的商品ID
	 * @return 该ID 对应的商品信息
	 */
	List<ServiceArticle> doHistoryData(int goodsId, int serviceTypeId);

	/**
	 * @param serviceArticle
	 *            拿取该文章的相关评论
	 * @return
	 */
	List<ServiceArticleDetails> doDetailsToServiceArticle(ServiceArticle serviceArticle);

	/**
	 * @param user
	 *            点赞人
	 * @param serviceArticle
	 *            被点赞的文章
	 * @return 返回点赞的结果
	 */
	ResultMessage doThumbsUp(User user, ServiceArticle serviceArticle);

	/**
	 * @param serviceArticleDetails
	 *            评论的内容
	 * @return 评论的返回结果
	 */
	ResultMessage doComment(ServiceArticleDetails serviceArticleDetails);
	/**
	 * @param user
	 *            检测点赞人
	 * @param serviceArticle
	 *            检测的文章
	 * @return 返回的结果
	 */
	int isDoThumbsUp(User user, ServiceArticle serviceArticle);
}
