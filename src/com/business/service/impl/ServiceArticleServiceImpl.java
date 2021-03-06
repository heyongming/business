package com.business.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.business.dao.IGoodsListDao;
import com.business.dao.IServiceArticleDao;
import com.business.dao.IServiceArticleDetailsDao;
import com.business.dao.IServiceTimeDao;
import com.business.dao.IUserDao;
import com.business.entitys.ResultMessage;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.mp.template.Template;
import com.business.entitys.service.ServiceArticle;
import com.business.entitys.service.ServiceArticleDetails;
import com.business.entitys.service.ServiceArticleHelper;
import com.business.entitys.service.ServiceTime;
import com.business.entitys.user.User;
import com.business.service.IServiceArticleService;
import com.business.service.IUserService;
import com.business.util.SenMsgThread;

@Repository("serviceArticleService")
public class ServiceArticleServiceImpl implements IServiceArticleService {
	@Resource
	private IServiceArticleDao serviceArticleDao;
	@Resource
	private IServiceArticleDetailsDao serviceArticleDetailsDao;
	@Resource
	private IUserDao userDao;
	@Resource
	private IGoodsListDao goodsListDao;
	@Resource
	private IServiceTimeDao serviceTimeDao;

	public IServiceTimeDao getServiceTimeDao() {
		return serviceTimeDao;
	}

	public void setServiceTimeDao(IServiceTimeDao serviceTimeDao) {
		this.serviceTimeDao = serviceTimeDao;
	}

	public IGoodsListDao getGoodsListDao() {
		return goodsListDao;
	}

