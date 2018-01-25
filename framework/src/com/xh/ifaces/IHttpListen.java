package com.xh.ifaces;
/**
 * @version 创建时间：2017-11-15 下午4:31:19
 * 项目：TvBlackAD-eclipse
 * 包名：com.tvblack.tv.http
 * 文件名：ITVBHttpListen.java
 * 作者：lhl
 * 说明:
 */

public interface IHttpListen {
	/**
	 * 
	 * lhl
	 * 2017-11-15 下午4:31:33
	 * 说明：开始加载时候回调
	 *  void
	 */
	void starting();
	/**
	 * 
	 * lhl
	 * 2017-11-15 下午4:31:47
	 * 说明：加载失败回调
	 * @param string void
	 */
	void loadDeafalt(String deafalt);
}
