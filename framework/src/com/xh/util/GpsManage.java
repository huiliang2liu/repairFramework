package com.xh.util;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings.Secure;

public class GpsManage {
	private Context context;
	 /**
	  * <p>GPS开关
	  * <p>当前若关则打开
	  * <p>当前若开则关闭
	  */
	 private void toggleGPS() {
	  Intent gpsIntent = new Intent();
	  gpsIntent.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
	  gpsIntent.addCategory("android.intent.category.ALTERNATIVE");
	  gpsIntent.setData(Uri.parse("custom:3"));
	  try {
	   PendingIntent.getBroadcast(context, 0, gpsIntent, 0).send();
	  } catch (CanceledException e) {
	   e.printStackTrace();
	  }
	 }
	   //获取Gps开启或关闭状态  
	    private boolean getGpsStatus(Context context)  
	    {  
	        boolean status = Secure.isLocationProviderEnabled(context.getContentResolver(),   
	                LocationManager.GPS_PROVIDER);  
	        return status;  
	    }  
	      
	    //打开或关闭Gps  
	    private void setGpsStatus(Context context, boolean enabled)  
	    {  
	        Secure.setLocationProviderEnabled(context.getContentResolver(),  
	                LocationManager.GPS_PROVIDER, enabled);  
	    } 
//	    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />  
//	    <uses-permission android:name="android.permission.WRITE_SETTINGS" />  
//	    <uses-permission android:name="android.permission.WRITE_SECURE_SETTINGS" /> 
}