	public void setGoodsListDao(IGoodsListDao goodsListDao) {
		this.goodsListDao = goodsListDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public IServiceArticleDetailsDao getServiceArticleDetailsDao() {
		return serviceArticleDetailsDao;
	}

	public void setServiceArticleDetailsDao(IServiceArticleDetailsDao serviceArticleDetailsDao) {
		this.serviceArticleDetailsDao = serviceArticleDetailsDao;
	}

	public IServiceArticleDao getServiceArticleDao() {
		return serviceArticleDao;
	}

	public void setServiceArticleDao(IServiceArticleDao serviceArticleDao) {
		this.serviceArticleDao = serviceArticleDao;
	}

	@Override
	public String saveServiceArticle(ServiceArticle serviceArticle) {
		// TODO Auto-generated method stub
		int flog = serviceArticleDao.insert(serviceArticle);
		ResultMessage resultMessage = null;

		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "添加成功");
			int goodsId = serviceArticle.getGoodsId();
			GoodsList goodsList = goodsListDao.queryByGoodsId(goodsId);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("haveGoodsIdUser", "获得用户拥有此商品的LIST");
			map.put("haveGoodsId", goodsId);
			List<User> list = userDao.selectBywhere(map);
			List<String> openIdList = new ArrayList<String>();
			for (User user : list) {
				if (user.getMpUserEntity() != null) {
					if ((user.getMpUserEntity().getOpenid()).length() > 5) {
						openIdList.add(user.getMpUserEntity().getOpenid());
					}
				}

			}
			//推送红点！相关API查看微信接口
			SenMsgThread senMsgThread = new SenMsgThread(0, new Template(),
					"upDR8Yi1RkjSwiyQ51WZf1t6XxLjUGOFlPhqQrM8OGY", flog, openIdList, serviceArticle, goodsList);
			senMsgThread.start();
		} else {
			resultMessage = new ResultMessage("-1", "false", "添加失败,请及时联系管理员");
		}
		return JSONObject.toJSONString(resultMessage);
	}

	@Override
	public String updateServiceArticle(ServiceArticle serviceArticle) {
		// TODO Auto-generated method stub
		int flog = serviceArticleDao.update(serviceArticle);
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "修改成功");

		} else {
			resultMessage = new ResultMessage("-1", "false", "修改失败,请及时联系管理员");
		}
		return JSONObject.toJSONString(resultMessage);
	}

	@Override
	public String delServiceArticle(ServiceArticle serviceArticle) {
		// TODO Auto-generated method stub
		int flog = serviceArticleDao.delete(serviceArticle);
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "刪除成功");

		} else {
			resultMessage = new ResultMessage("-1", "false", "刪除失败,请及时联系管理员");
		}
		return JSONObject.toJSONString(resultMessage);
	}

	@Override
	public List<ServiceArticle> getFullData() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<ServiceArticle> list = serviceArticleDao.selectBywhere(map);
		if (list == null)
			return null;
		return list;
	}

	@Override
	public ServiceArticle findByServiceArticleNum(int serviceArticleNum) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyServiceArticleNum", serviceArticleNum);
		List<ServiceArticle> list = serviceArticleDao.selectBywhere(map);
		if (list.size() > 0)
			return list.get(0);
		return null;

	}

	@Override
	public List<ServiceArticle> doCurrentData(int goodsId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd?HH:mm:ss");// 设置日期格式
		String str = df.format(new Date()).toString();
		int index = str.lastIndexOf("?");
		str = str.subSequence(0, index).toString();
		map.put("goodsIdCurrentData", "获取这个商品ID 当天发布的相关信息");
		map.put("findGoodsId", goodsId);
		map.put("findTime", str);

		List<ServiceArticle> list = serviceArticleDao.selectBywhere(map);

		return list;
	}

	@Override
	public List<ServiceArticle> doHistoryData(int goodsId, int serviceTypeId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd?HH:mm:ss");// 设置日期格式
		String str = df.format(new Date()).toString();
		int index = str.lastIndexOf("?");
		str = str.subSequence(0, index).toString();
		map.put("goodsIdHistoryData", "获取这个商品ID历史发布的相关信息");
		map.put("historyGoodsId", goodsId);
		map.put("historyTime", str);
		map.put("historyType", serviceTypeId);

		List<ServiceArticle> list = serviceArticleDao.selectBywhere(map);

		return list;
	}

	@Override
	public List<ServiceArticleDetails> doDetailsToServiceArticle(ServiceArticle serviceArticle) {
		// TODO Auto-generated method stub
		serviceArticle.setReadingNumber(serviceArticle.getReadingNumber() + 1);
		serviceArticleDao.update(serviceArticle);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("getEvaluateList", "获得该文章下的所有评论");
		map.put("evaluateId", serviceArticle.getServiceArticleNum());
		List<ServiceArticleDetails> list = serviceArticleDetailsDao.selectBywhere(map);
		return list;
	}

	@Override
	public ResultMessage doThumbsUp(User user, ServiceArticle serviceArticle) {
		// TODO Auto-generated method stub
		ServiceArticleHelper serviceArticleHelper = new ServiceArticleHelper(0, serviceArticle.getServiceArticleNum(),
				user.getUserId(), null);
		ServiceArticleHelper helper = serviceArticleDetailsDao.selectServiceArticleHelper(serviceArticleHelper);
		ResultMessage message = null;
		if (helper == null) {
			serviceArticleDetailsDao.insertServiceArticleHelper(serviceArticleHelper);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("keyServiceArticleNum", serviceArticle.getServiceArticleNum());
			ServiceArticle article = (serviceArticleDao.selectBywhere(map)).get(0);
			article.setPointNumber(article.getPointNumber() + 1);
			serviceArticleDao.update(article);
			message = new ResultMessage("1", "true", "成功");
			return message;
		}
		message = new ResultMessage("-2", "false", "已点赞，不能重复点赞");
		return message;
	}

	@Override
	public ResultMessage doComment(ServiceArticleDetails serviceArticleDetails) {
		// TODO Auto-generated method stub
		int flog = serviceArticleDetailsDao.insertServiceArticleDetail(serviceArticleDetails);
		ResultMessage message = null;
		if (flog > 0) {
			return message = new ResultMessage("1", "true", "成功");
		}

		return message = new ResultMessage("-2", "false", "系统错误");
	}

	@Override
	public int isDoThumbsUp(User user, ServiceArticle serviceArticle) {
		// TODO Auto-generated method stub
		ServiceArticleHelper serviceArticleHelper = new ServiceArticleHelper(0, serviceArticle.getServiceArticleNum(),
				user.getUserId(), null);
		ServiceArticleHelper helper = serviceArticleDetailsDao.selectServiceArticleHelper(serviceArticleHelper);

		if (helper == null) {
			return 0;
		}

		return 1;
	}

	@Override
	public List<ServiceArticle> doHistoryDateData(int goodsId, String date, int userId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serviceGoodsIdList", "test");
		map.put("serviceUserId", userId);
		List<ServiceTime> serviceTimelist = serviceTimeDao.selectByWhere(map);
		String lostTime=null;
		for (ServiceTime time : serviceTimelist) {
			if (time.getGoodsId() == goodsId) {
				lostTime=time.getServiceTime();
			}
		}
		if (lostTime == null) {
			return null;
		}
		map = new HashMap<String, Object>();
		map.put("doHistoryDateData", "获取这个商品历史时间所发布的消息");
		map.put("doHistoryDateDataId", goodsId);
		map.put("doHistoryDateDataIdTime", date);
		map.put("lostTime",lostTime);
		List<ServiceArticle> list = serviceArticleDao.selectBywhere(map);

		return list;

	}

}
