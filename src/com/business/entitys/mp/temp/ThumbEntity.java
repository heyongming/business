package com.business.entitys.mp.temp;

public class ThumbEntity {
private String thumb_media_id;
private String type;
private String created_at;
public String getThumb_media_id() {
	return thumb_media_id;
}
public void setThumb_media_id(String thumb_media_id) {
	this.thumb_media_id = thumb_media_id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getCreated_at() {
	return created_at;
}
public void setCreated_at(String created_at) {
	this.created_at = created_at;
}
public ThumbEntity() {
	super();
}
public ThumbEntity(String thumb_media_id, String type, String created_at) {
	super();
	this.thumb_media_id = thumb_media_id;
	this.type = type;
	this.created_at = created_at;
}
@Override
public String toString() {
	return "ThumbEntity [thumb_media_id=" + thumb_media_id + ", type=" + type + ", created_at=" + created_at + "]";
}
}
