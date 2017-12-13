package com.business.action.redDot;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.redDot.ProductOperationReport;
import com.business.service.IRedDotService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductOperationReportAction extends ActionSupport implements ModelDriven<ProductOperationReport> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8665908232749756387L;
	@Resource
	private IRedDotService redDotService;
	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	public IRedDotService getRedDotService() {
		return redDotService;
	}

	public void setRedDotService(IRedDotService redDotService) {
		this.redDotService = redDotService;
	}

	public ProductOperationReport getProductOperationReport() {
		return productOperationReport;
	}

	public void setProductOperationReport(ProductOperationReport productOperationReport) {
		this.productOperationReport = productOperationReport;
	}

	private ProductOperationReport productOperationReport;

	@Override
	public ProductOperationReport getModel() {
		// TODO Auto-generated method stub
		productOperationReport = new ProductOperationReport();
		return productOperationReport;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		productOperationReport.setTemplateID("RudKnIk9wAa3Gnva6AY1-7kgKz9wGjtnZ0AZsTai8RM");
		int flog = redDotService.insertRemindingPrice(productOperationReport);
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "发送成功");
		} else {
			resultMessage = new ResultMessage("-1", "false", "发送失败");
		}
		String result = JSONObject.toJSONString(resultMessage);
		toJsonSteam(result);
		return this.SUCCESS;
	}

	public String update() {
		int flog = redDotService.updateRemindingPrice(productOperationReport);
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "修改成功");
		} else {
			resultMessage = new ResultMessage("-1", "false", "修改失败");
		}
		String result = JSONObject.toJSONString(resultMessage);
		toJsonSteam(result);
		return this.SUCCESS;
	}
	public String getAllData()
	{
		List<ProductOperationReport> list=redDotService.selectAllDate("RudKnIk9wAa3Gnva6AY1-7kgKz9wGjtnZ0AZsTai8RM");
		String json=JSONObject.toJSONString(list);
		toJsonSteam(json);
		return this.SUCCESS;
	}
	public String getDataById()
	{
		ProductOperationReport por=redDotService.selectDataById("RudKnIk9wAa3Gnva6AY1-7kgKz9wGjtnZ0AZsTai8RM",productOperationReport.getPorId());
		String json=JSONObject.toJSONString(por);
		toJsonSteam(json);
		return this.SUCCESS;
	}
	private void toJsonSteam(String text) {
		try {
			bis = new ByteArrayInputStream(text.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			bis = null;
			e.printStackTrace();
		}
	}
}
