package com.kor.java.proj;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("=== 프로그램 시작 ===");
		Scanner sc = new Scanner(System.in);
		
		String command;
		String title;
		int num = 1;
		while(true) {
			System.out.print("명령어를 입력해주세요 : ");
			command = sc.nextLine();
			command = command.trim();
			if(command.length() == 0) {
				continue;
			}
			if(command.equals("system exit")) {
				break;
			}
			else if(command.equals("article write")) {
				System.out.print("제목 : ");
				title = sc.nextLine();
				System.out.print("내용 : ");
				title = sc.nextLine();
				System.out.printf("%d번 글이 생성되었습니다.\n",num);
				num++;
				
			}
			else if(command.equals("article list")) {
				System.out.println("게시물이 없습니다.");
			}
			else {
				System.out.printf("%s(은)는 존재하지 않는 명령어 입니다.\n",command);
			}
		}
	
		sc.close();
		System.out.println("=== 프로그램 끝 ===");
		
	}
}
