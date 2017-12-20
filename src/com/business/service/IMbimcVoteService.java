package com.business.service;

import java.util.List;

import com.business.entitys.mbimcVote.MbimcVote;
import com.business.entitys.mbimcVote.MbimcVoteAndSituation;
import com.business.entitys.mbimcVote.MbimcVoteAndStrategy;

public interface IMbimcVoteService {
	int addMbimcVote(MbimcVote mbimcVote);

	int addMbimcVoteAndSituation(MbimcVoteAndSituation mbimcVoteAndSituation);

	int addMbimcVoteAndStrategy(MbimcVoteAndStrategy mbimcVoteAndStrategy);

	int updateMbimcVote(MbimcVote mbimcVote);

	int delMbimcVote(int mvId);

	int delMbimcVoteAndSituationByKey(int msId);

	int delMbimcVoteAndSituationByMvId(int mvId);

	int delMbimcVoteAndStrategyByKey(int mvsId);

	int delMbimcVoteAndStrategyByMvId(int mvId);
	
	List<MbimcVote> selectAllMbimcVote();
	
	List<MbimcVote> selectMbimcVoteByKey(int mvId);
	
	List<MbimcVoteAndSituation> selectAllMbimcVoteAndSituation();
	
	List<MbimcVoteAndSituation> selectMbimcVoteAndSituationByKey(int msId);
	
	List<MbimcVoteAndStrategy> selectAllMbimcVoteAndStrategy();
	
	List<MbimcVoteAndStrategy> selectMbimcVoteAndStrategyByKey(int mvsId);
	
	
	
}
