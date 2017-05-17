package com.orienttech.statics.commons.utils;

import java.util.Calendar;

public class CalendarUtils {
	/**
     * 是否存在
     * @param file
     * @return
     */
    public static String getDateContents(){
    	Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DATE);
		String finalFlieContents = year+"/";
		if(month<10){
			finalFlieContents += "0"+month;
		}else{
			finalFlieContents += month;
		}
		if(day<10){
			finalFlieContents += "0"+day;
		}else{
			finalFlieContents += day;
		}
		return finalFlieContents+"/";
    }
     
}
