package com.business.action.salesman;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.sales.Salesman;
import com.business.entitys.sales.SalesmanSuccess;
import com.business.entitys.user.User;
import com.business.service.ISalesmanService;
import com.business.service.IUserService;
import com.business.util.PacthUtill;
import com.business.util.RandomUtill;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SalesmanSuccessAction extends ActionSupport implements ModelDriven<SalesmanSuccess> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8050230018498590429L;
	private SalesmanSuccess salesmanSuccess;
	@Resource
	private ISalesmanService salesmanService;

	@Resource
	private IUserService userService;
	private InputStream bis;
	// 文件相关描述
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String savePath;
	private String fictitiousPath;
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getFictitiousPath() {
		return fictitiousPath;
	}

	public void setFictitiousPath(String fictitiousPath) {
		this.fictitiousPath = fictitiousPath;
	}

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	public ISalesmanService getSalesmanService() {
		return salesmanService;
	}

	public void setSalesmanService(ISalesmanService salesmanService) {
		this.salesmanService = salesmanService;
	}

	public SalesmanSuccess getSalesmanSuccess() {
		return salesmanSuccess;
	}

	public void setSalesmanSuccess(SalesmanSuccess salesmanSuccess) {
		this.salesmanSuccess = salesmanSuccess;
	}

	@Override
	public SalesmanSuccess getModel() {
		// TODO Auto-generated method stub
		salesmanSuccess = new SalesmanSuccess();
		return salesmanSuccess;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		savePath=PacthUtill.getPacthVal("saveOrderSuccessSavePath");
		fictitiousPath=PacthUtill.getPacthVal("saveOrderSuccessSavePathFictitiousPath");
		ResultMessage resultMessage = null;
		User user = userService.selectByRdCode(salesmanSuccess.getCustomerPhoneRdCode());
		if (user == null) {
			resultMessage = new ResultMessage("-1", "false", "该推荐码不存在，请查证");
			getJsonText(resultMessage);
			return this.SUCCESS;
		}
		Salesman salesman=salesmanService.querySalesmanById(salesmanSuccess.getServiceSalesman());
		if(salesman==null)
		{
			resultMessage = new ResultMessage("-2", "false", "注意请填写的登录ID而不是姓名或者检查一下ID");
			getJsonText(resultMessage);
			return this.SUCCESS;
		}
		String random = RandomUtill.randomUtil();
		fictitiousPath = fictitiousPath  +salesmanSuccess.getOrderNumber() +random;
		savePath = savePath + salesmanSuccess.getOrderNumber() + random;
		String tempPath = "";
		while (!(createDir(savePath))) {

			random = RandomUtill.randomUtil();
			fictitiousPath = fictitiousPath + salesmanSuccess.getOrderNumber() + random;
			savePath = savePath + salesmanSuccess.getOrderNumber()+ random;

		}
		InputStream is = new FileInputStream(file);
		OutputStream os = new FileOutputStream(new File(savePath, fileFileName));
	

		byte[] buffer = new byte[500];
		while (-1 != (is.read(buffer, 0, buffer.length))) {

			os.write(buffer);
		}
		os.close();
		is.close();
		tempPath = tempPath + fictitiousPath + "/" + fileFileName;
		salesmanSuccess.setPayVoucher(tempPath);
		int i=salesmanService.saveSalesManSuccess(salesmanSuccess);
		if(i>0)
		{
			resultMessage = new ResultMessage("1", "true", "添加成功");
			getJsonText(resultMessage);
			return this.SUCCESS;
		}
		else
		{
			resultMessage = new ResultMessage("-4", "false", "添加失败");
			getJsonText(resultMessage);
			return this.SUCCESS;
		}
		
	}

	private void getJsonText(Object obj) {
		String jsonText = JSONObject.toJSONString(obj);
		try {
			jsonText = new String(jsonText.getBytes(), "UTF-8");
			System.out.println(jsonText);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
		}
		try {
			bis = new ByteArrayInputStream(jsonText.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			try {
				bis = new ByteArrayInputStream("[]".getBytes("utf-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	public String getSalesManSuccessById()
	{
		SalesmanSuccess salesman=salesmanService.getSalesmanById(salesmanSuccess.getSuccessId());
		getJsonText(salesman);
		return this.SUCCESS;
	}
	public String getSalesManSuccessList()
	{
		List<SalesmanSuccess> list=salesmanService.getSalesmanSuccessFullData();
		getJsonText(list);
		return this.SUCCESS;
	}
	private boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {// 判断目录是否存在
			System.out.println("创建目录失败，目标目录已存在！");
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {// 结尾是否以"/"结束
			destDirName = destDirName + File.separator;
		}
		if (dir.mkdirs()) {// 创建目标目录
			System.out.println("创建目录成功！" + destDirName);
			return true;
		} else {
			System.out.println("创建目录失败！");
			return false;
		}

	}
}
