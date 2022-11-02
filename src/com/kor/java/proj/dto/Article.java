package com.kor.java.proj.dto;

public class Article {
	public int num;
	public String title;
	public String text;
	public String date;
	public int hit;
	public Article(int num, String title, String text, String date) {
		this.num = num;
		this.title = title;
		this.text = text;
		this.date = date;
		this.hit = 0;
	}
}