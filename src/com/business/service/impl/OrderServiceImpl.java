package com.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.business.dao.IGoodsListDao;
import com.business.dao.IOrderDao;
import com.business.dao.IServiceTimeDao;
import com.business.entitys.ResultMessage;
import com.business.entitys.goods.GoodsList;
import com.business.entitys.goods.GoodsListUpgrade;
import com.business.entitys.order.OrderActivationCode;
import com.business.entitys.order.OrderForm;
import com.business.entitys.service.ServiceTime;
import com.business.entitys.user.User;
import com.business.service.IOrderService;
import com.business.temp.ResultOrderActivationCodeEntitys;
import com.business.util.RandomUtill;
import com.business.util.SnowflakeIdWorker;

@Repository("orderService")
public class OrderServiceImpl implements IOrderService {
	@Resource
	private IOrderDao orderDao;
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

	// 生成账单号
	@Resource
	private SnowflakeIdWorker snowflakeIdWorker;

	public SnowflakeIdWorker getSnowflakeIdWorker() {
		return snowflakeIdWorker;
	}

	public void setSnowflakeIdWorker(SnowflakeIdWorker snowflakeIdWorker) {
		this.snowflakeIdWorker = snowflakeIdWorker;
	}

	public IOrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public String addOrder(OrderForm orderForm) {
		// TODO Auto-generated method stub
		long id = snowflakeIdWorker.nextId();
		orderForm.setOrderSerialNumber(id + "");
		// orderForm.setOrderStatus(1);
		System.out.println(orderForm);
		int flog = orderDao.insertOrder(orderForm);
		String result = null;
		ResultMessage message = null;
		if (flog > 0) {

			message = new ResultMessage("1", "true", "insert Success");
		} else {

			message = new ResultMessage("-1", "false", "insert fail");
		}
		result = JSONObject.toJSONString(message);
		return result;
	}

	/*
	 * @Override public String saveOrderStatus(String phone) { // TODO
	 * Auto-generated method stub OrderForm orderForm =
	 * orderDao.selectByphone(phone); System.out.println(orderForm);
	 * orderForm.setOrderStatus(orderForm.getOrderStatus() + 1); int flog =
	 * orderDao.updateOrder(orderForm); String result = null; ResultMessage
	 * message = null; if (flog > 0) { message = new ResultMessage("1", "true",
	 * "update Success");
	 * 
	 * } else { message = new ResultMessage("-1", "false", "update fail"); }
	 * result = JSONObject.toJSONString(message); return result; }
	 */
	@Override
	public boolean findIsbuy(String phone) {
		// TODO Auto-generated method stub
		OrderForm orderForm = orderDao.selectByphone(phone);
		if (orderForm == null) {
			return false;
		}
		return true;
	}

	@Override
	public String saveOrderActivationCode(String phone) {
		// TODO Auto-generated method stub
		OrderForm orderForm = orderDao.selectByphone(phone);
		orderForm.setOrderStatus(1);
		orderDao.updateOrder(orderForm);
		OrderActivationCode orderActivationCode = new OrderActivationCode();
		orderActivationCode.setOrderSerialNumber(orderForm.getOrderSerialNumber());
		String activationCode = RandomUtill.randomUtil();
		int checkFlog = orderDao.checkActivationCode(activationCode);
		while (checkFlog != 0) {
			activationCode = RandomUtill.randomUtil();
			checkFlog = orderDao.checkActivationCode(activationCode);
		}

		orderActivationCode.setActivationCode(activationCode);
		orderActivationCode.setIsActivation("false");
		int flog = orderDao.addOrderActivationCode(orderActivationCode);
		String result = null;

		ResultOrderActivationCodeEntitys message = null;
		if (flog > 0) {
			GoodsList goodsList = goodsListDao.queryByGoodsId(orderForm.getGoodsId());
			message = new ResultOrderActivationCodeEntitys(orderForm.getOrderSerialNumber(), goodsList.getGoodsName(),
					activationCode);
			message.setSuccess("true");
			message.setErrMsg("insert success");
			message.setCode("1");
		} else {
			message = new ResultOrderActivationCodeEntitys();
			message.setSuccess("false");
			message.setErrMsg("insert fail");
			message.setCode("-1");
		}
		result = JSONObject.toJSONString(message);
		return result;
	}

