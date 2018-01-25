package com.xh.ifaces;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
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
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

/**
 * @version 创建时间：2018-1-12 上午10:45:18 项目：proxy 包名：com.xh.proxy
 *          文件名：IActivity.java 作者：lhl 说明:
 */

public interface IPlugin {

	public void dump(String prefix, FileDescriptor fd, PrintWriter writer,
			String[] args);

	public Object getLastCustomNonConfigurationInstance();

	public FragmentManager getSupportFragmentManager();

	public LoaderManager getSupportLoaderManager();

	public void onActivityResult(int arg0, int arg1, Intent arg2);

	public void onAttachFragment(Fragment fragment);

	public void onBackPressed();

	public void onConfigurationChanged(Configuration newConfig);

	public void onCreate(Bundle arg0);

	public boolean onCreatePanelMenu(int arg0, Menu arg1);

	public View onCreateView(String name, @NonNull Context context,
			@NonNull AttributeSet attrs);

	public void onDestroy();

	public boolean onKeyDown(int keyCode, KeyEvent event);

	public void onLowMemory();

	public boolean onMenuItemSelected(int featureId, MenuItem item);

	public void onNewIntent(Intent intent);

	public void onPanelClosed(int featureId, Menu menu);

	public void onPause();

	public void onPostResume();


	public boolean onPreparePanel(int arg0, View arg1, Menu arg2);

	public void onResume() ;

	public void onResumeFragments();

	public Object onRetainCustomNonConfigurationInstance();

	public void onSaveInstanceState(Bundle outState);

	public void onStart();

	public void onStop();

	public void startActivityForResult(Intent intent, int requestCode);

	public void startActivityFromFragment(Fragment fragment, Intent intent,
			int requestCode);


	public void addContentView(View view, LayoutParams params);

	public void closeContextMenu() ;

	public void closeOptionsMenu();
	public PendingIntent createPendingResult(int requestCode, Intent data,
			int flags);
	public boolean dispatchGenericMotionEvent(MotionEvent ev);

	public boolean dispatchKeyEvent(KeyEvent event);
	public boolean dispatchKeyShortcutEvent(KeyEvent event);

