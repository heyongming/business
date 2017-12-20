package com.business.dao;

import java.util.List;
import java.util.Map;

import com.business.entitys.mbimcVote.MbimcVote;
import com.business.entitys.mbimcVote.MbimcVoteAndSituation;
import com.business.entitys.mbimcVote.MbimcVoteAndStrategy;

public interface IMbimcVoteDao {
	int insertMbimcVote(MbimcVote mbimcVote);

	int insertMbimcVoteAndSituation(MbimcVoteAndSituation mbimcVoteAndSituation);

	int insertMbimcVoteAndStrategy(MbimcVoteAndStrategy mbimcVoteAndStrategy);

	int updateMbimcVote(MbimcVote mbimcVote);

	int deleteMbimcVote(int mvId);

	int deleteMbimcVoteAndSituation(Map<String, Object> map);

	int deleteMbimcVoteAndStrategy(Map<String, Object> map);

	List<MbimcVote> selectMbimcVoteBywhere(Map<String, Object> map);
	
	List<MbimcVoteAndStrategy> selectMbimcVoteAndStrategyBywhere(Map<String, Object> map);
	
	List<MbimcVoteAndSituation> selectMbimcVoteAndSituationBywhere(Map<String, Object> map);
	
}
