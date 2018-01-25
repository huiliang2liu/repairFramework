package com.xh.plugin;

import java.io.FileDescriptor;
import java.io.PrintWriter;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
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

import com.xh.ifaces.IPlugin;

/**
 * @version 创建时间：2018-1-12 上午10:46:15 项目：proxy 包名：com.xh.proxy
 *          文件名：ActivityImpl.java 作者：lhl 说明:
 */

public class PluginActivity extends PluginWrapperImpl implements IPlugin {
	protected FragmentActivity activity;

	@Override
	public final Application getApplication() {
		// TODO Auto-generated method stub
		return activity.getApplication();
	}

	@Override
	public final boolean isChild() {
		// TODO Auto-generated method stub
		return activity.isChild();
	}

	@Override
	public final Activity getParent() {
		// TODO Auto-generated method stub
		return activity.getParent();
	}

	@Override
	public final Cursor managedQuery(Uri uri, String[] projection,
			String selection, String sortOrder) {
		// TODO Auto-generated method stub
		return activity.managedQuery(uri, projection, selection, null,
				sortOrder);
	}

	@Override
	public final Cursor managedQuery(Uri uri, String[] projection,
			String selection, String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		return activity.managedQuery(uri, projection, selection, selectionArgs,
				sortOrder);
	}

	@Override
	public final void setDefaultKeyMode(int mode) {
		// TODO Auto-generated method stub
		activity.setDefaultKeyMode(mode);
	}

	@Override
	public final void showDialog(int id) {
		// TODO Auto-generated method stub
		activity.showDialog(id);
	}

	@Override
	public final void dismissDialog(int id) {
		// TODO Auto-generated method stub
		activity.dismissDialog(id);
	}

	@Override
	public final void removeDialog(int id) {
		// TODO Auto-generated method stub
		activity.removeDialog(id);
	}

	@Override
	public final boolean requestWindowFeature(int featureId) {
		// TODO Auto-generated method stub
		return activity.requestWindowFeature(featureId);
	}

	@Override
	public final void setFeatureDrawableResource(int featureId, int resId) {
		// TODO Auto-generated method stub
		activity.setFeatureDrawableResource(featureId, resId);
	}

	@Override
	public final void setFeatureDrawableUri(int featureId, Uri uri) {
		// TODO Auto-generated method stub
		activity.setFeatureDrawableUri(featureId, uri);
	}

	@Override
	public final void setFeatureDrawable(int featureId, Drawable drawable) {
		// TODO Auto-generated method stub
		activity.setFeatureDrawable(featureId, drawable);
	}

	@Override
	public final void setFeatureDrawableAlpha(int featureId, int alpha) {
		// TODO Auto-generated method stub
		activity.setFeatureDrawableAlpha(featureId, alpha);
	}

	@Override
	public final void setResult(int resultCode) {
		// TODO Auto-generated method stub
		activity.setResult(resultCode);
	}

	@Override
	public final void setResult(int resultCode, Intent data) {
		// TODO Auto-generated method stub
		activity.setResult(resultCode, data);
	}

	@Override
	public final CharSequence getTitle() {
		// TODO Auto-generated method stub
		return activity.getTitle();
	}

	@Override
	public final int getTitleColor() {
		// TODO Auto-generated method stub
		return activity.getTitleColor();
	}

	@Override
	public final void setProgressBarVisibility(boolean visible) {
		// TODO Auto-generated method stub
		activity.setProgressBarVisibility(visible);
	}

	@Override
	public final void setProgressBarIndeterminateVisibility(boolean visible) {
		// TODO Auto-generated method stub
		activity.setProgressBarIndeterminateVisibility(visible);
	}

	@Override
	public final void setProgressBarIndeterminate(boolean indeterminate) {
		// TODO Auto-generated method stub
		activity.setProgressBarIndeterminate(indeterminate);
	}

	@Override
	public final void setProgress(int progress) {
		// TODO Auto-generated method stub
		activity.setProgress(progress);
	}

	@Override
	public final void setSecondaryProgress(int secondaryProgress) {
		// TODO Auto-generated method stub
		activity.setSecondaryProgress(secondaryProgress);
	}

