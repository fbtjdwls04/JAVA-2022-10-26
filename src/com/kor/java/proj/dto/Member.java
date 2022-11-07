package com.kor.java.proj.dto;

public class Member extends Dto{
	public String passWord;
	public String userName;
	public Member(int num, String userId, String passWord, String userName ,String date) {
		this.num = num;
		this.userId = userId;
		this.passWord = passWord;
		this.userName = userName;
		this.date = date;
	}
}
