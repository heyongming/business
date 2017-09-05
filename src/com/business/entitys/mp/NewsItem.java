package com.business.entitys.mp;

public class NewsItem {
	private String Title;
	private String Description;
	private String PicUrl;
	private String Url;

	public NewsItem() {
		super();
	}

	public NewsItem(String title, String description, String picUrl, String url) {
		super();
		Title = title;
		Description = description;
		PicUrl = picUrl;
		Url = url;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	@Override
	public String toString() {
		return "NewsItem [Title=" + Title + ", Description=" + Description + ", PicUrl=" + PicUrl + ", Url=" + Url
				+ "]";
	}
}
