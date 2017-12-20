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

public class MbimcVoteAndSituationAction extends ActionSupport implements ModelDriven<MbimcVoteAndSituation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4978481009687540574L;
	@Resource
	private IMbimcVoteService mbimcVoteService;
	private InputStream bis;

	public IMbimcVoteService getMbimcVoteService() {
		return mbimcVoteService;
	}

	public void setMbimcVoteService(IMbimcVoteService mbimcVoteService) {
		this.mbimcVoteService = mbimcVoteService;
	}

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	public MbimcVoteAndSituation getMbimcVoteAndSituation() {
		return mbimcVoteAndSituation;
	}

	public void setMbimcVoteAndSituation(MbimcVoteAndSituation mbimcVoteAndSituation) {
		this.mbimcVoteAndSituation = mbimcVoteAndSituation;
	}

	private MbimcVoteAndSituation mbimcVoteAndSituation;

	@Override
	public MbimcVoteAndSituation getModel() {
		// TODO Auto-generated method stub
		mbimcVoteAndSituation = new MbimcVoteAndSituation();
		return mbimcVoteAndSituation;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		int flog = mbimcVoteService.addMbimcVoteAndSituation(mbimcVoteAndSituation);
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "true");
		} else {
			resultMessage = new ResultMessage("-1", "false", "false");
		}
		toJsonSteam(JSONObject.toJSONString(resultMessage));
		return this.SUCCESS;
	}

	public String getFullData() {
		List<MbimcVoteAndSituation> list = mbimcVoteService.selectAllMbimcVoteAndSituation();
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
		List<MbimcVoteAndSituation> list = mbimcVoteService
				.selectMbimcVoteAndSituationByKey(mbimcVoteAndSituation.getMsId());
		if (list != null) {
			if (list.size() > 0) {
				toJsonSteam(JSONObject.toJSONString(list));
				return this.SUCCESS;
			}
		}
		toJsonSteam("[]");
		return this.SUCCESS;
	}

	public String delMbimcVoteAndSituationbykey() {
		ResultMessage resultMessage = null;
		int flog = mbimcVoteService.delMbimcVoteAndSituationByKey(mbimcVoteAndSituation.getMsId());
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "del ok");
		} else {
			resultMessage = new ResultMessage("1", "true", "del ok");
		}
		return JSONObject.toJSONString(resultMessage);
	}

	public String delMbimcVoteAndSituationbymbimcVote() {
		ResultMessage resultMessage = null;
		int flog = mbimcVoteService.delMbimcVoteAndSituationByMvId(mbimcVoteAndSituation.getMvId());
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "del ok");
		} else {
			resultMessage = new ResultMessage("1", "true", "del ok");
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
