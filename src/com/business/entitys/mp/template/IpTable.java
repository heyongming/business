package com.business.entitys.mp.template;

public class IpTable {
	private int id;
	private int TemplateId;
	private String ip;
	private String dateManufacture;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTemplateId() {
		return TemplateId;
	}

	public void setTemplateId(int templateId) {
		TemplateId = templateId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDateManufacture() {
		return dateManufacture;
	}

	public void setDateManufacture(String dateManufacture) {
		this.dateManufacture = dateManufacture;
	}

	public IpTable(int id, int templateId, String ip, String dateManufacture) {
		super();
		this.id = id;
		TemplateId = templateId;
		this.ip = ip;
		this.dateManufacture = dateManufacture;
	}

	public IpTable() {
		super();
	}

	@Override
	public String toString() {
		return "IpTable [id=" + id + ", TemplateId=" + TemplateId + ", ip=" + ip + ", dateManufacture="
				+ dateManufacture + "]";
	}

}
