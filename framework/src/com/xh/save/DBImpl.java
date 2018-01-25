package com.xh.save;

import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.xh.ifaces.IDB;
import com.xh.util.XhLog;

/**
 * @version 创建时间：2017-12-26 下午12:44:56 项目：repair 包名：com.xh.save 文件名：DBImpl.java
 *          作者：lhl 说明:
 */

public class DBImpl implements IDB {
	private final static String TAG = DBImpl.class.getName();

	@Override
	public void deleteTable(SQLiteDatabase db, String tableName) {
		// TODO Auto-generated method stub
		db.execSQL(DBHelper.dropTable(tableName));
	}

	@Override
	public void clear(SQLiteDatabase db, String tableName) {
		// TODO Auto-generated method stub
		db.execSQL(DBHelper.empty(tableName));
	}

	@Override
	public void createTable(SQLiteDatabase db, String tableName,
			List<DBTableEntity> entities) {
		// TODO Auto-generated method stub
		XhLog.e(TAG, DBHelper.createTable(tableName, entities));
		try {
			db.execSQL(DBHelper.createTable(tableName, entities));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public long insert(SQLiteDatabase db, String table, ContentValues values) {
		// TODO Auto-generated method stub
		return db.insert(table, null, values);
	}

	@Override
	public int delete(SQLiteDatabase db, String table, String whereClause,
			String[] whereArgs) {
		// TODO Auto-generated method stub
		return db.delete(table, whereClause, whereArgs);
	}

	@Override
	public int update(SQLiteDatabase db, String table, ContentValues values,
			String whereClause, String[] whereArgs) {
		// TODO Auto-generated method stub
		return db.update(table, values, whereClause, whereArgs);
	}

	@Override
	public Cursor select(SQLiteDatabase db, String table) {
		// TODO Auto-generated method stub
		return db.rawQuery(DBContants.SELECT.replace("tableName", table), null);
	}

	@Override
	public Cursor select(SQLiteDatabase db, String table, List<String> names) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < names.size(); i++) {
			sb.append(names.get(i)).append(",");
		}
		String string = sb.substring(0, sb.length() - 1);
		return db.rawQuery(DBContants.SELECT_COLUMNS.replace("columns", string)
				.replace("tableName", table), null);
	}

	@Override
	public Cursor select(SQLiteDatabase db, String table, String whereClause,
			String[] whereArgs) {
		// TODO Auto-generated method stub
		return db.rawQuery(DBContants.SELECT.replace("tableName", table)
				+ " WHERE " + whereClause, whereArgs);
	}

	@Override
	public Cursor select(SQLiteDatabase db, String table, String whereClause,
			String[] whereArgs, List<String> names) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < names.size(); i++) {
			sb.append(names.get(i)).append(",");
		}
		String string = sb.substring(0, sb.length() - 1);
		return db.rawQuery(DBContants.SELECT_COLUMNS.replace("columns", string)
				.replace("tableName", table) + " WHERE " + whereClause,
				whereArgs);
	}

}
