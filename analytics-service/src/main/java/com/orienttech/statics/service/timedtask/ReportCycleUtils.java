/**
 * 报送周期工具类
 * @author gph
 */
package com.orienttech.statics.service.timedtask;

import java.util.Calendar;
import com.orienttech.statics.commons.utils.CommonHelper;

public class ReportCycleUtils {
	/*
	 * 年报：规定每年的12-25是报送日 /半年报：规定每年的06-25，12-25是报送日
	 * 季报：规定每年的02-25,05-25,08-25,11-25是报送日 /月报：规定每月的25号是报送日
	 * 旬报：规定每月的上旬5号、中旬15号、下旬25号是报送日 /周报：每周三报送 /一次性报：报送一次结束，手动触发
	 */
	public static final String YEAR_REPORT = "12-25";// 年报
	public static final String HARF_REPORT = "06-25,12-25";// 半年报
	public static final String SEASON_REPORT = "02-25,05-25,08-25,11-25";// 季报
	public static final String MONTH_REPORT = "25";// 月报
	public static final String TEN_REPORT = "5,15,25";// 旬报

	public static final int DAYVAL = 5;// 增加天数

	/**
	 * 获取年报开始时间和结束时间
	 * 
	 * @return String['开始时间','结束时间']
	 */
	public static String[] getYearStartEndTime() {
		String[] strDate = new String[2];
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		c.set(Calendar.DAY_OF_YEAR, 1);// 本年第一天
		strDate[0] = CommonHelper.date2Str(c.getTime(), CommonHelper.DF_DATE);

		c.add(Calendar.YEAR, 1);// 本月最后一天
		c.set(Calendar.DAY_OF_YEAR, 1);
		c.add(Calendar.DAY_OF_YEAR, -1);
		strDate[1] = String.valueOf(year).concat("-")
				.concat(CommonHelper.date2Str(c.getTime(), "MM-dd"));
		return strDate;
	}

	/**
	 * 获取半年报的开始时间和结束时间
	 * 
	 * @return String['开始时间','结束时间']
	 */
	public static String[] getHalfYearStartEndTime() {
		String[] strDate = new String[2];
		Calendar c = Calendar.getInstance();
		if ((c.get(Calendar.MONTH) + 1) == 6) {// 上半年
			strDate[0] = String.valueOf(c.get(Calendar.YEAR)).concat("-01-01");// 上半年的开始时间
		} else if ((c.get(Calendar.MONTH) + 1) == 12) {// 下半年
			strDate[0] = String.valueOf(c.get(Calendar.YEAR)).concat("-06-30");// 下半年的开始时间
		}
		strDate[1] = CommonHelper.date2Str(
				CommonHelper.addDay(c.getTime(), DAYVAL), CommonHelper.DF_DATE);// 上/下半年的结束时间
		return strDate;
	}

	/**
	 * 获取季报的开始时间和结束时间
	 * 
	 * @return String['开始时间','结束时间']
	 */
	public static String[] getSeasonReportStartEndTime() {
		String[] strDate = new String[2];
		Calendar c = Calendar.getInstance();
		if ((c.get(Calendar.MONTH) + 1) == 2) {// 第一季度
			strDate[0] = String.valueOf(c.get(Calendar.YEAR)).concat("-01-01");// 开始时间
			strDate[1] = String.valueOf(c.get(Calendar.YEAR)).concat("-03-31");// 开始时间
		} else if ((c.get(Calendar.MONTH) + 1) == 5) {// 第二季度
			strDate[0] = String.valueOf(c.get(Calendar.YEAR)).concat("-04-01");// 开始时间
			strDate[1] = String.valueOf(c.get(Calendar.YEAR)).concat("-06-30");// 开始时间
		} else if ((c.get(Calendar.MONTH) + 1) == 8) {// 第三季度
			strDate[0] = String.valueOf(c.get(Calendar.YEAR)).concat("-07-01");// 开始时间
			strDate[1] = String.valueOf(c.get(Calendar.YEAR)).concat("-09-30");// 开始时间
		} else if ((c.get(Calendar.MONTH) + 1) == 11) {// 第四季度
			strDate[0] = String.valueOf(c.get(Calendar.YEAR)).concat("-10-31");// 开始时间
			strDate[1] = String.valueOf(c.get(Calendar.YEAR)).concat("-12-31");// 开始时间
		}
		return strDate;
	}

