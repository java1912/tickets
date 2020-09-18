package com.yueqian.tickets.controller;

import org.springframework.util.StringUtils;

public class ParamCheckController {
	
	/**
	 * 字符串校验
	 */
	public boolean isEmptyStr(String ... strArray) {
		return StringUtils.isEmpty(strArray);
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
