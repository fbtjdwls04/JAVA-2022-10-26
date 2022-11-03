package com.kor.java.proj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kor.java.proj.controller.ArticleController;
import com.kor.java.proj.controller.MemberController;
import com.kor.java.proj.dto.Article;
import com.kor.java.proj.dto.Member;

public class App {
	public List<Article> articles;
	public List<Member> members;
	public App() {
		articles = new ArrayList();
		members = new ArrayList();
	}
	public void start() {
		Scanner sc = new Scanner(System.in);
		MemberController mc = new MemberController(sc, members);
		ArticleController ac = new ArticleController(sc, articles);
		
		System.out.println("======== 프로그램 시작 ========");
		while (true) {
			System.out.print("명령어) ");
			String command = sc.nextLine();
			command = command.trim();
			if (command.length() == 0) {
				continue;
			}
			if (command.equals("exit") || command.equals("ex")) {  // 프로그램 종료
				break;
			} 
			else if(command.equals("sign up")) {
				mc.doJoin();
			}
			else if(command.equals("help")) {					// 명령어 도움말
				ac.doHelp();
			}
			
			else if (command.equals("article write")) {	// 게시물 작성
				ac.doWrite();
			} 
			else if (command.equals("article list")) {	// 게시물 리스트 (번호, 제목)
				ac.doList();
			}
			
			else if(command.startsWith("article delete ")) {	 // 게시물 삭제
				String[] s = command.split(" ");
				ac.doDelete(s[2]);
			}
			
			else if(command.startsWith("article detail ")) { 	// 게시물 디테일
				String[] s = command.split(" ");
				ac.doDetail(s[2]);
			}
			
			else if(command.startsWith("article modify ")) {
				String[] s = command.split(" ");
				ac.doModify(s[2]);
			}
			
			else if (command.equals("article number sort")) {	// 게시글 번호 정렬(빈 번호 채우기)
				ac.doSort();
			}
			
			else {
				System.out.printf("%s(은)는 존재하지 않는 명령어 입니다.\n", command);
			}

		}
		sc.close();
		System.out.println("======== 프로그램 종료 ========");
	}
}