	@Override
	public String findData() {
		// TODO Auto-generated method stub
		List<OrderForm> list = orderDao.getAllData();
		if (list == null || list.size() == 0) {
			return "";
		}
		return JSONObject.toJSONString(list);
	}

	@Override
	public String findDataBywhere(OrderForm orderForm) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		if (orderForm.getOrderSerialNumber() != null) {
			map.put("orderSerialNumber", orderForm.getOrderSerialNumber());
		} else if (orderForm.getPurchaseTime() != null) {
			map.put("purchaseTime", orderForm.getPurchaseTime());
		} else if (orderForm.getUser().getUserName() != null) {
			map.put("userName", orderForm.getUser().getUserName());
		}
		List<OrderForm> list = orderDao.getDataByWhere(map);
		if (list == null || list.size() == 0) {
			return "";
		}
		return JSONObject.toJSONString(list);

	}

	@Override
	public String CheckGoodListAndOrderFrom(GoodsList goodsList, OrderForm orderForm, User user) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serviceUserId", user.getUserId());
		List<ServiceTime> list = serviceTimeDao.selectByWhere(map); // 拿到该用户已有的产品

		if (list.size() > 0) // 检测是否到了购买上限
		{
			for (ServiceTime serviceTime : list) {
				if (serviceTime.getGoodsId() == goodsList.getGoodsId()) {

					int serviceDay = serviceTime.getServiceDay();

					int serviceDayshang = serviceDay / 30;
					int serviceDayys = serviceDay % 30;
					if (serviceDayys != 0)
						serviceDayshang = serviceDayshang + 1;
					int buyNum = Integer.parseInt(orderForm.getPaymentNumber()) + serviceDayshang;
					if (buyNum >= goodsList.getMaxMon()) {
						ResultMessage resultMessage = new ResultMessage("-4", "false",
								"此商品最高只可以购买" + goodsList.getMaxMon() + "份");
						String msg = JSONObject.toJSONString(resultMessage);
						return msg;
					}
					if (goodsList.getMinMon() != 0) {
						if (buyNum <= goodsList.getMinMon()) {
							ResultMessage resultMessage = new ResultMessage("-4", "false",
									"此商品最少" + goodsList.getMinMon() + "份起卖");
							String msg = JSONObject.toJSONString(resultMessage);
							return msg;
						}
					}
				}
			}
		}
		ResultMessage resultMessage = new ResultMessage("1", "true", "ok");
		String msg = JSONObject.toJSONString(resultMessage);
		return msg;
		// 以上代码是检测是否满足产品要求

	}
	//遗弃该接口 以后可能会用到！
	@Override
	public Map<String, Object> UpgradeGoodListAndchekOrder(GoodsList goodsList, OrderForm orderForm, User user) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serviceUserId", user.getUserId());
		List<ServiceTime> list = serviceTimeDao.selectByWhere(map); // 拿到该用户已有的产品
		GoodsList upgradeGoodslist = null;
		OrderForm buyOrder = null;
		if (list.size() > 0) {
			for (ServiceTime serviceTime : list) {

				map.put("goodsId", serviceTime.getGoodsId());
				map.put("UpgradeGoodsId", goodsList.getGoodsId());
				List<GoodsListUpgrade> upgrade = goodsListDao.selectUpgradeByWhere(map);
				if (upgrade.size() > 0) {
					int upgradeId = upgrade.get(0).getUpgradeGoodsId();
					upgradeGoodslist = goodsListDao.queryByGoodsId(upgradeId);
				}
			}
		}
		if (upgradeGoodslist != null) {

			buyOrder = new OrderForm();
			buyOrder.setUserId(user.getUserId());
			buyOrder.setPaymentNumber(orderForm.getPaymentNumber());
			int actualPurch = CalculationActualPurchasePriceGoods(goodsList, orderForm, user);
			buyOrder.setActualPurchasePriceGoods(actualPurch + "");
			buyOrder.setGoodsId(goodsList.getGoodsId());
			Map<String, Object> tempmap = new HashMap<String, Object>();
			tempmap.put("buyOrder", buyOrder);
			tempmap.put("upGoodsList", CustomaryGoodslist);

			return tempmap;
		} else {
			buyOrder = new OrderForm();
			buyOrder.setUserId(user.getUserId());
			buyOrder.setPaymentNumber(orderForm.getPaymentNumber());
			int actualPurchasePriceGoods = 0;
			if (goodsList.getIsBlend() == 0) {
				actualPurchasePriceGoods = (goodsList.getGoodsPrice())
						* (Integer.parseInt(orderForm.getPaymentNumber()));

			} else {
				actualPurchasePriceGoods = (goodsList.getGoodsPrice())
						* (Integer.parseInt(orderForm.getPaymentNumber())) + 999;
			}
			buyOrder.setActualPurchasePriceGoods(actualPurchasePriceGoods + "");
			buyOrder.setGoodsId(goodsList.getGoodsId());
			Map<String, Object> tempmap = new HashMap<String, Object>();
			tempmap.put("buyOrder", buyOrder);
			return tempmap;
		}

	}

	private GoodsList CustomaryGoodslist = null;// 拥有的的产品对应升级前的实体
	//遗弃该接口 以后可能会用到！
	private int CalculationActualPurchasePriceGoods(GoodsList goodsList, OrderForm orderForm, User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serviceUserId", user.getUserId());
		List<ServiceTime> list = serviceTimeDao.selectByWhere(map); // 拿到该用户已有的产品

		CustomaryGoodslist = null; // 初始化值
		int buyNum = Integer.parseInt(orderForm.getPaymentNumber());// 购买的份数
		if (list.size() > 0) // 检测是否到了购买上限
		{
			for (ServiceTime serviceTime : list) {
				map.put("goodsId", serviceTime.getGoodsId());
				map.put("UpgradeGoodsId", goodsList.getGoodsId());
				List<GoodsListUpgrade> upgrade = goodsListDao.selectUpgradeByWhere(map);
				if (upgrade.size() > 0) {
					System.out.println("这是升级后的产品" + upgrade.get(0));
					int upgradeId = upgrade.get(0).getGoodsId();
					CustomaryGoodslist = goodsListDao.queryByGoodsId(upgradeId);
					int serviceDay = serviceTime.getServiceDay();
					int serviceDayys = serviceDay / 30;
					if (serviceDayys != 0) {
						int allGoodsPrice = serviceDayys * CustomaryGoodslist.getGoodsPrice();
						System.out.println("单价是" + allGoodsPrice + "总价是" + (buyNum * goodsList.getGoodsPrice()));
						allGoodsPrice = (buyNum * goodsList.getGoodsPrice()) - allGoodsPrice;

						int serviceDayOp = serviceDay % 30;
						System.out.println(serviceDayOp + "sddf");
						if (serviceDayOp >= 15) {
							if (goodsList.getIsBlend() == 1) {
								/*
								 * if(serviceDayys)
								 */
								if (buyNum < serviceDayys + 1) {
									return ((serviceDayys + 1) - buyNum) * goodsList.getGoodsPrice() + 999;
								}
								return allGoodsPrice + 999;
							} else {

								allGoodsPrice = allGoodsPrice - 2000;
								return allGoodsPrice;
							}
						} else {
							if (goodsList.getIsBlend() == 1) {
								if (buyNum < serviceDayys + 1) {
									return ((serviceDayys + 1) - buyNum) * goodsList.getGoodsPrice() + 999;
								}
								return allGoodsPrice + 999;
							} else {

								int monneySur = CustomaryGoodslist.getGoodsPrice() / 30;// 单价
								System.out.println("单价是" + monneySur + "总价是" + allGoodsPrice);
								allGoodsPrice = allGoodsPrice - (monneySur * serviceDayOp);
								return allGoodsPrice;
							}

						}
					} else {
						if (serviceDay >= 15) {
							if (goodsList.getIsBlend() == 1) {
								if (buyNum - 1 > 0) {
									return goodsList.getGoodsPrice() * (buyNum - 1) + 999 + 999;
								}
								return 999;
							} else {
								return 2000;
							}
						} else {
							if (goodsList.getIsBlend() == 1) {
								if (buyNum - 1 > 0) {
									return goodsList.getGoodsPrice() * (buyNum - 1) + 999 + 999;
								}
								return 999;
							} else {
								if (buyNum - 1 > 0) {
									return goodsList.getGoodsPrice() * (buyNum - 1) + 2000;
								}

								int surplusNum = 30 - serviceDay; // 剩余的天数
								int monneySur = CustomaryGoodslist.getGoodsPrice() / 30;// 单价
								int money = goodsList.getGoodsPrice() - (monneySur * surplusNum);
								if (buyNum - 1 > 0) {
									money = goodsList.getGoodsPrice() * (buyNum - 1) + money;
								}
								return money;
							}

						}
					}

				}

			}

		}
		return 0;
	}

	@Override
	public Map<String, Object> saveBuyoeder(GoodsList buyGoodsList, OrderForm buyorderForm, User userEntitys,
			GoodsList upGoodsList) {
		// TODO Auto-generated method stub
		try {
			if (upGoodsList != null) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("serviceUserId", userEntitys.getUserId());
				map.put("serviceGoodsId", upGoodsList.getGoodsId());
				List<ServiceTime> list = serviceTimeDao.selectByWhere(map);
				list.get(0).setServiceDay(0);
				serviceTimeDao.update(list.get(0));

			}
			int buyNum = Integer.parseInt(buyorderForm.getPaymentNumber()) * 30 * buyGoodsList.getEffectiveTime();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("serviceUserId", userEntitys.getUserId());
			map.put("serviceGoodsId", buyGoodsList.getGoodsId());
			List<ServiceTime> list = serviceTimeDao.selectByWhere(map);
			if (list.size() > 0) {
				ServiceTime serviceTime = list.get(0);
				serviceTime.setServiceDay(buyNum + serviceTime.getServiceDay());
				serviceTimeDao.update(serviceTime);
			} else {
				serviceTimeDao.insert(new ServiceTime(0, buyNum, buyGoodsList.getGoodsId(), null,
						userEntitys.getUserId(), -1, null, null, null, null));
			}
			// 以上为生成服务表
			OrderForm orderForm = buyorderForm;
			orderForm.setOrderStatus(2); // 生成状态值
			long id = snowflakeIdWorker.nextId(); // 生成订单号
			orderForm.setOrderSerialNumber(id + "");
			orderForm.setGoodsId(buyGoodsList.getGoodsId());
			orderForm.setUserId(userEntitys.getUserId());

			OrderActivationCode orderActivationCode = new OrderActivationCode();
			orderActivationCode.setOrderSerialNumber(orderForm.getOrderSerialNumber());

			String activationCode = RandomUtill.randomUtil();
			int checkFlog = orderDao.checkActivationCode(activationCode);
			while (checkFlog != 0) {
				activationCode = RandomUtill.randomUtil();
				checkFlog = orderDao.checkActivationCode(activationCode);
			}

			orderForm.setRdCode(userEntitys.getRdCode());
			orderActivationCode.setActivationCode(activationCode);
			orderActivationCode.setIsActivation("false");
			int flog = orderDao.addOrderActivationCode(orderActivationCode);
			int flog1 = orderDao.insertOrder(orderForm);
			buyGoodsList.setSalesVolume(buyGoodsList.getSalesVolume() + (buyNum / 30));
			buyGoodsList.setInventory(buyGoodsList.getInventory() - (buyNum / 30));

			goodsListDao.updateGoods(buyGoodsList);
			String result = null;
			ResultOrderActivationCodeEntitys message = null;
			if (flog > 0 && flog1 > 0) {
				GoodsList goodsList = goodsListDao.queryByGoodsId(orderForm.getGoodsId());
				message = new ResultOrderActivationCodeEntitys(orderForm.getOrderSerialNumber(),
						goodsList.getGoodsName(), activationCode);
				map = new HashMap<String, Object>();
				map.put("msg", message);
				map.put("buyOrder", orderForm);
				return map;
			} else {
				return null;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Map<String, Object> generateOrder(GoodsList goodsList, OrderForm orderForm, User user) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serviceUserId", user.getUserId());
		List<ServiceTime> list = serviceTimeDao.selectByWhere(map); // 拿到该用户已有的产品

		OrderForm buyOrder = null;

		buyOrder = new OrderForm();
		buyOrder.setUserId(user.getUserId());
		buyOrder.setPaymentNumber(orderForm.getPaymentNumber());
		int actualPurchasePriceGoods = 0;
		if (goodsList.getIsBlend() == 0) {
			actualPurchasePriceGoods = (goodsList.getGoodsPrice()) * (Integer.parseInt(orderForm.getPaymentNumber()));

		} else {
			actualPurchasePriceGoods = (goodsList.getGoodsPrice()) * (Integer.parseInt(orderForm.getPaymentNumber()))
					+ 999;
		}
		buyOrder.setActualPurchasePriceGoods(actualPurchasePriceGoods + "");
		buyOrder.setGoodsId(goodsList.getGoodsId());
		Map<String, Object> tempmap = new HashMap<String, Object>();
		tempmap.put("buyOrder", buyOrder);
		return tempmap;

	}

	@Override
	public OrderActivationCode doClosingTheDeal(OrderForm orderForm) {
		// TODO Auto-generated method stub
		orderForm.setOrderStatus(-1);
		orderDao.updateOrder(orderForm);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("checkOrderSerialNumber", orderForm.getOrderSerialNumber());
		List<OrderActivationCode> list = orderDao.selectActivationCodeBywhere(map);
		if (list.size() > 0) {
			OrderActivationCode activationCode = list.get(0);

			return activationCode;
		}
		return null;
	}

	@Override
	public String saveOrderFromrOderStatus(OrderForm form, int orderStatus) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderSerialNumber", form.getOrderSerialNumber());
		ResultMessage message = null;
		List<OrderForm> list = orderDao.getDataByWhere(map);
		
		if (list.size() == 0) {
			message = new ResultMessage("-2", "false", "user not find");
			return JSONObject.toJSONString(message);

		}

		form.setOrderStatus(orderStatus);
		int flog = orderDao.updateOrder(form);
		String result = null;

		if (flog > 0) {
			message = new ResultMessage("1", "true", "update Success");

		} else {
			message = new ResultMessage("-1", "false", "update fail");
		}
		result = JSONObject.toJSONString(message);
		return result;
	}

	@Override
	public OrderForm findOffLinePayUser(User user) {
		// TODO Auto-generated method stub
		Map<String, Object> orderForm = new HashMap<String, Object>();
		orderForm.put("offLinePay", "检查是否在线下支付");
		orderForm.put("offLineUserId", user.getUserId());
		List<OrderForm> list = orderDao.getDataByWhere(orderForm);
		if (list != null) {
			if (list.size() > 0) {
				return list.get(0);
			}
		}
		return null;
	}

	@Override
	public OrderActivationCode findActivaTionCode(String orderNo) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("checkOrderSerialNumber", orderNo);
		List<OrderActivationCode> list = orderDao.selectActivationCodeBywhere(map);
		if (list != null) {
			if (list.size() > 0) {
				return list.get(0);
			}
		}
		return null;
	}

	@Override
	public List<OrderForm> findOffLinePayAll() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("offLinePayList", "拿取线下支付的所以数据");
		List<OrderForm> list = orderDao.getDataByWhere(map);
		if (list != null) {
			if (list.size() > 0) {
				return list;
			}
		}
		return null;
	}
}