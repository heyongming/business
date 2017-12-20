package com.business.action.mbimcVote;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.json.JsonObject;

import com.alibaba.fastjson.JSONObject;
import com.business.entitys.ResultMessage;
import com.business.entitys.mbimcVote.MbimcVote;
import com.business.entitys.mbimcVote.MbimcVoteAndStrategy;
import com.business.service.IMbimcVoteService;
import com.business.util.PacthUtill;
import com.business.util.RandomUtill;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 天禄跟投表Action
 * 
 * @ActionSupport 为struts2的提供的上下文的一个类
 * @ModelDriven 该方法返回一个用于接收用户输入数据的模型对象。
 */
public class MbimcVoteAction extends ActionSupport implements ModelDriven<MbimcVote> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6667316751339195916L;
	// 注入Service
	@Resource
	private IMbimcVoteService mbimcVoteService;
	private InputStream bis;
	// 资产走势图相关文件
	private File file;
	private String fileFileName;
	private String fileContentType;

	// 净值走势图相关文件
	private File vtFile;
	private String vtFileFileName;
	private String vtFileContentType;

	private String savePath;

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

	public File getVtFile() {
		return vtFile;
	}

	public void setVtFile(File vtFile) {
		this.vtFile = vtFile;
	}

	public String getVtFileFileName() {
		return vtFileFileName;
	}

	public void setVtFileFileName(String vtFileFileName) {
		this.vtFileFileName = vtFileFileName;
	}

	public String getVtFileContentType() {
		return vtFileContentType;
	}

	public void setVtFileContentType(String vtFileContentType) {
		this.vtFileContentType = vtFileContentType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	private String fictitiousPath;

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

	public IMbimcVoteService getMbimcVoteService() {
		return mbimcVoteService;
	}

	public void setMbimcVoteService(IMbimcVoteService mbimcVoteService) {
		this.mbimcVoteService = mbimcVoteService;
	}

	private MbimcVote mbimcVote;

	@Override
	public MbimcVote getModel() {
		// TODO Auto-generated method stub
		mbimcVote = new MbimcVote();
		return mbimcVote;
	}

	public MbimcVote getMbimcVote() {
		return mbimcVote;
	}

	public void setMbimcVote(MbimcVote mbimcVote) {
		this.mbimcVote = mbimcVote;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		ResultMessage message = null;
		savePath = PacthUtill.getPacthVal("mbimcVoteImagePath");
		fictitiousPath = PacthUtill.getPacthVal("mbimcVoteFictitiousPath");

		if (file == null || vtFile == null) {
			message = new ResultMessage("-2", "flase", "file is null");
			toJsonSteam(JSONObject.toJSONString(message));
			return this.SUCCESS;
		}

		Date today = new Date();
		long time = today.getTime();
		fictitiousPath = fictitiousPath + time;
		savePath = savePath + time;
		String tempPath = "";
		while (!(createDir(savePath))) {

			time = today.getTime();
			fictitiousPath = fictitiousPath + time;
			savePath = savePath + time;

		}

		InputStream is = new FileInputStream(file);
		OutputStream os = new FileOutputStream(new File(savePath, fileFileName));

		byte[] buffer = new byte[500];
		while (-1 != (is.read(buffer, 0, buffer.length))) {

			os.write(buffer);
		}
		os.close();
		is.close();

		mbimcVote.setAssetChart(fictitiousPath + "/" + fileFileName);

		is = new FileInputStream(vtFile);
		os = new FileOutputStream(new File(savePath, vtFileFileName));

		buffer = new byte[500];
		while (-1 != (is.read(buffer, 0, buffer.length))) {

			os.write(buffer);
		}
		os.close();
		is.close();
		mbimcVote.setNetValueTrendChart(fictitiousPath + "/" + vtFileFileName);
		int id = mbimcVoteService.addMbimcVote(mbimcVote);
		if (id > 0) {
			message = new ResultMessage("1", "true", id + "");
		} else {
			message = new ResultMessage("-1", "false", -1 + "");
		}
		toJsonSteam(JSONObject.toJSONString(message));
		return this.SUCCESS;
	}

	public String update() throws Exception {
		ResultMessage message = null;
		List<MbimcVote> list = mbimcVoteService.selectMbimcVoteByKey(mbimcVote.getMvId());
		String basePath = "";
		String savePath = PacthUtill.getPacthVal("mbimcVoteImagePath");
		;
		if (list != null) {
			if (list.size() > 0) {
				MbimcVote tempMbimcVote = list.get(0);
				int index = tempMbimcVote.getAssetChart().lastIndexOf("/");
				String tempStr = tempMbimcVote.getAssetChart().substring(0, index);
				basePath = tempMbimcVote.getAssetChart().substring(0, index + 1);
				savePath = savePath + basePath.substring(tempStr.lastIndexOf("/"), index);
				mbimcVote.setAssetChart(tempMbimcVote.getAssetChart());
				mbimcVote.setNetValueTrendChart(tempMbimcVote.getNetValueTrendChart());
			} else {
				message = new ResultMessage("-1", "false", "not find");
				toJsonSteam(JSONObject.toJSONString(message));
				return this.SUCCESS;

			}
		} else {
			message = new ResultMessage("-1", "false", "not find");
			toJsonSteam(JSONObject.toJSONString(message));
			return this.SUCCESS;

		}
		if (file != null) {
			InputStream is = new FileInputStream(file);
			OutputStream os = new FileOutputStream(new File(savePath, fileFileName));

			byte[] buffer = new byte[500];
			while (-1 != (is.read(buffer, 0, buffer.length))) {

				os.write(buffer);
			}
			os.close();
			is.close();

			mbimcVote.setAssetChart(basePath + fileFileName);

		}
		if (vtFile != null) {
			InputStream is = new FileInputStream(vtFile);
			OutputStream os = new FileOutputStream(new File(savePath, vtFileFileName));

			byte[] buffer = new byte[500];
			while (-1 != (is.read(buffer, 0, buffer.length))) {

				os.write(buffer);
			}
			os.close();
			is.close();
			mbimcVote.setNetValueTrendChart(basePath + vtFileFileName);
		}

		int flog = mbimcVoteService.updateMbimcVote(mbimcVote);
		if (flog > 0) {
			message = new ResultMessage("1", "ture", " update ok");
		} else {
			message = new ResultMessage("-2", "false", "update over");
		}
		toJsonSteam(JSONObject.toJSONString(message));
		return this.SUCCESS;
	}

	public String getFullData() {
		List<MbimcVote> list = mbimcVoteService.selectAllMbimcVote();
		if (list != null) {
			if (list.size() > 0) {
				toJsonSteam(JSONObject.toJSONString(list));
				return this.SUCCESS;
			}
		}
		toJsonSteam("[]");
		return this.SUCCESS;
	}

	public String getMbimcVoteById() {
		List<MbimcVote> list = mbimcVoteService.selectMbimcVoteByKey(mbimcVote.getMvId());
		if (list != null) {
			if (list.size() > 0) {
				toJsonSteam(JSONObject.toJSONString(list));
				return this.SUCCESS;
			}
		}
		toJsonSteam("[]");
		return this.SUCCESS;
	}

	public String delMbimcVote() {
		ResultMessage resultMessage = null;
		int flog = mbimcVoteService.delMbimcVote(mbimcVote.getMvId());
		if (flog > 0) {
			resultMessage = new ResultMessage("1", "true", "del ok");
		} else {
			resultMessage = new ResultMessage("1", "true", "del ok");
		}
		return JSONObject.toJSONString(resultMessage);
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
