package com.xh.http;

import java.io.InputStream;

import com.xh.util.StreamManage;

/**
 * @version ����ʱ�䣺2017-11-15 ����6:13:44 ��Ŀ��TvBlackAD-eclipse
 *          ������com.tvblack.tv.http �ļ�����TVBHttpString.java ���ߣ�lhl ˵��:ͬ���ַ�������
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
