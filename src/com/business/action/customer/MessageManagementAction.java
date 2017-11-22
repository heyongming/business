package com.business.action.customer;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.autoReply.AutoReply;
import com.business.entitys.autoReply.MessageManagement;
import com.business.entitys.user.User;
import com.business.service.ICustomerService;
import com.business.util.RandomUtill;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MessageManagementAction extends ActionSupport implements ModelDriven<MessageManagement> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5153326258682581235L;

	// 文件相关描述
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String savePath;
	private String fictitiousPath;

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

	public MessageManagement getMessageManagement() {
		return messageManagement;
	}

	public void setMessageManagement(MessageManagement messageManagement) {
		this.messageManagement = messageManagement;
	}

	private MessageManagement messageManagement;
	@Resource
	private ICustomerService customerService;

	public ICustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	private InputStream bis;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) session.get("loginUser");

		String ip = getIpAddr(request);
		System.out.println(ip);
		messageManagement.setIp(ip);
		if (user != null) {
			messageManagement.setUserId(user.getUserId());
		}
		if (file != null) {
			String random = RandomUtill.randomUtil();
			fictitiousPath = fictitiousPath + messageManagement.getMessageContent() + random;
			savePath = savePath + messageManagement.getMessageContent() + random;
			String tempPath = "";
			while (!(createDir(savePath))) {

				random = RandomUtill.randomUtil();
				fictitiousPath = fictitiousPath + messageManagement.getMessageContent() + random;
				savePath = savePath + messageManagement.getMessageContent() + random;
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
			messageManagement.setMessageImage(tempPath);
		}
		int flog = customerService.saveMessageManagement(messageManagement);
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "插入成功");
		} else {
			resultMessage = new ResultMessage("-1", "false", "插入失败");
		}
		toJsonSteam(JSONObject.toJSONString(resultMessage));
		return this.SUCCESS;
	}

	public String findAutoReplyByTypeName() {

		List<MessageManagement> list = customerService
				.findMessageManagementByTypeData(messageManagement.getMessageType());

		if (list == null) {
			toJsonSteam("[]");
		} else {
			toJsonSteam(JSONObject.toJSONString(list));
		}
		return this.SUCCESS;
	}

	public String getFullAutoData() {
		List<MessageManagement> list = customerService.findMessageManagementFullDate();
		toJsonSteam(JSONObject.toJSONString(list));
		return this.SUCCESS;
	}

	public String getFullMsgDataById() {
		MessageManagement messageManage = customerService.findMessageManagementById(messageManagement.getMmId());
		if (messageManage == null) {
			toJsonSteam("{}");
		} else {
			toJsonSteam(JSONObject.toJSONString(messageManage));
		}

		return this.SUCCESS;
	}

	public String update() {
		/*
		 * int flog = customerService.updateAutoReply(autoReply); ResultMessage
		 * resultMessage = null; if (flog > 0) { resultMessage = new
		 * ResultMessage("1", "true", "修改成功"); } else { resultMessage = new
		 * ResultMessage("-1", "false", "修改失败"); }
		 * toJsonSteam(JSONObject.toJSONString(resultMessage));
		 */
		return this.SUCCESS;
	}

	public String delete() {
		/*
		 * int flog = customerService.delAutoReply(autoReply); ResultMessage
		 * resultMessage = null; if (flog > 0) { resultMessage = new
		 * ResultMessage("1", "true", "删除成功"); } else { resultMessage = new
		 * ResultMessage("-1", "false", "删除失败"); }
		 * toJsonSteam(JSONObject.toJSONString(resultMessage));
		 */
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

	// 拿到用户的真实IP地址
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		// System.out.println(ip);
		int indexOf = ip.indexOf(",");
		if (indexOf > 0) {
			return ip.substring(0, indexOf);
		}
		return ip;

	}

	@Override
	public MessageManagement getModel() {
		// TODO Auto-generated method stub
		messageManagement = new MessageManagement();
		return messageManagement;
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
