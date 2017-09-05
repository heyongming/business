package com.business.entitys.mp;

public class BaseMsgEntity {
	private String ToUserName;
	private String FromUserName;
	private String CreateTime;
	private String MsgType;

	public String getToUserName() {
		return ToUserName;
	}

	@Override
	public String toString() {
		return "BaseMsgEntity [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime="
				+ CreateTime + ", MsgType=" + MsgType + "]";
	}

	public BaseMsgEntity() {
		super();
	}

	public BaseMsgEntity(String toUserName, String fromUserName, String createTime, String msgType) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}
