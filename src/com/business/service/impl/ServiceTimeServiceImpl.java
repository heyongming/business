package com.business.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.business.dao.IServiceTimeDao;
import com.business.entitys.ResultMessage;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.order.OrderForm;
import com.business.entitys.service.ServiceTime;
import com.business.entitys.user.User;
import com.business.service.IServiceTimeService;
import com.business.util.HtmlToPdf;
import com.business.util.PacthUtill;

@Repository("serviceTimeService")
public class ServiceTimeServiceImpl implements IServiceTimeService {
	@Resource
	private IServiceTimeDao serviceTimeDao;

	public IServiceTimeDao getServiceTimeDao() {
		return serviceTimeDao;
	}

	public void setServiceTimeDao(IServiceTimeDao serviceTimeDao) {
		this.serviceTimeDao = serviceTimeDao;
	}
	//生成协议的PDF
	@Override
	public String savePdf(User user, OrderForm orderForm, GoodsList goodsList, String isDanger) {
		// TODO Auto-generated method stub
		String rootPath = PacthUtill.getPacthVal("savePdfSavePath");
		String fictitiousPath = PacthUtill.getPacthVal("savePdfFictitiousPath");
		String path = rootPath + user.getUserId();
		File file = new File(path);
		if (!file.exists() && !file.isDirectory()) {
			file.mkdir();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pdfGoodsId", goodsList.getGoodsId());
		map.put("pdfUserId", user.getUserId());
		List<ServiceTime> serviceTimeList = serviceTimeDao.selectByWhere(map);
		ServiceTime st = serviceTimeList.get(0);

		path = path + "//" + orderForm.getOrderSerialNumber() + ".pdf";
		if (isDanger == null) {
			//是资讯类消息
			//该工具访问该action会生成对应的网页，工具会自动把网页转换成PDF
			if (HtmlToPdf.convert("http://localhost/business/order/getFxPdf?userId=" + user.getUserId(), path)) {

			}
		} else {
			//模拟盘消息
			//该工具访问该action会生成对应的网页，工具会自动把网页转换成PDF
			if (HtmlToPdf.convert("http://localhost/business/order/getPdfData?userId=" + user.getUserId() + "&goodsId="
					+ goodsList.getGoodsId() + "&oderId=" + orderForm.getOrderSerialNumber(), path)) {

			}

		}
		//把PDF存储在本地
		String xnpath = fictitiousPath + user.getUserId() + "/" + orderForm.getOrderSerialNumber() + ".pdf"; // web访问路径
		st.setAgreement(xnpath);
		st.setRealAgreement(path);

		int flog = serviceTimeDao.update(st);
		String result = null;
		if (flog > 0) {
			ResultMessage resultMessage = new ResultMessage("1", "true", "ok");
			result = JSONObject.toJSONString(resultMessage);
		} else {
			ResultMessage resultMessage = new ResultMessage("-1", "false", "系统出现故障,请联系客服");
			result = JSONObject.toJSONString(resultMessage);
		}
		return result;
	}

	@Override
	public ServiceTime findServiceTimeEntity(User user, GoodsList goodsList) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pdfGoodsId", goodsList.getGoodsId());
		map.put("pdfUserId", user.getUserId());
		List<ServiceTime> serviceTimeList = serviceTimeDao.selectByWhere(map);
		ServiceTime st = serviceTimeList.get(0);
		return st;
	}

	@Override
	public ServiceTime findServiceUserEntity(User user, GoodsList goodsList) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pdfUserId", user.getUserId());
		map.put("pdfGoodsId", goodsList.getGoodsId());

		List<ServiceTime> list = serviceTimeDao.selectByWhere(map);
		if (list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public int subSertviceTime() {
		// TODO Auto-generated method stub
		return serviceTimeDao.updateBySubService();
	}

	@Override
	public List<ServiceTime> findServiceUserEntityByUser(User user) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serviceUserId", user.getUserId());

		List<ServiceTime> list = serviceTimeDao.selectByWhere(map);
		if (list.size() > 0)
			return list;
		return null;

	}

	@Override
	public int updateServiceTime(ServiceTime serviceTime) {
		// TODO Auto-generated method stub
		return serviceTimeDao.update(serviceTime);

	}

	@Override
	public List<ServiceTime> findAllData() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<ServiceTime> list = serviceTimeDao.selectByWhere(map);
		return list;
	}

	@Override
	public ServiceTime findDataById(int id) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("findKey", "寻找主键的数据");
		map.put("findId", id);
		List<ServiceTime> list = serviceTimeDao.selectByWhere(map);
		if (list != null) {
			if (list.size() > 0) {
				return list.get(0);
			}
		}

		return null;
	}

	@Override
	public int deleteServiceTime(int id) {
		// TODO Auto-generated method stub
		return serviceTimeDao.delete(id);

	}

	@Override
	public List<User> findBuyGoodsUser(int goodsId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("buyGoodsUserList", "拉取购买该商品下的所有用户");
		map.put("buyGoodsUserGoods", goodsId);
		List<ServiceTime> list = serviceTimeDao.selectByWhere(map);
		List<User> userList = new ArrayList<User>();
		for (ServiceTime serviceTime : list) {
			if (serviceTime.getUser().getMpUserEntity() != null) {
				userList.add(serviceTime.getUser());
			}

		}
		if (userList.size() > 0) {
			return userList;
		}
		return null;
	}
}
