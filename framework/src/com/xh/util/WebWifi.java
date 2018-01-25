package com.xh.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.wifi.*;
import android.net.wifi.WifiManager.WifiLock;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract.Contacts.*;
import android.widget.Toast;

public class WebWifi {
	// ����WifiManager����
	private WifiManager mWifiManager;
	// ����WifiInfo����
	private WifiInfo mWifiInfo;
	// ɨ��������������б�
	private List<ScanResult> mWifiList;
	// ���������б�
	private List<WifiConfiguration> mWifiConfiguration;
	// ����һ��WifiLock
	WifiLock mWifiLock;

	// ���������û�Ȩ��
	//
	// <uses-permission
	// android:name="android.permission.ACCESS_WIFI_STATE"></uses-permission>
	//
	// <uses-permission
	// android:name="android.permission.CHANGE_WIFI_STATE"></uses-permission>
	//
	// <uses-permission
	// android:name="android.permission.WAKE_LOCK"></uses-permission>
	public WebWifi(Context context) {
		// TODO Auto-generated constructor stub
		// ȡ��WifiManager����
		mWifiManager = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		// ȡ��WifiInfo����
		if (mWifiManager != null) {
			openWifi();
			mWifiInfo = mWifiManager.getConnectionInfo();
		}
	}

	// ��WIFI
	public void openWifi() {
		if (!mWifiManager.isWifiEnabled()) {
			mWifiManager.setWifiEnabled(true);
		}
	}

	// �ر�WIFI
	public void closeWifi() {
		if (mWifiManager.isWifiEnabled()) {
			mWifiManager.setWifiEnabled(false);
		}
	}

	// ��鵱ǰWIFI״̬
	public int checkState() {
		return mWifiManager.getWifiState();
	}

	// ����WifiLock
	public void acquireWifiLock() {
		mWifiLock.acquire();
	}

	// ����WifiLock
	public void releaseWifiLock() {
		// �ж�ʱ������
		if (mWifiLock.isHeld()) {
			mWifiLock.acquire();
		}
	}

	// ����һ��WifiLock
	public void creatWifiLock() {
		mWifiLock = mWifiManager.createWifiLock("Test");
	}

	// �õ����úõ�����
	public List<WifiConfiguration> getConfiguration() {
		return mWifiConfiguration;
	}

	// ָ�����úõ������������
	public void connectConfiguration(int index) {
		// �����������úõ�������������
		if (index > mWifiConfiguration.size()) {
			return;
		}
		// �������úõ�ָ��ID������
		mWifiManager.enableNetwork(mWifiConfiguration.get(index).networkId,
				true);
	}

	public void startScan() {
		mWifiManager.startScan();
		// �õ�ɨ����
		mWifiList = mWifiManager.getScanResults();
		// �õ����úõ���������
		mWifiConfiguration = mWifiManager.getConfiguredNetworks();
	}

	// �õ������б�
	public List<ScanResult> getWifiList() {
		return mWifiList;
	}

