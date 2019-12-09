package net.admin.db;

import java.sql.Date;

public class MovieInfoBean {
	private String MOV_TITLE;
	private String MOV_GENRE;
	private Date MOV_DATE;
	private int MOV_TIME;
	private String MOV_RATING;
	private String MOV_STORY;
	private String MOV_POSTER;
	
	public String getMOV_TITLE() {
		return MOV_TITLE;
	}
	public String getMOV_GENRE() {
		return MOV_GENRE;
	}
	public void setMOV_GENRE(String mOV_GENRE) {
		MOV_GENRE = mOV_GENRE;
	}
	public void setMOV_TITLE(String mOV_TITLE) {
		MOV_TITLE = mOV_TITLE;
	}
	public Date getMOV_DATE() {
		return MOV_DATE;
	}
	public void setMOV_DATE(Date mOV_DATE) {
		MOV_DATE = mOV_DATE;
	}
	public int getMOV_TIME() {
		return MOV_TIME;
	}
	public void setMOV_TIME(int mOV_TIME) {
		MOV_TIME = mOV_TIME;
	}
	public String getMOV_RATING() {
		return MOV_RATING;
	}
	public void setMOV_RATING(String mOV_RATING) {
		MOV_RATING = mOV_RATING;
	}
	public String getMOV_STORY() {
		return MOV_STORY;
	}
	public void setMOV_STORY(String mOV_STORY) {
		MOV_STORY = mOV_STORY;
	}
	public String getMOV_POSTER() {
		return MOV_POSTER;
	}
	public void setMOV_POSTER(String mOV_POSTER) {
		MOV_POSTER = mOV_POSTER;
	}
	
	
	
}
