package com.kor.java.proj.service;

import com.kor.java.proj.container.Container;
import com.kor.java.proj.dao.MemberDao;
import com.kor.java.proj.dto.Member;

public class MemberService {
	private MemberDao memberDao;
	public MemberService() {
		this.memberDao = Container.memberDao;
	}
	public int getUserId() {
		return memberDao.getUserId();
	}
	public void add(Member 저장) {
		memberDao.add(저장);
	}
	public Member foundId(String userId) {
		return memberDao.foundId(userId);
	}
}
