package com.business.util.mp;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.mp.btn.Button;
import com.business.entitys.mp.btn.ClickButton;
import com.business.entitys.mp.btn.Menu;
import com.business.entitys.mp.btn.ViewButton;
import com.business.util.HttpClientUtil;

public class WeiXinUtil {
	// 初始化菜单
	public static String initMenu() {
		String result = null;
		Menu menu = new Menu();
		ViewButton vb_1 = new ViewButton();
		vb_1.setName("商城");
		vb_1.setType("view");
		String tempUrl = "http://m.mbimc.com/business/mp/index";
		tempUrl = MessAgeUtil.webLicensingnSapi_userinfo(tempUrl);
		vb_1.setUrl(tempUrl);
		ClickButton ck_1 = new ClickButton();
		ck_1.setName("我的");
		ck_1.setKey("100");
		ck_1.setType("click");
		ViewButton vk_1_1 = new ViewButton();
		vk_1_1.setName("我的服务");
		vk_1_1.setType("view");
		String url = MessAgeUtil.webLicensingnSapi_userinfo("http://m.mbimc.com/business/mp/service");
		vk_1_1.setUrl(url);
		ViewButton vk_1_2 = new ViewButton();
		vk_1_2.setName("产品激活");
		vk_1_2.setType("view");
		url = MessAgeUtil.webLicensingnSapi_userinfo("http://m.mbimc.com/business/mp/code");
		vk_1_2.setUrl(url);
		ViewButton vk_1_3 = new ViewButton();
		vk_1_3.setName("联系我们");
		vk_1_3.setType("view");
		url = MessAgeUtil.webLicensingnSapi_userinfo("http://m.mbimc.com/business/index/kefu/kefu.jsp");
		vk_1_3.setUrl(url);
		ck_1.setSub_button(new Button[] { vk_1_1, vk_1_2,vk_1_3 });
		/*
		 * ClickButton ck1_1 = new ClickButton(); ClickButton ck2_1 = new
		 * ClickButton(); ViewButton vb_3 = new ViewButton();
		 * 
		 * ck1_1.setType("click"); ck1_1.setName("资本剑客"); ck1_1.setKey("120");
		 * ck2_1.setType("click"); ck2_1.setName("人员介绍"); ck2_1.setKey("220");
		 * 
		 * vb_3.setName("疑难杂症"); vb_3.setType("view");
		 * vb_3.setUrl("http://www.baidu.com");
		 * 
		 * ClickButton ck1_2 = new ClickButton(); ck1_2.setName("公司介绍");
		 * ck1_2.setType("click"); ck1_2.setKey("120"); ClickButton ck1_3 = new
		 * ClickButton(); ck1_3.setName("人员介绍"); ck1_3.setType("click");
		 * ck1_3.setKey("130"); ViewButton vk1_4 = new ViewButton();
		 * vk1_4.setName("公司HP"); vk1_4.setType("view");
		 * vk1_4.setUrl("http://www.txcf888.com"); ck1_1.setSub_button(new
		 * Button[] { ck1_2, ck1_3, vk1_4 }); //
		 * <------------------------------------------> ClickButton ck2_2 = new
		 * ClickButton(); ck2_2.setName("相关人员介绍"); ck2_2.setType("click");
		 * ck2_2.setKey("220"); ClickButton ck2_3 = new ClickButton();
		 * ck2_3.setName("技术人员介绍"); ck2_3.setType("click"); ck2_3.setKey("230");
		 * ViewButton vk2_4 = new ViewButton(); vk2_4.setName("相关链接");
		 * vk2_4.setType("view"); vk2_4.setUrl("http://www.txcf888.com");
		 * ck2_1.setSub_button(new Button[] { ck2_2, ck2_3, vk2_4 });
		 */
		menu.setButton(new Button[] { vb_1, ck_1 });
		result = JSONObject.toJSONString(menu);
		System.out.println(result);
		return result;
	}

	public static String sendMenu(String access_token, String data) {
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

		url = url.replace("ACCESS_TOKEN", access_token);
		return HttpClientUtil.httpPost(url, data);
	}
}
