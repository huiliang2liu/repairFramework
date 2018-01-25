package com.xh.http;

import com.xh.ifaces.IHttpListen;

/**
 * @version 创建时间：2017-11-15 下午4:34:05
 * 项目：TvBlackAD-eclipse
 * 包名：com.tvblack.tv.http
 * 文件名：TVBHttpLoadListenObject.java
 * 作者：lhl
 * 说明:网络请求对象监听
 */

public interface XhHttpLoadListenObject extends IHttpListen {
	/**
	 * 
	 * lhl
	 * 2017-11-25 下午4:10:48
	 * 说明：加载成功回调
	 * @param object void
	 */
	void loaded( Object object);
}
