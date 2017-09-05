package com.business.entitys.mp.btn;

public class ViewButton extends Button {
	private String url;

	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "ViewButton [url=" + url + "]";
	}

	public ViewButton() {
		super();
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
}
