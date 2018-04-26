package com.xh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * 系统时间
 * 
 */
public class TimeUtil {
	public static final int DAY = 0, MONTH = 1, YEAR = 2;
	public static final int format1 = 0, format2 = 1, format3 = 3, format4 = 4;

	/**
	 * 获取系统时间到日 20160607
	 * 
	 * @return
	 */
	private static StringBuffer time_to_day(Date date) {
		StringBuffer sb = new StringBuffer(year_full_name(date));
		return sb.append(month(date)).append(day_two(date));
	}

	/**
	 * 获取系统时间到日 2016-06-07
	 * 
	 * @param date
	 * @return
	 */
	private static StringBuffer time_to_day_one(Date date) {
		StringBuffer sb = new StringBuffer(year_full_name(date));
		sb.append("-").append(month(date)).append("-").append(day_two(date));
		return sb;
	}

	/**
	 * 获取系统时间到日 2016/06/07
	 * 
	 * @param date
	 * @return
	 */
	private static StringBuffer time_to_day_two(Date date) {
		StringBuffer sb = new StringBuffer(year_full_name(date));
		sb.append("/").append(month(date)).append("/").append(day_two(date));
		return sb;
	}

	/**
	 * 获取系统时间到日 20160607
	 * 
	 * @return
	 */
	public static String time_to_day() {
		Date date = new Date();
		return time_to_day(date).toString();
	}

	/**
	 * 获取系统时间到日 2016-06-07
	 * 
	 * @return
	 */
	public static String time_to_day_one() {
		Date date = new Date();
		return time_to_day_one(date).toString();
	}

	/**
	 * 获取系统时间到日 2016/06/07
	 * 
	 * @return
	 */
	public static String time_to_day_two() {
		Date date = new Date();
		return time_to_day_two(date).toString();
	}

	/**
	 * 获取系统时间到秒 20160607135436
	 * 
	 * @return
	 */
	private static StringBuffer time_to_second(Date date) {
		StringBuffer sb = time_to_day(date);
		return sb.append(hour_H(date)).append(minute(date))
				.append(second(date));
	}

	/**
	 * 获取系统时间到秒 2016-06-07 13:54:36
	 * 
	 * @return
	 */
	private static StringBuffer time_to_second_one(Date date) {
		return time_to_day_one(date).append(" ").append(
				hour_minute_second(date));
	}

	/**
	 * 获取系统时间到秒 2016/06/07 13:54:36
	 * 
	 * @return
	 */
	private static StringBuffer time_to_second_two(Date date) {
		return time_to_day_two(date).append(" ").append(
				hour_minute_second(date));
	}

	/**
	 * 获取系统时间到秒 20160607 13:54:36
	 * 
	 * @return
	 */
	private static StringBuffer time_to_second_three(Date date) {
		return time_to_day(date).append(" ").append(hour_minute_second(date));
	}

	/**
	 * 获取系统时间到秒 20160607135436
	 * 
	 * @return
	 */
	public static String time_to_second() {
		Date date = new Date();
		return time_to_second(date).toString();
	}

	/**
	 * 获取系统时间到秒 2016-06-07 13:54:36
	 * 
	 * @return
	 */
	public static String time_to_second_one() {
		Date date = new Date();
		return time_to_second_one(date).toString();
	}

	/**
	 * 获取系统时间到秒 2016/06/07 13:54:36
	 * 
	 * @return
	 */
	public static String time_to_second_two() {
		Date date = new Date();
		return time_to_second_two(date).toString();
	}

	/**
	 * 获取系统时间到秒 20160607 13:54:36
	 * 
	 * @return
	 */
	public static String time_to_second_three() {
		Date date = new Date();
		return time_to_second_three(date).toString();
	}

	/**
	 * 将时间转化为星座
	 * 
	 * @param month
	 *            月
	 * @param day
	 *            日
	 * @return
	 */
	public static String time_to_constellation(int month, int day) {
		if ((month == 3 && day >= 21) || (month == 4 && day <= 19))
			return "白羊座";
		if ((month == 4 && day >= 20) || (month == 5 && day <= 20))
			return "金牛座";
		if ((month == 5 && day >= 21) || (month == 6 && day <= 21))
			return "双子座";
		if ((month == 6 && day >= 22) || (month == 7 && day <= 22))
			return "巨蟹座";
		if ((month == 7 && day >= 23) || (month == 8 && day <= 22))
			return "狮子座";
		if ((month == 8 && day >= 23) || (month == 9 && day <= 22))
			return "处女座";
		if ((month == 9 && day >= 23) || (month == 10 && day <= 23))
			return "天秤座";
		if ((month == 10 && day >= 24) || (month == 11 && day <= 22))
			return "天蝎座";
		if ((month == 11 && day >= 23) || (month == 12 && day <= 21))
			return "射手座";
		if ((month == 12 && day >= 22) || (month == 1 && day <= 19))
			return "摩羯座";
		if ((month == 1 && day >= 20) || (month == 2 && day <= 18))
			return "水瓶座";
		return "双鱼座";
	}

