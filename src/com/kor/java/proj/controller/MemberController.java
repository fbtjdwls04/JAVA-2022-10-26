package com.kor.java.proj.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kor.java.proj.dto.Member;
import com.kor.java.proj.util.Util;

public class MemberController extends Controller {
	private Scanner sc;
	private List<Member> members;
	String command;
	String command2;
	
	public MemberController(Scanner sc) {
		this.sc = sc;
		this.members = new ArrayList<>();
	}
	
	public void doAction(String command, String command2) {
		this.command = command;
		this.command2 = command2;
		switch (command2) {
		case "join":
			doJoin();
			break;
		case "login":
			doLogIn();
			break;
		case "logout":
			doLogout();
			break;
		default:
			System.out.printf("%s(은)는 존재하지 않는 명령어 입니다.\n",command);
			break;
		}
	}
	// ========================================================================//
	private void doLogout() {
		if(logStatus == false) {
			System.out.println("로그인 상태가 아닙니다.");
			return;
		}
		logStatus = false;
		logInMember = null;
		System.out.println("로그아웃 되었습니다.");
	}
	// ========================================================================//
	private void doLogIn() {
		if(logStatus) {
			System.out.println("이미 로그인 상태입니다.");
			return;
		}
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String passWord = sc.nextLine();
		if (foundId(userId) == null) {
			System.out.println("존재하지 않는 아이디 입니다.");
			return;
		}
		if (foundId(userId).passWord.equals(passWord) == false) {
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		}
		System.out.printf("%s 님 환영합니다.\n", foundId(userId).userName);
		logStatus = true;
		logInMember = foundId(userId);
	}

	// ========================================================================//
	private void doJoin() {
		String userId;
		String passWord;
		String passWord2;
		String userName;
		int userNum = members.size() + 1;
		while (true) {
			System.out.print("아이디 : ");
			userId = sc.nextLine();
			if (foundId(userId) != null) {
				System.out.printf("%s(은)는 이미 사용중인 아이디 입니다.\n", userId);
				continue;
			}
			break;
		}
		System.out.print("비밀번호 : ");
		passWord = sc.nextLine();
		while (true) {
			System.out.print("비밀번호 확인: ");
			passWord2 = sc.nextLine();
			if (passWord.equals(passWord2) == false) {
				System.out.println("비밀번호를 다시 확인해주세요.");
				continue;
			}
			break;
		}
		System.out.print("이름 : ");
		userName = sc.nextLine();
		System.out.printf("계정이 생성 되었습니다.\n");
		
		Member 저장 = new Member(userNum, userId, passWord, userName, Util.nowDate());
		members.add(저장);
		userNum++;
	}

	// ========================================================================//
	private Member foundId(String a) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).userId.equals(a)) {
				return members.get(i);
			}
		}
		return null;
	}

	public void admin() {
		members.add(new Member(1, "admin", "admin", "admin", Util.nowDate()));
	}
}
