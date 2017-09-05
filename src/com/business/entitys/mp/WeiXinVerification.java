package com.business.entitys.mp;

//微信初始化实体类
public class WeiXinVerification {
	private String signature;
	private String timestamp;
	private String nonce;

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Override
	public String toString() {
		return "WeiXinVerification [signature=" + signature + ", timestamp=" + timestamp + ", nonce=" + nonce
				+ ", echostr=" + echostr + "]";
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public WeiXinVerification() {
		super();
	}

	public WeiXinVerification(String signature, String timestamp, String nonce, String echostr) {
		super();
		this.signature = signature;
		this.timestamp = timestamp;
		this.nonce = nonce;
		this.echostr = echostr;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getEchostr() {
		return echostr;
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}

	private String echostr;
}
