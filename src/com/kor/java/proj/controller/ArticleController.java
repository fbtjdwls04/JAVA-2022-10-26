package com.kor.java.proj.controller;

import java.util.Scanner;

import com.kor.java.proj.container.Container;
import com.kor.java.proj.dto.Article;
import com.kor.java.proj.service.ArticleService;
import com.kor.java.proj.service.MemberService;
import com.kor.java.proj.util.Util;

public class ArticleController extends Controller {
	private ArticleService articleService;
	private MemberService memberService;
	private Scanner sc;
	private String command;
	private String command2;

	public ArticleController(Scanner sc) {
		this.sc = sc;
		articleService = Container.articleService;
		memberService = Container.memberService;
		
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
		default:
			System.out.printf("%s(은)는 존재하지 않는 명령어 입니다.\n", command);
			break;
		}
	}

	// ========================================================================//
	private void doWrite() {
		int id = articleService.getNewId();
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String text = sc.nextLine();
		System.out.printf("%d번 게시물이 작성 되었습니다.\n", id);
		Article 저장 = new Article(id, logInMember.userId, title, text, Util.nowDate());
		articleService.add(저장);
	}

	// ========================================================================//
	private void showList() {
		Article article;
		if (articleService.size() == 0) {
			System.out.println("게시물이 없습니다.");
			return;
		}
		for (int i = articleService.size() - 1; i >= 0; i--) {
			article = (Article) articleService.get(i);
			System.out.println(" 번호 |  제목  | 조회수 | 작성자 |");
			System.out.printf("%4d | %4s | %4d | %4s |\n", article.num, article.title,
					article.hit, article.userId);
		}
		return;
	}

	// ========================================================================//
	private void doDelete() {
		String[] Bit = command.split(" ");
		if (Bit.length == 2) {
			System.out.println("실행할 번호를 기입해주세요.");
			return;
		}
		int remove = Integer.parseInt(Bit[2]);
		
		int fi = articleService.foundIndex(remove);
		
		if (fi == -1) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n", remove);
			return;
		}
		Article article;
		article = (Article) articleService.get(fi);
		if (article.userId != logInMember.userId) {
			System.out.println("권한이 없습니다.");
			return;
		}
		articleService.remove(fi);
		System.out.printf("%d 번 게시물이 삭제되었습니다.\n", remove);
		return;
	}

	// ========================================================================//
	private void showDetail() {
		String[] Bit = command.split(" ");
		if (Bit.length == 2) {
			System.out.println("실행할 번호를 기입해주세요.");
			return;
		}
		int detail = Integer.parseInt(Bit[2]);

		int fi = articleService.foundIndex(detail);

		if (fi == -1) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n", detail);
			return;
		}
		Article article;
		article = (Article) articleService.get(fi);
		article.hitUp();
		System.out.printf("번호	: %d\n", article.num);
		System.out.printf("날짜 	: %s\n", article.date);
		System.out.printf("작성자	: %s\n", article.userId);
		System.out.printf("제목	: %s\n", article.title);
		System.out.printf("내용	: %s\n", article.text);
		System.out.printf("조회수	: %d\n", article.hit);

	}

	// ========================================================================//
	private void doModify() {

		String[] Bit = command.split(" ");
		if (Bit.length == 2) {
			System.out.println("실행할 번호를 기입해주세요.");
			return;
		}
		int modify = Integer.parseInt(Bit[2]);
		int fi = articleService.foundIndex(modify);
		if (fi == -1) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n", modify);
			return;
		}
		Article article;
		article = (Article) articleService.get(fi);
		if (article.userId != logInMember.userId) {
			System.out.println("권한이 없습니다.");
			return;
		}
		System.out.print("제목 : ");
		article.title = sc.nextLine();
		System.out.print("내용 : ");
		article.text = sc.nextLine();
		System.out.printf("%d번 게시물이 수정 되었습니다.\n", modify);
		return;
	}

	// ========================================================================//

	public void TestArticle() {
		articleService.add(new Article(1, "admin", "Test", "Test", Util.nowDate()));
		articleService.add(new Article(2, "admin", "Test", "Test", Util.nowDate()));
		articleService.add(new Article(3, "admin", "Test", "Test", Util.nowDate()));
	}
}
