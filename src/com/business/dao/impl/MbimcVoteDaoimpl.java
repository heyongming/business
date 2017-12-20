package com.business.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.business.dao.IMbimcVoteDao;
import com.business.entitys.mbimcVote.MbimcVote;
import com.business.entitys.mbimcVote.MbimcVoteAndSituation;
import com.business.entitys.mbimcVote.MbimcVoteAndStrategy;

@Repository("mbimcVoteDao")
public class MbimcVoteDaoimpl implements IMbimcVoteDao {
	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	@Resource
	private SqlSessionTemplate sessionTemplate;

	@Override
	public int insertMbimcVote(MbimcVote mbimcVote) {
		// TODO Auto-generated method stub
		int flog = sessionTemplate.insert("mbimcVote.insertMbimcVote", mbimcVote);
		if (flog > 0) {
			return mbimcVote.getMvId();
		}
		return 0;
	}

	@Override
	public int insertMbimcVoteAndSituation(MbimcVoteAndSituation mbimcVoteAndSituation) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("mbimcVote.insertMbimcVoteAndSituation", mbimcVoteAndSituation);
	}

	@Override
	public int insertMbimcVoteAndStrategy(MbimcVoteAndStrategy mbimcVoteAndStrategy) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("mbimcVote.insertMbimcVoteAndStrategy", mbimcVoteAndStrategy);
	}

	@Override
	public int updateMbimcVote(MbimcVote mbimcVote) {
		// TODO Auto-generated method stub
		return sessionTemplate.update("mbimcVote.updateMbimcVote", mbimcVote);
	}

	@Override
	public int deleteMbimcVote(int mvId) {
		// TODO Auto-generated method stub
		return sessionTemplate.delete("mbimcVote.delMbimcVoteAndSituation", mvId);
	}

	@Override
	public int deleteMbimcVoteAndSituation(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sessionTemplate.delete("mbimcVote.delMbimcVote", map);
	}

	@Override
	public int deleteMbimcVoteAndStrategy(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sessionTemplate.delete("mbimcVote.delMbimcVoteAndStrategy", map);
	}

	@Override
	public List<MbimcVote> selectMbimcVoteBywhere(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("mbimcVote.selectMbimcVoteBywhere", map);
	}

	@Override
	public List<MbimcVoteAndStrategy> selectMbimcVoteAndStrategyBywhere(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("mbimcVote.selectMbimcVoteAndStrategyBywhere", map);
	}

	@Override
	public List<MbimcVoteAndSituation> selectMbimcVoteAndSituationBywhere(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("mbimcVote.selectMbimcVoteAndSituationBywhere", map);
	}

}
