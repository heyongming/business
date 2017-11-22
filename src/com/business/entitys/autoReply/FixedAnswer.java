package com.business.entitys.autoReply;

public class FixedAnswer {
	private int fdid;
	private String problem;
	private String answer;
	private String dateManufacture;

	public int getFdid() {
		return fdid;
	}

	public void setFdid(int fdid) {
		this.fdid = fdid;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getDateManufacture() {
		return dateManufacture;
	}

	public void setDateManufacture(String dateManufacture) {
		this.dateManufacture = dateManufacture;
	}

	/**
	 * @param fdid
	 * @param problem
	 * @param answer
	 * @param dateManufacture
	 */
	public FixedAnswer(int fdid, String problem, String answer, String dateManufacture) {
		super();
		this.fdid = fdid;
		this.problem = problem;
		this.answer = answer;
		this.dateManufacture = dateManufacture;
	}

	/**
	 * 
	 */
	public FixedAnswer() {
		super();
	}

	@Override
	public String toString() {
		return "FixedAnswer [fdid=" + fdid + ", problem=" + problem + ", answer=" + answer + ", dateManufacture="
				+ dateManufacture + "]";
	}

}
