package com.xh.image;
/**
 * @version 创建时间：2017-11-23 上午11:35:32
 * 项目：TvBlackAD-eclipse
 * 包名：com.tvblack.tv.image
 * 文件名：TVBImageListen.java
 * 作者：lhl
 * 说明:图片加载监听
 */

public interface XhImageListen {
	/**
	 * 
	 * lhl
	 * 2017-11-23 上午11:39:56
	 * 说明：失败回调
	 *  void
	 */
void fail();
/**
 * 
 * lhl
 * 2017-11-23 上午11:40:09
 * 说明： 成功回调
 * void
 */
void succeed();
}
