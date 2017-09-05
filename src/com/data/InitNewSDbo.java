package com.data;

import java.util.ArrayList;
import java.util.List;

import com.business.entitys.mp.NewsItem;



public class InitNewSDbo {
	public static List<NewsItem> singleNewTextList() {
		List<NewsItem> list = new ArrayList<NewsItem>();
		NewsItem item = new NewsItem();
		item.setUrl("www.baidu.com");
		item.setDescription("别问我问题，有种你你点我试试？");
		item.setPicUrl("http://181433wt25.iok.la/wx/images/fist.jpg");
		item.setTitle("有问必答");
		list.add(item);
		return list;
	}
	public static List<NewsItem> complexNewTextList()
	{
		List<NewsItem> list = new ArrayList<NewsItem>();
		NewsItem item = new NewsItem();
		item.setUrl("www.baidu.com");
		item.setDescription("别问我问题，有种你你点我试试？");
		item.setPicUrl("http://181433wt25.iok.la/wx/images/fist.jpg");
		item.setTitle("有问必答");
		list.add(item);
		NewsItem item1 = new NewsItem();
		item1.setUrl("www.zhihu.com/");
		item1.setDescription("各种疑难杂症，有种你你点我试试？");
		item1.setPicUrl("http://181433wt25.iok.la/wx/images/two.jpg");
		item1.setTitle("有问必答");
		list.add(item1);
		return list;
	}
}
