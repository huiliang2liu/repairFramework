package com.xh.save;

import java.util.TreeMap;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

/**
 * 数据库帮助类
 * 
 */
public class DBContentProvider extends ContentProvider {
	private final static String TAG = "com.example.saveData.DBContentProvider";
	private static DBOpenHelper dboh;
	private SQLiteDatabase db;
	private static Uri CONTENT_URI;
	private static boolean isCreate = false;
	private static TreeMap<Uri, String> getTableName;

	// /** Uri工具类 */
	private static final UriMatcher mUriMatcher = new UriMatcher(
			UriMatcher.NO_MATCH);
	//
	// 查询、更新和删除条件
	private static final int SEARCH = 2;

	private static final int SEARCH_ID = 3;

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		try {
			if (dboh != null) {
				isCreate = true;
				Log.e(TAG, "table is exist");
				return isCreate;
			}
			dboh = new DBOpenHelper(getContext());
			db = dboh.getReadableDatabase();
			getTableName = new TreeMap<Uri, String>();
			CONTENT_URI = Uri.parse("content://" + TAG + "/" + dboh.getName());
			getTableName.put(CONTENT_URI, dboh.getName());
			mUriMatcher.addURI(TAG, dboh.getName(), SEARCH);
			mUriMatcher.addURI(TAG, dboh.getName() + "/#", SEARCH_ID);
			isCreate = true;
			Log.e(TAG, "create table success");
		} catch (Exception e) {
			isCreate = false;
			throw new IllegalArgumentException("Error: create table defeat"
					+ TAG);
		}
		return false;
	}

	/** 功能:查询数据 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		// SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
		// switch (mUriMatcher.match(uri)) {
		// case COLLECTION_INDICATOR:
		// // 设置查询的表
		// queryBuilder.setTables(dboh.name);
		// // 设置投影映射
		// queryBuilder.setProjectionMap(sNotesProjectionMap);
		// break;
		//
		// case SINGLE_INDICATOR:
		// queryBuilder.setTables(dboh.name);
		// queryBuilder.setProjectionMap(sNotesProjectionMap);
		// queryBuilder.appendWhere(NoteProviderMetaData.NoteTableMetaData._ID
		// + "=" + uri.getPathSegments().get(1));
		// break;
		//
		// default:
		// throw new IllegalArgumentException("Unknow URI: " + uri);
		// }
		//
		// String orderBy;
		// if (TextUtils.isEmpty(sortOrder)) {
		// orderBy = NoteProviderMetaData.NoteTableMetaData.DEFAULT_ORDERBY;
		// } else {
		// orderBy = sortOrder;
		// }
		// SQLiteDatabase db = dboh.getReadableDatabase();
		// Cursor cursor = queryBuilder.query(db, projection, selection,
		// selectionArgs, null, null, orderBy);
		//
		return null;
	}

	/** 功能:获得操作内容类型 */
	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		switch (mUriMatcher.match(uri)) {
		// 得到的是表中的列
		case SEARCH:
			return "";

		case SEARCH_ID:
			return "";

		default:
			throw new IllegalArgumentException("Unknow URI: " + uri);
		}
	}

	/** 功能:添加数据 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		db.beginTransaction();
		Uri reUri = null;/* 返回值,插入成功返回Uri,否则返回null */
		try {
			/* 插入数据，返回行ID */
			// db.execSQL("insert into device_type (_id,device_type_id) values(11,'123')");
			long rowId = db.insert(getTableName.get(uri), null, values);
			reUri = rowId > 0 ? ContentUris.withAppendedId(uri, rowId) : reUri;
			// if(reUri!=null){
			getContext().getContentResolver().notifyChange(reUri, null);
			// }
			db.setTransactionSuccessful();
		} catch (Exception e) {
			Log.e(TAG, e.toString());
			db.endTransaction();
			throw new IllegalArgumentException("Error " + e.toString());
		}
		db.endTransaction();
		return reUri;
	}

	/** 功能:删除数据 */
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		int count = 0; /* 返回值 */
		db.beginTransaction();
		try {
			selection = (mUriMatcher.match(uri) % 2 == 0) ? selection : "_id="
					+ uri.getPathSegments().get(1)
					+ (!TextUtils.isEmpty(selection) ? " AND (" + selection
							+ ')' : "");
			switch (mUriMatcher.match(uri)) {
			case SEARCH:
				count = delete(getTableName.get(uri), selection, selectionArgs);
				break;
			case SEARCH_ID:
				count = delete(getTableName.get(uri), selection, selectionArgs);
				break;
			}
			db.setTransactionSuccessful();
		} catch (Exception e) {
			db.endTransaction();
			throw new IllegalArgumentException("Error SQL " + uri);
		}
		db.endTransaction();
		getContext().getContentResolver().notifyChange(uri, null);
		return count;
	}

	private int delete(String string, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return db.delete(string, selection, selectionArgs);
	}

	/** 功能:更新数据 */
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int count; /* 返回值 */
		db.beginTransaction();
		try {
			switch (mUriMatcher.match(uri) % 2) {
			/* 根据指定条件更新 */
			case 0:
				count = db.update(getTableName.get(uri), values, selection,
						selectionArgs);
				break;
			/* 根据指定条件和ID更新 */
			case 1:
				selection = "_id="
						+ uri.getPathSegments().get(1)
						+ (!TextUtils.isEmpty(selection) ? " AND (" + selection
								+ ')' : "");
				count = db.update(getTableName.get(uri), values, selection,
						selectionArgs);
				break;
			default:
				throw new IllegalArgumentException("Unknown URI " + uri);
			}
			db.setTransactionSuccessful();
		} catch (Exception e) {
			db.endTransaction();
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
		db.endTransaction();
		getContext().getContentResolver().notifyChange(uri, null);
		return count;
	}

}
