package com.data;

import com.business.entitys.mp.Music;

public class InitMusicDbo {
	public static String ThumbMediaId="";
	public static Music initMusic()
	{
		Music music=new Music();
		music.setTitle("心做し");
		music.setMusicUrl("http://181433wt25.iok.la/wx/music/まじ娘 - 心做し.mp3");
		music.setHQMusicUrl("http://181433wt25.iok.la/wx/music/まじ娘 - 心做し.mp3");
		music.setDescription("最符合您心情的曲子");
		music.setThumbMediaId("M14j0-C3ccmPwdgCRPnze0cYuitYoko4uj6ahQxG9qVWPzyKCf3fzkkBM_d4qPoh");
		return music;
	}
}
