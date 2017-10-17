package com.business.entitys.service;

import com.business.entitys.goods.GoodsList;
import com.business.entitys.goods.GoodsType;

/**
 * @author user {@code} 服务的实体
 */
public class ServiceArticle {
	private int serviceArticleNum;
	private String serviceArticleTitle;
	private int goodsId;
	private int serviceTypeId;
	private String isOriginal = "原创";
	private String currentDate;
	private String thumbnail;
	private String targetTime;
	private String author;
	private String articleContent;
	private int pointNumber;
	private int readingNumber;
	private GoodsList goodsList;
	@Override
	public String toString() {
		return "ServiceArticle [serviceArticleNum=" + serviceArticleNum + ", serviceArticleTitle=" + serviceArticleTitle
				+ ", goodsId=" + goodsId + ", serviceTypeId=" + serviceTypeId + ", isOriginal=" + isOriginal
				+ ", currentDate=" + currentDate + ", thumbnail=" + thumbnail + ", targetTime=" + targetTime
				+ ", author=" + author + ", articleContent=" + articleContent + ", pointNumber=" + pointNumber
				+ ", readingNumber=" + readingNumber + ", goodsList=" + goodsList + ", serviceArticleType="
				+ serviceArticleType + "]";
	}
	public ServiceArticle() {
		super();
	}
	public ServiceArticle(int serviceArticleNum, String serviceArticleTitle, int goodsId, int serviceTypeId,
			String isOriginal, String currentDate, String thumbnail, String targetTime, String author,
			String articleContent, int pointNumber, int readingNumber, GoodsList goodsList,
			ServiceArticleType serviceArticleType) {
		super();
		this.serviceArticleNum = serviceArticleNum;
		this.serviceArticleTitle = serviceArticleTitle;
		this.goodsId = goodsId;
		this.serviceTypeId = serviceTypeId;
		this.isOriginal = isOriginal;
		this.currentDate = currentDate;
		this.thumbnail = thumbnail;
		this.targetTime = targetTime;
		this.author = author;
		this.articleContent = articleContent;
		this.pointNumber = pointNumber;
		this.readingNumber = readingNumber;
		this.goodsList = goodsList;
		this.serviceArticleType = serviceArticleType;
	}
	public int getServiceArticleNum() {
		return serviceArticleNum;
	}
	public void setServiceArticleNum(int serviceArticleNum) {
		this.serviceArticleNum = serviceArticleNum;
	}
	public String getServiceArticleTitle() {
		return serviceArticleTitle;
	}
	public void setServiceArticleTitle(String serviceArticleTitle) {
		this.serviceArticleTitle = serviceArticleTitle;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getServiceTypeId() {
		return serviceTypeId;
	}
	public void setServiceTypeId(int serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}
	public String getIsOriginal() {
		return isOriginal;
	}
	public void setIsOriginal(String isOriginal) {
		this.isOriginal = isOriginal;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getTargetTime() {
		return targetTime;
	}
	public void setTargetTime(String targetTime) {
		this.targetTime = targetTime;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public int getPointNumber() {
		return pointNumber;
	}
	public void setPointNumber(int pointNumber) {
		this.pointNumber = pointNumber;
	}
	public int getReadingNumber() {
		return readingNumber;
	}
	public void setReadingNumber(int readingNumber) {
		this.readingNumber = readingNumber;
	}
	public GoodsList getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(GoodsList goodsList) {
		this.goodsList = goodsList;
	}
	public ServiceArticleType getServiceArticleType() {
		return serviceArticleType;
	}
	public void setServiceArticleType(ServiceArticleType serviceArticleType) {
		this.serviceArticleType = serviceArticleType;
	}
	private ServiceArticleType serviceArticleType;


}
