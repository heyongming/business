package com.business.util.mp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alibaba.fastjson.JSONObject;
import com.business.job.AccessTokenManager;
import com.business.job.MsgMeesage;
import com.business.temp.Api_add_template;
import com.business.temp.MpCodeEntitys;
import com.business.temp.ThumbEntity;
import com.business.util.HttpClientUtil;

import com.thoughtworks.xstream.XStream;
import com.business.entitys.mp.Image;
import com.business.entitys.mp.ImageMessage;
import com.business.entitys.mp.MpUserEntity;
import com.business.entitys.mp.Music;
import com.business.entitys.mp.MusicMessage;
import com.business.entitys.mp.NewsItem;
import com.business.entitys.mp.NewsTextMessage;
import com.business.entitys.mp.TextMessage;
import com.business.entitys.mp.WeiXinOpenUser;
import com.business.entitys.mp.template.TemplateCtent;
import com.business.entitys.mp.template.TemplateUser;

/**
 * @author mbimc
 *
 */
public class MessAgeUtil {
	public static final String MESSAGE_VIEW = "VIEW";
	public static final String MESSAGE_NEWS = "news";

	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_EVNET = "event";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_MUSIC = "music";

	// 把XML文件转为map集合
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		SAXReader saxReader = new SAXReader();
		InputStream is = request.getInputStream();
		Document doc = saxReader.read(is);
		Element root = doc.getRootElement();
		List<Element> list = root.elements();
		for (Element element : list) {
			map.put(element.getName(), element.getText());

		}
		return map;
	}

	// 把文本消息转为XML
	public static String textToXml(TextMessage textMessage) {

		XStream xStream = new XStream();
		xStream.alias("xml", textMessage.getClass());

		String xmlStr = xStream.toXML(textMessage);

		return xmlStr;

	}

	// 把MAP集合转成文本对象
	public static TextMessage mapToTextMessage(Map<String, String> map) {
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(map.get("ToUserName"));
		textMessage.setFromUserName(map.get("FromUserName"));
		textMessage.setMsgType(map.get("MsgType"));
		textMessage.setMsgId(map.get("MsgId"));
		textMessage.setContent(map.get("Content"));
		textMessage.setCreateTime(map.get("CreateTime"));
		if (map.get("Event") != null) {
			textMessage.setEvent(map.get("Event"));
		}
		if (map.get("EventKey") != null) {
			textMessage.setEventKey(map.get("EventKey"));
		}

		return textMessage;
	}

	// 显示主菜单
	public static String showMenu() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("终于等到你！还好我没放弃！\n\n");
		sbf.append("1.资本剑客说相关介绍\n");
		sbf.append("2.迈步相关介绍\n");
		sbf.append("3.课程相关介绍\n");
		sbf.append("4.自身教师介绍\n");
		sbf.append("5.企业文化介绍\n");
		sbf.append("重复显示请输入?或者help\n");
		return sbf.toString();
	}

	public static String overOut() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("有缘再见\n");
		return sbf.toString();
	}

	// 其他選項
	public static String ontherMenu() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("相关功能正在开发中，请期待\n");
		return sbf.toString();
	}

	// 初始化文本消息
	public static TextMessage initText(TextMessage message) {
		TextMessage ToMessage = new TextMessage();
		ToMessage.setToUserName(message.getFromUserName());
		ToMessage.setFromUserName(message.getToUserName());
		ToMessage.setMsgType(MESSAGE_TEXT);
		ToMessage.setCreateTime(new Date().getTime() + "");
		ToMessage.setContent(message.getContent());
		return ToMessage;
	}

	// 初始化图文消息
	public static NewsTextMessage initNewText(TextMessage message, List<NewsItem> newItem) {
		NewsTextMessage ntm = new NewsTextMessage();
		ntm.setFromUserName(message.getToUserName());
		ntm.setToUserName(message.getFromUserName());
		ntm.setMsgType(MessAgeUtil.MESSAGE_NEWS);
		ntm.setArticles(newItem);
		ntm.setArticleCount(newItem.size());
		ntm.setCreateTime(new Date().getTime() + "");

		return ntm;
	}

	// 图文消息转成XML
	public static String NewsTextToXml(NewsTextMessage newsTextMessage) {
		XStream xStream = new XStream();
		xStream.alias("xml", newsTextMessage.getClass());
		xStream.alias("item", newsTextMessage.getArticles().get(0).getClass());
		String xmlStr = xStream.toXML(newsTextMessage);

		return xmlStr;
	}

	// 微信文件上传
	public static String FileupLoad(String filePach, String accessToken, String type) throws Exception {
		String media_id = null;

		File file = new File(filePach);
		if (!file.exists() || !file.isFile()) {
			return media_id;
		}
		String upLoadurl = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";

		upLoadurl = upLoadurl.replace("ACCESS_TOKEN", accessToken);
		upLoadurl = upLoadurl.replace("TYPE", type);

		URL urlObj = null;
		urlObj = new URL(upLoadurl);
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
		con.setRequestMethod("POST");
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false);
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");
		String BOUNDARY = "---------------------------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BOUNDARY);
		StringBuffer sb = new StringBuffer();
		sb.append("--");
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition:form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");

		byte[] head = sb.toString().getBytes("utf-8");
		OutputStream out = new DataOutputStream(con.getOutputStream());
		out.write(head);
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];

		while ((bytes = in.read(bufferOut)) != -1) {

			out.write(bufferOut, 0, bytes);
		}
		in.close();
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");
		out.write(foot);
		out.flush();
		out.close();
		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		String result = null;
		reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line = null;
		while ((line = reader.readLine()) != null) {
			buffer.append(line);

		}
		if (result == null) {
			result = buffer.toString();
		}
		reader.close();
		if (type.equals("image")) {
			MsgMeesage msg = JSONObject.parseObject(result, MsgMeesage.class);
			media_id = msg.getMedia_id();
		} else if (type.equals("thumb")) {
			ThumbEntity thumbEntity = JSONObject.parseObject(result, ThumbEntity.class);
			media_id = thumbEntity.getThumb_media_id();
		}

		return media_id;
	}

	// 初始化图片消息
	public static ImageMessage initImage(TextMessage message, Image image) {
		ImageMessage imageMessage = new ImageMessage();
		imageMessage.setFromUserName(message.getToUserName());
		imageMessage.setToUserName(message.getFromUserName());
		imageMessage.setMsgType(MessAgeUtil.MESSAGE_IMAGE);
		imageMessage.setImage(image);

		imageMessage.setCreateTime(new Date().getTime() + "");
		return imageMessage;
	}

	// 把图片消息转为XML
	public static String imageToXml(ImageMessage imageMessage) {

		XStream xStream = new XStream();
		xStream.alias("xml", imageMessage.getClass());
		xStream.alias("Image", imageMessage.getImage().getClass());
		String xmlStr = xStream.toXML(imageMessage);
		xmlStr = xmlStr.replaceAll("<image>", "<Image>");
		xmlStr = xmlStr.replaceAll("</image>", "</Image>");

		return xmlStr;

	}

	// 把音乐消息转成XML
	public static String musicToXml(MusicMessage message) {
		XStream xStream = new XStream();
		xStream.alias("xml", message.getClass());
		xStream.alias("music", message.getMusic().getClass());
		String xmlStr = xStream.toXML(message);
		xmlStr = xmlStr.replaceAll("<music>", "<Music>");
		xmlStr = xmlStr.replaceAll("</music>", "</Music>");

		return xmlStr;
	}

	// 初始化音乐消息
	public static MusicMessage initMusic(TextMessage message, Music music) {

		MusicMessage mm = new MusicMessage();
		mm.setFromUserName(message.getToUserName());
		mm.setToUserName(message.getFromUserName());
		mm.setMsgType(MessAgeUtil.MESSAGE_MUSIC);
		mm.setMusic(music);
		mm.setCreateTime(new Date().getTime() + "");
		return mm;

	}

	// 获得模板消息ID
	public static String GetTemplate_id(String template_id, String accesToken) {
		String result = null;
		String url = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
		template_id = "{\"template_id_short\":\"" + template_id + "\"}";

		url = url.replaceAll("ACCESS_TOKEN", accesToken);
		result = HttpClientUtil.httpPost(url, template_id);
		Api_add_template add_template = JSONObject.parseObject(result, Api_add_template.class);

		return add_template.getTemplate_id();
	}

	// 获得用户列表
	public static String[] getUserList(String access_token, String next_openid) {
		String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
		url = url.replaceAll("ACCESS_TOKEN", access_token);
		url = url.replaceAll("NEXT_OPENID", next_openid);
		String result = HttpClientUtil.httpGet(url);
		System.out.println(result);
		WeiXinOpenUser list = JSONObject.parseObject(result, WeiXinOpenUser.class);
		return list.getData().getOpenid();
	}

	public static String sendTemplate(String access_token, TemplateUser templateUser) {
		String data = JSONObject.toJSONString(templateUser);
		System.out.println(data);
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
		url = url.replaceAll("ACCESS_TOKEN", access_token);
		String result = HttpClientUtil.httpPost(url, data);
		System.out.println(result);
		return null;
	}

	/**
	 * @param 微信授权的网页
	 * @return 加密后的网页
	 */
	public static String webLicensingnSapi_userinfo(String url) {
		try {
			url = URLEncoder.encode(url, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String getUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=URI&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
		getUrl = getUrl.replaceAll("APPID", AccessTokenManager.APPID);
		getUrl = getUrl.replaceAll("URI", url);
		System.out.println(getUrl);
		return getUrl;
	}

	/**
	 * @param 微信返回的code
	 * @return 返回用code换取的accessToken
	 */
	public static MpCodeEntitys GetwebpagesCode(String code) {

		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		url = url.replaceAll("APPID", AccessTokenManager.APPID);
		url = url.replaceAll("SECRET", AccessTokenManager.AppSecret);
		url = url.replaceAll("CODE", code);
		System.out.println(url + "???");
		String result = HttpClientUtil.httpGet(url);

		System.out.println(result);
		MpCodeEntitys mpCodeEntitys = JSONObject.parseObject(result, MpCodeEntitys.class);
		return mpCodeEntitys;

	}

	/**
	 * @param access_token
	 *            网页授权凭证
	 * @param openId
	 *            用户的openId
	 * @return 用户的相关信息
	 */
	public static MpUserEntity getMpUserEntity(String access_token, String openId) {
		String url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
		url = url.replaceAll("ACCESS_TOKEN", access_token);
		url = url.replaceAll("OPENID", openId);
		String result = HttpClientUtil.httpGet(url);
		System.out.println(result);
		MpUserEntity entity = JSONObject.parseObject(result, MpUserEntity.class);
		return entity;
	}
}
