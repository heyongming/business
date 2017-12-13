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
import com.business.entitys.redDot.ProductOperationReport;
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

	private ServiceArticle serviceArticle; // 发送的文章实体
	private ProductOperationReport productOperationReport;// 发送红点的通用实体

	private List<String> openIdList;

	public static int num, errNum, total;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (serviceArticle != null) {
			sendServiceArticle();
		}
		if(productOperationReport!=null)
		{
			sendProductOperationReport();
		}

	}

	// 文章的构造
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

	// 通用红点模板构造
	public SenMsgThread(int tempLateId, Template template, String type, ProductOperationReport productOperationReport,
			List<String> openIdList, GoodsList goodsList) {
		super();
		this.tempLateId = tempLateId;
		this.template = template;
		this.type = type;
		this.productOperationReport = productOperationReport;
		this.openIdList = openIdList;
		initPro(productOperationReport);

	}

	private void initPro(ProductOperationReport productOperationReport) {

		template.setFirst(productOperationReport.getPorTitle()+"\n");
		template.setFirstColor("#FF0000");
		template.setKeyword1(productOperationReport.getKeyword1()+"\n");
		template.setKeyword1Color("#FF0000");
		template.setKeyword2(productOperationReport.getKeyword2()+"\n");
		template.setKeyword2Color("#000000");
		template.setKeyword3(productOperationReport.getKeyword3()+"\n");
		template.setKeyword3Color("#000000");
		template.setKeyword4(productOperationReport.getKeyword4()+"\n");
		template.setKeyword4Color("#000000");
		template.setKeyword5(productOperationReport.getKeyword5()+"\n");
		template.setKeyword5Color("#000000");
		template.setRemark(productOperationReport.getRemark()+"\n");
		template.setRemarkColor("#FF0000");
		
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
		template.setFirst("【" + typeName + "】" + ",最新资讯火热出炉！\n");
		template.setFirstColor("#FF0000");
		template.setKeyword1(goodsList.getGoodsName() + "\n");
		template.setKeyword1Color("#FF0000");
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日" + "\n");
		template.setKeyword2(sdf.format(d));
		template.setKeyword2Color("#000000");
		template.setRemark("今天看好什么呢？速度点击这里！！！" + "\n");
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

	/*
	 * 发送文章
	 */
	private void sendServiceArticle() {
		try {
			String url = "http://18f42658v7.iok.la/business/mp/serviceArticleHd?serviceArticleNum=" + serviceId;
			url = MessAgeUtil.webLicensingnSapi_userinfo(url);
			template.setResetUrl(url);
			ResultMsg resultMsg = null;
			num = errNum = 0;

			for (int i = 0; i < openIdList.size(); i++) {
				TemplateUser templateUser = getTemplateCtent(openIdList.get(i), type, template);
				System.out.println(templateUser);
				String result = MessAgeUtil.sendTemplate(AccessTokenManager.Access_Token, templateUser);
				System.out.println(result);

			}

		} catch (Exception ex) {

		}
	}
	/*
	 * 发送红点
	 */
	private void sendProductOperationReport() {
		try {													
			String url = "http://18f42658v7.iok.la/business/redDot/redCent?porId=" + productOperationReport.getPorId();
			System.out.println(url);
			url = MessAgeUtil.webLicensingnSapi_userinfo(url);
			template.setResetUrl(url);
			ResultMsg resultMsg = null;
			num = errNum = 0;

			for (int i = 0; i < openIdList.size(); i++) {
				TemplateUser templateUser = getTemplateCtent(openIdList.get(i), type, template);
				System.out.println(templateUser);
				String result = MessAgeUtil.sendTemplate(AccessTokenManager.Access_Token, templateUser);
				System.out.println(result);

			}

		} catch (Exception ex) {

		}
	}
}