	@Override
	public final void setVolumeControlStream(int streamType) {
		// TODO Auto-generated method stub
		activity.setVolumeControlStream(streamType);
	}

	@Override
	public final int getVolumeControlStream() {
		// TODO Auto-generated method stub
		return activity.getVolumeControlStream();
	}

	@Override
	public final void runOnUiThread(Runnable action) {
		// TODO Auto-generated method stub
		activity.runOnUiThread(action);
	}

	@Override
	public Object getLastCustomNonConfigurationInstance() {
		// TODO Auto-generated method stub
		return activity.getLastCustomNonConfigurationInstance();
	}

	@Override
	public FragmentManager getSupportFragmentManager() {
		// TODO Auto-generated method stub
		return activity.getSupportFragmentManager();
	}

	@Override
	public LoaderManager getSupportLoaderManager() {
		// TODO Auto-generated method stub
		return activity.getSupportLoaderManager();
	}

	@Override
	public void onAttachFragment(Fragment fragment) {
		// TODO Auto-generated method stub
		activity.onAttachFragment(fragment);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		activity.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onCreatePanelMenu(int arg0, Menu arg1) {
		// TODO Auto-generated method stub
		return activity.onCreatePanelMenu(arg0, arg1);
	}

	@Override
	public View onCreateView(String name, @NonNull Context context,
			@NonNull AttributeSet attrs) {
		// TODO Auto-generated method stub
		return activity.onCreateView(name, context, attrs);
	}

	@Override
	public boolean onPreparePanel(int arg0, View arg1, Menu arg2) {
		// TODO Auto-generated method stub
		return activity.onPreparePanel(arg0, arg1, arg2);
	}

	@Override
	public Object onRetainCustomNonConfigurationInstance() {
		// TODO Auto-generated method stub
		return activity.onRetainCustomNonConfigurationInstance();
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		// TODO Auto-generated method stub
		activity.startActivityForResult(intent, requestCode);
	}

	@Override
	public void startActivityFromFragment(Fragment fragment, Intent intent,
			int requestCode) {
		// TODO Auto-generated method stub
		activity.startActivityFromFragment(fragment, intent, requestCode);
	}

	@Override
	public void startActivityFromFragment(android.app.Fragment fragment,
			Intent intent, int requestCode) {
		// TODO Auto-generated method stub
		activity.startActivityFromFragment(fragment, intent, requestCode);
	}

	@Override
	public void addContentView(View view, LayoutParams params) {
		// TODO Auto-generated method stub
		activity.addContentView(view, params);
	}

	@Override
	public void closeContextMenu() {
		// TODO Auto-generated method stub
		activity.closeContextMenu();
	}

	@Override
	public void closeOptionsMenu() {
		// TODO Auto-generated method stub
		activity.closeContextMenu();
	}

	@Override
	public PendingIntent createPendingResult(int requestCode, Intent data,
			int flags) {
		// TODO Auto-generated method stub
		return activity.createPendingResult(requestCode, data, flags);
	}

	@Override
	public View findViewById(int id) {
		// TODO Auto-generated method stub
		return activity.findViewById(id);
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		activity.finish();
	}

	@Override
	public void finishActivity(int requestCode) {
		// TODO Auto-generated method stub
		activity.finishActivity(requestCode);
	}

	@Override
	public void finishActivityFromChild(Activity child, int requestCode) {
		// TODO Auto-generated method stub
		activity.finishActivityFromChild(child, requestCode);
	}

	@Override
	public void finishAffinity() {
		// TODO Auto-generated method stub
		activity.finishAffinity();
	}

	@Override
	public void finishFromChild(Activity child) {
		// TODO Auto-generated method stub
		activity.finishFromChild(child);
	}

	@Override
	public ActionBar getActionBar() {
		// TODO Auto-generated method stub
		return activity.getActionBar();
	}

	@Override
	public ComponentName getCallingActivity() {
		// TODO Auto-generated method stub
		return activity.getCallingActivity();
	}

	@Override
	public String getCallingPackage() {
		// TODO Auto-generated method stub
		return activity.getCallingPackage();
	}

	@Override
	public int getChangingConfigurations() {
		// TODO Auto-generated method stub
		return activity.getChangingConfigurations();
	}

	@Override
	public ComponentName getComponentName() {
		// TODO Auto-generated method stub
		return activity.getComponentName();
	}

	@Override
	public View getCurrentFocus() {
		// TODO Auto-generated method stub
		return activity.getCurrentFocus();
	}

	@Override
	public android.app.FragmentManager getFragmentManager() {
		// TODO Auto-generated method stub
		return activity.getFragmentManager();
	}

	@Override
	public Intent getIntent() {
		// TODO Auto-generated method stub
		return activity.getIntent();
	}

	@Override
	public Object getLastNonConfigurationInstance() {
		// TODO Auto-generated method stub
		return activity.getLastNonConfigurationInstance();
	}

	@Override
	public LayoutInflater getLayoutInflater() {
		// TODO Auto-generated method stub
		return activity.getLayoutInflater();
	}

	@Override
	public android.app.LoaderManager getLoaderManager() {
		// TODO Auto-generated method stub
		return activity.getLoaderManager();
	}

	@Override
	public String getLocalClassName() {
		// TODO Auto-generated method stub
		return activity.getLocalClassName();
	}

	@Override
	public MenuInflater getMenuInflater() {
		// TODO Auto-generated method stub
		return activity.getMenuInflater();
	}

	@Override
	public Intent getParentActivityIntent() {
		// TODO Auto-generated method stub
		return activity.getParentActivityIntent();
	}

	@Override
	public SharedPreferences getPreferences(int mode) {
		// TODO Auto-generated method stub
		return activity.getPreferences(mode);
	}

	@Override
	public int getRequestedOrientation() {
		// TODO Auto-generated method stub
		return activity.getRequestedOrientation();
	}

	@Override
	public int getTaskId() {
		// TODO Auto-generated method stub
		return activity.getTaskId();
	}

	@Override
	public Window getWindow() {
		// TODO Auto-generated method stub
		return activity.getWindow();
	}

	@Override
	public WindowManager getWindowManager() {
		// TODO Auto-generated method stub
		return activity.getWindowManager();
	}

	@Override
	public boolean hasWindowFocus() {
		// TODO Auto-generated method stub
		return activity.hasWindowFocus();
	}

	@Override
	public boolean isChangingConfigurations() {
		// TODO Auto-generated method stub
		return activity.isChangingConfigurations();
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return activity.isDestroyed();
	}

	@Override
	public boolean isFinishing() {
		// TODO Auto-generated method stub
		return activity.isFinishing();
	}

	@Override
	public boolean isImmersive() {
		// TODO Auto-generated method stub
		return activity.isImmersive();
	}

	@Override
	public boolean isTaskRoot() {
		// TODO Auto-generated method stub
		return activity.isTaskRoot();
	}

	@Override
	public boolean moveTaskToBack(boolean nonRoot) {
		// TODO Auto-generated method stub
		return activity.moveTaskToBack(nonRoot);
	}

	@Override
	public boolean navigateUpTo(Intent upIntent) {
		// TODO Auto-generated method stub
		return activity.navigateUpTo(upIntent);
	}

	@Override
	public boolean navigateUpToFromChild(Activity child, Intent upIntent) {
		// TODO Auto-generated method stub
		return activity.navigateUpToFromChild(child, upIntent);
	}

	@Override
	public void onActionModeFinished(ActionMode mode) {
		// TODO Auto-generated method stub
		activity.onActionModeFinished(mode);
	}

	@Override
	public void onActionModeStarted(ActionMode mode) {
		// TODO Auto-generated method stub
		activity.onActionModeStarted(mode);
	}

	@Override
	public void onAttachFragment(android.app.Fragment fragment) {
		// TODO Auto-generated method stub
		activity.onAttachFragment(fragment);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return activity.onContextItemSelected(item);
	}

	@Override
	public void onContextMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
		activity.onContextMenuClosed(menu);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		activity.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public CharSequence onCreateDescription() {
		// TODO Auto-generated method stub
		return activity.onCreateDescription();
	}

	@Override
	public void onCreateNavigateUpTaskStack(TaskStackBuilder builder) {
		// TODO Auto-generated method stub
		activity.onCreateNavigateUpTaskStack(builder);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return activity.onCreateOptionsMenu(menu);
	}

	@Override
	public View onCreatePanelView(int featureId) {
		// TODO Auto-generated method stub
		return activity.onCreatePanelView(featureId);
	}

	@Override
	public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
		// TODO Auto-generated method stub
		return activity.onCreateThumbnail(outBitmap, canvas);
	}

