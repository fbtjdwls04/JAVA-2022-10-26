package com.kor.java.proj.controller;

import java.util.Scanner;

import com.kor.java.proj.container.Container;
import com.kor.java.proj.service.ExportService;

public class ExportController extends Controller {
	private Scanner sc;
	private String command;
	private String command2;
	private ExportService exportService;

	public ExportController(Scanner sc) {
		this.sc = sc;
		exportService = Container.exportService;
	}

	public void doAction(String command, String command2) {
		this.command = command;
		this.command2 = command2;
		switch (command2) {
		case "html":
			doHtml();
			break;
		default:
			System.out.println("존재하지 않는 명령어 입니다.");
			break;
		}

	}

	private void doHtml() {
		System.out.println("html을 생성합니다.");
		exportService.makeHtml();
	}
}
