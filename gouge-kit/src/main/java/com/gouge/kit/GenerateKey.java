package com.gouge.kit;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Filename:     GenerateKey.java
 * Description:
 * Autor:        Grandfen.he
 * Version:      1.0
 * Create at:    Jan 20, 2015 12:08:35 PM
 * Modification History :
 * Date           Autor          Version      Description
 * ------------------------------------------------------
 * Jan 20, 2015   Grandfen.he     1.0
 */
public class GenerateKey {
	private static long sequence;
	private static String compareTime;
	
	public static String generate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		String currentTime = sdf.format(new Date());

		if (compareTime == null || compareTime.compareTo(currentTime) != 0) {
			compareTime = currentTime;
			sequence = 1;
		} else {
			sequence++;
		}
		
		StringBuffer key = new StringBuffer();
		key.append(currentTime);
		key.append(getNumToStr(sequence));
		
		return key.toString();
	}

	private static String getNumToStr(long num) {
		String numStr = "";
		if (num <= 9) {
			numStr = "0000" + String.valueOf(num);
		} else if (num < 99) {
			numStr = "000" + String.valueOf(num);
		} else {
			numStr = "0" + getRndToStr() + "99";
		}
		return numStr;
	}

	private static String getRndToStr() {
		java.util.Random r = new java.util.Random();
		String numStr = "";
		int num = r.nextInt(99);
		if (num <= 9) {
			numStr = "0" + String.valueOf(num);
		} else {
			numStr = String.valueOf(num);
		}
		return numStr;
	}
}
