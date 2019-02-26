package com.sinaif.hoover.utils;


import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 *
 */
public class DateUtils {

	private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

	public enum DateFiled {
		YEAR, MONTH, DATE, HOUR, MINUTE
	}

	public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 指定日期格式yyyyMMddHHmmss
	 */
	public static final String DATE_FORMAT_1 = "yyyyMMddHHmmss";
	/**
	 * 指定日期格式 yyyy-MM-dd HH:mm:ss
	 */
	public static final String DATE_FORMAT_2 = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 指定日期格式 yyyy-MM-dd'T'HH:mm:ssZ
	 */
	public static final String DATE_FORMAT_3 = "yyyy-MM-dd'T'HH:mm:ssZ";

	/**
	 * 指定日期格式 yyyy-MM-dd
	 */
	public static final String DATE_FORMAT_4 = "yyyy-MM-dd";

	/**
	 * 指定日期格式 yyyy.M.d
	 */
	public static final String DATE_FORMAT_5 = "yyyy.M.d";

	/**
	 * 指定日期格式yyyy-MM-dd HH:mm
	 */
	public static final String DATE_FORMAT_6 = "yyyy-MM-dd HH:mm";

	/**
	 * 指定日期格式HH:mm
	 */
	public static final String DATE_FORMAT_7 = "HH:mm";

	/**
	 * 指定日期格式MM-dd HH:mm
	 */
	public static final String DATE_FORMAT_8 = "MM-dd HH:mm";

	/**
	 * 指定日期格式HH:mm:ss
	 */
	public static final String DATE_FORMAT_9 = "HH:mm:ss";

	/**
	 * 指定日期格式MM-dd
	 */
	public static final String DATE_FORMAT_10 = "MM-dd";

	/**
	 * 指定日期格式yy-MM-dd HH:mm
	 */
	public static final String DATE_FORMAT_11 = "yy-MM-dd HH:mm";

	/**
	 * 指定日期格式yyyyMMdd
	 */
	public static final String DATE_FORMAT_12 = "yyyyMMdd";

	/**
	 * 指定日期格式HHmmss
	 */
	public static final String DATE_FORMAT_13 = "HHmmss";

	/**
	 * 指定日期格式yyyyMMddHH
	 */
	public static final String DATE_FORMAT_14 = "yyyyMMddHH";

	/**
	 * 指定日期格式yyyyMMddHHmm
	 */
	public static final String DATE_FORMAT_15 = "yyyyMMddHHmm";

	/**
	 * 指定日期格式yyyyMM
	 */
	public static final String DATE_FORMAT_16 = "yyyyMM";

	/**
	 * 指定日期格式yyyy年MM月dd日
	 */
	public static final String DATE_FORMAT_17 = "yyyy年MM月dd日";

	/**
	 * 指定日期格式yyyy年MM月dd日
	 */
	public static final String DATE_FORMAT_18 = "yyyy/MM/dd HH:mm:ss";

	/**
	 * 日期排序类型-升序
	 */
	public final static int DATE_ORDER_ASC = 0;

	/**
	 * 日期排序类型-降序
	 */
	public final static int DATE_ORDER_DESC = 1;

	public static boolean isNight(Date date) {
		int hour = date.getHours();
		if (hour > 22 || hour < 5) {
			return true;
		}
		return false;
	}

	public static Date string2Date(String str) {
		return string2Date(str, DEFAULT_FORMAT);
	}

	public static Date string2Date(String dateStr, String format) {
		if (StringUtils.isEmpty(dateStr) || StringUtils.isEmpty(format) ) {
			return null;
		}
		Date date = null;
		try {
			date = FastDateFormat.getInstance(format).parse(dateStr);// Apache工具类
		} catch (Exception ex) {
			logger.error(String.format("程序异常：dateStr：%s，format：%s", dateStr, format), ex);
			date = null;
		}
		return date;
	}

	public static String dateToString(Date date) {
		return dateToString(date, DEFAULT_FORMAT);
	}

	public static String dateToString(Date date, String format) {
		if (date == null || StringUtils.isEmpty(format)) {
			return null;
		}
		String dateStr = null;
		try {
			dateStr = FastDateFormat.getInstance(format).format(date);// Apache工具类
		} catch (Exception ex) {

			logger.error(String.format("程序异常：date：%s，format：%s", date, format), ex);
			dateStr = null;
		}
		return dateStr;
	}

