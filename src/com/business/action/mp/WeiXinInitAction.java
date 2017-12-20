package com.business.action.mp;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.business.entitys.mp.Image;
import com.business.entitys.mp.ImageMessage;
import com.business.entitys.mp.Music;
import com.business.entitys.mp.MusicMessage;
import com.business.entitys.mp.NewsItem;
import com.business.entitys.mp.NewsTextMessage;
import com.business.entitys.mp.TextMessage;
import com.business.entitys.mp.WeiXinVerification;
import com.business.util.mp.MessAgeUtil;
import com.business.util.mp.WeiXinCheckInit;
import com.data.InitMusicDbo;
import com.data.InitNewSDbo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class WeiXinInitAction extends ActionSupport implements ModelDriven<WeiXinVerification> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5384854045485977580L;
	private WeiXinVerification weiXinVerification;

	@Override
	public WeiXinVerification getModel() {
		// TODO Auto-generated method stub
		weiXinVerification = new WeiXinVerification();
		return weiXinVerification;
	}

	private InputStream bis;

	public InputStream getBis() {
		return bis;
	}

	public void setBis(InputStream bis) {
		this.bis = bis;
	}

	public WeiXinVerification getWeiXinVerification() {
		return weiXinVerification;
	}

	public void setWeiXinVerification(WeiXinVerification weiXinVerification) {
		this.weiXinVerification = weiXinVerification;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String method = ServletActionContext.getRequest().getMethod();

		if (method.equals("POST")) {// 注意全部大写

			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
					.get(StrutsStatics.HTTP_REQUEST);
			ServiceAnswer(request);
		} else {
			initWeiXin();
		}

		return super.execute();
	}

	private void initWeiXin() {
		try {
			if (WeiXinCheckInit.checkSignature(weiXinVerification)) {
				bis = new ByteArrayInputStream(weiXinVerification.getEchostr().getBytes("utf-8"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	private void ServiceAnswer(HttpServletRequest request) {
		Map<String, String> map = null;

		try {
			map = MessAgeUtil.xmlToMap(request);
			TextMessage FromMessage = MessAgeUtil.mapToTextMessage(map);
			if (FromMessage.getMsgType().equals("text")) {
				if (FromMessage.getContent().equals("1")) {
					List<NewsItem> news = InitNewSDbo.singleNewTextList();
					msgNewsTextToResult(FromMessage, news);
				} else if (FromMessage.getContent().equals("2")) {
					List<NewsItem> news = InitNewSDbo.complexNewTextList();
					msgNewsTextToResult(FromMessage, news);
				} else if (FromMessage.getContent().equals("3")) {
					imageTextToResult(FromMessage,
							new Image("y7V5kzHL2jb7Hz6tMsYOEelcjrQyzw4hGv35hMJI67jrJc2jc_yQEZb4mE2gCmtJ"));
				} else if (FromMessage.getContent().equals("4")) {
					musicTextToResult(FromMessage, InitMusicDbo.initMusic());
				} else if (FromMessage.getContent().equals("5")) {
					msgToResult(FromMessage, MessAgeUtil.ontherMenu());
				} else if (FromMessage.getContent().equals("？") || FromMessage.getContent().equals("help")) {
					msgToResult(FromMessage, MessAgeUtil.showMenu());
				} else {
					msgToResult(FromMessage, "没有该选项请重新输入");
				}

				return;
			} else if (FromMessage.getMsgType().equals(MessAgeUtil.MESSAGE_EVNET)) {
				if (FromMessage.getEvent().equals(MessAgeUtil.MESSAGE_SUBSCRIBE)) {
					String menu = MessAgeUtil.showMenu();
					msgToResult(FromMessage, menu);
					return;
				} else if (FromMessage.getEvent().equals(MessAgeUtil.MESSAGE_UNSUBSCRIBE)) {
					String ovString = MessAgeUtil.overOut();
					msgToResult(FromMessage, ovString);
					return;
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 把文本消息转成流
	private void msgToResult(TextMessage textMsg, String content) {
		textMsg.setContent(content);

		TextMessage MenuText = MessAgeUtil.initText(textMsg);
		String xmlData = MessAgeUtil.textToXml(MenuText);
		try {
			bis = new ByteArrayInputStream(xmlData.getBytes("utf-8"));
			return;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bis = null;
	}

	// 把图文消息转换成流
	private void msgNewsTextToResult(TextMessage textMessage, List<NewsItem> list) {
		NewsTextMessage message = MessAgeUtil.initNewText(textMessage, list);
		String xmlData = MessAgeUtil.NewsTextToXml(message);

		try {
			bis = new ByteArrayInputStream(xmlData.getBytes("utf-8"));
			return;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bis = null;
	}

	// 把图片消息转成流
	private void imageTextToResult(TextMessage textMessage, Image image) {
		ImageMessage message = MessAgeUtil.initImage(textMessage, image);
		String xmlData = MessAgeUtil.imageToXml(message);
		try {
			bis = new ByteArrayInputStream(xmlData.getBytes("utf-8"));
			return;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bis = null;
	}

	// 把音乐消息转成流
	private void musicTextToResult(TextMessage textMessage, Music music) {
		MusicMessage message = MessAgeUtil.initMusic(textMessage, music);
		String xmlData = MessAgeUtil.musicToXml(message);
		try {
			bis = new ByteArrayInputStream(xmlData.getBytes("utf-8"));
			return;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bis = null;
	}
}
