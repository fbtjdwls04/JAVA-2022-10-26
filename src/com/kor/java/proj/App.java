package com.kor.java.proj;

import java.util.Scanner;

import com.kor.java.proj.controller.ArticleController;
import com.kor.java.proj.controller.Controller;
import com.kor.java.proj.controller.ExportController;
import com.kor.java.proj.controller.MemberController;

public class App {
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		MemberController mc = new MemberController(sc);
		ArticleController ac = new ArticleController(sc);
		ExportController ec = new ExportController(sc);
		
		mc.admin();
		ac.TestArticle();
		
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
			String[] commandSplit = command.split(" ");
			Controller ct = null;
			if(commandSplit.length == 1) {
				System.out.printf("%s(은)는 존재하지 않는 명령어 입니다.\n", command);
				continue;
			}
			
			if(commandSplit[0].equals("article")) {
				ct = ac;
			}else if(commandSplit[0].equals("member")) {
				ct = mc;
			}else if(commandSplit[0].equals("export")) {
				ct = ec;
			}
			else {
				System.out.printf("%s(은)는 존재하지 않는 명령어 입니다.\n", command);
				continue;
			}

			String logCommand = commandSplit[0] + " " + commandSplit[1];
			switch(logCommand) {
			case "article write":
			case "article delete":
			case "article modify":
			case "member logout":
				if(ct.logStatus == false) {
					System.out.println("로그인이 필요합니다.");
					continue;
				}
			}
			switch(logCommand) {
			case "member login":
			case "member join":
				if(ct.logStatus) {
					System.out.println("로그아웃 후에 이용해주세요.");
					continue;
				}
			}
			
			ct.doAction(command, commandSplit[1]);
		}
		sc.close();
		System.out.println("======== 프로그램 종료 ========");
	}
}
