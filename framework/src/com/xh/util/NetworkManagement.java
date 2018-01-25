package com.xh.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

public class NetworkManagement {
	public static final String CTWAP = "ctwap";
	public static final String CTNET = "ctnet";
	public static final String CMWAP = "cmwap";
	public static final String CMNET = "cmnet";
	public static final String NET_3G = "3gnet";
	public static final String WAP_3G = "3gwap";
	public static final String UNIWAP = "uniwap";
	public static final String UNINET = "uninet";

	public static final int TYPE_CT_WAP = 5;
	public static final int TYPE_CT_NET = 6;
	public static final int TYPE_CT_WAP_2G = 7;
	public static final int TYPE_CT_NET_2G = 8;

	public static final int TYPE_CM_WAP = 9;
	public static final int TYPE_CM_NET = 10;
	public static final int TYPE_CM_WAP_2G = 11;
	public static final int TYPE_CM_NET_2G = 12;

	public static final int TYPE_CU_WAP = 13;
	public static final int TYPE_CU_NET = 14;
	public static final int TYPE_CU_WAP_2G = 15;
	public static final int TYPE_CU_NET_2G = 16;

	public static final int TYPE_OTHER = 17;
	public static Uri PREFERRED_APN_URI = Uri
			.parse("content://telephony/carriers/preferapn");

	/** û������ */
	public static final int TYPE_NET_WORK_DISABLED = 0;

	/** wifi���� */
	public static final int TYPE_WIFI = 4;
	private static ConnectivityManager connectivityManager;
	private static NetworkInfo networkInfo;

	// <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
	// <uses-permission android:name="android.permission.INTERNET"/>
	public NetworkManagement(Context context) {
		// TODO Auto-generated constructor stub
		createConnectivityManager(context);
		createNetworkInfo();
		// NetworkInfo [] networkInfos =
		// connectivityManager.getAllNetworkInfo();
	}

	public static void createConnectivityManager(Context context) {
		connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
	}

	public static void createNetworkInfo() {
		// TelephonyManager telephonyManager =
		// (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
		// int networkType = telephonyManager.getNetworkType();
		networkInfo = connectivityManager.getActiveNetworkInfo();
	}

