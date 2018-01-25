package com.xh.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * 获取系统中的Intent
 * 
 */
public class IntentUtil {
	/**
	 * 调用浏览器
	 * 
	 * @param url
	 * @return
	 */
	public static Intent open_url(String url) {
		Uri webViewUri = Uri.parse(url);
		Intent intent = new Intent(Intent.ACTION_VIEW, webViewUri);
		return intent;
	}

	/**
	 * 调用地图
	 * 
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            维度
	 * @return
	 */
	public static Intent j(float longitude, float latitude) {
		Uri mapUri = Uri.parse("geo:" + longitude + "," + latitude);
		Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
		return intent;
	}

	/**
	 * 播放mp3
	 * 
	 * @param file
	 * @return
	 */
	public static Intent open_audio(String file,String end) {
		Uri playUri = Uri.parse(file);
		Intent intent = new Intent(Intent.ACTION_VIEW, playUri);
		intent.setDataAndType(playUri, "audio/"+end);
		return intent;
	}
	/**
	 * 播放视频
	 * xh
	 * 2017-2-15 上午9:49:56
	 * @param file
	 * @param end
	 * @return
	 */
	public static Intent open_video(String file,String end){
		Uri playUri = Uri.parse(file);
		Intent intent = new Intent(Intent.ACTION_VIEW, playUri);
		intent.setDataAndType(playUri, "video/"+end);
		return intent;
	} 

	/**
	 * 调用拨打电话
	 * 
	 * @param phon_num
	 * @return
	 */
	public static Intent open_phone(int phon_num) {
		Uri dialUri = Uri.parse("tel:" + phon_num);
		Intent intent = new Intent(Intent.ACTION_DIAL, dialUri);
		return intent;
	}

	/**
	 * 直接拨打电话，需要加上权限<uses-permission id="android.permission.CALL_PHONE" />
	 * 
	 * @param phon_num
	 * @return
	 */
	public static Intent make_phone(int phon_num) {
		Uri callUri = Uri.parse("tel:" + phon_num);
		Intent intent = new Intent(Intent.ACTION_CALL, callUri);
		return intent;
	}

	/**
	 * 调用发邮件（这里要事先配置好的系统Email，否则是调不出发邮件界面的）
	 * 
	 * @param email
	 * @return
	 */
	public static Intent open_email(String email) {
		Uri emailUri = Uri.parse(email);
		Intent intent = new Intent(Intent.ACTION_SENDTO, emailUri);
		return intent;
	}

	/**
	 * 直接发邮件
	 * 
	 * @param tos
	 * @param ccs
	 * @param text
	 * @return
	 */
	public static Intent send_email(String[] tos, String ccs, String text) {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.putExtra(Intent.EXTRA_EMAIL, tos);
		intent.putExtra(Intent.EXTRA_CC, ccs);
		intent.putExtra(Intent.EXTRA_TEXT, text);
		intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
		intent.setType("text/plain");
		Intent.createChooser(intent, "Choose Email Client");
		return intent;
	}

	/**
	 * 发短信
	 * 
	 * @param text
	 * @return
	 */
	public static Intent open_sms(String text) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.putExtra("sms_body", text);
		intent.setType("vnd.android-dir/mms-sms");
		return intent;
	}

	/**
	 * 直接发短信
	 * 
	 * @param phone_num
	 * @param text
	 * @return
	 */
	public static Intent send_sms(int phone_num, String text) {
		Uri smsToUri = Uri.parse("smsto:" + phone_num);
		Intent intent = new Intent(Intent.ACTION_SENDTO, smsToUri);
		intent.putExtra("sms_body", text);
		return intent;
	}

	/**
	 * 发彩信
	 * 
	 * @param text
	 * @return
	 */
	public static Intent open_mms(String text) {
		Uri mmsUri = Uri.parse("content://media/external/images/media/23");
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.putExtra("sms_body", text);
		intent.putExtra(Intent.EXTRA_STREAM, mmsUri);
		intent.setType("image/png");
		return intent;
	}

	/**
	 * 卸载应用
	 * 
	 * @return
	 */
	public static Intent uninstall(String package_name) {
		Uri uninstallUri = Uri.fromParts("package", package_name, null);
		Intent intent = new Intent(Intent.ACTION_DELETE, uninstallUri);
		return intent;
	}

	public static Intent install(String file) {
		// 安装应用
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.parse(file),
				"application/vnd.android.package-archive");
		return intent;
	}

	/**
	 * 运行app
	 * 
	 * @param context
	 * @param package_name
	 * @return
	 */
	public static Intent run(Context context, String package_name) {
		return context.getPackageManager().getLaunchIntentForPackage(
				package_name);
	}
}
