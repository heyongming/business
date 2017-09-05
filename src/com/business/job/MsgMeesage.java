package com.business.job;

public class MsgMeesage {
	private String media_id;
	private String created_at;

	public MsgMeesage() {
		super();
	}

	public MsgMeesage(String media_id, String created_at, String type) {
		super();
		this.media_id = media_id;
		this.created_at = created_at;
		this.type = type;
	}

	private String type;

	@Override
	public String toString() {
		return "MsgMeesage [media_id=" + media_id + ", created_at=" + created_at + ", type=" + type + "]";
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
