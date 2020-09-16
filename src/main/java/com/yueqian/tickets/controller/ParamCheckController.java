package com.yueqian.tickets.controller;

public class ParamCheckController {
	
	/**
	 * 字符串校验
	 */
	public boolean isEmptyStr(String ... strArray) {
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
	
	/**
	 * 字符串长度校验
	 */
	public boolean isAllowStrLength(String str, int minLen, int maxLen) {
		if(str == null) {
			return false;
		}
		if(str.length() >= minLen && str.length() <= maxLen) {
			return true;
		}
		return false;
		
	}

}
