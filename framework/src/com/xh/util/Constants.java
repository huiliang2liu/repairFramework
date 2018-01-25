package com.xh.util;

/**
 * @version 创建时间：2017-12-15 下午6:23:26 项目：repair 包名：com.xh.util
 *          文件名：Constants.java 作者：lhl 说明:
 */

public class Constants {
	private final static String TAG = Constants.class.getName();
	public static final long SECOND = 1000;// 秒
	public static final long MINUTE = 60 * SECOND;// 分钟
	public static final long HOUR = 60 * MINUTE;// 小时
	public static final long DAY = HOUR * 24;// 天
	public final static String NO_NETWORK = TAG + "_NO_NETWORK";
	public final static String NETWORK = TAG + "_NETWORK";
	public final static String CLASS_NAME = TAG + "CLASS_NAME";
}
