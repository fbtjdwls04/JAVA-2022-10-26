package com.kor.java.proj;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList<게시판> arr = new ArrayList();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String command;
		String title;
		String text;
		int num = 1;
		System.out.println("======== 프로그램 시작 ========");
		while (true) {
			System.out.print("명령어) ");
			command = sc.nextLine();
			command = command.trim();
			if (command.length() == 0) {
				continue;
			}
			if (command.equals("exit") || command.equals("ex")) {  // 프로그램 종료
				break;
			} 
			else if(command.equals("help")) {					// 명령어 도움말
				System.out.println("====================================");
				System.out.println("article write = 게시글 작성하기");
				System.out.println("article detail (번호) = 게시글 디테일 확인");
				System.out.println("article delete (번호) = 게시글 삭제하기");
				System.out.println("article list = 게시글 목록 간소화 전체보기");
				System.out.println("article number sort = 게시글 번호 정렬 (빈 번호 채우기)");
				System.out.println("ex, exit = 프로그램 종료");
				System.out.println("====================================");
				
			}
			else if (command.equals("article write")) {	// 게시물 작성
				System.out.print("제목 : ");
				title = sc.nextLine();
				System.out.print("내용 : ");
				text = sc.nextLine();
				System.out.printf("%d번 게시물이 작성 되었습니다.\n", num);
				게시판 저장 = new 게시판(num, title, text, Util.nowDate());
				arr.add(저장);
				num++;
			} 
			else if (command.equals("article list")) {	// 게시물 리스트 (번호, 제목)
				if (arr.size() == 0) {
					System.out.println("게시물이 없습니다.");
				}
				for (int i = arr.size() - 1; i >= 0; i--) {
					System.out.println(" 번호 |  제목  | 조회수 |");
					System.out.printf("%4d | %4s | %4d |\n",arr.get(i).num,arr.get(i).title,arr.get(i).hit);
				}
			}
			else if(command.startsWith("article delete ")) {	 // 게시물 삭제
				String[] s = command.split(" ");
				int remove = Integer.parseInt(s[2]);
				int fi = -1;
				for(int i = 0; i < arr.size(); i++) {
					if(arr.get(i).num == remove) {
						fi = i;
						break;
					}
				}
				if(fi == -1) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n",remove);
					continue;
				}
				arr.remove(fi);
				System.out.printf("%d 번 게시물이 삭제되었습니다.\n",remove);
			}
			else if(command.startsWith("article detail ")) { 	// 게시물 디테일
				String[] s = command.split(" ");
				int detail = Integer.parseInt(s[2]);
				int fi = -1;
				for(int i = 0; i < arr.size(); i++) {
					if(arr.get(i).num == detail) {
						fi = i;
						break;
					}
				}
				if(fi == -1) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n",detail);
					continue;
				}
				arr.get(fi).hit++;
				System.out.printf("번호 : %d\n",arr.get(fi).num);
				System.out.printf("날짜 : %s\n",arr.get(fi).date);
				System.out.printf("제목 : %s\n",arr.get(fi).title);
				System.out.printf("내용 : %s\n",arr.get(fi).text);
				System.out.printf("조회수: %d\n",arr.get(fi).hit);
			}
			else if(command.startsWith("article modify ")) {
				String[] s = command.split(" ");
				int modify = Integer.parseInt(s[2]);
				int fi = -1;
				for(int i = 0; i < arr.size(); i++) {
					if(arr.get(i).num == modify) {
						fi = i;
						break;
					}
				}
				if(fi == -1) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n",modify);
					continue;
				}
				System.out.print("제목 : ");
				arr.get(fi).title = sc.nextLine();
				System.out.print("내용 : ");
				arr.get(fi).text = sc.nextLine();
				System.out.printf("%d번 게시물이 수정 되었습니다.\n", modify);
				
			}
			else if (command.equals("article number sort")) {	// 게시글 번호 정렬(빈 번호 채우기)
				if(arr.size()==0) {
					System.out.println("게시물이 존재하지 않습니다.");
					continue;
				}
				for(int i= 0; i < arr.size(); i++) {
					arr.get(i).num = i+1;
				}
				System.out.println("게시물이 정렬되었습니다.");
			}
			else {
				System.out.printf("%s(은)는 존재하지 않는 명령어 입니다.\n", command);
			}

		}
		sc.close();
		System.out.println("======== 프로그램 종료 ========");
	}
}

class 게시판 {
	int num;
	String title;
	String text;
	String date;
	int hit;
	게시판(int num, String title, String text, String date) {
		this.num = num;
		this.title = title;
		this.text = text;
		this.date = date;
		this.hit = 0;
	}
}
