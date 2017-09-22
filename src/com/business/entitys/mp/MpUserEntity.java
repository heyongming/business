package com.business.entitys.mp;

public class MpUserEntity {
	private String openid;

	@Override
	public String toString() {
		return "MpUserEntity [openid=" + openid + ", nickname=" + nickname + ", sex=" + sex + ", province=" + province
				+ ", city=" + city + ", country=" + country + ", headimgurl=" + headimgurl + ", privilege=" + privilege
				+ ", unionid=" + unionid + "]";
	}

	public MpUserEntity() {
		super();
	}

	public MpUserEntity(String openid, String nickname, String sex, String province, String city, String country,
			String headimgurl, String privilege, String unionid) {
		super();
		this.openid = openid;
		this.nickname = nickname;
		this.sex = sex;
		this.province = province;
		this.city = city;
		this.country = country;
		this.headimgurl = headimgurl;
		this.privilege = privilege;
		this.unionid = unionid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	private String nickname;
	private String sex;
	private String province;
	private String city;
	private String country;
	private String headimgurl;
	private String privilege;
	private String unionid;
}