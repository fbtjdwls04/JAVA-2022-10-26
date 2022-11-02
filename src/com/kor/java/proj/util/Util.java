package com.kor.java.proj.util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Util {
	public static String nowDate() {
		Date date = new Date();
		SimpleDateFormat ndate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return ndate.format(date);
	}
}
