package com.yueqian.tickets.util;

public class StringUtils {
	
	/**
	 * 字符空校验串校验
	 */
	public static boolean isEmptyStr(String ... strArray) {
		if(strArray == null || strArray.length == 0) {
			return true;
		}
		
		for (int i = 0; i < strArray.length; i++) {
			if(strArray[i] == null || strArray[i].length() == 0) {
				return true;
			}
		}
		
		return false;
	}
}
