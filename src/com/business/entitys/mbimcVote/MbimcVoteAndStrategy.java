package com.business.entitys.mbimcVote;

public class MbimcVoteAndStrategy {
	private int mvsId;
	private String mvsDate; /* 日期 */
	private String mvsName; /* 名称 */
	private String mvsCode;/* 代码 */
	private String mvsBuyIn;/* 买入 */
	private String mvsSellOut;/* 卖出 */
	private String mvsPrice;/* 价格 */
	private String mvsNumber;/* 数量 */
	private int mvId;/* 对应的总表的ID */
	private String mvsTime;/* 创建时间 */

	public int getMvsId() {
		return mvsId;
	}

	public void setMvsId(int mvsId) {
		this.mvsId = mvsId;
	}

	public String getMvsDate() {
		return mvsDate;
	}

	public void setMvsDate(String mvsDate) {
		this.mvsDate = mvsDate;
	}

	public String getMvsName() {
		return mvsName;
	}

	public void setMvsName(String mvsName) {
		this.mvsName = mvsName;
	}

	public String getMvsCode() {
		return mvsCode;
	}

	public void setMvsCode(String mvsCode) {
		this.mvsCode = mvsCode;
	}

	public String getMvsBuyIn() {
		return mvsBuyIn;
	}

	public void setMvsBuyIn(String mvsBuyIn) {
		this.mvsBuyIn = mvsBuyIn;
	}

	public String getMvsSellOut() {
		return mvsSellOut;
	}

	public void setMvsSellOut(String mvsSellOut) {
		this.mvsSellOut = mvsSellOut;
	}

	public String getMvsPrice() {
		return mvsPrice;
	}

	public void setMvsPrice(String mvsPrice) {
		this.mvsPrice = mvsPrice;
	}

	public String getMvsNumber() {
		return mvsNumber;
	}

	public void setMvsNumber(String mvsNumber) {
		this.mvsNumber = mvsNumber;
	}

	public int getMvId() {
		return mvId;
	}

	public void setMvId(int mvId) {
		this.mvId = mvId;
	}

	public String getMvsTime() {
		return mvsTime;
	}

	public void setMvsTime(String mvsTime) {
		this.mvsTime = mvsTime;
	}

	@Override
	public String toString() {
		return "MbimcVoteAndStrategy [mvsId=" + mvsId + ", mvsDate=" + mvsDate + ", mvsName=" + mvsName + ", mvsCode="
				+ mvsCode + ", mvsBuyIn=" + mvsBuyIn + ", mvsSellOut=" + mvsSellOut + ", mvsPrice=" + mvsPrice
				+ ", mvsNumber=" + mvsNumber + ", mvId=" + mvId + ", mvsTime=" + mvsTime + "]";
	}

}
