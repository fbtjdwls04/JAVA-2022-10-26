package com.kor.java.proj.controller;

import com.kor.java.proj.dto.Member;

public abstract class Controller {
	public static boolean logStatus = false;
	public static Member logInMember = null;

	public abstract void doAction(String command, String command2);
}
