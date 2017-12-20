package com.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.business.dao.IMbimcVoteDao;
import com.business.entitys.mbimcVote.MbimcVote;
import com.business.entitys.mbimcVote.MbimcVoteAndSituation;
import com.business.entitys.mbimcVote.MbimcVoteAndStrategy;
import com.business.service.IMbimcVoteService;

@Repository("mbimcVoteService")
public class MbimcVoteServiceImpl implements IMbimcVoteService {

	@Resource
	private IMbimcVoteDao MbimcVoteDao;

	public IMbimcVoteDao getMbimcVoteDao() {
		return MbimcVoteDao;
	}

	public void setMbimcVoteDao(IMbimcVoteDao mbimcVoteDao) {
		MbimcVoteDao = mbimcVoteDao;
	}

	@Override
	public int addMbimcVote(MbimcVote mbimcVote) {
		// TODO Auto-generated method stub
		return MbimcVoteDao.insertMbimcVote(mbimcVote);
	}

	@Override
	public int addMbimcVoteAndSituation(MbimcVoteAndSituation mbimcVoteAndSituation) {
		// TODO Auto-generated method stub
		return MbimcVoteDao.insertMbimcVoteAndSituation(mbimcVoteAndSituation);
	}

	@Override
	public int addMbimcVoteAndStrategy(MbimcVoteAndStrategy mbimcVoteAndStrategy) {
		// TODO Auto-generated method stub
		return MbimcVoteDao.insertMbimcVoteAndStrategy(mbimcVoteAndStrategy);
	}

	@Override
	public int updateMbimcVote(MbimcVote mbimcVote) {
		// TODO Auto-generated method stub
		return MbimcVoteDao.updateMbimcVote(mbimcVote);
	}

	@Override
	public int delMbimcVote(int mvId) {
		// TODO Auto-generated method stub
		int flog= MbimcVoteDao.deleteMbimcVote(mvId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mvId", mvId);
		MbimcVoteDao.deleteMbimcVoteAndStrategy(map);
		MbimcVoteDao.deleteMbimcVoteAndSituation(map);
		return flog;
	}

	@Override
	public int delMbimcVoteAndSituationByKey(int msId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msId", msId);
		return MbimcVoteDao.deleteMbimcVoteAndSituation(map);
	}

	@Override
	public int delMbimcVoteAndSituationByMvId(int mvId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mvId", mvId);
		return MbimcVoteDao.deleteMbimcVoteAndSituation(map);
	}

	@Override
	public int delMbimcVoteAndStrategyByKey(int mvsId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mvsId", mvsId);
		return MbimcVoteDao.deleteMbimcVoteAndStrategy(map);
	}

	@Override
	public int delMbimcVoteAndStrategyByMvId(int mvId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mvId", mvId);
		return MbimcVoteDao.deleteMbimcVoteAndStrategy(map);
	}

	@Override
	public List<MbimcVote> selectAllMbimcVote() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();

		return MbimcVoteDao.selectMbimcVoteBywhere(map);
	}

	@Override
	public List<MbimcVote> selectMbimcVoteByKey(int mvId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("findKey", "寻找主键的数据");
		map.put("mvId", mvId);

		return MbimcVoteDao.selectMbimcVoteBywhere(map);
	}

	@Override
	public List<MbimcVoteAndSituation> selectAllMbimcVoteAndSituation() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();

		return MbimcVoteDao.selectMbimcVoteAndSituationBywhere(map);
	}

	@Override
	public List<MbimcVoteAndSituation> selectMbimcVoteAndSituationByKey(int msId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("findKey", "寻找主键的数据");
		map.put("msId", msId);

		return MbimcVoteDao.selectMbimcVoteAndSituationBywhere(map);
	}

	@Override
	public List<MbimcVoteAndStrategy> selectAllMbimcVoteAndStrategy() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();

		return MbimcVoteDao.selectMbimcVoteAndStrategyBywhere(map);
	}

	@Override
	public List<MbimcVoteAndStrategy> selectMbimcVoteAndStrategyByKey(int mvsId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("findKey", "寻找主键的数据");
		map.put("mvsId", mvsId);

		return MbimcVoteDao.selectMbimcVoteAndStrategyBywhere(map);
	}

}