	/**
	 * �ж��Ƿ�Ϊ����
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isRoam(Context context) {
		if (connectivityManager == null) {
			createConnectivityManager(context);
			createNetworkInfo();
		}
		if (networkInfo == null)
			return false;
		if (!networkInfo.isConnected())
			return false;
		if (networkInfo.isRoaming())
			return true;
		return false;
	}

	/**
	 * �ж������Ƿ����
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isNetworkAvailable(Context context) {
		createConnectivityManager(context);
		createNetworkInfo();
		if (networkInfo == null)
			return false;
		if (!networkInfo.isConnected())
			return false;
		if (networkInfo.isConnected())
			return true;
		return false;
	}

	/***
	 * �ж�Network�������ͣ���ͨ�ƶ�wap������wap������net��
	 * 
	 * */
	public static int checkNetworkType(Context mContext) {
		try {
			final ConnectivityManager connectivityManager = (ConnectivityManager) mContext
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			final NetworkInfo mobNetInfoActivity = connectivityManager
					.getActiveNetworkInfo();
			if (mobNetInfoActivity == null || !mobNetInfoActivity.isAvailable())
				// ע��һ��
				// NetworkInfo Ϊ�ջ��߲������õ�ʱ���������Ӧ���ǵ�ǰû�п������磬
				// ������Щ���Ż������Կ�������������
				// ���Ե���net���紦����Ȼ�����������硣
				// ��Ȼ����socket�в�׽�쳣�����ж����ж����û���ʾ����
				return TYPE_NET_WORK_DISABLED;
			// NetworkInfo��Ϊnull��ʼ�ж�����������
			int netType = mobNetInfoActivity.getType();
			if (netType == ConnectivityManager.TYPE_WIFI)
				// wifi net����
				return TYPE_WIFI;
			if (netType == ConnectivityManager.TYPE_MOBILE) {
				// ע�����
				// �ж��Ƿ����wap:
				// ��Ҫͨ��getExtraInfo��ȡ������������ж����ͣ�
				// ��Ϊͨ��Ŀǰ���Ŷ��ֻ��Ͳ��Է��ֽ�������ƴ�Ϊ#777����null��
				// ���Ż���wap�������Ҫ���ƶ���ͨwap����������һ���û���������,
				// ���Կ���ͨ����������жϣ�
				boolean is3G = isFastMobileNetwork(mContext);
				final Cursor c = mContext.getContentResolver().query(
						PREFERRED_APN_URI, null, null, null, null);
				if (c != null) {
					c.moveToFirst();
					final String user = c.getString(c.getColumnIndex("user"));
					if (!TextUtils.isEmpty(user)) {
						if (user.startsWith(CTWAP))
							return is3G ? TYPE_CT_WAP : TYPE_CT_WAP_2G;
						if (user.startsWith(CTNET))
							return is3G ? TYPE_CT_NET : TYPE_CT_NET_2G;
					}
				}
				c.close();
				// ע������
				// �ж����ƶ���ͨwap:
				// ��ʵ����һ�ַ���ͨ��getString(c.getColumnIndex("proxy")��ȡ����ip
				// ���жϽ���㣬10.0.0.172�����ƶ���ͨwap��10.0.0.200���ǵ���wap������
				// ʵ�ʿ����в��������л������ܻ�ȡ������������Ϣ����������M9 ��2.2����...
				// ���Բ���getExtraInfo��ȡ��������ֽ����ж�
				String netMode = mobNetInfoActivity.getExtraInfo();
				Log.i("", "==================netmode:" + netMode);
				if (netMode != null) {
					// ͨ��apn�����ж��Ƿ�����ͨ���ƶ�wap
					netMode = netMode.toLowerCase();
					if (netMode.equals(CMWAP))
						return is3G ? TYPE_CM_WAP : TYPE_CM_WAP_2G;
					if (netMode.equals(CMNET))
						return is3G ? TYPE_CM_NET : TYPE_CM_NET_2G;
					if (netMode.equals(NET_3G) || netMode.equals(UNINET))
						return is3G ? TYPE_CU_NET : TYPE_CU_NET_2G;
					if (netMode.equals(WAP_3G) || netMode.equals(UNIWAP))
						return is3G ? TYPE_CU_WAP : TYPE_CU_WAP_2G;
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return TYPE_OTHER;
		}

		return TYPE_OTHER;

	}

	private static boolean isFastMobileNetwork(Context context) {
		TelephonyManager telephonyManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);

		switch (telephonyManager.getNetworkType()) {
		case TelephonyManager.NETWORK_TYPE_1xRTT:
			return false; // ~ 50-100 kbps
		case TelephonyManager.NETWORK_TYPE_CDMA:
			return false; // ~ 14-64 kbps
		case TelephonyManager.NETWORK_TYPE_EDGE:
			return false; // ~ 50-100 kbps
		case TelephonyManager.NETWORK_TYPE_EVDO_0:
			return true; // ~ 400-1000 kbps
		case TelephonyManager.NETWORK_TYPE_EVDO_A:
			return true; // ~ 600-1400 kbps
		case TelephonyManager.NETWORK_TYPE_GPRS:
			return false; // ~ 100 kbps
		case TelephonyManager.NETWORK_TYPE_HSDPA:
			return true; // ~ 2-14 Mbps
		case TelephonyManager.NETWORK_TYPE_HSPA:
			return true; // ~ 700-1700 kbps
		case TelephonyManager.NETWORK_TYPE_HSUPA:
			return true; // ~ 1-23 Mbps
		case TelephonyManager.NETWORK_TYPE_UMTS:
			return true; // ~ 400-7000 kbps
		case TelephonyManager.NETWORK_TYPE_EHRPD:
			return true; // ~ 1-2 Mbps
		case TelephonyManager.NETWORK_TYPE_EVDO_B:
			return true; // ~ 5 Mbps
		case TelephonyManager.NETWORK_TYPE_HSPAP:
			return true; // ~ 10-20 Mbps
		case TelephonyManager.NETWORK_TYPE_IDEN:
			return false; // ~25 kbps
		case TelephonyManager.NETWORK_TYPE_LTE:
			return true; // ~ 10+ Mbps
		case TelephonyManager.NETWORK_TYPE_UNKNOWN:
			return false;
		default:
			return false;

		}
	}

	/**
	 * �������������
	 * */
	public static void setNetworkMethod(Context context) {
		Intent intent = null;
		// �ж��ֻ�ϵͳ�İ汾 ��API����10 ����3.0�����ϰ汾
		// intent = new Intent(Settings.ACTION_APN_SETTINGS);
		// startActivity(intent);
		if (android.os.Build.VERSION.SDK_INT > 10) {
			intent = new Intent(
					android.provider.Settings.ACTION_WIRELESS_SETTINGS);
			context.startActivity(intent);
			return;
		}
		intent = new Intent();
		ComponentName component = new ComponentName("com.android.settings",
				"com.android.settings.WirelessSettings");
		intent.setComponent(component);
		intent.setAction("android.intent.action.VIEW");
		context.startActivity(intent);
	}

	/**
	 * ��wifi����
	 */
	public static void setwifi(Context context) {
		// 3.0���ϴ����ý��棬Ҳ����ֱ����ACTION_WIRELESS_SETTINGS�򿪵�wifi����
		if (android.os.Build.VERSION.SDK_INT > 10) {
			context.startActivity(new Intent(
					android.provider.Settings.ACTION_SETTINGS));
			return;
		}
		context.startActivity(new Intent(
				android.provider.Settings.ACTION_WIRELESS_SETTINGS));
	}

	public static void setSet(Context context) {
		// ��com.android.settings.AccessibilitySettings ������������
		// ����com.android.settings.ActivityPicker ѡ��
		// ����com.android.settings.ApnSettings APN����
		// ����com.android.settings.ApplicationSettings Ӧ�ó�������
		// ����com.android.settings.BandMode ����GSM/UMTS����
		// ����com.android.settings.BatteryInfo �����Ϣ
		// ����com.android.settings.DateTimeSettings ���ںͰ���������ʱ������
		// ����com.android.settings.DateTimeSettingsSetupWizard ���ں�ʱ������
		// ����com.android.settings.DevelopmentSettings Ӧ�ó�������=����������
		// ����com.android.settings.DeviceAdminSettings �豸������
		// ����com.android.settings.DeviceInfoSettings �����ֻ�
		// ����com.android.settings.Display ��ʾ����������ʾ�����С��Ԥ��
		// ����com.android.settings.DisplaySettings ��ʾ����
		// ����com.android.settings.DockSettings ��������
		// ����com.android.settings.IccLockSettings SIM����������
		// ����com.android.settings.InstalledAppDetails ���Ժͼ�������
		// ����com.android.settings.LanguageSettings ���Ժͼ�������
		// ����com.android.settings.LocalePicker ѡ���ֻ�����
		// ����com.android.settings.LocalePickerInSetupWizard ѡ���ֻ�����
		// ����com.android.settings.ManageApplications �����أ���װ������б�
		// ����com.android.settings.MasterClear �ָ���������
		// ����com.android.settings.MediaFormat ��ʽ���ֻ�����
		// ����com.android.settings.PhysicalKeyboardSettings ���ü���
		// ����com.android.settings.PrivacySettings ��˽����
		// ����com.android.settings.ProxySelector ��������
		// ����com.android.settings.RadioInfo �ֻ���Ϣ
		// ����com.android.settings.RunningServices �������еĳ��򣨷���
		// ����com.android.settings.SecuritySettings λ�úͰ�ȫ����
		// ����com.android.settings.Settings ϵͳ����
		// ����com.android.settings.SettingsSafetyLegalActivity ��ȫ��Ϣ
		// ����com.android.settings.SoundSettings ��������
		// ����com.android.settings.TestingSettings ���ԡ�����ʾ�ֻ���Ϣ�������Ϣ��ʹ�����ͳ�ơ�Wifi
		// information��������Ϣ
		// ����com.android.settings.TetherSettings �����Яʽ�ȵ�
		// ����com.android.settings.TextToSpeechSettings ����ת��������
		// ����com.android.settings.UsageStats ʹ�����ͳ��
		// ����com.android.settings.UserDictionarySettings �û��ʵ�
		// ����com.android.settings.VoiceInputOutputSettings �����������������
		// ����com.android.settings.WirelessSettings ���ߺ���������
		// Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
		// context.startActivity(intent);
		Intent intent = new Intent(Settings.ACTION_SETTINGS);
		context.startActivity(intent);
	}

	/**
	 * �ƶ����翪��
	 */
	public void toggleMobileData(Context context, boolean enabled) {
		ConnectivityManager conMgr = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		Class<?> conMgrClass = null; // ConnectivityManager��
		Field iConMgrField = null; // ConnectivityManager���е��ֶ�
		Object iConMgr = null; // IConnectivityManager�������
		Class<?> iConMgrClass = null; // IConnectivityManager��
		Method setMobileDataEnabledMethod = null; // setMobileDataEnabled����

		try {
			// ȡ��ConnectivityManager��
			conMgrClass = Class.forName(conMgr.getClass().getName());
			// ȡ��ConnectivityManager���еĶ���mService
			iConMgrField = conMgrClass.getDeclaredField("mService");
			// ����mService�ɷ���
			iConMgrField.setAccessible(true);
			// ȡ��mService��ʵ������IConnectivityManager
			iConMgr = iConMgrField.get(conMgr);
			// ȡ��IConnectivityManager��
			iConMgrClass = Class.forName(iConMgr.getClass().getName());
			// ȡ��IConnectivityManager���е�setMobileDataEnabled(boolean)����
			setMobileDataEnabledMethod = iConMgrClass.getDeclaredMethod(
					"setMobileDataEnabled", Boolean.TYPE);
			// ����setMobileDataEnabled�����ɷ���
			setMobileDataEnabledMethod.setAccessible(true);
			// ����setMobileDataEnabled����
			setMobileDataEnabledMethod.invoke(iConMgr, enabled);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ж�WIFI�����Ƿ����
	 * 
	 * @param context
	 * @return
	 */
	public boolean isWifiConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mWiFiNetworkInfo = mConnectivityManager
					.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
			if (mWiFiNetworkInfo != null) {
				return mWiFiNetworkInfo.isAvailable();
			}
		}
		return false;
	}

	/**
	 * �ж�MOBILE�����Ƿ����
	 * 
	 * @param context
	 * @return
	 */
	public boolean isMobileConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mMobileNetworkInfo = mConnectivityManager
					.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
			if (mMobileNetworkInfo != null) {
				return mMobileNetworkInfo.isAvailable();
			}
		}
		return false;
	}

	/**
	 * ��ȡ��ǰ�������ӵ�������Ϣ
	 * 
	 * @param context
	 * @return
	 */
	public static int getConnectedType(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager
					.getActiveNetworkInfo();
			if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
				return mNetworkInfo.getType();
			}
		}
		return -1;
	}
}
