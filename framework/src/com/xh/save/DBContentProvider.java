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
 * ���ݿ������
 * 
 */
public class DBContentProvider extends ContentProvider {
	private final static String TAG = "com.example.saveData.DBContentProvider";
	private static DBOpenHelper dboh;
	private SQLiteDatabase db;
	private static Uri CONTENT_URI;
	private static boolean isCreate = false;
	private static TreeMap<Uri, String> getTableName;

	// /** Uri������ */
	private static final UriMatcher mUriMatcher = new UriMatcher(
			UriMatcher.NO_MATCH);
	//
	// ��ѯ�����º�ɾ������
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

	/** ����:��ѯ���� */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		// SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
		// switch (mUriMatcher.match(uri)) {
		// case COLLECTION_INDICATOR:
		// // ���ò�ѯ�ı�
		// queryBuilder.setTables(dboh.name);
		// // ����ͶӰӳ��
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

	/** ����:��ò����������� */
	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		switch (mUriMatcher.match(uri)) {
		// �õ����Ǳ��е���
		case SEARCH:
			return "";

		case SEARCH_ID:
			return "";

		default:
			throw new IllegalArgumentException("Unknow URI: " + uri);
		}
	}

	/** ����:������� */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		db.beginTransaction();
		Uri reUri = null;/* ����ֵ,����ɹ�����Uri,���򷵻�null */
		try {
			/* �������ݣ�������ID */
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

	/** ����:ɾ������ */
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		int count = 0; /* ����ֵ */
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

	/** ����:�������� */
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int count; /* ����ֵ */
		db.beginTransaction();
		try {
			switch (mUriMatcher.match(uri) % 2) {
			/* ����ָ���������� */
			case 0:
				count = db.update(getTableName.get(uri), values, selection,
						selectionArgs);
				break;
			/* ����ָ��������ID���� */
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
