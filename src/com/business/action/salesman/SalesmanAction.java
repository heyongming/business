package com.business.action.salesman;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.sales.Salesman;
import com.business.service.ISalesmanService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SalesmanAction extends ActionSupport implements ModelDriven<Salesman> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5795968437621143486L;
	private Salesman salesman;
	@Resource
	private ISalesmanService salesmanService;
	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ISalesmanService getSalesmanService() {
		return salesmanService;
	}

	public void setSalesmanService(ISalesmanService salesmanService) {
		this.salesmanService = salesmanService;
	}

	public Salesman getSalesman() {
		return salesman;
	}

	public void setSalesman(Salesman salesman) {
		this.salesman = salesman;
	}

	@Override
	public Salesman getModel() {
		// TODO Auto-generated method stub
		salesman = new Salesman();
		return salesman;
	}

	public String login() {

		Salesman loginMan = salesmanService.queryLogin(salesman);
		if (loginMan != null) {
			ActionContext actionContext = ActionContext.getContext();
			Map<String, Object> session = actionContext.getSession();
			session.put("salesmanUser", loginMan);
			ResultMessage message = new ResultMessage("1", "ok", "login in");
			getJsonText(message);
			return this.SUCCESS;
		} else {
			ResultMessage message = new ResultMessage("-2", "false", "check your passWord and Account");
			getJsonText(message);
			return this.SUCCESS;
		}

	}

	public String addUser() {
		Salesman sesionman = getSesion();
		if (sesionman == null) {
			ResultMessage message = new ResultMessage("-1", "false", " not login");
			getJsonText(message);
			return super.SUCCESS;
		}
		int id = salesmanService.saveSalesman(salesman);
		ResultMessage message = new ResultMessage("1", "ture", id + "");
		getJsonText(message);
		return this.SUCCESS;
	}

	public String delUser() {
		Salesman sesionman = getSesion();
		if (sesionman == null) {
			ResultMessage message = new ResultMessage("-1", "false", " not login");
			getJsonText(message);
			return super.SUCCESS;
		}
		if (salesmanService.delSalesman(salesman.getUserId()) > 0) {
			ResultMessage message = new ResultMessage("1", "ture", "Delete successfully");
			getJsonText(message);
			return super.SUCCESS;
		} else {
			ResultMessage message = new ResultMessage("-2", "false", "Delete failed");
			getJsonText(message);
			return super.SUCCESS;
		}
	}

	public String selectByName() {
		Salesman sesionman = getSesion();
		if (sesionman == null) {
			ResultMessage message = new ResultMessage("-1", "false", " not login");
			getJsonText(message);
			return super.SUCCESS;
		}
		List<Salesman> list = salesmanService.querySalesmanByName(salesman.getUserName());
		getJsonText(list);

		return this.SUCCESS;
	}

	public String selectById() {
		Salesman sesionman = getSesion();
		if (sesionman == null) {
			ResultMessage message = new ResultMessage("-1", "false", " not login");
			getJsonText(message);
			return super.SUCCESS;
		}
		getJsonText(salesmanService.querySalesmanById(salesman.getUserId()));
		return this.SUCCESS;
	}

	public String selectAll() {
		Salesman sesionman = getSesion();
		if (sesionman == null) {
			ResultMessage message = new ResultMessage("-1", "false", " not login");
			getJsonText(message);
			return super.SUCCESS;
		}
		getJsonText(salesmanService.getAllSalesman());
		return this.SUCCESS;
	}

	private Salesman getSesion() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		Salesman salesman = (Salesman) session.get("salesmanUser");
		return salesman;
	}

	private void getJsonText(Object obj) {
		String jsonText = JSONObject.toJSONString(obj);
		try {
			jsonText = new String(jsonText.getBytes(), "UTF-8");
			System.out.println(jsonText);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			bis = new ByteArrayInputStream(jsonText.getBytes("GBK"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bis = null;
		}

	}
}
