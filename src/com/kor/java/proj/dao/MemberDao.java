package com.kor.java.proj.dao;

import java.util.ArrayList;
import java.util.List;

import com.kor.java.proj.dto.Member;

public class MemberDao extends Dao {
	public List<Member> members;

	public MemberDao(){
		members = new ArrayList<>();
	}

	public void add(Member 저장) {
		members.add(저장);
		lastMemberId = 저장.num;
	}
	public Member foundId(String a) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).userId.equals(a)) {
				return members.get(i);
			}
		}
		return null;
	}
}
