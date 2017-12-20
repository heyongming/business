package com.business.entitys.mbimcVote;

import java.util.List;

public class MbimcVote {
	private int mvId;
	private String title;
	private String marketAnalysis;
	private String initialFunds;
	private String capitalBalance;
	private String totalAssets;
	private String totalMarketValue;
	private String totalProfitAndLoss;
	private String assetChart;
	private String netValueTrendChart;
	private String mvTime;
	public String getNetValueTrendChart() {
		return netValueTrendChart;
	}

	public void setNetValueTrendChart(String netValueTrendChart) {
		this.netValueTrendChart = netValueTrendChart;
	}

	@Override
	public String toString() {
		return "MbimcVote [mvId=" + mvId + ", title=" + title + ", marketAnalysis=" + marketAnalysis + ", initialFunds="
				+ initialFunds + ", capitalBalance=" + capitalBalance + ", totalAssets=" + totalAssets
				+ ", totalMarketValue=" + totalMarketValue + ", totalProfitAndLoss=" + totalProfitAndLoss
				+ ", assetChart=" + assetChart + ", netValueTrendChart=" + netValueTrendChart + ", mvTime=" + mvTime
				+ ", mbimcVoteAndSituation=" + mbimcVoteAndSituation + ", mbimcVoteAndStrategy=" + mbimcVoteAndStrategy
				+ "]";
	}

	public String getMvTime() {
		return mvTime;
	}

	public void setMvTime(String mvTime) {
		this.mvTime = mvTime;
	}

	private List<MbimcVoteAndSituation> mbimcVoteAndSituation;
	private List<MbimcVoteAndStrategy> mbimcVoteAndStrategy;

	public int getMvId() {
		return mvId;
	}



	public void setMvId(int mvId) {
		this.mvId = mvId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMarketAnalysis() {
		return marketAnalysis;
	}

	public void setMarketAnalysis(String marketAnalysis) {
		this.marketAnalysis = marketAnalysis;
	}

	public String getInitialFunds() {
		return initialFunds;
	}

	public void setInitialFunds(String initialFunds) {
		this.initialFunds = initialFunds;
	}

	public String getCapitalBalance() {
		return capitalBalance;
	}

	public void setCapitalBalance(String capitalBalance) {
		this.capitalBalance = capitalBalance;
	}

	public String getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(String totalAssets) {
		this.totalAssets = totalAssets;
	}

	public String getTotalMarketValue() {
		return totalMarketValue;
	}

	public void setTotalMarketValue(String totalMarketValue) {
		this.totalMarketValue = totalMarketValue;
	}

	public String getTotalProfitAndLoss() {
		return totalProfitAndLoss;
	}

	public void setTotalProfitAndLoss(String totalProfitAndLoss) {
		this.totalProfitAndLoss = totalProfitAndLoss;
	}

	public String getAssetChart() {
		return assetChart;
	}

	public void setAssetChart(String assetChart) {
		this.assetChart = assetChart;
	}

	public List<MbimcVoteAndSituation> getMbimcVoteAndSituation() {
		return mbimcVoteAndSituation;
	}

	public void setMbimcVoteAndSituation(List<MbimcVoteAndSituation> mbimcVoteAndSituation) {
		this.mbimcVoteAndSituation = mbimcVoteAndSituation;
	}

	public List<MbimcVoteAndStrategy> getMbimcVoteAndStrategy() {
		return mbimcVoteAndStrategy;
	}

	public void setMbimcVoteAndStrategy(List<MbimcVoteAndStrategy> mbimcVoteAndStrategy) {
		this.mbimcVoteAndStrategy = mbimcVoteAndStrategy;
	}

}
