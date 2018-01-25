package com.xh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * ϵͳʱ��
 * 
 */
public class TimeUtil {
	public static final int DAY = 0, MONTH = 1, YEAR = 2;
	public static final int format1 = 0, format2 = 1, format3 = 3, format4 = 4;

	/**
	 * ��ȡϵͳʱ�䵽�� 20160607
	 * 
	 * @return
	 */
	private static StringBuffer time_to_day(Date date) {
		StringBuffer sb = new StringBuffer(year_full_name(date));
		return sb.append(month(date)).append(day_two(date));
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 2016-06-07
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
	 * ��ȡϵͳʱ�䵽�� 2016/06/07
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
	 * ��ȡϵͳʱ�䵽�� 20160607
	 * 
	 * @return
	 */
	public static String time_to_day() {
		Date date = new Date();
		return time_to_day(date).toString();
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 2016-06-07
	 * 
	 * @return
	 */
	public static String time_to_day_one() {
		Date date = new Date();
		return time_to_day_one(date).toString();
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 2016/06/07
	 * 
	 * @return
	 */
	public static String time_to_day_two() {
		Date date = new Date();
		return time_to_day_two(date).toString();
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 20160607135436
	 * 
	 * @return
	 */
	private static StringBuffer time_to_second(Date date) {
		StringBuffer sb = time_to_day(date);
		return sb.append(hour_H(date)).append(minute(date))
				.append(second(date));
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 2016-06-07 13:54:36
	 * 
	 * @return
	 */
	private static StringBuffer time_to_second_one(Date date) {
		return time_to_day_one(date).append(" ").append(
				hour_minute_second(date));
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 2016/06/07 13:54:36
	 * 
	 * @return
	 */
	private static StringBuffer time_to_second_two(Date date) {
		return time_to_day_two(date).append(" ").append(
				hour_minute_second(date));
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 20160607 13:54:36
	 * 
	 * @return
	 */
	private static StringBuffer time_to_second_three(Date date) {
		return time_to_day(date).append(" ").append(hour_minute_second(date));
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 20160607135436
	 * 
	 * @return
	 */
	public static String time_to_second() {
		Date date = new Date();
		return time_to_second(date).toString();
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 2016-06-07 13:54:36
	 * 
	 * @return
	 */
	public static String time_to_second_one() {
		Date date = new Date();
		return time_to_second_one(date).toString();
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 2016/06/07 13:54:36
	 * 
	 * @return
	 */
	public static String time_to_second_two() {
		Date date = new Date();
		return time_to_second_two(date).toString();
	}

	/**
	 * ��ȡϵͳʱ�䵽�� 20160607 13:54:36
	 * 
	 * @return
	 */
	public static String time_to_second_three() {
		Date date = new Date();
		return time_to_second_three(date).toString();
	}

	/**
	 * ��ʱ��ת��Ϊ����
	 * 
	 * @param month
	 *            ��
	 * @param day
	 *            ��
	 * @return
	 */
	public static String time_to_constellation(int month, int day) {
		if ((month == 3 && day >= 21) || (month == 4 && day <= 19))
			return "������";
		if ((month == 4 && day >= 20) || (month == 5 && day <= 20))
			return "��ţ��";
		if ((month == 5 && day >= 21) || (month == 6 && day <= 21))
			return "˫����";
		if ((month == 6 && day >= 22) || (month == 7 && day <= 22))
			return "��з��";
		if ((month == 7 && day >= 23) || (month == 8 && day <= 22))
			return "ʨ����";
		if ((month == 8 && day >= 23) || (month == 9 && day <= 22))
			return "��Ů��";
		if ((month == 9 && day >= 23) || (month == 10 && day <= 23))
			return "�����";
		if ((month == 10 && day >= 24) || (month == 11 && day <= 22))
			return "��Ы��";
		if ((month == 11 && day >= 23) || (month == 12 && day <= 21))
			return "������";
		if ((month == 12 && day >= 22) || (month == 1 && day <= 19))
			return "Ħ����";
		if ((month == 1 && day >= 20) || (month == 2 && day <= 18))
			return "ˮƿ��";
		return "˫����";
	}

	/**
	 * 
	 * @param year
	 *            �ж�����
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
	 *            ���ĳ��ĳ�µ�����
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
	 * ��ʱ��ת��Ϊʱ��� ʱ���ʽΪ yyyy-MM-dd HH:mm:ss
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
	 * ��ʱ��ת��Ϊʱ��� ʱ���ʽΪ yyyy��MM��dd�� HH:mm:ss
	 * 
	 * @param time
	 * @return
	 */
	public static long time_to_mill2(String time) {
		long mill = 0l;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy��MM��dd�� HH:mm:ss");
			Date date = simpleDateFormat.parse(time);
			mill = date.getTime();
		} catch (Exception e) {
			// TODO: handle exception

		}
		return mill;
	}

	/**
	 * ��ʱ��ת��Ϊʱ��� ʱ���ʽΪ yyyy/MM/dd hh:mm:ss
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
	 * �Ƚ�����ʱ��Ĵ�С ��ʽ 2016-03-06 �� 2016-03-06 09:51:40
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
	 * ʱ������ ��ʽ2016-03-06 �� 2016-03-06 09:51:40
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
	 * ת��Ϊ��Ф
	 * 
	 * @param year
	 * @return
	 */
	public static String chinese_zodiac(int year) {

		String[] shengxiaos = { "��", "ţ", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��" };
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
	 * ʱ���ת��Ϊʱ��
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
	 * ʱ��ת��Ϊʱ���
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
	 * ��ʱ��ƽ�ƶ��ٺ���
	 * 
	 * @param date
	 *            ��ƽ�Ƶ�ʱ��
	 * @param mill
	 * 
	 * @return
	 */
	public static Date date_translation_mill(Date date, long mill) {
		return mill_to_date(date_to_mill(date) + mill);
	}

	/**
	 * ��ʱ��ƽ�ƶ�����
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date date_translation_day(Date date, int day) {
		return date_translation_mill(date, day * 24l * 60 * 60 * 1000);
	}

	/**
	 * ��ʱ��ƽ�ƶ���Сʱ
	 * 
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date date_translation_hour(Date date, int hour) {
		return date_translation_mill(date, hour * 60l * 60 * 1000);
	}

	/**
	 * ��ʱ��ƽ�ƶ��ٷ���
	 * 
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date date_translation_minute(Date date, int minute) {
		return date_translation_mill(date, minute * 60l * 1000);
	}

	/**
	 * ��ʱ��ƽ�ƶ�����
	 * 
	 * @param date
	 * @param second
	 * @return
	 */
	public static Date date_translation_second(Date date, int second) {
		return date_translation_mill(date, second * 1000l);
	}

	/**
	 * ��ʱ��ƽ��
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
		return date_translation_mill(date, day * 24l * 60 * 60 * 1000 + hour
				* 60l * 60 * 1000 + minute * 60l * 1000 + second * 1000l);
	}

	// ����ʱ����23ʱ��01ʱ��ҹ�룬������ҹ����ҹ��ʮ��ʱ���ĵ�һ��ʱ������
	//
	// ����ʱ����01ʱ��03ʱ�������������ļ���ʮ��ʱ���ĵڶ���ʱ����ţ
	//
	// ����ʱ����03ʱ��05ʱ��ƽ�����ֳ��������糿��ʱ��ҹ���յĽ���֮�� ��
	//
	// ��îʱ����05ʱ��07ʱ���ճ����������������գ�ָ̫����¶����������ʱ�䡣 ��
	//
	// ����ʱ����07ʱ��09ʱ��ʳʱ��������ʳ��Ҳ�ǳ��緹ʱ�䣬 ��
	//
	// ����ʱ����09ʱ��11ʱ�����У�������خ�ȣ��ٽ������ʱ���Ϊ���С� ��
	//
	// ����ʱ����11ʱ��13ʱ�����У���������������� ��
	//
	// ��δʱ����13ʱ��15ʱ�� �Օi�������յ�������ȣ�̫��ƫ��Ϊ�յ�����
	//
	// ����ʱ����15ʳ��17ʱ�� ��ʱ���������̡�Ϧʳ�� ��
	//
	// ����ʱ����17����19ʱ�� ���룬�������䡢������Ϊ̫����ɽ��ʱ�� ��
	//
	// ����ʱ����19ʱ��21ʱ�� �ƻ裬������Ϧ����ĺ������ȣ���ʱ̫���Ѿ���ɽ���콫��δ�ڡ���ػ�ƣ��������ʣ��ʳƻƻ衣 ��
	//
	// ����ʱ����21ʱ��23ʱ���˶�����������ȣ���ʱҹɫ�������Ҳ�Ѿ�ֹͣ�����Ъ˯���ˡ��˶�Ҳ�����˾��� ��
	/**
	 * ʱ��ת��Ϊ��Ф �������Сʱ
	 * 
	 * @param time
	 * @return
	 */
	public static String time2Zodiac(int time) {
		if (time >= 23 || time < 1)
			return "��ʱ";
		if (time >= 1 || time < 3)
			return "��ʱ";
		if (time >= 3 || time < 5)
			return "��ʱ";
		if (time >= 5 || time < 7)
			return "îʱ";
		if (time >= 7 || time < 9)
			return "��ʱ";
		if (time >= 9 || time < 11)
			return "��ʱ";
		if (time >= 11 || time < 13)
			return "��ʱ";
		if (time >= 13 || time < 15)
			return "δʱ";
		if (time >= 15 || time < 17)
			return "��ʱ";
		if (time >= 17 || time < 19)
			return "��ʱ";
		if (time >= 19 || time < 21)
			return "��ʱ";
		return "��ʱ";
	}

	/**
	 * ���ʱ��
	 * 
	 * @param date
	 * @return
	 */
	public static String time_zone(Date date) {
		return String.format("%tZ", date);
	}

	/**
	 * ���ʱ��ƫ���� ���GMT RFC 82
	 * 
	 * @param date
	 * @return
	 */
	public static String time_offset(Date date) {
		return String.format("%tz", date);
	}

	/**
	 * ������������
	 * 
	 * @param date
	 * @return
	 */
	public static String am_or_pm(Date date) {
		return String.format("%tp", date);
	}

	/**
	 * ��õ�ǰ΢���� 9λ
	 * 
	 * @param date
	 * @return
	 */
	public static String subtle(Date date) {
		return String.format("%tN", date);
	}

	/**
	 * ��õ�ǰ������ 3λ
	 * 
	 * @param date
	 * @return
	 */
	public static String mill(Date date) {
		return String.format("%tL", date);
	}

	/**
	 * ��õ�ǰ�� 2λ
	 * 
	 * @param date
	 * @return
	 */
	public static String second(Date date) {
		return String.format("%tS", date);
	}

	/**
	 * ��õ�ǰ���� 2Ϊ
	 * 
	 * @param date
	 * @return
	 */
	public static String minute(Date date) {
		return String.format("%tM", date);
	}

	/**
	 * ��õ�ǰСʱ 1-12
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_l(Date date) {
		return String.format("%tl", date);
	}

	/**
	 * ��õ�ǰСʱ 0-23
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_k(Date date) {
		return String.format("%tk", date);
	}

	/**
	 * ��õ�ǰСʱ 01-12
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_I(Date date) {
		return String.format("%tI", date);
	}

	/**
	 * ��õ�ǰСʱ 00-23
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_H(Date date) {
		return String.format("%tH", date);
	}

	/**
	 * ��õ�ǰʱ�� 15:25
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_minute(Date date) {
		return String.format("%tR", date);
	}

	/**
	 * ��õ�ǰʱ�� 15:23:50
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_minute_second(Date date) {
		return String.format("%tT", date);
	}

	/**
	 * ��õ�ǰʱ�� 03:22:06 ����
	 * 
	 * @param date
	 * @return
	 */
	public static String hour_minute_second_pm_or_am(Date date) {
		return String.format("%tr", date);
	}

	/**
	 * ��ȡ��ǰʱ�䵽�� 03/25/08����/��/�꣩
	 * 
	 * @param date
	 * @return
	 */
	public static String mdy(Date date) {
		return String.format("%tD", date);
	}

	/**
	 * ��ȡ��ǰʱ�䵽�� 2008-03-25 �ꡪ�¡���
	 * 
	 * @param date
	 * @return
	 */
	public static String ymd(Date date) {
		return String.format("%tF", date);
	}

	/**
	 * ��������� 1-31
	 * 
	 * @param date
	 * @return
	 */
	public static String day_one(Date date) {
		return String.format("%te", date);
	}

	/**
	 * ��������� 01-31
	 * 
	 * @param date
	 * @return
	 */
	public static String day_two(Date date) {
		return String.format("%td", date);
	}

	/**
	 * һ���еĵڼ��� 085
	 * 
	 * @param date
	 * @return
	 */
	public static String day_to_year(Date date) {
		return String.format("%tj", date);
	}

	/**
	 * ����·ݼ��
	 */
	public static String month_referred(Date date) {
		return String.format("%tb", date);
	}

	/**
	 * ����·�ȫ��
	 * 
	 * @param date
	 * @return
	 */
	public static String month_full_name(Date date) {
		return String.format("%tB", date);
	}

	/**
	 * ����·� 01-12
	 * 
	 * @param date
	 * @return
	 */
	public static String month(Date date) {
		return String.format("%tm", date);
	}

	/**
	 * ������ڼ��
	 * 
	 * @param date
	 * @return
	 */
	public static String week_referred(Date date) {
		return String.format("%ta", date);
	}

	/**
	 * �������ȫ��
	 * 
	 * @param date
	 * @return
	 */
	public static String week_full_name(Date date) {
		return String.format("%tA", date);
	}

	/**
	 * ������� 16
	 * 
	 * @param date
	 * @return
	 */
	public static String year_referred(Date date) {
		return String.format("%ty", date);
	}

	/**
	 * �����ȫ�� 2016
	 * 
	 * @param date
	 * @return
	 */
	public static String year_full_name(Date date) {
		return String.format("%tY", date);
	}

	/**
	 * ���ڶ� ���� 25 13:37:22 CST 2016
	 * 
	 * @param date
	 * @return
	 */
	public static String time(Date date) {
		return String.format("%tc", date);
	}

	/**
	 * ��ȡʱ���������
	 * 
	 * @param date
	 * @return
	 */
	public static String time_to_mill(Date date) {
		return String.format("%tQ", date);
	}

	/**
	 * ��ȡʱ���������
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
	 *            ���ϵͳ��ʱ�� ����ForTime.DAY����죬ForTime.MONTH����£�ForTime.YEAR�����
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
	 *            ���ϵͳ��ʱ�䵽��
	 */
	public static String getSysTimeDay(int format) {
		switch (format) {
		case format1:
			return getSysTime(YEAR) + "��" + getSysTime(MONTH) + "��"
					+ getSysTime(DAY) + "��";
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
	 *            ���ϵͳ��ʱ�䵽��
	 */
	public static String getSysTimeSecond(int format) {
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat fmt;
		switch (format) {
		case format1:
			fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return fmt.format(rightNow.getTime());
		case format2:
			fmt = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
			return fmt.format(rightNow.getTime());
		case format3:
			fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			return fmt.format(rightNow.getTime());

		default:
			break;
		}
		fmt = new SimpleDateFormat("yyyy��MM��dd�� hh:mm:ss");
		return fmt.format(rightNow.getTime());
	}

	/**
	 * 
	 * @param MonthFirstDayToWeek
	 *            ����ϸ���Ҫ���������
	 */
	public static int getLastMonth(String MonthFirstDayToWeek) {
		return WeekToInt(MonthFirstDayToWeek);
	}

	/**
	 * 
	 * @param MonthFirstDayToWeek
	 * @param day
	 *            ����¸��¼��������
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
	 *            ������ת��������
	 */
	public static int WeekToInt(String week) {
		int week1 = 0;
		if (week.equals("����һ") || week.equals("Monday"))
			return 1;
		if (week.equals("���ڶ�") || week.equals("Tuesday"))
			return 2;
		if (week.equals("������") || week.equals("Wednesday"))
			return 3;
		if (week.equals("������") || week.equals("Thursday"))
			return 4;
		if (week.equals("������") || week.equals("Friday"))
			return 5;
		if (week.equals("������") || week.equals("Saturday"))
			return 6;
		return week1;
	}

	/**
	 * 
	 * @param year
	 *            �ж�����
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
	 *            ���ĳ��ĳ�µ�����
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
	 * ȡϵͳʱ��14λ
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
	 * ��ȡʱ���
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
	 * ��ʱ��ת��Ϊʱ���
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
				simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
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

	// ת��ʱ��Ϊ����+ʱ�䡢���졢ǰ�졢��������
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
		// Log.d("day_diff", day_diff + "��");

		String return_date = "����";

		if (date_shut.getYear() == curentDate.getYear()) {
			if (date_shut.getMonth() == curentDate.getMonth()) {
				switch (day_diff) {
				case 0:
					return_date = "����  ";

					break;
				case 1:
					return_date = "����";
					break;
				case 2:
					return_date = "ǰ��";
					break;

				}

			}

		}

		return return_date;

	}

	/**
	 * ��ʱ��ת��Ϊ����
	 * 
	 * @param day
	 * @param month
	 * @return
	 */
	public static String time2Constellation(int day, int month) {
		if ((month == 3 && day >= 21) || (month == 4 && day <= 19))
			return "������";
		if ((month == 4 && day >= 20) || (month == 5 && day <= 20))
			return "��ţ��";
		if ((month == 5 && day >= 21) || (month == 6 && day <= 21))
			return "˫����";
		if ((month == 6 && day >= 22) || (month == 7 && day <= 22))
			return "��з��";
		if ((month == 7 && day >= 23) || (month == 8 && day <= 22))
			return "ʨ����";
		if ((month == 8 && day >= 23) || (month == 9 && day <= 22))
			return "��Ů��";
		if ((month == 9 && day >= 23) || (month == 10 && day <= 23))
			return "�����";
		if ((month == 10 && day >= 24) || (month == 11 && day <= 22))
			return "��Ы��";
		if ((month == 11 && day >= 23) || (month == 12 && day <= 21))
			return "������";
		if ((month == 12 && day >= 22) || (month == 1 && day <= 19))
			return "Ħ����";
		if ((month == 1 && day >= 20) || (month == 2 && day <= 18))
			return "ˮƿ��";
		return "˫����";
	}

	/**
	 * ʱ���ת��Ϊʱ��
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
		return d + "��" + h + "Сʱ" + m + "����" + s + "��";
	}

	/**
	 * ʱ��ת��
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
				times[0] = "����";
			else
				times[0] = "����";
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
