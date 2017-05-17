package com.orienttech.statics.commons.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;


/**
 *	通用辅助类
 * @author AcoreHeng
 */
public final class CommonHelper {
	public final static String DF_DATE_TIME="yyyy-MM-dd HH:mm:ss";
	public final static String DF_DATE_SHORT_TIME="yyyy-MM-dd HH:mm";
	public final static String DF_DATE="yyyy-MM-dd";
	public final static String DF_TIME="HH:mm:ss";
	private static Map<String, DateFormat> DF_MAP;
	static{
		DF_MAP=new HashMap<String, DateFormat>();
		DF_MAP.put(DF_DATE, new SimpleDateFormat(DF_DATE));
		DF_MAP.put(DF_DATE_SHORT_TIME, new SimpleDateFormat(DF_DATE_SHORT_TIME));
		DF_MAP.put(DF_DATE_TIME, new SimpleDateFormat(DF_DATE_TIME));
	}
	//TODO String
	/**
	 * 判断字符串不能是null、""、"null"(忽略大小写)
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str){
		return StringUtils.isNoneBlank(str)&&!"null".equalsIgnoreCase(str);
	}
	/**
	 * Object转String
	 * @param obj
	 * @return
	 */
	public static String toStr(Object obj){
		if(obj==null){
			return null;
		}
		return String.valueOf(obj);
	}
	//TODO Long
	/**
	 * Object转Long
	 * @param obj
	 * @return
	 */
	public static Long toLong(Object obj){
		if(obj==null){
			return null;
		}
		if(obj instanceof BigDecimal){
			return ((BigDecimal)obj).longValue();
		}
		if(obj instanceof String){
			return Long.parseLong(String.valueOf(obj));
		}
		return (Long)obj;
	}
	
	/**
	 * Object转Int
	 * @param obj
	 * @return
	 */
	public static Integer toInt(Object obj){
		if(obj==null){
			return null;
		}
		if(obj instanceof BigDecimal){
			return ((BigDecimal)obj).intValue();
		}
		if(obj instanceof String){
			return Integer.parseInt(String.valueOf(obj));
		}
		return (Integer)obj;
	}
	/**
	 * Object转Int
	 * @param obj
	 * @return
	 */
	public static Integer toInt(Object obj,int defaultVal){
		Integer val=toInt(obj);
		return val!=null?val:0;
	}
	/**
	 * Object转BigDecimal
	 * @param obj
	 * @return
	 */
	public static BigDecimal toBigDecimal(Object obj){
		if(obj==null){
			return null;
		}
		if(obj instanceof String){
			String str=toStr(obj);
			if(StringUtils.isBlank(str)){
				return null;
			}
			return new BigDecimal(toStr(obj));
		}
		if(obj instanceof Integer){
			return new BigDecimal(toStr(obj));
		}
		return (BigDecimal)obj;
	}
	/**
	 * String转BigDecimal
	 * @param str
	 * @return
	 */
	public static BigDecimal str2BigDecimal(String str){
		if(str==null){
			return BigDecimal.ZERO;
		}
		if(str instanceof String){
			return new BigDecimal(toStr(str));
		}
		return null;
	}
	
	//TODO Date
	/**
	 * 获取系统当前时间
	 * @return
	 */
	public static Date getNow(){
		return new Date();
	}
	/**
	 * 获取指定格式DateFormat
	 * @param format
	 * @return
	 */
	public static DateFormat getDateFormat(String format){
		if(StringUtils.isBlank(format)){
			return null;
		}
		DateFormat df=DF_MAP.get(format);
		if(df==null){
			df=new SimpleDateFormat(format);
		}
		return df;
	}
	/**
	 * 格式化日期为指定格式
	 * @param date
	 * @param format
	 * @return
	 */
	public static  Date formatDate(final Date date,String format){
		if(date==null){
			return null;
		}
		if(StringUtils.isBlank(format)){
			return date;
		}
		Date temp_date=null;
		try {
			DateFormat df=getDateFormat(format);
			temp_date=df.parse(df.format(date));
		} catch (ParseException e) {
			//e.printStackTrace();
		}
		return temp_date;
	}
	/**
	 * 将日期转换为指定格式的字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2Str(Date date,String format){
		if(date==null||StringUtils.isBlank(format)){
			return null;
		}
		DateFormat df=getDateFormat(format);
		return df.format(date);
	}
	/**
	 * 将日期字符串按照指定格式转换为date
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date str2Date(String dateStr,String format){
		if(StringUtils.isBlank(dateStr)||StringUtils.isBlank(format)){
			return null;
		}
		try {
			DateFormat df=getDateFormat(format);
			return df.parse(dateStr);
		} catch (ParseException e) {
			//e.printStackTrace();
		}
		return null;
	}
	/**
	 * 增加指定月份
	 * @param date
	 * @param monthVal
	 * @return
	 */
	public static Date addMonth(Date date,int monthVal){
		Calendar c	=Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, monthVal);
		return c.getTime();
	}
	
	/**
	 * 增加指定天数
	 * @param date
	 * @param monthVal
	 * @return
	 */
	public static Date addDay(Date date,int dayVal){
		Calendar c	=Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, dayVal);
		return c.getTime();
	}
	
	//TODO　test
	public static void main(String[] args) {
		/*System.out.println(date2Str(getNow(), "yyyy-MM-dd HH:mm:ss"));
		System.out.println(str2BigDecimal("sdf"));*/
//		System.out.println(CommonHelper.date2Str(CommonHelper.getNow(), "yyyy/MMdd"));
		
		StringBuffer sb = new StringBuffer();
		sb.append("aa,bb,cc,dd,");
		System.out.println(sb.append(StringUtils.substringBeforeLast(sb.toString(), ",")).append("&"));;
	}
}
