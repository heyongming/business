package com.business.entitys.redDot;

import com.business.entitys.goods.GoodsList;

public class ProductOperationReport {
	@Override
	public String toString() {
		return "ProductOperationReport [porId=" + porId + ", porTitle=" + porTitle + ", porTitleClor=" + porTitleClor
				+ ", goodsList=" + goodsList + ", goodsId=" + goodsId + ", sendTime=" + sendTime + ", createTime="
				+ createTime + ", porCtent=" + porCtent + ", templateID=" + templateID + ", keyword1=" + keyword1
				+ ", keyword1Clor=" + keyword1Clor + ", keyword2=" + keyword2 + ", keyword2Clor=" + keyword2Clor
				+ ", keyword3=" + keyword3 + ", keyword3Clor=" + keyword3Clor + ", keyword4=" + keyword4
				+ ", keyword4Clor=" + keyword4Clor + ", keyword5=" + keyword5 + ", keyword5Clor=" + keyword5Clor
				+ ", keyword6=" + keyword6 + ", keyword6Clor=" + keyword6Clor + ", keyword7=" + keyword7
				+ ", keyword7Clor=" + keyword7Clor + ", remark=" + remark + ", remarkClor=" + remarkClor + ", userList="
				+ userList + "]";
	}

	private int porId;
	private String porTitle;
	private String porTitleClor;
	private GoodsList goodsList;
	public GoodsList getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(GoodsList goodsList) {
		this.goodsList = goodsList;
	}

	public String getPorTitleClor() {
		return porTitleClor;
	}

	public void setPorTitleClor(String porTitleClor) {
		this.porTitleClor = porTitleClor;
	}

	private int goodsId;
	private String sendTime;
	private String createTime;
	private String porCtent;
	private String templateID;
	private String keyword1;
	private String keyword1Clor;
	private String keyword2;
	private String keyword2Clor;
	private String keyword3;
	private String keyword3Clor;
	private String keyword4;
	private String keyword4Clor;
	private String keyword5;
	private String keyword5Clor;
	private String keyword6;
	private String keyword6Clor;
	private String keyword7;
	private String keyword7Clor;
	private String remark;
	private String remarkClor;
	private String userList;

	public int getPorId() {
		return porId;
	}

	public void setPorId(int porId) {
		this.porId = porId;
	}

	public String getPorTitle() {
		return porTitle;
	}

	public void setPorTitle(String porTitle) {
		this.porTitle = porTitle;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getPorCtent() {
		return porCtent;
	}

	public void setPorCtent(String porCtent) {
		this.porCtent = porCtent;
	}

	public String getTemplateID() {
		return templateID;
	}

	public void setTemplateID(String templateID) {
		this.templateID = templateID;
	}

	public String getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
	}

	public String getKeyword1Clor() {
		return keyword1Clor;
	}

	public void setKeyword1Clor(String keyword1Clor) {
		this.keyword1Clor = keyword1Clor;
	}

	public String getKeyword2() {
		return keyword2;
	}

	public void setKeyword2(String keyword2) {
		this.keyword2 = keyword2;
	}

	public String getKeyword2Clor() {
		return keyword2Clor;
	}

	public void setKeyword2Clor(String keyword2Clor) {
		this.keyword2Clor = keyword2Clor;
	}

	public String getKeyword3() {
		return keyword3;
	}

	public void setKeyword3(String keyword3) {
		this.keyword3 = keyword3;
	}

	public String getKeyword3Clor() {
		return keyword3Clor;
	}

	public void setKeyword3Clor(String keyword3Clor) {
		this.keyword3Clor = keyword3Clor;
	}

	public String getKeyword4() {
		return keyword4;
	}

	public void setKeyword4(String keyword4) {
		this.keyword4 = keyword4;
	}

	public String getKeyword4Clor() {
		return keyword4Clor;
	}

	public void setKeyword4Clor(String keyword4Clor) {
		this.keyword4Clor = keyword4Clor;
	}

	public String getKeyword5() {
		return keyword5;
	}

	public void setKeyword5(String keyword5) {
		this.keyword5 = keyword5;
	}

	public String getKeyword5Clor() {
		return keyword5Clor;
	}

	public void setKeyword5Clor(String keyword5Clor) {
		this.keyword5Clor = keyword5Clor;
	}

	public String getKeyword6() {
		return keyword6;
	}

	public void setKeyword6(String keyword6) {
		this.keyword6 = keyword6;
	}

	public String getKeyword6Clor() {
		return keyword6Clor;
	}

	public void setKeyword6Clor(String keyword6Clor) {
		this.keyword6Clor = keyword6Clor;
	}

	public String getKeyword7() {
		return keyword7;
	}

	public void setKeyword7(String keyword7) {
		this.keyword7 = keyword7;
	}

	public String getKeyword7Clor() {
		return keyword7Clor;
	}

	public void setKeyword7Clor(String keyword7Clor) {
		this.keyword7Clor = keyword7Clor;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemarkClor() {
		return remarkClor;
	}

	public void setRemarkClor(String remarkClor) {
		this.remarkClor = remarkClor;
	}

	public String getUserList() {
		return userList;
	}

	public void setUserList(String userList) {
		this.userList = userList;
	}

	/**
	 * @param porId
	 * @param porTitle
	 * @param goodsId
	 * @param sendTime
	 * @param createTime
	 * @param porCtent
	 * @param templateID
	 * @param keyword1
	 * @param keyword1Clor
	 * @param keyword2
	 * @param keyword2Clor
	 * @param keyword3
	 * @param keyword3Clor
	 * @param keyword4
	 * @param keyword4Clor
	 * @param keyword5
	 * @param keyword5Clor
	 * @param keyword6
	 * @param keyword6Clor
	 * @param keyword7
	 * @param keyword7Clor
	 * @param remark
	 * @param remarkClor
	 * @param userList
	 */
	public ProductOperationReport(int porId, String porTitle, int goodsId, String sendTime, String createTime,
			String porCtent, String templateID, String keyword1, String keyword1Clor, String keyword2,
			String keyword2Clor, String keyword3, String keyword3Clor, String keyword4, String keyword4Clor,
			String keyword5, String keyword5Clor, String keyword6, String keyword6Clor, String keyword7,
			String keyword7Clor, String remark, String remarkClor, String userList) {
		super();
		this.porId = porId;
		this.porTitle = porTitle;
		this.goodsId = goodsId;
		this.sendTime = sendTime;
		this.createTime = createTime;
		this.porCtent = porCtent;
		this.templateID = templateID;
		this.keyword1 = keyword1;
		this.keyword1Clor = keyword1Clor;
		this.keyword2 = keyword2;
		this.keyword2Clor = keyword2Clor;
		this.keyword3 = keyword3;
		this.keyword3Clor = keyword3Clor;
		this.keyword4 = keyword4;
		this.keyword4Clor = keyword4Clor;
		this.keyword5 = keyword5;
		this.keyword5Clor = keyword5Clor;
		this.keyword6 = keyword6;
		this.keyword6Clor = keyword6Clor;
		this.keyword7 = keyword7;
		this.keyword7Clor = keyword7Clor;
		this.remark = remark;
		this.remarkClor = remarkClor;
		this.userList = userList;
	}

	/**
	 * 
	 */
	public ProductOperationReport() {
		super();
	}

}