	// �鿴ɨ����
	public StringBuilder lookUpScan() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < mWifiList.size(); i++) {
			stringBuilder
					.append("Index_" + new Integer(i + 1).toString() + ":");
			// ��ScanResult��Ϣת����һ���ַ�����
			// ���аѰ�����BSSID��SSID��capabilities��frequency��level
			stringBuilder.append((mWifiList.get(i)).toString());
			stringBuilder.append("/n");
		}
		return stringBuilder;
	}

	// �õ�MAC��ַ
	public String getMacAddress() {
		return (mWifiInfo == null) ? "NULL" : mWifiInfo.getMacAddress();
	}

	// �õ�������BSSID
	public String getBSSID() {
		return (mWifiInfo == null) ? "NULL" : mWifiInfo.getBSSID();
	}

	// �õ�IP��ַ
	public InetAddress getIPAddress() {
		try {
			return (mWifiInfo == null) ? null : InetAddress
					.getByName(intToIp(mWifiInfo.getIpAddress()));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private String intToIp(int i) {

		return (i & 0xFF) + "." +

		((i >> 8) & 0xFF) + "." +

		((i >> 16) & 0xFF) + "." +

		(i >> 24 & 0xFF);

	}

	// �õ����ӵ�ID
	public int getNetworkId() {
		return (mWifiInfo == null) ? 0 : mWifiInfo.getNetworkId();
	}

	// �õ�WifiInfo��������Ϣ��
	public String getWifiInfo() {
		return (mWifiInfo == null) ? "NULL" : mWifiInfo.toString();
	}

	// ���һ�����粢����
	public void addNetwork(WifiConfiguration wcg) {
		int wcgID = mWifiManager.addNetwork(wcg);
		boolean b = mWifiManager.enableNetwork(wcgID, true);
		System.out.println("a--" + wcgID);
		System.out.println("b--" + b);
	}

	// �Ͽ�ָ��ID������
	public void disconnectWifi(int netId) {
		mWifiManager.disableNetwork(netId);
		mWifiManager.disconnect();
	}

	/**
	 * ��������
	 * 
	 * @param index
	 * @param password
	 */
	public void connetionConfiguration(int index, String password) {
		// progressDialog = ProgressDialog.show(WifiActivity.this, "��������...",
		// "���Ժ�...");
		new ConnectWifiThread().execute(index + "", password);
	}

	/**
	 * ����wifi
	 * 
	 * @author passing
	 * 
	 */
	class ConnectWifiThread extends AsyncTask<String, Integer, String> {
		private Context context;

		@Override
		protected String doInBackground(String... params) {
			int index = Integer.parseInt(params[0]);
			if (index > mWifiList.size()) {
				return null;
			}
			// �������ú�ָ��ID������
			WifiConfiguration config = WifiUtil.createWifiInfo(
					mWifiList.get(index).SSID, params[1], 3, mWifiManager);

			int networkId = mWifiManager.addNetwork(config);
			if (null != config) {
				mWifiManager.enableNetwork(networkId, true);
				return mWifiList.get(index).SSID;
			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			// if (null != progressDialog)
			// {
			// progressDialog.dismiss();
			// }
			if (null != result) {
				handler.sendEmptyMessage(0);
			} else {
				handler.sendEmptyMessage(1);
			}
			super.onPostExecute(result);
		}

	}

	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:
				// wifi_result_textview.setText("���ڻ�ȡip��ַ...");
				// new RefreshSsidThread().start();
				break;
			case 1:
				// Toast.makeText(context, "����ʧ�ܣ�", Toast.LENGTH_SHORT)
				// .show();
				break;
			case 3:
				break;
			case 4:
				break;
			}
			super.handleMessage(msg);
		}

	};

}

class WifiUtil {
	/**
	 * ����wifi
	 * 
	 * @param SSID
	 * @param Password
	 * @param Type
	 * @return
	 */
	public static WifiConfiguration createWifiInfo(String SSID,
			String Password, int Type, WifiManager wifiManager) {
		WifiConfiguration config = new WifiConfiguration();
		config.allowedAuthAlgorithms.clear();
		config.allowedGroupCiphers.clear();
		config.allowedKeyManagement.clear();
		config.allowedPairwiseCiphers.clear();
		config.allowedProtocols.clear();
		config.SSID = "\"" + SSID + "\"";

		WifiConfiguration tempConfig = isExsits(SSID, wifiManager);
		if (tempConfig != null) {
			wifiManager.removeNetwork(tempConfig.networkId);
		}

		if (Type == 1) // WIFICIPHER_NOPASS
		{
			config.wepKeys[0] = "";
			config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
			config.wepTxKeyIndex = 0;
		}
		if (Type == 2) // WIFICIPHER_WEP
		{
			config.hiddenSSID = true;
			config.wepKeys[0] = "\"" + Password + "\"";
			config.allowedAuthAlgorithms
					.set(WifiConfiguration.AuthAlgorithm.SHARED);
			config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
			config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
			config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);
			config.allowedGroupCiphers
					.set(WifiConfiguration.GroupCipher.WEP104);
			config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
			config.wepTxKeyIndex = 0;
		}
		if (Type == 3) // WIFICIPHER_WPA
		{
			config.preSharedKey = "\"" + Password + "\"";
			config.hiddenSSID = true;
			config.allowedAuthAlgorithms
					.set(WifiConfiguration.AuthAlgorithm.OPEN);
			config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
			config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
			config.allowedPairwiseCiphers
					.set(WifiConfiguration.PairwiseCipher.TKIP);
			// config.allowedProtocols.set(WifiConfiguration.Protocol.WPA);
			config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
			config.allowedPairwiseCiphers
					.set(WifiConfiguration.PairwiseCipher.CCMP);
			config.status = WifiConfiguration.Status.ENABLED;
		}
		return config;
	}

	/**
	 * �ж�wifi�Ƿ����
	 * 
	 * @param SSID
	 * @param wifiManager
	 * @return
	 */
	private static WifiConfiguration isExsits(String SSID,
			WifiManager wifiManager) {
		List<WifiConfiguration> existingConfigs = wifiManager
				.getConfiguredNetworks();
		for (WifiConfiguration existingConfig : existingConfigs) {
			if (existingConfig.SSID.equals("\"" + SSID + "\"")) {
				return existingConfig;
			}
		}
		return null;
	}

	/**
	 * ת��IP��ַ
	 * 
	 * @param i
	 * @return
	 */
	public static String intToIp(int i) {
		return (i & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + ((i >> 16) & 0xFF)
				+ "." + ((i >> 24) & 0xFF);
	}
}
