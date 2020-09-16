package com.yueqian.tickets.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat sdfYMDStrLine = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdfYMDStrDiv = new SimpleDateFormat("yyyy/MM/dd");
	private static SimpleDateFormat sdfYmdHmsStrLine = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat sdfYmdHmsStrDiv = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	private static SimpleDateFormat sdfTimesFileName = new SimpleDateFormat("yyyyMMddHHmmss");
	
	private static SimpleDateFormat sdfDayStrDiv = new SimpleDateFormat("dd日");
	
	
	/**
	 * 根据日期返回 String，格式： yyyy-MM-dd
	 */
	public static String formatYMD2StrLine(Date date){
		return sdfYMDStrLine.format(date);
	}
	/**
	 * 根据日期返回一月中的某天，格式： dd日
	 */
	public static String formatDate2DayStr(Date date){
		return sdfDayStrDiv.format(date);
	}
	
	/**
	 * 得到文件名时间表示String
	 */
	public static String formatDate2FileName(Date date){
		return sdfTimesFileName.format(date);
	}
	
	/**
	 * 将yyyy-MM-dd 的字符串换位为日期
	 */
	public static Date parseDate2YMD(String date){
		try {
			return sdfYMDStrLine.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
