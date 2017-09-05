package com.business.entitys.mp;

public class MusicMessage extends BaseMsgEntity {
	private Music music;

	public MusicMessage(Music music) {
		super();
		this.music = music;
	}

	public MusicMessage() {

	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

}
