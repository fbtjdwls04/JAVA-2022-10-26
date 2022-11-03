package com.kor.java.proj.controller;

import java.util.List;
import java.util.Scanner;

import com.kor.java.proj.dto.Article;
import com.kor.java.proj.util.Util;

public class ArticleController {
	
	int num = 1;
	private Scanner sc;
	private List<Article> articles;
	
	public ArticleController(Scanner sc, List<Article> articles){
		this.sc = sc;
		this.articles = articles;
	}
	public void doWrite() {
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String text = sc.nextLine();
		System.out.printf("%d번 게시물이 작성 되었습니다.\n", num);
		Article 저장 = new Article(num, title, text, Util.nowDate());
		articles.add(저장);
		num++;
	}
	public void doList() {
		if (articles.size() == 0) {
			System.out.println("게시물이 없습니다.");
		}
		for (int i = articles.size() - 1; i >= 0; i--) {
			System.out.println(" 번호 |  제목  | 조회수 |");
			System.out.printf("%4d | %4s | %4d |\n",articles.get(i).num,articles.get(i).title,articles.get(i).hit);
		}
	}
	public void doDelete(String s2) {
		int remove = Integer.parseInt(s2);
		
		int fi = foundIndex(remove);
		
		if(fi == -1) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n",remove);
		}
		else {
			articles.remove(fi);
			System.out.printf("%d 번 게시물이 삭제되었습니다.\n",remove);
		}
	}
	public void doDetail(String s2) {
		int detail = Integer.parseInt(s2);
		
		int fi = foundIndex(detail);
		
		if(fi == -1) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n",detail);
		}
		else {
			articles.get(fi).hit++;
			System.out.printf("번호 : %d\n",articles.get(fi).num);
			System.out.printf("날짜 : %s\n",articles.get(fi).date);
			System.out.printf("제목 : %s\n",articles.get(fi).title);
			System.out.printf("내용 : %s\n",articles.get(fi).text);
			System.out.printf("조회수: %d\n",articles.get(fi).hit);
			
		}
	}
	public void doModify(String s2) {
		int modify = Integer.parseInt(s2);
		
		int fi = foundIndex(modify);
		
		if(fi == -1) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n",modify);
		}
		else {
			System.out.print("제목 : ");
			articles.get(fi).title = sc.nextLine();
			System.out.print("내용 : ");
			articles.get(fi).text = sc.nextLine();
			System.out.printf("%d번 게시물이 수정 되었습니다.\n", modify);
		}
	}
	public void doSort() {
		if(articles.size()==0) {
			System.out.println("게시물이 존재하지 않습니다.");
		}
		else {
			for(int i= 0; i < articles.size(); i++) {
				articles.get(i).num = i+1;
			}
			num = articles.size() +1;
			System.out.println("게시물이 정렬되었습니다.");
		}
	}
	public void doHelp() {
		System.out.println("====================================");
		System.out.println("sign up = 회원 가입");
		System.out.println("article write = 게시글 작성하기");
		System.out.println("article detail (번호) = 게시글 디테일 확인");
		System.out.println("article delete (번호) = 게시글 삭제하기");
		System.out.println("article list = 게시글 목록 간소화 전체보기");
		System.out.println("article number sort = 게시글 번호 정렬 (빈 번호 채우기)");
		System.out.println("ex, exit = 프로그램 종료");
		System.out.println("====================================");
	}
	//========================================================================//
	private int foundIndex(int a) {
		int fi = -1;
		for(int i = 0; i < articles.size(); i++) {
			if(articles.get(i).num == a) {
				fi = i;
				return fi;
			}
		}
		return fi;
	}
}
