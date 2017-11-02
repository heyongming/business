package com.business.entitys.mp.template;

public class TemplateMapping {
	private int mappingId;
	private int TemplateId;
	private String TemplateTypeId;

	public int getMappingId() {
		return mappingId;
	}

	public void setMappingId(int mappingId) {
		this.mappingId = mappingId;
	}

	public int getTemplateId() {
		return TemplateId;
	}

	public void setTemplateId(int templateId) {
		TemplateId = templateId;
	}

	public String getTemplateTypeId() {
		return TemplateTypeId;
	}

	public void setTemplateTypeId(String templateTypeId) {
		TemplateTypeId = templateTypeId;
	}

	public TemplateMapping(int mappingId, int templateId, String templateTypeId) {
		super();
		this.mappingId = mappingId;
		TemplateId = templateId;
		TemplateTypeId = templateTypeId;
	}

	public TemplateMapping() {
		super();
	}

	@Override
	public String toString() {
		return "TemplateMapping [mappingId=" + mappingId + ", TemplateId=" + TemplateId + ", TemplateTypeId="
				+ TemplateTypeId + "]";
	}

}
