package com.business.entitys.mp;

public class ImageMessage extends BaseMsgEntity {
	private Image image;

	public ImageMessage() {
		super();
	}

	public ImageMessage(Image image) {
		super();
		this.image = image;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
