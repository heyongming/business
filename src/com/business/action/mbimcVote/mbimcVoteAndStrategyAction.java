package com.business.action.mbimcVote;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.mbimcVote.MbimcVoteAndSituation;
import com.business.entitys.mbimcVote.MbimcVoteAndStrategy;
import com.business.service.IMbimcVoteService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class mbimcVoteAndStrategyAction extends ActionSupport implements ModelDriven<MbimcVoteAndStrategy> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6667316751339195916L;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	@Resource
	private IMbimcVoteService mbimcVoteService;
	private InputStream bis;

	public IMbimcVoteService getMbimcVoteService() {
		return mbimcVoteService;
	}

	public void setMbimcVoteService(IMbimcVoteService mbimcVoteService) {
		this.mbimcVoteService = mbimcVoteService;
	}

	private MbimcVoteAndStrategy mbimcVoteAndStrategy;

	public MbimcVoteAndStrategy getMbimcVoteAndStrategy() {
		return mbimcVoteAndStrategy;
	}

	public void setMbimcVoteAndStrategy(MbimcVoteAndStrategy mbimcVoteAndStrategy) {
		this.mbimcVoteAndStrategy = mbimcVoteAndStrategy;
	}

	@Override
	public MbimcVoteAndStrategy getModel() {
		// TODO Auto-generated method stub
		mbimcVoteAndStrategy = new MbimcVoteAndStrategy();
		return mbimcVoteAndStrategy;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

	public String getFullData() {
		List<MbimcVoteAndStrategy> list = mbimcVoteService.selectAllMbimcVoteAndStrategy();
		if (list != null) {
			if (list.size() > 0) {
				toJsonSteam(JSONObject.toJSONString(list));
				return this.SUCCESS;
			}
		}
		toJsonSteam("[]");
		return this.SUCCESS;
	}

	public String getFindById() {
		List<MbimcVoteAndStrategy> list = mbimcVoteService
				.selectMbimcVoteAndStrategyByKey(mbimcVoteAndStrategy.getMvsId());
		if (list != null) {
			if (list.size() > 0) {
				toJsonSteam(JSONObject.toJSONString(list));
				return this.SUCCESS;
			}
		}
		toJsonSteam("[]");
		return this.SUCCESS;
	}

	public String delMbimcVoteAndStrategybykey() {
		ResultMessage resultMessage = null;
		int flog = mbimcVoteService.delMbimcVoteAndSituationByKey(mbimcVoteAndStrategy.getMvsId());
		if (flog > 0) {
			resultMessage=new ResultMessage("1", "true", "del ok");
		} else {
			resultMessage=new ResultMessage("1", "true", "del ok");
		}
		return JSONObject.toJSONString(resultMessage);
	}

	public String delMbimcVoteAndStrategybymbimcVote() {
		ResultMessage resultMessage = null;
		int flog = mbimcVoteService.delMbimcVoteAndStrategyByMvId(mbimcVoteAndStrategy.getMvId());
		if (flog > 0) {
			resultMessage=new ResultMessage("1", "true", "del ok");
		} else {
			resultMessage=new ResultMessage("1", "true", "del ok");
		}
		return JSONObject.toJSONString(resultMessage);
	}

	private void toJsonSteam(String text) {
		try {
			bis = new ByteArrayInputStream(text.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			bis = null;
			e.printStackTrace();
		}
	}
}
