package com.xh.http;

import java.io.InputStream;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

import com.xh.thread.XhHandler;
import com.xh.util.StreamManage;
import com.xh.util.XhLog;

/**
 * @version 创建时间：2017-12-20 下午4:10:22 项目：repair 包名：com.xh.http
 *          文件名：HttpCallback.java 作者：lhl 说明:
 */

public class XhHttpCallback implements Callback {
	private Handler handler;
	private XhHttpLoadListenStream listenStream;
	private XhHttpLoadListenString listenString;
	private XhHttp http;
	private final static int START = 1;
	private final static int LOADED = START << 1;
	private final static int DEAFALT = LOADED << 1;

	public XhHttpCallback() {
		// TODO Auto-generated constructor stub
		handler = new XhHandler(this);
	}

	void start() {
		XhLog.e("", "start");
		if (listenStream == null)
			return;
		if (http.isAsyn()) {
			Message msg = new Message();
			msg.what = START;
			handler.sendMessage(msg);
		} else
			listenStream.starting();
	}

	void loaded(InputStream is) {
		XhLog.e("", "loaded");
		if (http.isAsyn()) {
			Message msg = new Message();
			msg.what = LOADED;
			msg.obj = StreamManage.inputStream2String(is, null);
			handler.sendMessage(msg);
		} else {
			if (listenStream == null)
				return;
			listenStream.loaded(is);
		}
	}

	void loadDeafalt(String deafalt) {
		XhLog.e("", "loadDeafalt");
		if (listenStream == null)
			return;
		if (http.isAsyn()) {
			Message msg = new Message();
			msg.what = DEAFALT;
			msg.obj = deafalt;
			handler.sendMessage(msg);
		} else
			listenStream.loadDeafalt(deafalt);
	}

	@Override
	public boolean handleMessage(Message msg) {
		// TODO Auto-generated method stub
		switch (msg.what) {
		case START:
			listenStream.starting();
			break;
		case LOADED:
			if (listenString != null)
				listenString.loaded(((String) msg.obj));
			break;
		case DEAFALT:
			listenStream.loadDeafalt(((String) msg.obj));
			break;

		default:
			break;
		}
		return true;
	}

	public void setListenStream(XhHttpLoadListenStream listenStream) {
		this.listenStream = listenStream;
	}

	public void setListenString(XhHttpLoadListenString listenString) {
		this.listenString = listenString;
	}

	public void setHttp(XhHttp http) {
		this.http = http;
	}

}
