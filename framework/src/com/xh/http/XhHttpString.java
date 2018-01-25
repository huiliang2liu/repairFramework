package com.xh.http;

import java.io.InputStream;

import com.xh.util.StreamManage;

/**
 * @version 创建时间：2017-11-15 下午6:13:44 项目：TvBlackAD-eclipse
 *          包名：com.tvblack.tv.http 文件名：TVBHttpString.java 作者：lhl 说明:同步字符串请求
 */

public class XhHttpString extends XhHttpStream implements
		XhHttpLoadListenStream {
	private XhHttpLoadListenString listenString;

	public XhHttpString(XhHttpCallback handler) {
		super(handler);
		// TODO Auto-generated constructor stub
		setListemStream(this);
	}

	public void setListemString(XhHttpLoadListenString listenString) {
		this.listenString = listenString;
		callback.setListenString(listenString);
	}

	@Override
	public void starting() {
		// TODO Auto-generated method stub
		if (listenString != null)
			listenString.starting();
	}

	@Override
	public void loadDeafalt(String deafalt) {
		// TODO Auto-generated method stub
		if (listenString != null)
			listenString.loadDeafalt(deafalt);
	}

	@Override
	public void loaded(InputStream is) {
		// TODO Auto-generated method stub
		if (listenString != null)
			listenString.loaded(StreamManage.inputStream2String(is, null));
	}
}
