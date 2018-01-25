package com.xh.http;

import com.xh.ifaces.IHttpListen;


/**
 * @version 创建时间：2017-11-15 下午4:32:53
 * 项目：TvBlackAD-eclipse
 * 包名：com.tvblack.tv.http
 * 文件名：TVBHttpLoadListenString.java
 * 作者：lhl 
 * 说明: 网络请求字符串监听
 */

public interface XhHttpLoadListenString extends IHttpListen {
	/**
	 * 
	 * lhl
	 * 2017-11-15 下午4:33:16
	 * 说明：加载完成
	 * @param string void
	 */
	void loaded(String string);
}