	@Override
	public View onCreateView(View parent, String name, Context context,
			AttributeSet attrs) {
		// TODO Auto-generated method stub
		return activity.onCreateView(parent, name, context, attrs);
	}

	@Override
	public ActionMode onWindowStartingActionMode(Callback callback) {
		// TODO Auto-generated method stub
		return activity.onWindowStartingActionMode(callback);
	}

	@Override
	public void openContextMenu(View view) {
		// TODO Auto-generated method stub
		activity.openContextMenu(view);
	}

	@Override
	public void openOptionsMenu() {
		// TODO Auto-generated method stub
		activity.openOptionsMenu();
	}

	@Override
	public void overridePendingTransition(int enterAnim, int exitAnim) {
		// TODO Auto-generated method stub
		activity.overridePendingTransition(enterAnim, exitAnim);
	}

	@Override
	public void recreate() {
		// TODO Auto-generated method stub
		activity.recreate();
	}

	@Override
	public void registerForContextMenu(View view) {
		// TODO Auto-generated method stub
		activity.registerForContextMenu(view);
	}

	@Override
	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub
		activity.setContentView(layoutResID);
	}

	@Override
	public void setContentView(View view) {
		// TODO Auto-generated method stub
		activity.setContentView(view);
	}

	@Override
	public void setContentView(View view, LayoutParams params) {
		// TODO Auto-generated method stub
		activity.setContentView(view, params);
	}

	@Override
	public void setIntent(Intent newIntent) {
		// TODO Auto-generated method stub
		activity.setIntent(newIntent);
	}

	@Override
	public void setRequestedOrientation(int requestedOrientation) {
		// TODO Auto-generated method stub
		activity.setRequestedOrientation(requestedOrientation);
	}

	@Override
	public void setTitle(CharSequence title) {
		// TODO Auto-generated method stub
		activity.setTitle(title);
	}

	@Override
	public void setTitle(int titleId) {
		// TODO Auto-generated method stub
		activity.setTitle(titleId);
	}

	@Override
	public void setTitleColor(int textColor) {
		// TODO Auto-generated method stub
		activity.setTitleColor(textColor);
	}

	@Override
	public void setVisible(boolean visible) {
		// TODO Auto-generated method stub
		activity.setVisible(visible);
	}

	@Override
	public boolean shouldUpRecreateTask(Intent targetIntent) {
		// TODO Auto-generated method stub
		return activity.shouldUpRecreateTask(targetIntent);
	}

	@Override
	public ActionMode startActionMode(Callback callback) {
		// TODO Auto-generated method stub
		return activity.startActionMode(callback);
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode,
			Bundle options) {
		// TODO Auto-generated method stub
		activity.startActivityForResult(intent, requestCode, options);
	}

	@Override
	public void startActivityFromChild(Activity child, Intent intent,
			int requestCode) {
		// TODO Auto-generated method stub
		activity.startActivityFromChild(child, intent, requestCode);
	}

	@Override
	public void startActivityFromChild(Activity child, Intent intent,
			int requestCode, Bundle options) {
		// TODO Auto-generated method stub
		activity.startActivityFromChild(child, intent, requestCode, options);
	}

	@Override
	public void startActivityFromFragment(android.app.Fragment fragment,
			Intent intent, int requestCode, Bundle options) {
		// TODO Auto-generated method stub
		activity.startActivityFromFragment(fragment, intent, requestCode,
				options);
	}

	@Override
	public boolean startActivityIfNeeded(Intent intent, int requestCode) {
		// TODO Auto-generated method stub
		return activity.startActivityIfNeeded(intent, requestCode);
	}

	@Override
	public boolean startActivityIfNeeded(Intent intent, int requestCode,
			Bundle options) {
		// TODO Auto-generated method stub
		return activity.startActivityIfNeeded(intent, requestCode, options);
	}

	@Override
	public void startIntentSenderFromChild(Activity child, IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags) throws SendIntentException {
		// TODO Auto-generated method stub
		activity.startIntentSenderFromChild(child, intent, requestCode,
				fillInIntent, flagsMask, flagsValues, extraFlags);
	}

	@Override
	public void startIntentSenderFromChild(Activity child, IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags, Bundle options)
			throws SendIntentException {
		// TODO Auto-generated method stub
		activity.startIntentSenderFromChild(child, intent, requestCode,
				fillInIntent, flagsMask, flagsValues, extraFlags, options);
	}

	@Override
	public boolean startNextMatchingActivity(Intent intent) {
		// TODO Auto-generated method stub
		return activity.startNextMatchingActivity(intent);
	}

	@Override
	public boolean startNextMatchingActivity(Intent intent, Bundle options) {
		// TODO Auto-generated method stub
		return activity.startNextMatchingActivity(intent, options);
	}

	@Override
	public void startSearch(String initialQuery, boolean selectInitialQuery,
			Bundle appSearchData, boolean globalSearch) {
		// TODO Auto-generated method stub
		activity.startSearch(initialQuery, selectInitialQuery, appSearchData,
				globalSearch);
	}

	@Override
	public void unregisterForContextMenu(View view) {
		// TODO Auto-generated method stub
		activity.unregisterForContextMenu(view);
	}

	@Override
	public void applyOverrideConfiguration(Configuration overrideConfiguration) {
		// TODO Auto-generated method stub
		activity.applyOverrideConfiguration(overrideConfiguration);
	}

	@Override
	public void setFinishOnTouchOutside(boolean finish) {
		// TODO Auto-generated method stub
		activity.setFinishOnTouchOutside(finish);
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		return activity.onMenuOpened(featureId, menu);
	}

	@Override
	public boolean onNavigateUp() {
		// TODO Auto-generated method stub
		return activity.onNavigateUp();
	}

	@Override
	public boolean onNavigateUpFromChild(Activity child) {
		// TODO Auto-generated method stub
		return activity.onNavigateUpFromChild(child);
	}

	@Override
	public void setImmersive(boolean i) {
		// TODO Auto-generated method stub
		activity.setImmersive(i);
	}

	@Override
	public void dump(String prefix, FileDescriptor fd, PrintWriter writer,
			String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onActivityResult(int arg0, int arg1, Intent arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		activity.finish();
	}

	@Override
	public void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPanelClosed(int featureId, Menu menu) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPostResume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onResumeFragments() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean dispatchGenericMotionEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dispatchKeyShortcutEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dispatchTrackballEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void invalidateOptionsMenu() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onContentChanged() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDetachedFromWindow() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onGenericMotionEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onKeyShortcut(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPrepareNavigateUpTaskStack(TaskStackBuilder builder) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onProvideAssistData(Bundle data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRestart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSearchRequested() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onTitleChanged(CharSequence title, int color) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTrackballEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onTrimMemory(int level) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUserInteraction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUserLeaveHint() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onWindowAttributesChanged(
			android.view.WindowManager.LayoutParams params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reportFullyDrawn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void takeKeyEvents(boolean get) {
		// TODO Auto-generated method stub

	}

	@Override
	public void triggerSearch(String query, Bundle appSearchData) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attachBaseContext(Context newBase) {
		// TODO Auto-generated method stub

	}

	@Override
	public final void onCreate(FragmentActivity activity) {
		// TODO Auto-generated method stub
		this.activity = activity;
		ContextWrapper wrapper = activity;
		onCreate(wrapper);
		createActivity();
	}

	public void createActivity() {

	}

	public final Activity getActivity() {
		return activity;
	}
}
