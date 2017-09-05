package com.business.entitys.mp;

public class TextMessage extends BaseMsgEntity {

	private String Content;
	private String MsgId;
	private String Event;
	private String EventKey;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public TextMessage(String content, String msgId, String event, String eventKey) {
		super();
		Content = content;
		MsgId = msgId;
		Event = event;
		EventKey = eventKey;
	}

	public TextMessage() {
		super();
	}

	@Override
	public String toString() {

		return super.toString() + "TextMessage [Content=" + Content + ", MsgId=" + MsgId + ", Event=" + Event
				+ ", EventKey=" + EventKey + "]";
	}

}
