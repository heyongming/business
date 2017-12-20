package com.business.action.mp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.business.dao.IMpUserDao;
import com.business.dao.IServiceArticleDao;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.mp.MpUserEntity;
import com.business.entitys.service.ServiceArticle;
import com.business.entitys.service.ServiceTime;
import com.business.entitys.user.User;
import com.business.service.IGoodsOperationService;
import com.business.service.IMpUserService;
import com.business.service.IServiceArticleService;
import com.business.service.IServiceTimeService;
import com.business.temp.MpCodeEntitys;
import com.business.util.mp.CodeHelpEr;
import com.business.util.mp.MessAgeUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 微信服务页Action
 * 
 * @author hym {@code} 微信服务
 */
public class MpServiceAction extends ActionSupport {

	/**
	 * 
	 */
	@Resource
	private IMpUserService mpUserService;
	@Resource
	private IGoodsOperationService goodsOperationService;
	@Resource
	private IServiceTimeService serviceTimeService;

	public IServiceTimeService getServiceTimeService() {
		return serviceTimeService;
	}

	public void setServiceTimeService(IServiceTimeService serviceTimeService) {
		this.serviceTimeService = serviceTimeService;
	}

	public IGoodsOperationService getGoodsOperationService() {
		return goodsOperationService;
	}

	public void setGoodsOperationService(IGoodsOperationService goodsOperationService) {
		this.goodsOperationService = goodsOperationService;
	}

	@Resource
	private IServiceArticleService serviceArticleService;
	private int goodsId;
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public IServiceArticleService getServiceArticleService() {
		return serviceArticleService;
	}

	public void setServiceArticleService(IServiceArticleService serviceArticleService) {
		this.serviceArticleService = serviceArticleService;
	}

	public IMpUserService getMpUserService() {
		return mpUserService;
	}

	public void setMpUserService(IMpUserService mpUserService) {
		this.mpUserService = mpUserService;
	}

	private static final long serialVersionUID = 4702874975944077584L;

	public String activation() {

		return Action.SUCCESS;
	}
	//服务页的处理入口
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		MpUserEntity entity = (MpUserEntity) session.get("mpUser");

		if (entity == null) {
			HttpServletRequest request = ServletActionContext.getRequest();

			MpCodeEntitys mpCodeEntitys = null;
			Boolean isover = true;

			if (CodeHelpEr.map.get(code) != null) {
				isover = false;
				mpCodeEntitys = (MpCodeEntitys) CodeHelpEr.map.get(code);
			} else {
				mpCodeEntitys = MessAgeUtil.GetwebpagesCode(code);
				CodeHelpEr.map.put(code, mpCodeEntitys);
			}

			entity = mpUserService.findUserInfo(mpCodeEntitys.getOpenid()); //
			if (entity == null && isover) {

				entity = MessAgeUtil.getMpUserEntity(mpCodeEntitys.getAccess_token(), mpCodeEntitys.getOpenid());
				mpUserService.addMpUser(entity);
			}
			session.put("mpUser", entity);
		}

		/*
		 * entity = new MpUserEntity("oEMmVuOtjSjRmjL6E1Szv6lKrvUY", "月光的指引",
		 * "0", "", "", "",
		 * "http://wx.qlogo.cn/mmopen/vi_32/31QVdlsGfaAIEBVQgFibkqG2N1zuUJCCe8a9det1D84JxAQ9REB2ZQuQrQCytY0TSgtficrgcPmyhVvu5wY0dJUA/0",
		 * "[]", "");
		 */
		session.put("mpUser", entity);
		if (entity == null) {
			return this.input();
		}
		//判断用户是否购买了产品 没有购买则去产品页
		User user = mpUserService.findOpenIdToUser(entity);
		if (user == null) {
			return this.input();
		}
		List<GoodsList> goodsList = mpUserService.findGetUserBuyGoodsList(user);
		if (goodsList.size() == 0) {
			return this.input();
		}
		//用户
		session.put("loginUser", user);
		//产品列表
		session.put("loginUserGoodsList", goodsList);
		//产品的个数
		session.put("loginUserGoodsListSize", goodsList.size());


		return this.SUCCESS;
	}
	//相关产品对应的当天的服务页
	public String getNewestGoodsList() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = ((User) session.get("loginUser"));
		List<GoodsList> goodsList = (List<GoodsList>) session.get("loginUserGoodsList");
		if (user == null || goodsList == null) {
			return this.input();
		}
		List<ServiceArticle> list = serviceArticleService.doCurrentData(goodsId);
		String goodsStr = goodsOperationService.queryGoodsListById(goodsId);
		GoodsList gl = JSONObject.parseObject(goodsStr, GoodsList.class);
		ServiceTime serviceTime = serviceTimeService.findServiceUserEntity(user, gl);
		request.setAttribute("currentGoodsList", list); //当天产品文章列表 

		request.setAttribute("currentTime", getDateTime());
		request.setAttribute("currentGoods", gl);//当前购买的产品
		java.util.Calendar rightNow = java.util.Calendar.getInstance();
		java.text.SimpleDateFormat sim = new java.text.SimpleDateFormat("yyyy年MM月dd日");// 得到当前时间，+3天

		rightNow.add(java.util.Calendar.DAY_OF_MONTH, serviceTime.getServiceDay());

		String date = sim.format(rightNow.getTime());

		request.setAttribute("currentGoodsDay", date); //当前时间格式化
		session.put("serviceGoodsList", gl);
		return this.SUCCESS;
	}

	private String getDateTime() {

		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
		String op = df.format(new Date()).toString();
		int endIndex = op.lastIndexOf("日");
		return op.substring(5, endIndex + 1);
	}
}
