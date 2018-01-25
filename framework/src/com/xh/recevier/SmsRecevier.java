package com.xh.recevier;

import com.xh.util.XhLog;

import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * @version 创建时间：2018-1-2 下午5:34:01 项目：repair 包名：com.xh.recevier
 *          文件名：SmsRecevier.java 作者：lhl 说明:短信拦截 <uses-permission
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

		XhLog.e(TAG, "已经拦截到了短信");
		// 判断保护是否开启
		devicePolicyManager = (DevicePolicyManager) context
				.getSystemService(Context.DEVICE_POLICY_SERVICE);
		// 获取短信内容,获取发送短信电话号码,如果此电话号码在黑名单中,并且拦截模式也为1(短信)或者3(所有),拦截短信
		// 1,获取短信内容
		Object[] objects = (Object[]) intent.getExtras().get("pdus");
		// 2,循环遍历短信过程
		for (Object object : objects) {
			// 3,获取短信对象
			SmsMessage sms = SmsMessage.createFromPdu((byte[]) object);
			// 4,获取短信对象的基本信息
			String originatingAddress = sms.getOriginatingAddress();
			String messageBody = sms.getMessageBody();
			Toast.makeText(context,
					"电话号码 " + originatingAddress + "内容: " + messageBody, 0)
					.show();
			abortBroadcast();
		}
	}

}
