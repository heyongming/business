package com.business.entitys.mp.template;

public class TemplateUser {
private String touser;
private String template_id;
private String url;
private Miniprogram miniprogram;
	private TemplateCtent data;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Miniprogram getMiniprogram() {
		return miniprogram;
	}

	public void setMiniprogram(Miniprogram miniprogram) {
		this.miniprogram = miniprogram;
	}

	public TemplateCtent getData() {
		return data;
	}

	@Override
	public String toString() {
		return "TemplateUser [touser=" + touser + ", template_id=" + template_id + ", url=" + url + ", miniprogram="
				+ miniprogram + ", data=" + data + "]";
	}

	public void setData(TemplateCtent data) {
		this.data = data;
	}
}
