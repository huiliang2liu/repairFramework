package com.xh.recevier;

import com.xh.util.XhLog;

import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * @version ����ʱ�䣺2018-1-2 ����5:34:01 ��Ŀ��repair ������com.xh.recevier
 *          �ļ�����SmsRecevier.java ���ߣ�lhl ˵��:�������� <uses-permission
 *          android:name="android.permission.RECEIVE_SMS"/> <uses-permission
 *          android:name="android.permission.SEND_SMS"/> <uses-permission
 *          android:name="android.permission.CALL_PHONE"/> <uses-permission
 *          android:name="android.permission.READ_SMS"/> <uses-permission
 *          android:name="android.permission.PROCESS_OUTGOING_CALLS"/>
 */

public class SmsRecevier extends BroadcastReceiver {
	private final static String TAG = "SmsRecevier";
	DevicePolicyManager devicePolicyManager;

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub

		XhLog.e(TAG, "�Ѿ����ص��˶���");
		// �жϱ����Ƿ���
		devicePolicyManager = (DevicePolicyManager) context
				.getSystemService(Context.DEVICE_POLICY_SERVICE);
		// ��ȡ��������,��ȡ���Ͷ��ŵ绰����,����˵绰�����ں�������,��������ģʽҲΪ1(����)����3(����),���ض���
		// 1,��ȡ��������
		Object[] objects = (Object[]) intent.getExtras().get("pdus");
		// 2,ѭ���������Ź���
		for (Object object : objects) {
			// 3,��ȡ���Ŷ���
			SmsMessage sms = SmsMessage.createFromPdu((byte[]) object);
			// 4,��ȡ���Ŷ���Ļ�����Ϣ
			String originatingAddress = sms.getOriginatingAddress();
			String messageBody = sms.getMessageBody();
			Toast.makeText(context,
					"�绰���� " + originatingAddress + "����: " + messageBody, 0)
					.show();
			abortBroadcast();
		}
	}

}
