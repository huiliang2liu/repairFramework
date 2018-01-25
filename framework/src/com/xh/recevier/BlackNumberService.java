package com.xh.recevier;

import java.lang.reflect.Method;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.provider.CallLog.Calls;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

/**
 * 
 * �绰����
 * <uses-permission android:name="android.permission.CALL_PHONE"/>
 */
public class BlackNumberService extends Service {

	private TelephonyManager tm;
	private MyPhoneStateListener listener;
	private NotificationManager nm;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		listener = new MyPhoneStateListener();
		tm.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
		nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

	}

	private final class MyPhoneStateListener extends PhoneStateListener {

		private long startTime = 0;

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			// TODO Auto-generated method stub
			super.onCallStateChanged(state, incomingNumber);
			switch (state) {
			case TelephonyManager.CALL_STATE_RINGING:
				// �ж�����������Ƿ���
				endCall(incomingNumber);

				startTime = System.currentTimeMillis();

				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:

				break;
			case TelephonyManager.CALL_STATE_IDLE:
				long endTime = System.currentTimeMillis();
				// ����һ����
				if (endTime - startTime < 3000) {
					// ����֪ͨ
					// Notification notification = new Notification(
					// android.R.drawable.stat_notify_missed_call,
					// "���ص�����һ����", System.currentTimeMillis());
					// Intent intent = new Intent(getApplicationContext(),
					// BlackNumberListActivity.class);
					// intent.putExtra("number", incomingNumber);
					// PendingIntent contentIntent = PendingIntent.getActivity(
					// getApplicationContext(), 100, intent, 0);
					// notification.setLatestEventInfo(getApplicationContext(),
					// "����һ����", "���ص�����һ����", contentIntent);
					// notification.flags = Notification.FLAG_AUTO_CANCEL;
					// nm.notify(100, notification);
				}
				break;

			default:
				break;
			}
		}

	}

	// �Ҷϵ绰
	private void endCall(String incomingNumber) {
		try {
			Class<?> clazz = Class.forName("android.os.ServiceManager");
			Method method = clazz.getMethod("getService", String.class);
			IBinder ibinder = (IBinder) method.invoke(null,
					Context.TELEPHONY_SERVICE);
			Class iTelephony = Class
					.forName("com.android.internal.telephony.ITelephony");
			Class stub = Class
					.forName("com.android.internal.telephony.ITelephony$Stub");
			Method endCall = iTelephony.getDeclaredMethod("endCall");
			Method asInterface = stub.getDeclaredMethod("asInterface",
					IBinder.class);
			if (!asInterface.isAccessible())
				asInterface.setAccessible(true);
			Object receiver = asInterface.invoke(null, ibinder);
			if (!endCall.isAccessible())
				endCall.setAccessible(true);
			endCall.invoke(receiver);
			// ITelephony iTelephony = ITelephony.Stub.asInterface(ibinder);
			// iTelephony.endCall();

			// ɾ��ͨ����¼ ͨ����¼�ı�����һ���첽�Ĳ�������Ҫʹ��ContentObserver������ʵ��
			Uri uri = Calls.CONTENT_URI;
			getContentResolver().registerContentObserver(uri, true,
					new MyContentObserver(new Handler(), incomingNumber));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private final class MyContentObserver extends ContentObserver {

		private String incomingNumber;

		public MyContentObserver(Handler handler, String incomingNumber) {
			super(handler);
			// TODO Auto-generated constructor stub
			this.incomingNumber = incomingNumber;
		}

		@Override
		public void onChange(boolean selfChange) {
			// TODO Auto-generated method stub
			super.onChange(selfChange);
			Uri uri = Calls.CONTENT_URI;
			String where = Calls.NUMBER + " = ?";
			String[] selectionArgs = new String[] { incomingNumber };
			getContentResolver().delete(uri, where, selectionArgs);

			// �������
			getContentResolver().unregisterContentObserver(this);
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		// ȡ��״̬����
		tm.listen(listener, PhoneStateListener.LISTEN_NONE);
	}

}