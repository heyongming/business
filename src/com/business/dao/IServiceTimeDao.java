package com.business.dao;

import java.util.List;
import java.util.Map;

import com.business.entitys.service.ServiceTime;

public interface IServiceTimeDao {

	/**
	 * DAO层的插入请求。
	 * 
	 * @param serviceTime
	 *            服务的相关实体
	 * @return 插入成功后的主键
	 */
	int insert(ServiceTime serviceTime);

	/**
	 * DAO层的查询请求。
	 * 
	 * @param 需要查询的参数
	 * @return 查询的结果
	 */
	List<ServiceTime> selectByWhere(Map<String, Object> map);
	/**
	 * DAO层的删除请求。
	 * 
	 * @param 需要查询的参数
	 * @return 查询的结果
	 */
	int delete(int id);
	
	int update(ServiceTime serviceTime);
	int updateBySubService();
}