	/**
	 * 获取月报的开始时间和结束时间
	 * 
	 * @return String['开始时间','结束时间']
	 */
	public static String[] getMonthReportStartEndTime() {
		String[] strDate = new String[2];
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);// //本月第一天
		strDate[0] = CommonHelper.date2Str(c.getTime(), CommonHelper.DF_DATE);

		c.add(Calendar.MONTH, 1);// 本月最后一天
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		strDate[1] = CommonHelper.date2Str(c.getTime(), CommonHelper.DF_DATE);
		return strDate;
	}

	/**
	 * 获取旬报的开始时间和结束时间
	 * 
	 * @return String['开始时间','结束时间']
	 */
	public static String[] getTenDayReportStartEndTime() {
		String[] strDate = new String[2];
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		if (date == 5) {// 上旬
			strDate[0] = year + "-" + month + "-01";
			strDate[1] = year + "-" + month + "-10";
		} else if (date == 15) {// 中旬
			strDate[0] = year + "-" + month + "-11";
			strDate[1] = year + "-" + month + "-20";
		} else if (date == 25) {// 下旬
			c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));// 设置本月最大天数
			strDate[0] = year + "-" + month + "-20";
			strDate[1] = year + "-" + month + "-" + c.get(Calendar.DATE);
		}
		return strDate;
	}

	/**
	 * 获取周报的开始时间和结束时间
	 * 
	 * @return String['开始时间','结束时间']
	 */
	public static String[] getWeekReportStartEndTime() {
		String[] strDate = new String[2];
		Calendar c = Calendar.getInstance();

		c.set(Calendar.DAY_OF_WEEK, 1);// 本周第一天，以星期日开始
		strDate[0] = CommonHelper.date2Str(c.getTime(), CommonHelper.DF_DATE);

		c.set(Calendar.DAY_OF_WEEK, 7);// 本周最后一天
		strDate[1] = CommonHelper.date2Str(c.getTime(), CommonHelper.DF_DATE);

		return strDate;
	}

	/**
	 * 获取一次性报的开始时间和结束时间
	 * TODO
	 * @return String['开始时间','结束时间']
	 */
	public static String[] getOneReportStartEndTime() {
		String[] strDate = new String[2];
		Calendar c = Calendar.getInstance();
		//TODO
		strDate[0] = CommonHelper.date2Str(c.getTime(), CommonHelper.DF_DATE);
		strDate[1] = CommonHelper.date2Str(CommonHelper.addDay(c.getTime(), 0),
				CommonHelper.DF_DATE);

		return strDate;
	}

	/**
	 * 获取开始时间
	 * 
	 * @param cycle
	 *            报表周期
	 * @param index
	 *            下标：0取开始时间；1取结束时间
	 * @return 开始时间/结束时间
	 */
	public static String getReportTime(String cycle, int index) {
		switch (Integer.parseInt(cycle)) {
		case 2:// 年报
			return getYearStartEndTime()[index];
		case 3:// 半年报
			return getHalfYearStartEndTime()[index];
		case 4:// 季报
			return getSeasonReportStartEndTime()[index];
		case 5:// 月报
			return getMonthReportStartEndTime()[index];
		case 6:// 旬报
			return getTenDayReportStartEndTime()[index];
		case 7:// 周报
			return getWeekReportStartEndTime()[index];
		default:// 一次性报
			return getOneReportStartEndTime()[index];
		}
	}
	
	public static void main(String[] args) {
		System.out.println(ReportCycleUtils.getReportTime("2", 1));
	}
}