	public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event);

	public boolean dispatchTouchEvent(MotionEvent ev);

	public boolean dispatchTrackballEvent(MotionEvent ev);

	public View findViewById(int id);

	public void finish();

	public void finishActivity(int requestCode);

	public void finishActivityFromChild(Activity child, int requestCode) ;

	public void finishAffinity() ;

	public void finishFromChild(Activity child);

	public ActionBar getActionBar();

	public ComponentName getCallingActivity() ;

	public String getCallingPackage();

	public int getChangingConfigurations();

	public ComponentName getComponentName();

	public View getCurrentFocus() ;

	public android.app.FragmentManager getFragmentManager();

	public Intent getIntent() ;

	public Object getLastNonConfigurationInstance();

	public LayoutInflater getLayoutInflater();

	public android.app.LoaderManager getLoaderManager();

	public String getLocalClassName();

	public MenuInflater getMenuInflater();

	public Intent getParentActivityIntent();

	public SharedPreferences getPreferences(int mode);

	public int getRequestedOrientation() ;


	public int getTaskId();

	public Window getWindow() ;

	public WindowManager getWindowManager();

	public boolean hasWindowFocus();

	public void invalidateOptionsMenu();

	public boolean isChangingConfigurations();

	public boolean isDestroyed();

	public boolean isFinishing();

	public boolean isImmersive();

	public boolean isTaskRoot() ;

	public boolean moveTaskToBack(boolean nonRoot);

	public boolean navigateUpTo(Intent upIntent);

	public boolean navigateUpToFromChild(Activity child, Intent upIntent);

	public void onActionModeFinished(ActionMode mode);

	public void onActionModeStarted(ActionMode mode);


	public void onAttachFragment(android.app.Fragment fragment);

	public void onAttachedToWindow() ;


	public void onContentChanged();

	public boolean onContextItemSelected(MenuItem item);

	public void onContextMenuClosed(Menu menu);

	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo);

	public CharSequence onCreateDescription();

	public void onCreateNavigateUpTaskStack(TaskStackBuilder builder);

	public boolean onCreateOptionsMenu(Menu menu);

	public View onCreatePanelView(int featureId);

	public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) ;

	public View onCreateView(View parent, String name, Context context,
			AttributeSet attrs) ;

	public void onDetachedFromWindow();

	public boolean onGenericMotionEvent(MotionEvent event);

	public boolean onKeyLongPress(int keyCode, KeyEvent event);

	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) ;

	public boolean onKeyShortcut(int keyCode, KeyEvent event);

	public boolean onKeyUp(int keyCode, KeyEvent event);

	public boolean onMenuOpened(int featureId, Menu menu);

	public boolean onNavigateUp();
	public boolean onNavigateUpFromChild(Activity child);

	public boolean onOptionsItemSelected(MenuItem item) ;

	public void onOptionsMenuClosed(Menu menu) ;

	public void onPostCreate(Bundle savedInstanceState) ;

	public void onPrepareNavigateUpTaskStack(TaskStackBuilder builder) ;

	public boolean onPrepareOptionsMenu(Menu menu);

	public void onProvideAssistData(Bundle data);

	public void onRestart();

	public void onRestoreInstanceState(Bundle savedInstanceState);

	public boolean onSearchRequested();

	public void onTitleChanged(CharSequence title, int color);
	public boolean onTouchEvent(MotionEvent event);

	public boolean onTrackballEvent(MotionEvent event);

	public void onTrimMemory(int level);

	public void onUserInteraction();

	public void onUserLeaveHint();

	public void onWindowAttributesChanged(
			android.view.WindowManager.LayoutParams params);

	public void onWindowFocusChanged(boolean hasFocus);

	public ActionMode onWindowStartingActionMode(Callback callback);

	public void openContextMenu(View view) ;

	public void openOptionsMenu();

	public void overridePendingTransition(int enterAnim, int exitAnim);

	public void recreate() ;

	public void registerForContextMenu(View view);

	public void reportFullyDrawn();

	public void setContentView(int layoutResID);

	public void setContentView(View view) ;

	public void setContentView(View view, LayoutParams params);

	public void setFinishOnTouchOutside(boolean finish);

	public void setImmersive(boolean i);

	public void setIntent(Intent newIntent);

	public void setRequestedOrientation(int requestedOrientation);

	public void setTitle(CharSequence title);

	public void setTitle(int titleId);

	public void setTitleColor(int textColor);

	public void setVisible(boolean visible);

	public boolean shouldUpRecreateTask(Intent targetIntent) ;

	public ActionMode startActionMode(Callback callback);

	public void startActivityForResult(Intent intent, int requestCode,
			Bundle options);

	public void startActivityFromChild(Activity child, Intent intent,
			int requestCode);

	public void startActivityFromChild(Activity child, Intent intent,
			int requestCode, Bundle options);

	public void startActivityFromFragment(android.app.Fragment fragment,
			Intent intent, int requestCode) ;

	public void startActivityFromFragment(android.app.Fragment fragment,
			Intent intent, int requestCode, Bundle options);

	public boolean startActivityIfNeeded(Intent intent, int requestCode);

	public boolean startActivityIfNeeded(Intent intent, int requestCode,
			Bundle options);
	public void startIntentSenderFromChild(Activity child, IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags) throws SendIntentException;

	public void startIntentSenderFromChild(Activity child, IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags, Bundle options)
			throws SendIntentException ;

	public boolean startNextMatchingActivity(Intent intent);

	public boolean startNextMatchingActivity(Intent intent, Bundle options);

	public void startSearch(String initialQuery, boolean selectInitialQuery,
			Bundle appSearchData, boolean globalSearch);

	public void takeKeyEvents(boolean get) ;

	public void triggerSearch(String query, Bundle appSearchData);

	public void unregisterForContextMenu(View view);
	public void applyOverrideConfiguration(Configuration overrideConfiguration);

	public void attachBaseContext(Context newBase);







































































	public void onCreate(FragmentActivity activity);
	 public Application getApplication();
	 public boolean isChild();
	 public Activity getParent();
	 public Cursor managedQuery(Uri uri,
	 String[] projection,
	 String selection,
	 String sortOrder);
	 public Cursor managedQuery(Uri uri,
	 String[] projection,
	 String selection,
	 String[] selectionArgs,
	 String sortOrder);
	 public void setDefaultKeyMode(int mode);
	 public void showDialog(int id);
	 public void dismissDialog(int id);
	 public void removeDialog(int id);
	 public boolean requestWindowFeature(int featureId);
	 public void setFeatureDrawableResource(int featureId,
	 int resId);
	 public void setFeatureDrawableUri(int featureId,
	 Uri uri);
	 public void setFeatureDrawable(int featureId,
	 Drawable drawable);
	 public void setFeatureDrawableAlpha(int featureId,
	 int alpha);
	 public void setResult(int resultCode);
	 public void setResult(int resultCode,
	 Intent data);
	 public CharSequence getTitle();
	 public int getTitleColor();
	 public void setProgressBarVisibility(boolean visible);
	 public void setProgressBarIndeterminateVisibility(boolean visible);
	 public void setProgressBarIndeterminate(boolean indeterminate);
	 public void setProgress(int progress);
	 public void setSecondaryProgress(int secondaryProgress);
	 public void setVolumeControlStream(int streamType);
	 public int getVolumeControlStream();
	 public void runOnUiThread(Runnable action);
}
