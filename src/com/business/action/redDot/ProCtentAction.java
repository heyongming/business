package com.business.action.redDot;

import java.io.InputStream;
import java.util.Map;

import javax.annotation.Resource;

import com.business.entitys.redDot.ProductOperationReport;
import com.business.service.IRedDotService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProCtentAction extends ActionSupport implements ModelDriven<ProductOperationReport> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2875331397494970287L;
	@Resource
	private IRedDotService redDotService;
	private ProductOperationReport productOperationReport;

	public ProductOperationReport getProductOperationReport() {
		return productOperationReport;
	}

	public void setProductOperationReport(ProductOperationReport productOperationReport) {
		this.productOperationReport = productOperationReport;
	}

	private InputStream bis;

	public IRedDotService getRedDotService() {
		return redDotService;
	}

	public void setRedDotService(IRedDotService redDotService) {
		this.redDotService = redDotService;
	}

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	@Override
	public ProductOperationReport getModel() {
		// TODO Auto-generated method stub
		productOperationReport = new ProductOperationReport();
		return productOperationReport;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map request = (Map) ActionContext.getContext().get("request");

		ProductOperationReport result = redDotService.selectCtentById(productOperationReport.getPorId());
		if (result == null) {
			return this.INPUT;
		} else {
			request.put("msg", result);
			return this.SUCCESS;
		}
	}
}
