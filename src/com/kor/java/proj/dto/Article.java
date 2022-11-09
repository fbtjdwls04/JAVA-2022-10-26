package com.kor.java.proj.dto;

public class Article extends Dto {
	public String title;
	public String text;
	public int hit;
	public Article(int num, String userId, String title, String text, String date) {
		this.num = num;
		this.userId = userId;
		this.title = title;
		this.text = text;
		this.date = date;
		this.hit = 0;
	}
	public void hitUp() {
		hit++;
	}
}