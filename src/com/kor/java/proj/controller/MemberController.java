package com.kor.java.proj.controller;

import java.util.List;
import java.util.Scanner;

import com.kor.java.proj.dto.Member;
import com.kor.java.proj.util.Util;

public class MemberController {
	private Scanner sc;
	private List<Member> members;
	
	public MemberController(Scanner sc, List<Member> members) {
		this.sc = sc;
		this.members = members;
	}
	
	public void doJoin() {
		String userId;
		String passWord;
		String passWord2;
		int userNum = members.size() + 1;
		while(true) {
			System.out.print("아이디 : ");
			userId = sc.nextLine();
			if(foundId(userId) != null) {
				System.out.printf("%s(은)는 이미 사용중인 아이디 입니다.\n",userId);
				continue;
			}
			break;
		}
		System.out.print("비밀번호 : ");
		passWord = sc.nextLine();
		while(true) {
			System.out.print("비밀번호 확인: ");
			passWord2 = sc.nextLine();
			if(passWord.equals(passWord2) == false) {
				System.out.println("비밀번호를 다시 확인해주세요.");
				continue;
			}
			break;
		}
		System.out.printf("계정이 생성 되었습니다.\n");
		Member 저장 = new Member(userNum, userId, passWord, Util.nowDate());
		members.add(저장);
		userNum++;
	}
	private Member foundId(String a) {
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).userId.equals(a)) {
				return members.get(i);
			}
		}
		return null;
	}
}
