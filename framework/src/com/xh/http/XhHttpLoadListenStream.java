package com.xh.http;

import java.io.InputStream;

import com.xh.ifaces.IHttpListen;

/**
 * @version ����ʱ�䣺2017-11-15 ����4:29:00
 * ��Ŀ��TvBlackAD-eclipse
 * ������com.tvblack.tv.http
 * �ļ�����TVBHttpLoadListenStream.java
 * ���ߣ�lhl
 * ˵��:������������������
 */

public interface XhHttpLoadListenStream extends IHttpListen {
	/**
	 * 
	 * lhl
	 * 2017-11-15 ����4:32:10
	 * ˵�����������
	 * @param is void
	 */
void loaded(InputStream is);
}
