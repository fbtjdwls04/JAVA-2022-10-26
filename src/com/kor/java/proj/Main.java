package com.kor.java.proj;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("=== 프로그램 시작 ===");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("명령어를 입력해주세요 : ");
		String command = sc.nextLine();
		
		System.out.printf("입력된 명령어 : %s\n",command);
	
		sc.close();
		System.out.println("=== 프로그램 끝 ===");
		
	}
}
