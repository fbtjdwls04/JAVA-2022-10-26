package com.kor.java.proj.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kor.java.proj.dto.Article;
import com.kor.java.proj.util.Util;

public class ArticleController extends Controller {
	private List<Article> articles;
	private Scanner sc;
	int num = 1;
	String command;
	String command2;

	public ArticleController(Scanner sc) {
		this.sc = sc;
		this.articles = new ArrayList<>();
	}

	public void doAction(String command, String command2) {
		
		this.command = command;
		this.command2 = command2;
		switch (command2) {
		case "write":
			doWrite();
			break;
		case "list":
			showList();
			break;
		case "delete":
			doDelete();
			break;
		case "detail":
			showDetail();
			break;
		case "modify":
			doModify();
			break;
		case "sort":
			doSort();
			break;
		default:
			System.out.printf("%s(은)는 존재하지 않는 명령어 입니다.\n", command);
			break;
		}
	}

	// ========================================================================//
	private void doWrite() {
		if(logStatus == false) {
			System.out.println("로그인 후 사용가능합니다.");
			return;
		}
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String text = sc.nextLine();
		System.out.printf("%d번 게시물이 작성 되었습니다.\n", num);
		Article 저장 = new Article(num,logInMember.userId ,title, text, Util.nowDate());
		articles.add(저장);
		num++;
	}

	// ========================================================================//
	private void showList() {
		if (articles.size() == 0) {
			System.out.println("게시물이 없습니다.");
			return;
		}
		for (int i = articles.size() - 1; i >= 0; i--) {
			System.out.println(" 번호 |  제목  | 조회수 | 작성자 |");
			System.out.printf("%4d | %4s | %4d | %4s |\n", articles.get(i).num, articles.get(i).title, articles.get(i).hit,articles.get(i).userId);
		}
		return;
	}

	// ========================================================================//
	private void doDelete() {
		String[] Bit = command.split(" ");
		if(Bit.length == 2) {
			System.out.println("실행할 번호를 기입해주세요.");
			return;
		}
		int remove = Integer.parseInt(Bit[2]);

		int fi = foundIndex(remove);

		if (fi == -1) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n", remove);
			return;
		}
		if(logStatus) {
			if(articles.get(fi).userId.equals(logInMember.userId)) {
				articles.remove(fi);
				System.out.printf("%d 번 게시물이 삭제되었습니다.\n", remove);
				return;
			}
		}
		System.out.println("권한이 없습니다.");
		return;
	}

	// ========================================================================//
	private void showDetail() {
		String[] Bit = command.split(" ");
		if(Bit.length == 2) {
			System.out.println("실행할 번호를 기입해주세요.");
			return;
		}
		int detail = Integer.parseInt(Bit[2]);

		int fi = foundIndex(detail);

		if (fi == -1) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n", detail);
			return;
		}
		articles.get(fi).hit++;
		System.out.printf("번호	: %d\n", articles.get(fi).num);
		System.out.printf("날짜 	: %s\n", articles.get(fi).date);
		System.out.printf("작성자	: %s\n",articles.get(fi).userId);
		System.out.printf("제목	: %s\n", articles.get(fi).title);
		System.out.printf("내용	: %s\n", articles.get(fi).text);
		System.out.printf("조회수	: %d\n", articles.get(fi).hit);

	}

	// ========================================================================//
	private void doModify() {
		
		String[] Bit = command.split(" ");
		if(Bit.length == 2) {
			System.out.println("실행할 번호를 기입해주세요.");
			return;
		}
		int modify = Integer.parseInt(Bit[2]);
		int fi = foundIndex(modify);
		if (fi == -1) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n", modify);
			return;
		}
		if(logStatus) {
			if(articles.get(fi).userId.equals(logInMember.userId)) {
				System.out.print("제목 : ");
				articles.get(fi).title = sc.nextLine();
				System.out.print("내용 : ");
				articles.get(fi).text = sc.nextLine();
				System.out.printf("%d번 게시물이 수정 되었습니다.\n", modify);
				return;
			}
		}
		System.out.println("권한이 없습니다.");
		return;
	}

	// ========================================================================//
	private void doSort() {
		if (articles.size() == 0) {
			System.out.println("게시물이 존재하지 않습니다.");
			return;
		}
		for (int i = 0; i < articles.size(); i++) {
			articles.get(i).num = i + 1;
		}
		num = articles.size() + 1;
		System.out.println("게시물이 정렬되었습니다.");
	}

	// ========================================================================//
	private int foundIndex(int a) {
		int fi = -1;
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).num == a) {
				fi = i;
				return fi;
			}
		}
		return fi;
	}
}
