package com.business.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.mp.temp.ResultMsg;
import com.business.entitys.mp.template.DataRemark;
import com.business.entitys.mp.template.Template;
import com.business.entitys.mp.template.TemplateCtent;
import com.business.entitys.mp.template.TemplateUser;
import com.business.entitys.service.ServiceArticle;
import com.business.entitys.user.User;
import com.business.job.AccessTokenManager;
import com.business.util.mp.MessAgeUtil;

//
/**
 * @author heyongming {@code} 用来推送红点消息的工作线程
 */
public class SenMsgThread extends Thread {
	private int tempLateId;
	private Template template;
	private String type;
	private int serviceId;
	private ServiceArticle serviceArticle;

	public ServiceArticle getServiceArticle() {
		return serviceArticle;
	}

	public void setServiceArticle(ServiceArticle serviceArticle) {
		this.serviceArticle = serviceArticle;
	}

	private List<String> openIdList;

	public List<String> getOpenIdList() {
		return openIdList;
	}

	public void setOpenIdList(List<String> openIdList) {
		this.openIdList = openIdList;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public static int num, errNum, total;

	public int getTempLateId() {
		return tempLateId;
	}

	public void setTempLateId(int tempLateId) {
		this.tempLateId = tempLateId;
	}

	public static int getNum() {
		return num;
	}

	public static void setNum(int num) {
		SenMsgThread.num = num;
	}

	public static int getErrNum() {
		return errNum;
	}

	public static void setErrNum(int errNum) {
		SenMsgThread.errNum = errNum;
	}

	public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		SenMsgThread.total = total;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String url="http://18f42658v7.iok.la/business/mp/serviceArticleHd?serviceArticleNum=" + serviceId;
			url=MessAgeUtil.webLicensingnSapi_userinfo(url);
			template.setResetUrl(url);
			ResultMsg resultMsg = null;
			num = errNum = 0;

			/*
			 * TemplateUser templateUser =
			 * getTemplateCtent("oSYjBwABjLBEUOrQO54QqTqONbcE", type, template);
			 * String result =
			 * MessAgeUtil.sendTemplate(AccessTokenManager.Access_Token,
			 * templateUser);
			 */

			for (int i = 0; i < openIdList.size(); i++) {
				TemplateUser templateUser = getTemplateCtent(openIdList.get(i), type, template);

				String result = MessAgeUtil.sendTemplate(AccessTokenManager.Access_Token, templateUser);
				System.out.println(result);

			}

		} catch (Exception ex) {

		}
	}

	public SenMsgThread() {
		super();
	}

	public SenMsgThread(int tempLateId, Template template, String type, int serviceId, List<String> openIdList,
			ServiceArticle serviceArticle, GoodsList goodsList) {
		super();
		this.tempLateId = tempLateId;
		this.template = template;
		this.type = type;
		this.serviceId = serviceId;
		this.openIdList = openIdList;
		this.serviceArticle = serviceArticle;
		initTempLate(goodsList);
	}

	private void initTempLate(GoodsList goodsList) {

		String typeName = null;
		if (serviceArticle.getServiceTypeId() == 1) {
			typeName = "添禄早评";
		} else if (serviceArticle.getServiceTypeId() == 2) {
			typeName = "添禄午评";
		} else if (serviceArticle.getServiceTypeId() == 3) {
			typeName = "添禄晚评";
		} else if (serviceArticle.getServiceTypeId() == 4) {
			typeName = "添禄策略";
		}
		template.setFirst("【"+typeName +"】"+ ",最新资讯火热出炉！\n");
		template.setFirstColor("#FF0000");
		template.setKeyword1(goodsList.getGoodsName() +"\n");
		template.setKeyword1Color("#FF0000");
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日"+"\n");
		template.setKeyword2(sdf.format(d));
		template.setKeyword2Color("#000000");
		template.setRemark("今天看好什么呢？速度点击这里！！！"+"\n");
		template.setRemarkColor("#FF0000");

	}

	private TemplateUser getTemplateCtent(String openid, String template_id, Template template) {
		TemplateUser ctent = new TemplateUser();
		ctent.setTouser(openid);
		ctent.setTemplate_id(template_id);
		ctent.setUrl(template.getResetUrl());
		TemplateCtent templateCtent = new TemplateCtent();
		templateCtent.setFirst(new DataRemark(template.getFirst(), template.getFirstColor()));
		templateCtent.setKeyword1(new DataRemark(template.getKeyword1(), template.getKeyword1Color()));
		templateCtent.setKeyword2(new DataRemark(template.getKeyword2(), template.getKeyword2Color()));
		templateCtent.setKeyword3(new DataRemark(template.getKeyword3(), template.getKeyword3Color()));
		templateCtent.setKeyword4(new DataRemark(template.getKeyword4(), template.getKeyword4Color()));
		templateCtent.setKeyword5(new DataRemark(template.getKeyword5(), template.getKeyword5Color()));

		templateCtent.setRemark(new DataRemark(template.getRemark(), template.getRemarkColor()));

		ctent.setData(templateCtent);
		return ctent;
	}

}
