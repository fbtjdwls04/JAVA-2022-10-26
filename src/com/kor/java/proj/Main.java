package com.kor.java.proj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<게시판> arr = new ArrayList();
		String command;
		String title;
		String text;
		
		int num = 0;
		System.out.println("=== 프로그램 시작 ===");
		while(true) {
			System.out.print("명령어) ");
			command = sc.nextLine();
			command = command.trim();
			if(command.length() == 0){
				continue;
			}
			if(command.equals("exit")) {
				break;
			}
			else if(command.equals("article write")) {
				System.out.print("제목 : ");
				title = sc.nextLine();
				System.out.print("내용 : ");
				text = sc.nextLine();
				System.out.printf("%d번 게시물이 작성 되었습니다.\n",num+1);
				num++;
				게시판 저장 = new 게시판(num,title,text);
				arr.add(저장);
			}
			else if(command.equals("article list")) {
				if(arr.size() == 0) {
					System.out.println("게시물이 없습니다.");
				}
				else {
					for(int i = 0; i < arr.size(); i++) {
						System.out.printf("===(%s) %s ===\n",arr.get(i).num,arr.get(i).title);
						System.out.printf("%s\n",arr.get(i).text);
					}
				}
			}
			else {
				System.out.printf("%s(은)는 존재하지 않는 명령어 입니다.\n",command);
			}
			
		}
		System.out.println("=== 프로그램 종료 ===");
		
	}
}

class 게시판{
	int num;
	String title;
	String text;
	게시판(int num, String title, String text){
		this.num = num;
		this.title = title;
		this.text = text;
	}
}