	/**
	 * 设置为某天的0点起始时刻，即：yyyy-MM-dd 00:00:00
	 * 
	 * @return
	 */
	public static Date getStartDate(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// 设置当前时刻的时钟为0
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		// 设置当前时刻的分钟为0
		calendar.set(Calendar.MINUTE, 0);
		// 设置当前时刻的秒钟为0
		calendar.set(Calendar.SECOND, 0);
		// 设置当前的毫秒钟为0
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 
	 * 设置为某天的24点结束时刻(其实就是下一天的0点)，即：yyyy-MM-dd 00:00:00
	 * 
	 * @return
	 */
	public static Date getEndDate(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		// 第1步：先设置为某天的0点时间
		calendar.setTime(getStartDate(date));
		// 第2步：把日期往后增加一天
		calendar.add(calendar.DATE, 1);
		return calendar.getTime();
	}

	/**
	 * 明天的此时此刻
	 * 
	 * @return
	 */
	public static Date nextDateByNow() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		// 把日期往后增加一天
		calendar.add(calendar.DATE, 1);
		return calendar.getTime();
	}

	/**
	 * 明天的此时此刻
	 * 
	 * @return
	 */
	public static String nextDateStrByNow(String format) {

		return dateToString(nextDateByNow(), format);
	}

	/**
	 * 下一月的此时此刻
	 * 
	 * @return
	 */
	public static Date nextMonthByNow() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		// 把日期往后增加一月
		calendar.add(calendar.MONTH, 1);
		return calendar.getTime();
	}

	/**
	 * 明年的此时此刻
	 * 
	 * @return
	 */
	public static Date nextYearByNow() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		// 把日期往后增加一年
		calendar.add(calendar.YEAR, 1);
		return calendar.getTime();
	}

	/**
	 * 获取还款日期<br>
	 * 借款日期是 x月y日，则还款日期是 (x+1)月(y-1)日<br>
	 * 注意：该算法月底借但不一定是下个月的月底还<br>
	 * 
	 * @return
	 */
	public static Date getRepayDayByNow(Date date) {
		if (date == null) {
			date = new Date();
		}
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(calendar.YEAR);// 年度：2017
		int month = calendar.get(calendar.MONTH);// 月份：0-11
		boolean leepYear = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);// 是否闰年
		if (month != 1) {// 非2月
			calendar.add(calendar.DAY_OF_MONTH, days[month]);
		} else {// 2月
			if (leepYear) {
				calendar.add(calendar.DAY_OF_MONTH, 29);
			} else {
				calendar.add(calendar.DAY_OF_MONTH, 28);
			}
		}
		calendar.add(calendar.DAY_OF_MONTH, -1);// 前一天
		// 设置当前时刻的时钟为0
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		// 设置当前时刻的分钟为0
		calendar.set(Calendar.MINUTE, 0);
		// 设置当前时刻的秒钟为0
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 改变date的“时分秒”设置为当前时间的“时分秒”
	 * 
	 * @return
	 */
	public static Date changeTime(Date date) {
		if (date == null) {
			return new Date();
		}
		Date result = null;
		try {
			String yyyyMMdd = new SimpleDateFormat(DATE_FORMAT_12).format(date);
			String HHmmss = new SimpleDateFormat(DATE_FORMAT_13).format(new Date());
			result = new SimpleDateFormat(DATE_FORMAT_1).parse(yyyyMMdd + HHmmss);
		} catch (Exception ex) {
			logger.error(String.format("程序异常：date：%s", date), ex);
		}
		return result;
	}

	/**
	 * 比较两个时间的大小，返回1是date1大于date2，返回-1是date1小于date2，返回0是等于，2是异常
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareDate(String date1, String date2) {
		DateFormat df = new SimpleDateFormat(DEFAULT_FORMAT);
		try {
			Date dt1 = df.parse(date1);
			Date dt2 = df.parse(date2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception ex) {
			logger.error(String.format("程序异常：date1：%s，date2：%s", date1, date2), ex);
			return 2;
		}
	}

	/**
	 * 比较两个时间的大小，返回1是date1大于date2，返回-1是date1小于date2，返回0是等于，2是异常
	 * 
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	public static int compareDate(Date dt1, Date dt2) {
		try {
			logger.info(dt1.getTime() + "1---------2" + dt2.getTime());
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception ex) {
			logger.error(String.format("程序异常：dt1：%s，dt2：%s", dt1, dt2), ex);
			return 2;
		}
	}

	/**
	 * 给指定字段增加相对值
	 * 
	 * @param currdate
	 * @param num
	 * @throws ParseException
	 */
	public static Date plusField(Date currdate, int field, int num) {
		if (currdate == null) {
			return null;
		}
		Calendar ca = Calendar.getInstance();
		ca.setTime(currdate);
		ca.add(field, num);
		currdate = ca.getTime();
		return currdate;
	}

	/**
	 * 指定日期增加年数
	 * 
	 * @param currdate
	 * @param num
	 * @throws ParseException
	 */
	public static Date plusYear(Date currdate, int num) {
		if (currdate == null) {
			return null;
		}
		Calendar ca = Calendar.getInstance();
		ca.setTime(currdate);
		ca.add(Calendar.YEAR, num);// num为增加的年数，可以改变的
		currdate = ca.getTime();
		return currdate;
	}

	/**
	 * 指定日期增加月份 - 计算下一个还款日的时间
	 * 
	 * @param currdate
	 * @param num
	 * @throws ParseException
	 */
	public static Date plusMonth(Date currdate, int num) {
		if (currdate == null) {
			return null;
		}
		Calendar ca = Calendar.getInstance();
		ca.setTime(currdate);
		ca.add(Calendar.MONTH, num);// num为增加的月份，可以改变的
		currdate = ca.getTime();
		return currdate;
	}

	/**
	 * 指定日期加上指定天数得到新日期
	 * 
	 * @param currdate
	 * @param num
	 * @throws ParseException
	 */
	public static Date plusDay(Date currdate, int num) {
		if (currdate == null) {
			return null;
		}
		Calendar ca = Calendar.getInstance();
		ca.setTime(currdate);
		ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
		currdate = ca.getTime();
		return currdate;
	}

	/**
	 * 增加指定分钟
	 * 
	 * @param currdate
	 * @param num
	 * @throws ParseException
	 */
	public static Date plusMinute(Date currdate, int num) {
		if (currdate == null) {
			return null;
		}
		Calendar ca = Calendar.getInstance();
		ca.setTime(currdate);
		ca.add(Calendar.MINUTE, num);// num为增加的分钟，可以改变的
		currdate = ca.getTime();
		return currdate;
	}

	/**
	 * 增加指定秒
	 * 
	 * @param currdate
	 * @param num
	 * @throws ParseException
	 */
	public static Date plusSecond(Date currdate, int num) {
		if (currdate == null) {
			return null;
		}
		Calendar ca = Calendar.getInstance();
		ca.setTime(currdate);
		ca.add(Calendar.SECOND, num);// num为增加的秒，可以改变的
		currdate = ca.getTime();
		return currdate;
	}

	/**
	 * 把传入的时间转换为带23：59：59秒的时间
	 * 
	 * @param currdate
	 * @return
	 */
	public static Date plusDayTo23H(Date currdate) {
		if (currdate == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currdate);
		// 设置当前时刻的时钟为0
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		// 设置当前时刻的分钟为0
		calendar.set(Calendar.MINUTE, 59);
		// 设置当前时刻的秒钟为0
		calendar.set(Calendar.SECOND, 59);
		// 设置当前的毫秒钟为0
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();// "yyyy-MM-dd 23:59:59";
	}

	/**
	 * 指定日期加上指定分钟
	 * 
	 * @param currdate
	 * @param num
	 * @throws ParseException
	 */
	public static Date plusTimeMinute(Date currdate, int num) {
		if (currdate == null) {
			return null;
		}
		Calendar ca = Calendar.getInstance();
		ca.setTime(currdate);
		ca.add(Calendar.MINUTE, num);// num为增加的分钟，可以改变的
		currdate = ca.getTime();
		return currdate;
	}

	/**
	 * 计算出date2比date1多的天数：仅以日期计算<br>
	 * 参考文档：http://www.cnblogs.com/0201zcr/p/5000977.html
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int differentDays(Date date1, Date date2) {
		return differentDays(date1, date2, false);
	}

	/**
	 * @param date1
	 * @param date2
	 * @param flag
	 *            是否包含当天
	 * @return
	 */
	public static int differentDays(Date date1, Date date2, boolean flag) {
		int result = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_4);
			date1 = sdf.parse(sdf.format(date1));
			date2 = sdf.parse(sdf.format(date2));

			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			long time1 = cal.getTimeInMillis();
			cal.setTime(date2);
			long time2 = cal.getTimeInMillis();

			long between_days = (time2 - time1) / (1000 * 3600 * 24);

			result = Integer.parseInt(String.valueOf(between_days));
			if (flag) {
				result = result + 1;
			}
		} catch (Exception ex) {
			logger.error(String.format("程序异常：date1：%s，date2：%s，flag：%s", date1, date2, flag), ex);
		}
		return result;
	}

	/**
	 * 计算出date2比date1多的小时<br>
	 * 参考文档：http://www.cnblogs.com/0201zcr/p/5000977.html
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int differentHour(Date date1, Date date2) {
		int result = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
			date1 = sdf.parse(sdf.format(date1));
			date2 = sdf.parse(sdf.format(date2));

			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			long time1 = cal.getTimeInMillis();
			cal.setTime(date2);
			long time2 = cal.getTimeInMillis();

			long between_hours = (time2 - time1) / (1000 * 3600);

			result = Integer.parseInt(String.valueOf(between_hours));
		} catch (Exception ex) {
			logger.error(String.format("程序异常：date1：%s，date2：%s", date1, date2), ex);
		}
		return result;
	}

	/**
	 * 计算出date2比date1多的秒<br>
	 * 参考文档：http://www.cnblogs.com/0201zcr/p/5000977.html
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int differentTime(Date date1, Date date2) {
		int result = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
			date1 = sdf.parse(sdf.format(date1));
			date2 = sdf.parse(sdf.format(date2));

			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			long time1 = cal.getTimeInMillis();
			cal.setTime(date2);
			long time2 = cal.getTimeInMillis();

			long between_days = (time2 - time1) / 1000;

			result = Integer.parseInt(String.valueOf(between_days));
		} catch (Exception ex) {
			logger.error(String.format("程序异常：date1：%s，date2：%s", date1, date2), ex);
		}
		return result;
	}

	/**
	 * 判断这一天是否是月底
	 */
	public static boolean isEndOfMonth(Date date) {
		try {
			if (date == null) {
				return false;
			}
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
			if (dayOfMonth == calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
				return true;
			}
		} catch (Exception ex) {
			logger.error(String.format("程序异常：date：%s", date), ex);
		}
		return false;
	}

	/**
	 * 获取当天的日期默认格式
	 * 
	 * @return
	 */
	public static String getCurrentTime() {
		String date = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_1);
			date = sdf.format(new Date());
		} catch (Exception ex) {
			logger.error("程序异常", ex);
		}
		return date;
	}

	/**
	 * 判断是否是同一天
	 * 
	 * @param day
	 * @param nowDay
	 * @return
	 */
