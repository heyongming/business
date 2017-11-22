package com.business.entitys.autoReply;

public class AutoReply {
	private int arId;
	private String Keyword;
	private String replyContent;
	private String matchingMethod;
	private String replyMode;

	public int getArId() {
		return arId;
	}

	public void setArId(int arId) {
		this.arId = arId;
	}

	public String getKeyword() {
		return Keyword;
	}

	public void setKeyword(String keyword) {
		Keyword = keyword;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getMatchingMethod() {
		return matchingMethod;
	}

	public void setMatchingMethod(String matchingMethod) {
		this.matchingMethod = matchingMethod;
	}

	public String getReplyMode() {
		return replyMode;
	}

	public void setReplyMode(String replyMode) {
		this.replyMode = replyMode;
	}

	@Override
	public String toString() {
		return "AutoReply [arId=" + arId + ", Keyword=" + Keyword + ", replyContent=" + replyContent
				+ ", matchingMethod=" + matchingMethod + ", replyMode=" + replyMode + "]";
	}

	public AutoReply(int arId, String keyword, String replyContent, String matchingMethod, String replyMode) {
		super();
		this.arId = arId;
		Keyword = keyword;
		this.replyContent = replyContent;
		this.matchingMethod = matchingMethod;
		this.replyMode = replyMode;
	}

	/**
	 * 
	 */
	public AutoReply() {
		super();
	}

}
