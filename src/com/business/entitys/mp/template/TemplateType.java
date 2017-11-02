package com.business.entitys.mp.template;

public class TemplateType {
	private String TemplateTypeId;
	private String TemplateTypeName;
	private String clickCount;
	private int evCount;
	public int getEvCount() {
		return evCount;
	}

	public void setEvCount(int evCount) {
		this.evCount = evCount;
	}

	@Override
	public String toString() {
		return "TemplateType [TemplateTypeId=" + TemplateTypeId + ", TemplateTypeName=" + TemplateTypeName
				+ ", clickCount=" + clickCount + "]";
	}

	public TemplateType() {
		super();
	}

	public TemplateType(String templateTypeId, String templateTypeName, String clickCount) {
		super();
		TemplateTypeId = templateTypeId;
		TemplateTypeName = templateTypeName;
		this.clickCount = clickCount;
	}

	public String getTemplateTypeId() {
		return TemplateTypeId;
	}

	public void setTemplateTypeId(String templateTypeId) {
		TemplateTypeId = templateTypeId;
	}

	public String getTemplateTypeName() {
		return TemplateTypeName;
	}

	public void setTemplateTypeName(String templateTypeName) {
		TemplateTypeName = templateTypeName;
	}

	public String getClickCount() {
		return clickCount;
	}

	public void setClickCount(String clickCount) {
		this.clickCount = clickCount;
	}
}
