package com.business.entitys.mbimcVote;

public class MbimcVoteAndSituation {
	private int msId;
	private String msCode; /* 日期 */
	private String msName; /* 名称 */
	private String msPosition;/* 代码 */
	private String msProportion;/* 买入 */
	private String msCostPrice;/* 卖出 */
	private String msLatestPrice;/* 价格 */
	private String msMarketValue;/* 数量 */
	private String msProfitAndRatio; /* 盈亏比例 */
	private int mvId;/* 对应的总表的ID */

	@Override
	public String toString() {
		return "MbimcVoteAndSituation [msId=" + msId + ", msCode=" + msCode + ", msName=" + msName + ", msPosition="
				+ msPosition + ", msProportion=" + msProportion + ", msCostPrice=" + msCostPrice + ", msLatestPrice="
				+ msLatestPrice + ", msMarketValue=" + msMarketValue + ", msProfitAndRatio=" + msProfitAndRatio
				+ ", mvId=" + mvId + ", msTime=" + msTime + "]";
	}

	public int getMsId() {
		return msId;
	}

	public void setMsId(int msId) {
		this.msId = msId;
	}

	public String getMsCode() {
		return msCode;
	}

	public void setMsCode(String msCode) {
		this.msCode = msCode;
	}

	public String getMsName() {
		return msName;
	}

	public void setMsName(String msName) {
		this.msName = msName;
	}

	public String getMsPosition() {
		return msPosition;
	}

	public void setMsPosition(String msPosition) {
		this.msPosition = msPosition;
	}

	public String getMsProportion() {
		return msProportion;
	}

	public void setMsProportion(String msProportion) {
		this.msProportion = msProportion;
	}

	public String getMsCostPrice() {
		return msCostPrice;
	}

	public void setMsCostPrice(String msCostPrice) {
		this.msCostPrice = msCostPrice;
	}

	public String getMsLatestPrice() {
		return msLatestPrice;
	}

	public void setMsLatestPrice(String msLatestPrice) {
		this.msLatestPrice = msLatestPrice;
	}

	public String getMsMarketValue() {
		return msMarketValue;
	}

	public void setMsMarketValue(String msMarketValue) {
		this.msMarketValue = msMarketValue;
	}

	public String getMsProfitAndRatio() {
		return msProfitAndRatio;
	}

	public void setMsProfitAndRatio(String msProfitAndRatio) {
		this.msProfitAndRatio = msProfitAndRatio;
	}

	public int getMvId() {
		return mvId;
	}

	public void setMvId(int mvId) {
		this.mvId = mvId;
	}

	public String getMsTime() {
		return msTime;
	}

	public void setMsTime(String msTime) {
		this.msTime = msTime;
	}

	private String msTime;/* 创建时间 */
}
