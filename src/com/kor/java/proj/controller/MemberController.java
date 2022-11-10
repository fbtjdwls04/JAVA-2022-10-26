package com.kor.java.proj.controller;

import java.util.Scanner;

import com.kor.java.proj.container.Container;
import com.kor.java.proj.dto.Member;
import com.kor.java.proj.service.MemberService;
import com.kor.java.proj.util.Util;

public class MemberController extends Controller {
	private Scanner sc;
	private MemberService memberService;
	private String command;
	private String command2;

	public MemberController(Scanner sc) {
		this.sc = sc;
		memberService = Container.memberService;
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
			System.out.printf("%s(은)는 존재하지 않는 명령어 입니다.\n", command);
			break;
		}
	}

	// ========================================================================//
	private void doLogout() {
		logStatus = false;
		logInMember = null;
		System.out.println("로그아웃 되었습니다.");
	}

	// ========================================================================//
	private void doLogIn() {
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String passWord = sc.nextLine();
		Member member = memberService.foundId(userId);
		if (member == null) {
			System.out.println("존재하지 않는 아이디 입니다.");
			return;
		}
		if (member.passWord.equals(passWord) == false) {
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		}
		System.out.printf("%s 님 환영합니다.\n", member.userName);
		logStatus = true;
		logInMember = member;
	}

	// ========================================================================//
	private void doJoin() {
		String userId;
		String passWord;
		String passWord2;
		String userName;
		int userNum = memberService.getUserId();
		Member member = null;
		while (true) {
			System.out.print("아이디 : ");
			userId = sc.nextLine();
			member = memberService.foundId(userId);
			if (member == null) {
				break;
			}
			System.out.printf("%s(은)는 이미 사용중인 아이디 입니다.\n", userId);
			continue;
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
		memberService.add(저장);
	}

	// ========================================================================//

	public void admin() {
		memberService.add(new Member(1, "admin", "admin", "admin", Util.nowDate()));
	}
}
