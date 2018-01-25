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
import android.content.res.Resources.NotFoundException;
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
 * @version 创建时间：2018-1-16 下午3:33:21 项目：repair 包名：com.xh.plugin
 *          文件名：PluginWrapper.java 作者：lhl 说明:
 */

public class PluginWrapperImpl implements IPluginWrapper {
	protected ContextWrapper wrapper;

	@Override
	public final void onCreate(ContextWrapper wrapper) {
		// TODO Auto-generated method stub
		this.wrapper = wrapper;
	}

	@Override
	public final boolean bindService(Intent service, ServiceConnection conn,
			int flags) {
		// TODO Auto-generated method stub
		return wrapper.bindService(service, conn, flags);
	}

	@Override
	public final int checkCallingOrSelfPermission(String permission) {
		// TODO Auto-generated method stub
		return wrapper.checkCallingOrSelfPermission(permission);
	}

	@Override
	public final int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
		// TODO Auto-generated method stub
		return wrapper.checkCallingOrSelfUriPermission(uri, modeFlags);
	}

	@Override
	public final int checkCallingPermission(String permission) {
		// TODO Auto-generated method stub
		return wrapper.checkCallingPermission(permission);
	}

	@Override
	public final int checkCallingUriPermission(Uri uri, int modeFlags) {
		// TODO Auto-generated method stub
		return wrapper.checkCallingUriPermission(uri, modeFlags);
	}

	@Override
	public final int checkPermission(String permission, int pid, int uid) {
		// TODO Auto-generated method stub
		return wrapper.checkPermission(permission, pid, uid);
	}

	@Override
	public final int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
		// TODO Auto-generated method stub
		return wrapper.checkUriPermission(uri, pid, uid, modeFlags);
	}

	@Override
	public final int checkUriPermission(Uri uri, String readPermission,
			String writePermission, int pid, int uid, int modeFlags) {
		// TODO Auto-generated method stub
		return wrapper.checkUriPermission(uri, readPermission, writePermission,
				pid, uid, modeFlags);
	}

	@Override
	public final void clearWallpaper() throws IOException {
		// TODO Auto-generated method stub
		wrapper.clearWallpaper();
	}

	@Override
	public final Context createConfigurationContext(
			Configuration overrideConfiguration) {
		// TODO Auto-generated method stub
		return wrapper.createConfigurationContext(overrideConfiguration);
	}

	@Override
	public final Context createDisplayContext(Display display) {
		// TODO Auto-generated method stub
		return wrapper.createDisplayContext(display);
	}

	@Override
	public final Context createPackageContext(String packageName, int flags)
			throws NameNotFoundException {
		// TODO Auto-generated method stub
		return wrapper.createPackageContext(packageName, flags);
	}

	@Override
	public final String[] databaseList() {
		// TODO Auto-generated method stub
		return wrapper.databaseList();
	}

	@Override
	public final boolean deleteDatabase(String name) {
		// TODO Auto-generated method stub
		return wrapper.deleteDatabase(name);
	}

	@Override
	public final boolean deleteFile(String name) {
		// TODO Auto-generated method stub
		return wrapper.deleteFile(name);
	}

	@Override
	public final void enforceCallingOrSelfPermission(String permission,
			String message) {
		// TODO Auto-generated method stub
		wrapper.enforceCallingOrSelfPermission(permission, message);
	}

	@Override
	public final void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags,
			String message) {
		// TODO Auto-generated method stub
		wrapper.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
	}

	@Override
	public final void enforceCallingPermission(String permission, String message) {
		// TODO Auto-generated method stub
		wrapper.enforceCallingPermission(permission, message);
	}

	@Override
	public final void enforceCallingUriPermission(Uri uri, int modeFlags,
			String message) {
		// TODO Auto-generated method stub
		wrapper.enforceCallingUriPermission(uri, modeFlags, message);
	}

	@Override
	public final void enforcePermission(String permission, int pid, int uid,
			String message) {
		// TODO Auto-generated method stub
		wrapper.enforcePermission(permission, pid, uid, message);
	}

	@Override
	public final void enforceUriPermission(Uri uri, int pid, int uid,
			int modeFlags, String message) {
		// TODO Auto-generated method stub
		wrapper.enforceUriPermission(uri, pid, uid, modeFlags, message);
	}

	@Override
	public final void enforceUriPermission(Uri uri, String readPermission,
			String writePermission, int pid, int uid, int modeFlags,
			String message) {
		// TODO Auto-generated method stub
		wrapper.enforceUriPermission(uri, readPermission, writePermission, pid,
				uid, modeFlags, message);

	}

	@Override
	public final String[] fileList() {
		// TODO Auto-generated method stub
		return wrapper.fileList();
	}

	@Override
	public final Context getApplicationContext() {
		// TODO Auto-generated method stub
		return wrapper.getApplicationContext();
	}

	@Override
	public final ApplicationInfo getApplicationInfo() {
		// TODO Auto-generated method stub
		return wrapper.getApplicationInfo();
	}

	@Override
	public final AssetManager getAssets() {
		// TODO Auto-generated method stub
		return wrapper.getAssets();
	}

	@Override
	public final Context getBaseContext() {
		// TODO Auto-generated method stub
		return wrapper.getBaseContext();
	}

	@Override
	public final File getCacheDir() {
		// TODO Auto-generated method stub
		return wrapper.getCacheDir();
	}

	@Override
	public final ClassLoader getClassLoader() {
		// TODO Auto-generated method stub
		return wrapper.getClassLoader();
	}

	@Override
	public final ContentResolver getContentResolver() {
		// TODO Auto-generated method stub
		return wrapper.getContentResolver();
	}

	@Override
	public final File getDatabasePath(String name) {
		// TODO Auto-generated method stub
		return wrapper.getDatabasePath(name);
	}

	@Override
	public final File getDir(String name, int mode) {
		// TODO Auto-generated method stub
		return wrapper.getDir(name, mode);
	}

	@Override
	public final File getExternalCacheDir() {
		// TODO Auto-generated method stub
		return wrapper.getExternalCacheDir();
	}

	@Override
	public final File[] getExternalCacheDirs() {
		// TODO Auto-generated method stub
		return wrapper.getExternalCacheDirs();
	}

	@Override
	public final File getExternalFilesDir(String type) {
		// TODO Auto-generated method stub
		return wrapper.getExternalFilesDir(type);
	}

	@Override
	public final File[] getExternalFilesDirs(String type) {
		// TODO Auto-generated method stub
		return wrapper.getExternalFilesDirs(type);
	}

	@Override
	public final File getFileStreamPath(String name) {
		// TODO Auto-generated method stub
		return wrapper.getFileStreamPath(name);
	}

	@Override
	public final File getFilesDir() {
		// TODO Auto-generated method stub
		return wrapper.getFilesDir();
	}

	@Override
	public final Looper getMainLooper() {
		// TODO Auto-generated method stub
		return wrapper.getMainLooper();
	}

	@Override
	public final File getObbDir() {
		// TODO Auto-generated method stub
		return wrapper.getObbDir();
	}

	@Override
	public final File[] getObbDirs() {
		// TODO Auto-generated method stub
		return wrapper.getObbDirs();
	}

	@Override
	public final String getPackageCodePath() {
		// TODO Auto-generated method stub
		return wrapper.getPackageCodePath();
	}

	@Override
	public final PackageManager getPackageManager() {
		// TODO Auto-generated method stub
		return wrapper.getPackageManager();
	}

	@Override
	public final String getPackageName() {
		// TODO Auto-generated method stub
		return wrapper.getPackageName();
	}

	@Override
	public final String getPackageResourcePath() {
		// TODO Auto-generated method stub
		return wrapper.getPackageResourcePath();
	}

	@Override
	public final Resources getResources() {
		// TODO Auto-generated method stub
		return wrapper.getResources();
	}

	@Override
	public final SharedPreferences getSharedPreferences(String name, int mode) {
		// TODO Auto-generated method stub
		return wrapper.getSharedPreferences(name, mode);
	}

	@Override
	public final Object getSystemService(String name) {
		// TODO Auto-generated method stub
		return wrapper.getSystemService(name);
	}

	@Override
	public final Theme getTheme() {
		// TODO Auto-generated method stub
		return wrapper.getTheme();
	}

	@Override
	public final Drawable getWallpaper() {
		// TODO Auto-generated method stub
		return wrapper.getWallpaper();
	}

	@Override
	public final int getWallpaperDesiredMinimumHeight() {
		// TODO Auto-generated method stub
		return wrapper.getWallpaperDesiredMinimumHeight();
	}

	@Override
	public final int getWallpaperDesiredMinimumWidth() {
		// TODO Auto-generated method stub
		return wrapper.getWallpaperDesiredMinimumWidth();
	}

	@Override
	public final void grantUriPermission(String toPackage, Uri uri,
			int modeFlags) {
		// TODO Auto-generated method stub
		wrapper.grantUriPermission(toPackage, uri, modeFlags);
	}

	@Override
	public final boolean isRestricted() {
		// TODO Auto-generated method stub
		return wrapper.isRestricted();
	}

	@Override
	public final FileInputStream openFileInput(String name)
			throws FileNotFoundException {
		// TODO Auto-generated method stub
		return wrapper.openFileInput(name);
	}

	@Override
	public final FileOutputStream openFileOutput(String name, int mode)
			throws FileNotFoundException {
		// TODO Auto-generated method stub
		return wrapper.openFileOutput(name, mode);
	}

	@Override
	public final SQLiteDatabase openOrCreateDatabase(String name, int mode,
			CursorFactory factory, DatabaseErrorHandler errorHandler) {
		// TODO Auto-generated method stub
		return wrapper.openOrCreateDatabase(name, mode, factory, errorHandler);
	}

	@Override
	public final SQLiteDatabase openOrCreateDatabase(String name, int mode,
			CursorFactory factory) {
		// TODO Auto-generated method stub
		return wrapper.openOrCreateDatabase(name, mode, factory);
	}

	@Override
	public final Drawable peekWallpaper() {
		// TODO Auto-generated method stub
		return wrapper.peekWallpaper();
	}

	@Override
	public final Intent registerReceiver(BroadcastReceiver receiver,
			IntentFilter filter, String broadcastPermission, Handler scheduler) {
		// TODO Auto-generated method stub
		return wrapper.registerReceiver(receiver, filter, broadcastPermission,
				scheduler);
	}

	@Override
	public final Intent registerReceiver(BroadcastReceiver receiver,
			IntentFilter filter) {
		// TODO Auto-generated method stub
		return wrapper.registerReceiver(receiver, filter);
	}

	@Override
	public final void removeStickyBroadcast(Intent intent) {
		// TODO Auto-generated method stub
		wrapper.removeStickyBroadcast(intent);
	}

	@Override
	public final void removeStickyBroadcastAsUser(Intent intent, UserHandle user) {
		// TODO Auto-generated method stub
		wrapper.removeStickyBroadcastAsUser(intent, user);
	}

	@Override
	public final void revokeUriPermission(Uri uri, int modeFlags) {
		// TODO Auto-generated method stub
		wrapper.revokeUriPermission(uri, modeFlags);
	}

	@Override
	public final void sendBroadcast(Intent intent, String receiverPermission) {
		// TODO Auto-generated method stub
		wrapper.sendBroadcast(intent, receiverPermission);
	}

	@Override
	public final void sendBroadcast(Intent intent) {
		// TODO Auto-generated method stub
		wrapper.sendBroadcast(intent);
	}

	@Override
	public final void sendBroadcastAsUser(Intent intent, UserHandle user,
			String receiverPermission) {
		// TODO Auto-generated method stub
		wrapper.sendBroadcastAsUser(intent, user, receiverPermission);
	}

	@Override
	public final void sendBroadcastAsUser(Intent intent, UserHandle user) {
		// TODO Auto-generated method stub
		wrapper.sendBroadcastAsUser(intent, user);
	}

	@Override
	public final void sendOrderedBroadcast(Intent intent,
			String receiverPermission, BroadcastReceiver resultReceiver,
			Handler scheduler, int initialCode, String initialData,
			Bundle initialExtras) {
		// TODO Auto-generated method stub
		wrapper.sendOrderedBroadcast(intent, receiverPermission,
				resultReceiver, scheduler, initialCode, initialData,
				initialExtras);
	}

	@Override
	public final void sendOrderedBroadcast(Intent intent,
			String receiverPermission) {
		// TODO Auto-generated method stub
		wrapper.sendOrderedBroadcast(intent, receiverPermission);
	}

	@Override
	public final void sendOrderedBroadcastAsUser(Intent intent,
			UserHandle user, String receiverPermission,
			BroadcastReceiver resultReceiver, Handler scheduler,
			int initialCode, String initialData, Bundle initialExtras) {
		// TODO Auto-generated method stub
		wrapper.sendOrderedBroadcastAsUser(intent, user, receiverPermission,
				resultReceiver, scheduler, initialCode, initialData,
				initialExtras);
	}

	@Override
	public final void sendStickyBroadcast(Intent intent) {
		// TODO Auto-generated method stub
		wrapper.sendStickyBroadcast(intent);
	}

	@Override
	public final void sendStickyBroadcastAsUser(Intent intent, UserHandle user) {
		// TODO Auto-generated method stub
		wrapper.sendStickyBroadcastAsUser(intent, user);
	}

	@Override
	public final void sendStickyOrderedBroadcast(Intent intent,
			BroadcastReceiver resultReceiver, Handler scheduler,
			int initialCode, String initialData, Bundle initialExtras) {
		// TODO Auto-generated method stub
		wrapper.sendStickyOrderedBroadcast(intent, resultReceiver, scheduler,
				initialCode, initialData, initialExtras);
	}

	@Override
	public final void sendStickyOrderedBroadcastAsUser(Intent intent,
			UserHandle user, BroadcastReceiver resultReceiver,
			Handler scheduler, int initialCode, String initialData,
			Bundle initialExtras) {
		// TODO Auto-generated method stub
		wrapper.sendStickyOrderedBroadcastAsUser(intent, user, resultReceiver,
				scheduler, initialCode, initialData, initialExtras);
	}

	@Override
	public final void setTheme(int resid) {
		// TODO Auto-generated method stub
		wrapper.setTheme(resid);
	}

	@Override
	public final void setWallpaper(Bitmap bitmap) throws IOException {
		// TODO Auto-generated method stub
		wrapper.setWallpaper(bitmap);
	}

	@Override
	public final void setWallpaper(InputStream data) throws IOException {
		// TODO Auto-generated method stub
		wrapper.setWallpaper(data);
	}

	@Override
	public final void startActivities(Intent[] intents, Bundle options) {
		// TODO Auto-generated method stub
		wrapper.startActivities(intents, options);
	}

	@Override
	public final void startActivities(Intent[] intents) {
		// TODO Auto-generated method stub
		wrapper.startActivities(intents);
	}

	@Override
	public final void startActivity(Intent intent, Bundle options) {
		// TODO Auto-generated method stub
		wrapper.startActivity(intent, options);
	}

	@Override
	public final void startActivity(Intent intent) {
		// TODO Auto-generated method stub
		wrapper.startActivity(intent);
	}

	@Override
	public final boolean startInstrumentation(ComponentName className,
			String profileFile, Bundle arguments) {
		// TODO Auto-generated method stub
		return wrapper.startInstrumentation(className, profileFile, arguments);
	}

	@Override
	public final void startIntentSender(IntentSender intent,
			Intent fillInIntent, int flagsMask, int flagsValues,
			int extraFlags, Bundle options) throws SendIntentException {
		// TODO Auto-generated method stub
		wrapper.startIntentSender(intent, fillInIntent, flagsMask, flagsValues,
				extraFlags, options);
	}

	@Override
	public final void startIntentSender(IntentSender intent,
			Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags)
			throws SendIntentException {
		// TODO Auto-generated method stub
		wrapper.startIntentSender(intent, fillInIntent, flagsMask, flagsValues,
				extraFlags);

	}

	@Override
	public final ComponentName startService(Intent service) {
		// TODO Auto-generated method stub
		return wrapper.startService(service);
	}

	@Override
	public final boolean stopService(Intent name) {
		// TODO Auto-generated method stub
		return wrapper.stopService(name);
	}

	@Override
	public final void unbindService(ServiceConnection conn) {
		// TODO Auto-generated method stub
		wrapper.unbindService(conn);
	}

	@Override
	public final void unregisterReceiver(BroadcastReceiver receiver) {
		// TODO Auto-generated method stub
		wrapper.unregisterReceiver(receiver);
	}

	@Override
	public final void registerComponentCallbacks(ComponentCallbacks callback) {
		// TODO Auto-generated method stub
		wrapper.registerComponentCallbacks(callback);
	}

	@Override
	public final void unregisterComponentCallbacks(ComponentCallbacks callback) {
		// TODO Auto-generated method stub
		wrapper.unregisterComponentCallbacks(callback);
	}

	@Override
	public final CharSequence getText(int resId) {
		// TODO Auto-generated method stub
		return wrapper.getText(resId);
	}

	@Override
	public final String getString(int resId) {
		// TODO Auto-generated method stub
		return wrapper.getString(resId);
	}

	@Override
	public final String getString(int resId, Object... formatArgs) {
		// TODO Auto-generated method stub
		return wrapper.getString(resId, formatArgs);
	}

	@Override
	public final TypedArray obtainStyledAttributes(int[] attrs) {
		// TODO Auto-generated method stub
		return wrapper.obtainStyledAttributes(attrs);
	}

	@Override
	public final TypedArray obtainStyledAttributes(int resid, int[] attrs)
			throws NotFoundException {
		// TODO Auto-generated method stub
		return wrapper.obtainStyledAttributes(resid, attrs);
	}

	@Override
	public final TypedArray obtainStyledAttributes(AttributeSet set, int[] attrs) {
		// TODO Auto-generated method stub
		return wrapper.obtainStyledAttributes(set, attrs);
	}

	@Override
	public final TypedArray obtainStyledAttributes(AttributeSet set,
			int[] attrs, int defStyleAttr, int defStyleRes) {
		// TODO Auto-generated method stub
		return wrapper.obtainStyledAttributes(set, attrs, defStyleAttr,
				defStyleRes);
	}
}
