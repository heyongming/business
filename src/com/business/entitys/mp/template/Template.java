package com.business.entitys.mp.template;

public class Template {
	private int TemplateId;
	private String first = "";
	private String firstColor = "";
	private String keyword1 = "";
	private String keyword2 = "";
	private String keyword3 = "";
	private String keyword4 = "";
	private String keyword5 = "";

	public Template(int templateId, String first, String firstColor, String keyword1, String keyword2, String keyword3,
			String keyword4, String keyword5, String keyword1Color, String keyword2Color, String resetUrl,
			String keyword3Color, String keyword4Color, String keyword5Color, String remark, String remarkColor,
			String insertTime, String clickCount, TemplateType templateType) {
		super();
		TemplateId = templateId;
		this.first = first;
		this.firstColor = firstColor;
		this.keyword1 = keyword1;
		this.keyword2 = keyword2;
		this.keyword3 = keyword3;
		this.keyword4 = keyword4;
		this.keyword5 = keyword5;
		this.keyword1Color = keyword1Color;
		this.keyword2Color = keyword2Color;
		this.resetUrl = resetUrl;
		this.keyword3Color = keyword3Color;
		this.keyword4Color = keyword4Color;
		this.keyword5Color = keyword5Color;
		this.remark = remark;
		this.remarkColor = remarkColor;
		this.insertTime = insertTime;
		this.clickCount = clickCount;
		this.templateType = templateType;
	}

	public String getKeyword5() {
		return keyword5;
	}

	public void setKeyword5(String keyword5) {
		this.keyword5 = keyword5;
	}

	public String getKeyword5Color() {
		return keyword5Color;
	}

	public void setKeyword5Color(String keyword5Color) {
		this.keyword5Color = keyword5Color;
	}

	private String keyword1Color = "";
	private String keyword2Color = "";
	private String resetUrl = "";
	private String keyword3Color = "";
	private String keyword4Color = "";
	private String keyword5Color = "";
	private String remark = "";
	private String remarkColor = "";
	private String insertTime;
	private String clickCount = "0";
	private TemplateType templateType;
	private int evCount=0;

	public int getEvCount() {
		return evCount;
	}

	public void setEvCount(int evCount) {
		this.evCount = evCount;
	}

	public Template() {
		super();
	}

	public Template(int templateId, String first, String firstColor, String keyword1, String keyword2, String keyword3,
			String keyword4, String keyword5, String keyword1Color, String keyword2Color, String resetUrl,
			String keyword3Color, String keyword4Color, String keyword5Color, String remark, String remarkColor,
			String insertTime, String clickCount, TemplateType templateType, int evCount) {
		super();
		TemplateId = templateId;
		this.first = first;
		this.firstColor = firstColor;
		this.keyword1 = keyword1;
		this.keyword2 = keyword2;
		this.keyword3 = keyword3;
		this.keyword4 = keyword4;
		this.keyword5 = keyword5;
		this.keyword1Color = keyword1Color;
		this.keyword2Color = keyword2Color;
		this.resetUrl = resetUrl;
		this.keyword3Color = keyword3Color;
		this.keyword4Color = keyword4Color;
		this.keyword5Color = keyword5Color;
		this.remark = remark;
		this.remarkColor = remarkColor;
		this.insertTime = insertTime;
		this.clickCount = clickCount;
		this.templateType = templateType;
		this.evCount = evCount;
	}

	@Override
	public String toString() {
		return "Template [TemplateId=" + TemplateId + ", first=" + first + ", firstColor=" + firstColor + ", keyword1="
				+ keyword1 + ", keyword2=" + keyword2 + ", keyword3=" + keyword3 + ", keyword4=" + keyword4
				+ ", keyword5=" + keyword5 + ", keyword1Color=" + keyword1Color + ", keyword2Color=" + keyword2Color
				+ ", resetUrl=" + resetUrl + ", keyword3Color=" + keyword3Color + ", keyword4Color=" + keyword4Color
				+ ", keyword5Color=" + keyword5Color + ", remark=" + remark + ", remarkColor=" + remarkColor
				+ ", insertTime=" + insertTime + ", clickCount=" + clickCount + ", templateType=" + templateType
				+ ", evCount=" + evCount + "]";
	}

	public int getTemplateId() {
		return TemplateId;
	}

	public void setTemplateId(int templateId) {
		TemplateId = templateId;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getFirstColor() {
		return firstColor;
	}

	public void setFirstColor(String firstColor) {
		this.firstColor = firstColor;
	}

	public String getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
	}

	public String getKeyword2() {
		return keyword2;
	}

	public void setKeyword2(String keyword2) {
		this.keyword2 = keyword2;
	}

	public String getKeyword3() {
		return keyword3;
	}

	public void setKeyword3(String keyword3) {
		this.keyword3 = keyword3;
	}

	public String getKeyword4() {
		return keyword4;
	}

	public void setKeyword4(String keyword4) {
		this.keyword4 = keyword4;
	}

	public String getKeyword1Color() {
		return keyword1Color;
	}

	public void setKeyword1Color(String keyword1Color) {
		this.keyword1Color = keyword1Color;
	}

	public String getKeyword2Color() {
		return keyword2Color;
	}

	public void setKeyword2Color(String keyword2Color) {
		this.keyword2Color = keyword2Color;
	}

	public String getResetUrl() {
		return resetUrl;
	}

	public void setResetUrl(String resetUrl) {
		this.resetUrl = resetUrl;
	}

	public String getKeyword3Color() {
		return keyword3Color;
	}

	public void setKeyword3Color(String keyword3Color) {
		this.keyword3Color = keyword3Color;
	}

	public String getKeyword4Color() {
		return keyword4Color;
	}

	public void setKeyword4Color(String keyword4Color) {
		this.keyword4Color = keyword4Color;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemarkColor() {
		return remarkColor;
	}

	public void setRemarkColor(String remarkColor) {
		this.remarkColor = remarkColor;
	}

	public String getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}

	public String getClickCount() {
		return clickCount;
	}

	public void setClickCount(String clickCount) {
		this.clickCount = clickCount;
	}

	public TemplateType getTemplateType() {
		return templateType;
	}

	public void setTemplateType(TemplateType templateType) {
		this.templateType = templateType;
	}

}
