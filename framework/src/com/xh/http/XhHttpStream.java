package com.xh.http;

/**
 * @version 创建时间：2017-11-15 下午6:13:44 项目：TvBlackAD-eclipse
 *          包名：com.tvblack.tv.http 文件名：TVBHttpStream.java 作者：lhl 说明: 同步数据流请求
 */

public class XhHttpStream extends XhHttp {

	public XhHttpStream(XhHttpCallback handler) {
		// TODO Auto-generated constructor stub
		this.setType(Type.GET);
		setCallback(handler);
	}

	public void setListemStream(XhHttpLoadListenStream listenStream) {
		callback.setListenStream(listenStream);
	}

}
