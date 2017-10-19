package com.cache;

import java.util.HashMap;
import java.util.Map;

import com.business.entitys.goods.GoodsList;
import com.business.entitys.order.OrderForm;
import com.business.entitys.user.User;
import com.business.temp.ResultOrderActivationCodeEntitys;

public class OrderCache {
	public static Map<String, GoodsList> goodsListMap = new HashMap<String, GoodsList>();
	public static Map<String, OrderForm> orderFromMap = new HashMap<String, OrderForm>();
	public static Map<String, User> buyuser = new HashMap<String, User>();
	public static Map<String, GoodsList> upGoodsList = new HashMap<String, GoodsList>();
	public static Map<String, ResultOrderActivationCodeEntitys> msg = new HashMap<String, ResultOrderActivationCodeEntitys>();
	public static Map<String, OrderForm> buyOrderResult = new HashMap<String, OrderForm>();
	
	
}
