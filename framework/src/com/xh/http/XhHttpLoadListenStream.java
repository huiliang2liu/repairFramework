package com.xh.http;

import java.io.InputStream;

import com.xh.ifaces.IHttpListen;

/**
 * @version 创建时间：2017-11-15 下午4:29:00
 * 项目：TvBlackAD-eclipse
 * 包名：com.tvblack.tv.http
 * 文件名：TVBHttpLoadListenStream.java
 * 作者：lhl
 * 说明:网络请求数据流监听
 */

public interface XhHttpLoadListenStream extends IHttpListen {
	/**
	 * 
	 * lhl
	 * 2017-11-15 下午4:32:10
	 * 说明：加载完成
	 * @param is void
	 */
void loaded(InputStream is);
}
