package com.xh.plugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.util.AttributeSet;
import android.view.Display;

/**
 * @version 创建时间：2018-1-16 下午3:17:51 项目：repair 包名：com.xh.base
 *          文件名：IPluginServer.java 作者：lhl 说明:
 */

public interface IPluginWrapper {
	public boolean bindService(Intent service, ServiceConnection conn, int flags);

	public void onCreate(ContextWrapper wrapper);

	public int checkCallingOrSelfPermission(String permission);

	public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags);

	public int checkCallingPermission(String permission);

	public int checkCallingUriPermission(Uri uri, int modeFlags);

	public int checkPermission(String permission, int pid, int uid);

	public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags);

	public int checkUriPermission(Uri uri, String readPermission,
			String writePermission, int pid, int uid, int modeFlags);

	public void clearWallpaper() throws IOException;

	public Context createConfigurationContext(
			Configuration overrideConfiguration);

	public Context createDisplayContext(Display display);

	public Context createPackageContext(String packageName, int flags)
			throws NameNotFoundException;

	public String[] databaseList();

	public boolean deleteDatabase(String name);

	public boolean deleteFile(String name);

	public void enforceCallingOrSelfPermission(String permission, String message);

	public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags,
			String message);

	public void enforceCallingPermission(String permission, String message);

	public void enforceCallingUriPermission(Uri uri, int modeFlags,
			String message);

	public void enforcePermission(String permission, int pid, int uid,
			String message);

	public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags,
			String message);

	public void enforceUriPermission(Uri uri, String readPermission,
			String writePermission, int pid, int uid, int modeFlags,
			String message);

	public String[] fileList();

	public Context getApplicationContext();

	public ApplicationInfo getApplicationInfo();

	public AssetManager getAssets();

	public Context getBaseContext();

	public File getCacheDir();

	public ClassLoader getClassLoader();

	public ContentResolver getContentResolver();

	public File getDatabasePath(String name);

	public File getDir(String name, int mode);

	public File getExternalCacheDir();

	public File[] getExternalCacheDirs();

	public File getExternalFilesDir(String type);

	public File[] getExternalFilesDirs(String type);

	public File getFileStreamPath(String name);

	public File getFilesDir();

	public Looper getMainLooper();

	public File getObbDir();

	public File[] getObbDirs();

	public String getPackageCodePath();

	public PackageManager getPackageManager();

	public String getPackageName();

	public String getPackageResourcePath();

	public Resources getResources();

	public SharedPreferences getSharedPreferences(String name, int mode);

	public Object getSystemService(String name);

	public Theme getTheme();

	public Drawable getWallpaper();

	public int getWallpaperDesiredMinimumHeight();

	public int getWallpaperDesiredMinimumWidth();

	public void grantUriPermission(String toPackage, Uri uri, int modeFlags);

	public boolean isRestricted();

	public FileInputStream openFileInput(String name)
			throws FileNotFoundException;

	public FileOutputStream openFileOutput(String name, int mode)
			throws FileNotFoundException;

	public SQLiteDatabase openOrCreateDatabase(String name, int mode,
			CursorFactory factory, DatabaseErrorHandler errorHandler);

	public SQLiteDatabase openOrCreateDatabase(String name, int mode,
			CursorFactory factory);

	public Drawable peekWallpaper();

	public Intent registerReceiver(BroadcastReceiver receiver,
			IntentFilter filter, String broadcastPermission, Handler scheduler);

	public Intent registerReceiver(BroadcastReceiver receiver,
			IntentFilter filter);

	public void removeStickyBroadcast(Intent intent);

	public void removeStickyBroadcastAsUser(Intent intent, UserHandle user);

	public void revokeUriPermission(Uri uri, int modeFlags);

	public void sendBroadcast(Intent intent, String receiverPermission);

	public void sendBroadcast(Intent intent);

	public void sendBroadcastAsUser(Intent intent, UserHandle user,
			String receiverPermission);

	public void sendBroadcastAsUser(Intent intent, UserHandle user);

	public void sendOrderedBroadcast(Intent intent, String receiverPermission,
			BroadcastReceiver resultReceiver, Handler scheduler,
			int initialCode, String initialData, Bundle initialExtras);

	public void sendOrderedBroadcast(Intent intent, String receiverPermission);

	public void sendOrderedBroadcastAsUser(Intent intent, UserHandle user,
			String receiverPermission, BroadcastReceiver resultReceiver,
			Handler scheduler, int initialCode, String initialData,
			Bundle initialExtras);

	public void sendStickyBroadcast(Intent intent);

	public void sendStickyBroadcastAsUser(Intent intent, UserHandle user);

	public void sendStickyOrderedBroadcast(Intent intent,
			BroadcastReceiver resultReceiver, Handler scheduler,
			int initialCode, String initialData, Bundle initialExtras);

	public void sendStickyOrderedBroadcastAsUser(Intent intent,
			UserHandle user, BroadcastReceiver resultReceiver,
			Handler scheduler, int initialCode, String initialData,
			Bundle initialExtras);

	public void setTheme(int resid);

	public void setWallpaper(Bitmap bitmap) throws IOException;

	public void setWallpaper(InputStream data) throws IOException;

	public void startActivities(Intent[] intents, Bundle options);

	public void startActivities(Intent[] intents);

	public void startActivity(Intent intent, Bundle options);

	public void startActivity(Intent intent);

	public boolean startInstrumentation(ComponentName className,
			String profileFile, Bundle arguments);

	public void startIntentSender(IntentSender intent, Intent fillInIntent,
			int flagsMask, int flagsValues, int extraFlags, Bundle options)
			throws SendIntentException;

	public void startIntentSender(IntentSender intent, Intent fillInIntent,
			int flagsMask, int flagsValues, int extraFlags)
			throws SendIntentException;

	public ComponentName startService(Intent service);

	public boolean stopService(Intent name);

	public void unbindService(ServiceConnection conn);

	public void unregisterReceiver(BroadcastReceiver receiver);

	public void registerComponentCallbacks(ComponentCallbacks callback);

	public void unregisterComponentCallbacks(ComponentCallbacks callback);

	public CharSequence getText(int resId);

	public String getString(int resId);

	public String getString(int resId, Object... formatArgs);

	public TypedArray obtainStyledAttributes(int[] attrs);

	public TypedArray obtainStyledAttributes(int resid, int[] attrs)
			throws Resources.NotFoundException;

	public TypedArray obtainStyledAttributes(AttributeSet set, int[] attrs);

	public TypedArray obtainStyledAttributes(AttributeSet set, int[] attrs,
			int defStyleAttr, int defStyleRes);
}
