package com.business.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.business.dao.IScheduleJobDao;
import com.business.entitys.Schedule.ScheduleJob;

@Repository("scheduleJobDao")
public class ScheduleJobDaoImpl implements IScheduleJobDao {
	@Resource
	private SqlSessionTemplate sessionTemplate;

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	@Override
	public int deleteByPrimaryKey(Long jobId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ScheduleJob record) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("schedule.insert", record);
	}

	@Override
	public int insertSelective(ScheduleJob record) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("schedule.insertSelective", record);
	}

	@Override
	public ScheduleJob selectByPrimaryKey(Long jobId) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("schedule.selectByPrimaryKey", jobId);
	}

	@Override
	public int updateByPrimaryKeySelective(ScheduleJob record) {
		// TODO Auto-generated method stub
		return sessionTemplate.update("schedule.updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(ScheduleJob record) {
		// TODO Auto-generated method stub
		return sessionTemplate.update("schedule.updateByPrimaryKey", record);
	}

	@Override
	public List<ScheduleJob> getAll() {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("schedule.getAll");
	}

}
