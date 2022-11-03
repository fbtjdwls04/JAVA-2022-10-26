package com.kor.java.proj.dto;

public class Member extends Dto{
	public String userId;
	public String passWord;
	public Member(int num, String userId, String passWord, String date) {
		this.num = num;
		this.userId = userId;
		this.passWord = passWord;
		this.date = date;
	}
}
