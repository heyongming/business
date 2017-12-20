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
import com.business.util.PacthUtill;
import com.business.util.RandomUtill;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 留言板的Action
 * 
 * @ActionSupport 为struts2的提供的上下文的一个类
 * @ModelDriven 该方法返回一个用于接收用户输入数据的模型对象。
 */
public class MessageManagementAction extends ActionSupport implements ModelDriven<MessageManagement> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5153326258682581235L;

	// 上传的文件
	private File file;
	// 上传的文件 的文件名
	private String fileFileName;
	// 上传文件的类型
	private String fileContentType;
	// 保存本地的路径 在项目的路径下面的/configs/pacth.properties里面配置
	private String savePath;
	// web访问的路径 在项目的路径下面的/configs/pacth.properties里面配置
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

	// 留言板对应的实体类
	private MessageManagement messageManagement;
	/*
	 * 注入对应的Service层
	 */
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

	/*
	 * AJAX处理完毕返回的流
	 */
	private InputStream bis;

	/*
	 * 默认的处理的方法 执行添加操作 入口与struts_Customer.xml配置文件对应
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public MessageManagement getModel() {
		// TODO Auto-generated method stub
		messageManagement = new MessageManagement();
		return messageManagement;
	}

	/*
	 * 默认的处理的方法 执行添加操作 入口与struts_Customer.xml配置文件对应
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// 从配置文件获得用户上传文件的根保存路径
		savePath = PacthUtill.getPacthVal("MessageManagementPath");
		// 从配置中获得web根访问路径
		fictitiousPath = PacthUtill.getPacthVal("MessageManagementFictitiousPath");
		// 获得struts2的上下文
		ActionContext actionContext = ActionContext.getContext();
		// 获得session
		Map session = actionContext.getSession();
		// 获得request
		HttpServletRequest request = ServletActionContext.getRequest();
		// 从session中拿取用户
		User user = (User) session.get("loginUser");
		// 拿取用户的IP
		String ip = getIpAddr(request);

		messageManagement.setIp(ip);
		if (user != null) {
			// 把登录后的用户做记录
			messageManagement.setUserId(user.getUserId());
		}
		if (file != null) {
			// 生成随机数
			String random = RandomUtill.randomUtil();
			// 生成web访问的全路径
			fictitiousPath = fictitiousPath + messageManagement.getMessageContent() + random;
			// 生成文件夹保存的全路径
			savePath = savePath + messageManagement.getMessageContent() + random;
			String tempPath = "";
			// 判断文件夹是否存在
			while (!(createDir(savePath))) {
				// 存在则继续生成，直到生成为止
				random = RandomUtill.randomUtil();
				fictitiousPath = fictitiousPath + messageManagement.getMessageContent() + random;
				savePath = savePath + messageManagement.getMessageContent() + random;
			}
			// 输入流
			InputStream is = new FileInputStream(file);
			// 输出流
			OutputStream os = new FileOutputStream(new File(savePath, fileFileName));
			byte[] buffer = new byte[500];
			// 保存文件
			while (-1 != (is.read(buffer, 0, buffer.length))) {

				os.write(buffer);
			}
			os.close();
			is.close();
			// 生成web访问的全路径
			tempPath = tempPath + fictitiousPath + "/" + fileFileName;
			// 保存全路径
			messageManagement.setMessageImage(tempPath);
		}
		// 调用Servicec层代码
		int flog = customerService.saveMessageManagement(messageManagement);
		ResultMessage resultMessage = null;
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "插入成功");
		} else {
			resultMessage = new ResultMessage("-1", "false", "插入失败");
		}
		// 把对应的JAVA实体类 转换成json格式最后转成流传给前端
		toJsonSteam(JSONObject.toJSONString(resultMessage));
		// 执行完毕
		return this.SUCCESS;
	}

	/*
	 * 执行查找的操作 获得MessageManagement类的相应类型数据 入口与struts_Customer.xml配置文件对应
	 */
	public String findAutoReplyByTypeName() {
		// 执行查询
		List<MessageManagement> list = customerService
				.findMessageManagementByTypeData(messageManagement.getMessageType());

		if (list == null) {
			toJsonSteam("[]");
		} else {
			toJsonSteam(JSONObject.toJSONString(list));
		}
		// 执行完毕
		return this.SUCCESS;
	}

	/*
	 * 执行查找的操作 获得MessageManagement类的全量数据 入口与struts_Customer.xml配置文件对应
	 */
	public String getFullAutoData() {
		List<MessageManagement> list = customerService.findMessageManagementFullDate();
		toJsonSteam(JSONObject.toJSONString(list));
		return this.SUCCESS;
	}
	/*
	 * 执行查找的操作 获得ListUserQuery类根据Id查   入口与struts_Customer.xml配置文件对应
	 */
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
	// 把JSON字符串转换成流
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
		int indexOf = ip.indexOf(",");
		if (indexOf > 0) {
			return ip.substring(0, indexOf);
		}
		return ip;

	}
	//根据传入的字符串创建文件夹
	private boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {// 判断目录是否存在
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {// 结尾是否以"/"结束
			destDirName = destDirName + File.separator;
		}
		if (dir.mkdirs()) {// 创建目标目录
			return true;
		} else {
			return false;
		}

	}
}