	/**
	 * 
	 * @param year
	 *            判断闰年
	 */
	public static boolean leap_year(int year) {
		if (year % 100 == 0) {
			if (year % 400 == 0)
				return true;
		} else if (year % 4 == 0)
			return true;
		return false;
	}

	/**
	 * 
	 * @param month
	 * @param year
	 *            获得某年某月的天数
	 */
	public static int month_day(int month, int year) {
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			if (leap_year(year))
				return 29;
			else
				return 28;
		}
		return 31;
	}

	/**
	 * 将时间转化为时间戳 时间格式为 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param time
	 * @return
	 */
	public static long time_to_mill1(String time) {
		long mill = 0l;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			Date date = simpleDateFormat.parse(time);
			mill = date.getTime();
		} catch (Exception e) {
			// TODO: handle exception

		}
		return mill;
	}

	/**
	 * 将时间转化为时间戳 时间格式为 yyyy年MM月dd日 HH:mm:ss
	 * 
	 * @param time
	 * @return
	 */
	public static long time_to_mill2(String time) {
		long mill = 0l;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy年MM月dd日 HH:mm:ss");
			Date date = simpleDateFormat.parse(time);
			mill = date.getTime();
		} catch (Exception e) {
			// TODO: handle exception

		}
		return mill;
	}

	/**
	 * 将时间转化为时间戳 时间格式为 yyyy/MM/dd hh:mm:ss
	 * 
	 * @param time
	 * @return
	 */
	public static long time_to_mill3(String time) {
		long mill = 0l;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy/MM/dd hh:mm:ss");
			Date date = simpleDateFormat.parse(time);
			mill = date.getTime();
		} catch (Exception e) {
			// TODO: handle exception

		}
		return mill;
	}

	/**
	 * 比较两个时间的大小 格式 2016-03-06 或 2016-03-06 09:51:40
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static boolean compare(String time1, String time2) {
		long time11 = time_to_mill1(time1.split(" ").length > 1 ? time1 : time1
				+ " 00:00:00");
		long time21 = time_to_mill1(time2.split(" ").length > 1 ? time2 : time2
				+ " 00:00:00");
		return time11 > time21;
	}

	/**
	 * 时间排序 格式2016-03-06 或 2016-03-06 09:51:40
	 * 
	 * @return
	 */
	public static List<String> sort(List<String> times) {
		if (times == null)
			return times;
		for (int i = 1; i < times.size(); i++) {
			for (int j = 0; j < times.size() - i; j++) {
				String time1 = times.get(j);
				String time2 = times.get(j + 1);
				if (compare(time2, time1)) {
					times.set(j, time2);
					times.set(j + 1, time1);
				}
			}
		}
		return times;
	}

	/**
	 * 转化为生肖
	 * 
	 * @param year
	 * @return
	 */
	public static String chinese_zodiac(int year) {

		String[] shengxiaos = { "鼠", "牛", "虎", "免", "龙", "蛇", "马", "羊", "猴",
				"鸡", "狗", "猪" };
		String shengxiao;
		int m = Math.abs(year - 2008) % 12;
		if (year >= 2008) {
			shengxiao = shengxiaos[m];
		} else {
			if (m == 0) {
				m = 12;
			}
			shengxiao = shengxiaos[12 - m];
		}
		return shengxiao;
	}

	/**
	 * 时间戳转化为时间
	 * 
	 * @param mill
	 * @return
	 */
	public static Date mill_to_date(long mill) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String d = format.format(mill);
			Date date = format.parse(d);
			return date;
		} catch (Exception e) {
			// TODO: handle exception
			return new Date();
		}
	}

	/**
	 * 时间转化为时间戳
	 * 
	 * @param date
	 * @return
	 */
	public static long date_to_mill(Date date) {
		if (date == null)
			date = new Date();
		return date.getTime();
	}

	/**
	 * 将时间平移多少毫秒
	 * 
	 * @param date
	 *            被平移的时间
	 * @param mill
	 * 
	 * @return
	 */
	public static Date date_translation_mill(Date date, long mill) {
		return mill_to_date(date_to_mill(date) + mill);
	}

	/**
	 * 将时间平移多少天
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date date_translation_day(Date date, int day) {
		return date_translation_mill(date, day * 24 * 60 * 60 * 1000);
	}

	/**
	 * 将时间平移多少小时
	 * 
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date date_translation_hour(Date date, int hour) {
		return date_translation_mill(date, hour * 60 * 60 * 1000);
	}

	/**
	 * 将时间平移多少分钟
	 * 
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date date_translation_minute(Date date, int minute) {
		return date_translation_mill(date, minute * 60 * 1000);
	}

	/**
	 * 将时间平移多少秒
	 * 
	 * @param date
	 * @param second
	 * @return
	 */
	public static Date date_translation_second(Date date, int second) {
		return date_translation_mill(date, second * 1000);
	}

	/**
	 * 将时间平移
	 * 
	 * @param date
	 * @param day
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	public static Date date_translation(Date date, int day, int hour,
			int minute, int second) {
		return date_translation_mill(date, day * 24 * 60 * 60 * 1000 + hour
				* 60l * 60 * 1000 + minute * 60l * 1000 + second * 1000l);
	}

	// 【子时】（23时至01时）夜半，又名子夜、中夜：十二时辰的第一个时辰．鼠
	//
	// 【丑时】（01时至03时）鸡鸣，又名荒鸡：十二时辰的第二个时辰。牛
	//
	// 【寅时】（03时至05时）平旦，又称黎明、早晨、时是夜与日的交替之际 虎
	//
	// 【卯时】（05时至07时）日出，又名破晓、旭日，指太阳刚露脸，初升的时间。 兔
	//
	// 【辰时】（07时至09时）食时，又名早食，也是吃早饭时间， 龙
	//
	// 【巳时】（09时至11时）隅中，又名日禺等：临近中午的时候称为隅中。 蛇
	//
	// 【午时】（11时至13时）日中，又名日正、中午等 马
	//
	// 【未时】（13时至15时） 日昳，又名日跌、日央等：太阳偏西为日跌。羊
	//
	// 【申时】（15食至17时） 哺时，又名日铺、夕食等 猴
	//
	// 【酉时】（17是至19时） 日入，又名日落、傍晚：意为太阳落山的时候。 鸡
	//
	// 【戌时】（19时至21时） 黄昏，又名日夕、日暮、日晚等：此时太阳已经落山，天将黑未黑。天地昏黄，万物朦胧，故称黄昏。 狗
	//
	// 【亥时】（21时至23时）人定，又名定昏等：此时夜色已深，人们也已经停止活动，安歇睡眠了。人定也就是人静。 猪
	/**
	 * 时间转换为生肖 输入的是小时
	 * 
	 * @param time
	 * @return
	 */
	public static String time2Zodiac(int time) {
		if (time >= 23 || time < 1)
			return "子时";
		if (time >= 1 || time < 3)
			return "丑时";
		if (time >= 3 || time < 5)
			return "寅时";
		if (time >= 5 || time < 7)
			return "卯时";
		if (time >= 7 || time < 9)
			return "辰时";
		if (time >= 9 || time < 11)
			return "巳时";
		if (time >= 11 || time < 13)
			return "午时";
		if (time >= 13 || time < 15)
			return "未时";
		if (time >= 15 || time < 17)
			return "申时";
		if (time >= 17 || time < 19)
			return "酉时";
		if (time >= 19 || time < 21)
			return "戌时";
		return "亥时";
	}

	/**
	 * 获得时区
	 * 
	 * @param date
	 * @return
	 */
	public static String time_zone(Date date) {
		return String.format("%tZ", date);
	}

	/**
	 * 获得时区偏移量 相对GMT RFC 82
	 * 
	 * @param date
	 * @return
	 */
	public static String time_offset(Date date) {
		return String.format("%tz", date);
	}

	/**
	 * 获得下午或上午
	 * 
	 * @param date
	 * @return
	 */
	public static String am_or_pm(Date date) {
		return String.format("%tp", date);
	}

	/**
	 * 获得当前微妙数 9位
	 * 
	 * @param date
	 * @return
	 */
	public static String subtle(Date date) {
		return String.format("%tN", date);
	}

	/**
	 * 获得当前毫秒数 3位
	 * 
	 * @param date
	 * @return
	 */
	public static String mill(Date date) {
		return String.format("%tL", date);
	}

	/**
	 * 获得当前秒 2位
	 * 
	 * @param date
	 * @return
	 */
	public static String second(Date date) {
		return String.format("%tS", date);
	}

	/**
	 * 获得当前分钟 2为
	 * 
	 * @param date
	 * @return
	 */
	public static String minute(Date date) {
		return String.format("%tM", date);
	}

	/**
	 * 获得当前小时 1-12
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_l(Date date) {
		return String.format("%tl", date);
	}

	/**
	 * 获得当前小时 0-23
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_k(Date date) {
		return String.format("%tk", date);
	}

	/**
	 * 获得当前小时 01-12
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_I(Date date) {
		return String.format("%tI", date);
	}

	/**
	 * 获得当前小时 00-23
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_H(Date date) {
		return String.format("%tH", date);
	}

	/**
	 * 获得当前时间 15:25
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_minute(Date date) {
		return String.format("%tR", date);
	}

	/**
	 * 获得当前时间 15:23:50
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_minute_second(Date date) {
		return String.format("%tT", date);
	}

	/**
	 * 获得当前时间 03:22:06 下午
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_minute_second_pm_or_am(Date date) {
		return String.format("%tr", date);
	}

	/**
	 * 获取当前时间到日 03/25/08（月/日/年）
	 * 
	 * @param date
	 * @return
	 */
	public static String mdy(Date date) {
		return String.format("%tD", date);
	}

	/**
	 * 获取当前时间到日 2008-03-25 年—月—日
	 * 
	 * @param date
	 * @return
	 */
	public static String ymd(Date date) {
		return String.format("%tF", date);
	}

	/**
	 * 获得日期天 1-31
	 * 
	 * @param date
	 * @return
	 */
	public static String day_one(Date date) {
		return String.format("%te", date);
	}

	/**
	 * 获得日期天 01-31
	 * 
	 * @param date
	 * @return
	 */
	public static String day_two(Date date) {
		return String.format("%td", date);
	}

	/**
	 * 一年中的第几天 085
	 * 
	 * @param date
	 * @return
	 */
	public static String day_to_year(Date date) {
		return String.format("%tj", date);
	}

	/**
	 * 获得月份简称
	 */
	public static String month_referred(Date date) {
		return String.format("%tb", date);
	}

	/**
	 * 获得月份全称
	 * 
	 * @param date
	 * @return
	 */
	public static String month_full_name(Date date) {
		return String.format("%tB", date);
	}

	/**
	 * 获得月份 01-12
	 * 
	 * @param date
	 * @return
	 */
	public static String month(Date date) {
		return String.format("%tm", date);
	}

	/**
	 * 获得星期简称
	 * 
	 * @param date
	 * @return
	 */
	public static String week_referred(Date date) {
		return String.format("%ta", date);
	}

	/**
	 * 获得星期全称
	 * 
	 * @param date
	 * @return
	 */
	public static String week_full_name(Date date) {
		return String.format("%tA", date);
	}

	/**
	 * 获得年简称 16
	 * 
	 * @param date
	 * @return
	 */
	public static String year_referred(Date date) {
		return String.format("%ty", date);
	}

	/**
	 * 获得年全称 2016
	 * 
	 * @param date
	 * @return
	 */
	public static String year_full_name(Date date) {
		return String.format("%tY", date);
	}

	/**
	 * 星期二 三月 25 13:37:22 CST 2016
	 * 
	 * @param date
	 * @return
	 */
	public static String time(Date date) {
		return String.format("%tc", date);
	}

	/**
	 * 获取时间戳到毫秒
	 * 
	 * @param date
	 * @return
	 */
	public static String time_to_mill(Date date) {
		return String.format("%tQ", date);
	}

	/**
	 * 获取时间戳到毫秒
	 * 
	 * @return
	 * 
	 */
	public static long time_to_mill() {
		return System.currentTimeMillis();
	}

	public static String getCurrentTime(String format) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
		String currentTime = sdf.format(date);
		return currentTime;
	}

	public static String getCurrentTime() {
		return getCurrentTime("yyyy-MM-dd  HH:mm:ss");
	}

	public static String getMonthFirstDayToWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat format = new SimpleDateFormat("E");
		return format.format(calendar.getTime());
	}

	/**
	 * 
	 * @param time
	 *            获得系统的时间 输入ForTime.DAY获得天，ForTime.MONTH获得月，ForTime.YEAR获得年
	 */
	public static int getSysTime(int time) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(new java.util.Date());
		switch (time) {
		case 0:
			return ca.get(Calendar.DAY_OF_MONTH);
		case 1:
			return ca.get(Calendar.MONTH) + 1;
		case 2:
			return ca.get(Calendar.YEAR);
		}
		return 0;
	}

	/**
	 * 
	 * @param format
	 *            获得系统的时间到天
	 */
	public static String getSysTimeDay(int format) {
		switch (format) {
		case format1:
			return getSysTime(YEAR) + "年" + getSysTime(MONTH) + "月"
					+ getSysTime(DAY) + "日";
		case format2:
			return getSysTime(YEAR) + "-" + getSysTime(MONTH) + "-"
					+ getSysTime(DAY);
		case format3:
			return "" + getSysTime(YEAR) + (getSysTime(MONTH) < 10 ? 0 : "")
					+ getSysTime(MONTH) + (getSysTime(DAY) < 10 ? 0 : "")
					+ getSysTime(DAY);

		default:
			break;
		}
		return null;
	}

	/**
	 * 
	 * @param format
	 *            获得系统的时间到秒
	 */
	public static String getSysTimeSecond(int format) {
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat fmt;
		switch (format) {
		case format1:
			fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return fmt.format(rightNow.getTime());
		case format2:
			fmt = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			return fmt.format(rightNow.getTime());
		case format3:
			fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			return fmt.format(rightNow.getTime());

		default:
			break;
		}
		fmt = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
		return fmt.format(rightNow.getTime());
	}

	/**
	 * 
	 * @param MonthFirstDayToWeek
	 *            获得上个月要加入的天数
	 */
	public static int getLastMonth(String MonthFirstDayToWeek) {
		return WeekToInt(MonthFirstDayToWeek);
	}

	/**
	 * 
	 * @param MonthFirstDayToWeek
	 * @param day
	 *            获得下个月加入的天数
	 */
	public static int getNextMonth(String MonthFirstDayToWeek, int day) {
		int i = 0;
		while (true) {
			if ((getLastMonth(MonthFirstDayToWeek) + day + i) % 7 == 0)
				return i;
			i++;
			System.out.println(i);
		}
	}

	/**
	 * 
	 * @param week
	 *            将星期转换成数字
	 */
	public static int WeekToInt(String week) {
		int week1 = 0;
		if (week.equals("星期一") || week.equals("Monday"))
			return 1;
		if (week.equals("星期二") || week.equals("Tuesday"))
			return 2;
		if (week.equals("星期三") || week.equals("Wednesday"))
			return 3;
		if (week.equals("星期四") || week.equals("Thursday"))
			return 4;
		if (week.equals("星期五") || week.equals("Friday"))
			return 5;
		if (week.equals("星期六") || week.equals("Saturday"))
			return 6;
		return week1;
	}

	/**
	 * 
	 * @param year
	 *            判断闰年
	 */
	public static boolean leapYear(int year) {
		if (year % 100 == 0) {
			if (year % 400 == 0)
				return true;
		} else if (year % 4 == 0)
			return true;
		return false;
	}

	/**
	 * 
	 * @param month
	 * @param year
	 *            获得某年某月的天数
	 */
	public static int getMonthDay(int month, int year) {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			if (leapYear(year))
				return 29;
			else
				return 28;
		}
		return 0;
	}

	/**
	 * 取系统时间14位
	 */
	public static String getNanoTimeS() {

		Random random = new Random();
		long nano = System.nanoTime();
		System.out.println(nano / 1000000 / 60 / 60 / 24);
		String nanoTimeStr = String.valueOf(System.nanoTime());
		// System.out.println(nanoTimeStr);
		if (nanoTimeStr.length() != 14) {
			String randomStr = String.valueOf(Math.abs(random.nextInt()));
			nanoTimeStr = (nanoTimeStr + randomStr).substring(0, 14);
			// System.out.println(nanoTimeStr);
			// System.out.println(nanoTimeStr.length());
		}
		return nanoTimeStr;

	}

	/****
	 * 获取时间戳
	 * 
	 * @return
	 */
	public static long getMillis() {
		java.util.Date date = new Date();
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 将时间转换为时间戳
	 * 
	 * @return
	 */
	public static long time2Millis(int format, String time) {
		try {
			SimpleDateFormat simpleDateFormat = null;
			switch (format) {
			case format1:
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			case format2:
				simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			case format3:
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			}
			Date date = simpleDateFormat.parse(time);
			return date.getTime();

		} catch (Exception e) {
			// TODO: handle exception
			return getMillis();
		}
	}

	// 转换时间为今天+时间、昨天、前天、具体日期
	public static String getDateExchangeString(String shutDown, Date curentDate) {
		if (shutDown.equals("") || curentDate == null || shutDown == null) {
			return "";
		}

		SimpleDateFormat turn_date = new SimpleDateFormat("yyyy-MM-dd");

		Date date_shut = null;
		try {
			date_shut = turn_date.parse(shutDown);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		int day_diff = curentDate.getDay() - date_shut.getDay();
		// Log.d("day_diff", day_diff + "天");

		String return_date = "更早";

		if (date_shut.getYear() == curentDate.getYear()) {
			if (date_shut.getMonth() == curentDate.getMonth()) {
				switch (day_diff) {
				case 0:
					return_date = "今天  ";

					break;
				case 1:
					return_date = "昨天";
					break;
				case 2:
					return_date = "前天";
					break;

				}

			}

		}

		return return_date;

	}

	/**
	 * 将时间转换为星座
	 * 
	 * @param day
	 * @param month
	 * @return
	 */
	public static String time2Constellation(int day, int month) {
		if ((month == 3 && day >= 21) || (month == 4 && day <= 19))
			return "白羊座";
		if ((month == 4 && day >= 20) || (month == 5 && day <= 20))
			return "金牛座";
		if ((month == 5 && day >= 21) || (month == 6 && day <= 21))
			return "双子座";
		if ((month == 6 && day >= 22) || (month == 7 && day <= 22))
			return "巨蟹座";
		if ((month == 7 && day >= 23) || (month == 8 && day <= 22))
			return "狮子座";
		if ((month == 8 && day >= 23) || (month == 9 && day <= 22))
			return "处女座";
		if ((month == 9 && day >= 23) || (month == 10 && day <= 23))
			return "天秤座";
		if ((month == 10 && day >= 24) || (month == 11 && day <= 22))
			return "天蝎座";
		if ((month == 11 && day >= 23) || (month == 12 && day <= 21))
			return "射手座";
		if ((month == 12 && day >= 22) || (month == 1 && day <= 19))
			return "摩羯座";
		if ((month == 1 && day >= 20) || (month == 2 && day <= 18))
			return "水瓶座";
		return "双鱼座";
	}

	/**
	 * 时间戳转换为时间
	 * 
	 * @param millis
	 * @return
	 */
	public static String millis2Time(long millis) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d = format.format(millis);
		Date date;
		try {
			date = format.parse(d);
			return d;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String millis2day(long millis) {
		if (millis <= 0)
			return null;
		int d = (int) (millis / (24 * 60 * 60 * 1000));
		int mod = (int) (millis % (24 * 60 * 60 * 1000));
		int h = mod / (60 * 60 * 1000);
		mod = mod % (60 * 60 * 1000);
		int m = mod / (60 * 1000);
		mod = mod % (60 * 1000);
		int s = mod / 1000;
		return d + "天" + h + "小时" + m + "分钟" + s + "秒";
	}

	/**
	 * 时间转化
	 * 
	 * @return
	 */
	public static String[] timeAdd30m() {
		try {
			String[] times = { "", "", "" };
			Date date = new Date();
			String now_day = day_one(date);
			long time = getMillis();
			time += 30 * 60 * 1000;
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String d = format.format(time);
			Date date1 = format.parse(d);
			String day = day_one(date1);
			int m = Integer.parseInt(minute(date1));
			boolean h_jia = false;
			if (m > 45) {
				h_jia = true;
				times[2] = "00";
			} else if (m > 30)
				times[2] = "45";
			else if (m > 15)
				times[2] = "30";
			else
				times[2] = "15";
			int h = Integer.parseInt(minute(date1));
			boolean d_jia = false;
			if (h_jia) {
				h++;
				if (h > 23) {
					d_jia = true;
					times[1] = "00";
				} else if (h >= 10)
					times[1] = "" + h;
				else
					times[1] = "0" + h;
			} else
				times[1] = hour_H(date1);
			if (now_day.equals(day) && !d_jia)
				times[0] = "今天";
			else
				times[0] = "明天";
			times[1] = hour_H(date1);
			return times;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(time_to_second_one());
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
			String dateString = String.format("%tY", date) + "-"
					+ String.format("%tm", date) + "-01 ";
			date = sdf.parse(dateString);
			String first_day = String.format("%tA", date);
			System.out.println(first_day);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
