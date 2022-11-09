package com.kor.java.proj.dao;

public class Dao {
	protected int lastArticleId;
	protected int lastMemberId;
	public Dao(){
		lastArticleId = 0;
		lastMemberId = 0;
	}
	public int getNewId() {
		return lastArticleId + 1;
	}
	public int getUserId() {
		return lastMemberId + 1;
	}
}
