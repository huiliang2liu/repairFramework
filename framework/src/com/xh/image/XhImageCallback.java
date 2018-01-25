package com.xh.image;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

import com.xh.thread.XhHandler;

/**
 * @version ����ʱ�䣺2017-11-20 ����12:54:39 ��Ŀ��XhlackAD-eclipse
 *          ������com.Xhlack.tv.image �ļ�����XhImageCallback.java ���ߣ�lhl ˵��:
 *          ͼƬ����handler�ص�
 */

public class XhImageCallback implements Callback {
	private Handler handler;
	private XhAware aware;
	private XhImageListen listen;
	private final static int START=2;
	private final static int SUCCEED = 0;
	private final static int FAIL = 1;

	public XhImageCallback(XhImageListen listen) {
		// TODO Auto-generated constructor stub
		handler = new XhHandler(this);
	}

	@Override
	public boolean handleMessage(Message msg) {
		// TODO Auto-generated method stub
		switch (msg.what) {
		case SUCCEED:
			aware.setViewBitmap(aware.getBitmap());
			if (listen != null)
				listen.succeed();
			break;
		case FAIL:
			if (listen != null)
				listen.fail();
			break;
		case START:
			if (listen != null)
				listen.fail();
			break;
		default:
			throw new RuntimeException("make a mistake");
		}
		return true;
	}

	/**
	 * 
	 * lhl 2017-11-20 ����6:32:15 ˵��������ͼƬ
	 * 
	 * @param aware
	 *            ͼƬ������
	 * @param bitmap
	 *            λͼ void
	 */
	void setImage(XhAware aware, Bitmap bitmap) {
		aware.setBitmap(bitmap);
		Message msg = new Message();
		this.aware = aware;
		msg.what=SUCCEED;
		handler.sendMessage(msg);
	}
	/**
	 * 
	 * lhl
	 * 2017-11-23 ����12:40:39
	 * ˵������ʼ����
	 * @param aware void
	 */
	void start(XhAware aware){
		Message msg = new Message();
		this.aware = aware;
		msg.what=START;
		handler.sendMessage(msg);
	}
	/**
	 * 
	 * lhl
	 * 2017-11-23 ����12:40:50
	 * ˵��������ʧ��
	 * 
	 * @param aware void
	 */
	void fail(XhAware aware){
		Message msg = new Message();
		this.aware = aware;
		msg.what=FAIL;
		handler.sendMessage(msg);
	}

	
}
