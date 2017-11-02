package com.business.entitys.mp.template;

public class TemplateCtent {

	@Override
	public String toString() {
		return "TemplateCtent [keyword4=" + keyword4 + ", keyword3=" + keyword3 + ", keyword2=" + keyword2
				+ ", keyword1=" + keyword1 + ", keyword5=" + keyword5 + ", first=" + first + ", remark=" + remark + "]";
	}

	public TemplateCtent() {
		super();
	}

	private DataRemark keyword4;

	public TemplateCtent(DataRemark keyword4, DataRemark keyword3, DataRemark keyword2, DataRemark keyword1,
			DataRemark first, DataRemark remark) {
		super();
		this.keyword4 = keyword4;
		this.keyword3 = keyword3;
		this.keyword2 = keyword2;
		this.keyword1 = keyword1;
		this.first = first;
		this.remark = remark;
	}

	public DataRemark getRemark() {
		return remark;
	}

	public void setRemark(DataRemark remark) {
		this.remark = remark;
	}

	public DataRemark getKeyword4() {
		return keyword4;
	}

	public void setKeyword4(DataRemark keyword4) {
		this.keyword4 = keyword4;
	}

	public DataRemark getKeyword3() {
		return keyword3;
	}

	public void setKeyword3(DataRemark keyword3) {
		this.keyword3 = keyword3;
	}

	public DataRemark getKeyword2() {
		return keyword2;
	}

	public void setKeyword2(DataRemark keyword2) {
		this.keyword2 = keyword2;
	}

	public DataRemark getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(DataRemark keyword1) {
		this.keyword1 = keyword1;
	}

	public DataRemark getFirst() {
		return first;
	}

	public void setFirst(DataRemark first) {
		this.first = first;
	}

	private DataRemark keyword3;
	private DataRemark keyword2;
	private DataRemark keyword1;
	private DataRemark keyword5;

	public TemplateCtent(DataRemark keyword4, DataRemark keyword3, DataRemark keyword2, DataRemark keyword1,
			DataRemark keyword5, DataRemark first, DataRemark remark) {
		super();
		this.keyword4 = keyword4;
		this.keyword3 = keyword3;
		this.keyword2 = keyword2;
		this.keyword1 = keyword1;
		this.keyword5 = keyword5;
		this.first = first;
		this.remark = remark;
	}

	public DataRemark getKeyword5() {
		return keyword5;
	}

	public void setKeyword5(DataRemark keyword5) {
		this.keyword5 = keyword5;
	}

	private DataRemark first;
	private DataRemark remark;

}