//	public static boolean isOneDay(Date day, Date nowDay) {
//		if (day == null && nowDay != null) {
//			return false;
//		}
//		if (day != null && nowDay == null) {
//			return false;
//		}
//
//		String dayTem = dateToString(day, DATE_FORMAT_4);
//		String nowDayTem = dateToString(nowDay, DATE_FORMAT_4);
//
//		if (dayTem.equals(nowDayTem)) {
//			return true;
//		}
//		return false;
//	}

	/**
	 * 格式化日期
	 * 
	 * @param day
	 * @param format
	 * @return
	 */
	public static Date format(String day, String format) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(day);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 比较两个月
	 * 
	 * @param nowDate
	 * @param date
	 * @return
	 */
//	public static int compare(Date nowDate, Date date) {
//		Calendar bef = Calendar.getInstance();
//		Calendar aft = Calendar.getInstance();
//		bef.setTime(nowDate);
//		aft.setTime(date);
//		int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
//		int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
//		return month + result;
//	}

	/**
	 * 比较两个日期的大小
	 * 
	 * @param nowDate
	 * @param date
	 * @return
	 */
	public static int compareMoth(Date nowDate, Date date) {
		if (nowDate.getTime() > date.getTime()) {
			return 1;
		} else if (nowDate.getTime() < date.getTime()) {
			return -1;
		} else {// 相等
			return 0;
		}
	}
	
	
	public static Date formatDate(Long tims) {
		 SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		   
		    String d = format.format(tims);  
		    try {
				Date date=format.parse(d);
				return date;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}

	/**
	 * 比较两个月
	 * 
	 * @param nowDate
	 * @param date
	 * @return
	 */
	public static int compareMonth(Date nowDate, Date date) {
		Calendar bef = Calendar.getInstance();
		Calendar aft = Calendar.getInstance();
		bef.setTime(nowDate);
		aft.setTime(date);
		int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
		int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
		return month + result;
	}

	/**
	 * 比较两个时间端 是否有交叉  true 交叉 或 空 /false 无交叉
	 * @return
	 */
	public static boolean isTimeIntersection(Date starttime ,Date endtime,Date starttime1,Date endtime2){
		if(starttime == null || endtime == null || starttime1 == null || endtime2 == null){
			return true;
		}
		boolean b1 = endtime.getTime() <= starttime1.getTime() && endtime.getTime() <= endtime2.getTime();
		boolean b2 = starttime.getTime() >= starttime1.getTime() && starttime.getTime() >= endtime2.getTime();
		if(b1 || b2)
			return false;
		return true;
	}


	/**
	 *
	 * ##########################################################
	 *
	 */

	public static Date getCurDate() {
		return new Date();
	}

//	public static String dateToString(Date date, String format) {
//		if (date == null || StringUtils.isBlank(format)) {
//			return null;
//		}
//		String dateStr = null;
//		try {
//			dateStr = FastDateFormat.getInstance(format).format(date);// Apache工具类
//		} catch (Exception ex) {
//			dateStr = null;
//		}
//		return dateStr;
//	}



	/**
	 * <p>标题: getCurDateStr<p>
	 * <p>说明: <br>获取当前时间（YYYY-MM-DD HH：MI：SS.mmm）</P>
	 *
	 * @return 当前时间
	 */
	public static String getCurDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
		return sdf.format(getCurDate());
	}

	/**
	 * 格式化日期
	 *
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 格式化日期
	 *
	 * @param date
	 * @return
	 */
	public static String formatDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	/**
	 * 格式化日期
	 *
	 * @param date
	 * @param strFormat
	 * @return
	 */
	public static String formatDate(Date date, String strFormat) {
		SimpleDateFormat sdf;
		if (strFormat == null) {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else {
			sdf = new SimpleDateFormat(strFormat);
		}
		return sdf.format(date);
	}

	/**
	 * <p>标题: getCurDateStr<p>
	 * <p>说明: <br>按指定格式获取当前时间<br>例：<br>yyyy<br>yyyy-MM-dd<br>yyyy-MM-dd HH:mm:ss</P>
	 *
	 * @param dateFormat
	 * @return 当前时间
	 */
	public static String getCurDateStr(String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(getCurDate());
	}

	/**
	 * <p>标题: compare<p>
	 * <p>说明: <br>比较两个时间大小</P>
	 *
	 * @param date1
	 * @param date2
	 * @return date1大于date2 返回1，date1等于date2 返回0, date1少于date2 返回-1
	 */
	public static int compare(Date date1, Date date2) {
		return date1.compareTo(date2);
	}

	/**
	 * <p>标题: parse<p>
	 * <p>说明: <br>获取指定时间对应的UTC时间    单位秒</P>
	 *
	 * @param date
	 * @return
	 */
	public static long getUTCTime(Date date) {
		if (date == null) {
			date = new Date();
		}
		return date.getTime() / 1000;
	}

	/**
	 * 获取当前时间的UTC时间（单位：秒）
	 *
	 * @return
	 */
	public static long getCurrentUTCTime() {
		return getUTCTime(new Date());
	}

	/**
	 * 判断当前时间是否在指定开始时间和结束时间范围内
	 *
	 * @param startTime 开始时间
	 * @param endTime   结束时间
	 * @return true在， false不在
	 */
	public static boolean judgeTimeScope(Date startTime, Date endTime) {

		boolean inScope = false;
		long currentUTCTime = DateUtils.getCurrentUTCTime();
		if (startTime.getTime() / 1000 <= currentUTCTime && currentUTCTime <= endTime.getTime() / 1000) {
			inScope = true;
		}

		return inScope;
	}

	/**
	 * 功能描述：返回小时
	 *
	 * @param date 日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 功能描述：返回分
	 *
	 * @param date 日期
	 * @return 返回分钟
	 */
	public static int getMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

//	public static void main(String[] args) throws Exception {

//		FastDateFormat fdf = FastDateFormat.getInstance(DATE_FORMAT_4);
//		Date date = DateUtils.string2Date("20160921", DATE_FORMAT_12);

//		System.out.println(date);

		// System.out.println("日期：" + fdf.format(date));
//		System.out.println("日期：" + fdf.format(DateUtils.plusMonth(date, 1)));
		// System.out.println("日期：" + DateUtils.isEndOfMonth(date));
		// System.out.println("日期：" + DateUtils.changeTime(date));

		// String loandate = "1996-01-02";
		// Date date1 = fdf.parse(loandate);// 借款日期
		// Date date2 = DateUtils.getRepayDayByNow(fdf.parse(loandate));// 还款日期
		// System.out.println("借款日期：" + fdf.format(date1));
		// System.out.println("还款日期：" + fdf.format(date2));
		// System.out.println("贷款期限：" + DateUtils.differentDays(date1, date2,
		// true));

//		date = new Date(Long.parseLong("1712592000000"));

		// System.out.println("日期：" + format(""));

//		boolean b = isTimeIntersection(string2Date("2018-03-01 00:00:00"), string2Date("2018-03-07 00:00:00"),string2Date("2018-03-07 00:00:00"), string2Date("2018-03-10 00:00:00"));
//		System.out.println(b);
//
//	}

}
