package com.xh.http;

/**
 * @version ����ʱ�䣺2017-11-15 ����6:13:44 ��Ŀ��TvBlackAD-eclipse
 *          ������com.tvblack.tv.http �ļ�����TVBHttpStream.java ���ߣ�lhl ˵��: ͬ������������
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
