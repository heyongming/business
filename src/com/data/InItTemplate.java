package com.data;

import com.business.entitys.mp.template.DataRemark;
import com.business.entitys.mp.template.TemplateCtent;
import com.business.entitys.mp.template.TemplateUser;

public class InItTemplate {
	public static TemplateUser getTemplateCtent(String openid,String template_id)
	{
		return null;
		/*
		TemplateUser ctent=new TemplateUser();
		ctent.setTouser(openid);
		ctent.setTemplate_id(template_id);
		ctent.setUrl("https://www.baidu.com/");
		TemplateCtent templateCtent=new TemplateCtent();
		templateCtent.setFirst(new DataRemark("您好这是测试消息", "#173177"));
		templateCtent.setStockName(new DataRemark("衡东株式", "#173177"));
		templateCtent.setRemark(new DataRemark("请持续关注", "#173177"));
		templateCtent.setPrice(new DataRemark("10", "173177"));
		templateCtent.setThresholdPrice(new DataRemark("10", "#173177"));
		ctent.setData(templateCtent);
		return ctent;
		*/
	}
}
