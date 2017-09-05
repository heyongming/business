package com.business.entitys.mp;

import java.util.List;

public class NewsTextMessage extends BaseMsgEntity {
	private int ArticleCount;
	private List<NewsItem> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<NewsItem> getArticles() {
		return Articles;
	}

	@Override
	public String toString() {
		return super.toString() + "NewsTextMessage [ArticleCount=" + ArticleCount + ", Articles=" + Articles + "]";
	}

	public NewsTextMessage() {
		super();
	}

	public NewsTextMessage(int articleCount, List<NewsItem> articles) {
		super();
		ArticleCount = articleCount;
		Articles = articles;
	}

	public void setArticles(List<NewsItem> articles) {
		Articles = articles;
	}
}
