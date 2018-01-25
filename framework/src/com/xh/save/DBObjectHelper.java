package com.xh.save;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.xh.encryption.MD5;
import com.xh.ifaces.IObjectDBHelper;

/**
 * @version 创建时间：2017-12-26 下午6:45:38 项目：repair 包名：com.xh.save
 *          文件名：DBObjectHelper.java 作者：lhl 说明:
 */

public class DBObjectHelper implements IObjectDBHelper {
	private SQLiteDatabase dbRead;
	private SQLiteDatabase dbWrit;
	private DBObjectImpl objectImpl;

	public DBObjectHelper(Context context) {
		// super(context, name, factory, version);
		// // TODO Auto-generated constructor stub
		// init(context);
		// DBOpenHelper.db
		this(context, MD5.String2MD5Method16(context.getPackageName()) + ".db",
				null, 1, null);
	}

	public DBObjectHelper(Context context, String name, CursorFactory factory,
			int version) {
		// super(context, name, factory, version);
		// // TODO Auto-generated constructor stub
		// init(context);
		this(context, name, factory, version, null);
	}

	public DBObjectHelper(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		// this(context, name, factory, version, errorHandler);
		// TODO Auto-generated constructor stub
		SQLiteOpenHelper openHelper = new SQLiteOpenHelper(context, name,
				factory, version, errorHandler) {

			@Override
			public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCreate(SQLiteDatabase arg0) {
				// TODO Auto-generated method stub

			}
		};
		dbRead = openHelper.getReadableDatabase();
		dbWrit = openHelper.getWritableDatabase();
		objectImpl = new DBObjectImpl();
	}

	@Override
	public void deleteTable(String tableName) {
		// TODO Auto-generated method stub
		objectImpl.deleteTable(dbWrit, tableName);
	}

	@Override
	public void clear(String tableName) {
		// TODO Auto-generated method stub
		objectImpl.clear(dbWrit, tableName);
	}

	@Override
	public void createTable(String tableName, List<DBTableEntity> entities) {
		// TODO Auto-generated method stub
		objectImpl.createTable(dbWrit, tableName, entities);
	}

	@Override
	public void createTable(String tableName, Class cl) {
		// TODO Auto-generated method stub
		objectImpl.createTable(dbWrit, tableName, cl);
	}

	@Override
	public long insert(String table, ContentValues values) {
		// TODO Auto-generated method stub
		return objectImpl.insert(dbWrit, table, values);
	}

	@Override
	public long insert(String table, Object object) {
		// TODO Auto-generated method stub
		return objectImpl.insert(dbWrit, table, object);
	}

	@Override
	public int delete(String table, String whereClause, String[] whereArgs) {
		// TODO Auto-generated method stub
		return objectImpl.delete(dbWrit, table, whereClause, whereArgs);
	}

	@Override
	public int delete(String table, Object object) {
		// TODO Auto-generated method stub
		return objectImpl.delete(dbWrit, table, object);
	}

	@Override
	public int update(String table, ContentValues values, String whereClause,
			String[] whereArgs) {
		// TODO Auto-generated method stub
		return objectImpl.update(dbWrit, table, values, whereClause, whereArgs);
	}

	@Override
	public int update(String table, Object newObject, Object oldObject) {
		// TODO Auto-generated method stub
		return objectImpl.update(dbWrit, table, newObject, oldObject);
	}

	@Override
	public int update(String table, Object object, String whereClause,
			String[] whereArgs) {
		// TODO Auto-generated method stub
		return objectImpl.update(dbWrit, table, object, whereClause, whereArgs);
	}

	@Override
	public Cursor select(String table) {
		// TODO Auto-generated method stub
		return objectImpl.select(dbRead, table);
	}

	@Override
	public Cursor select(String table, List<String> names) {
		// TODO Auto-generated method stub
		return objectImpl.select(dbRead, table, names);
	}

	@Override
	public Cursor select(String table, String whereClause, String[] whereArgs) {
		// TODO Auto-generated method stub
		return objectImpl.select(dbRead, table, whereClause, whereArgs);
	}

	@Override
	public Cursor select(String table, String whereClause, String[] whereArgs,
			List<String> names) {
		// TODO Auto-generated method stub
		return objectImpl.select(dbRead, table, whereClause, whereArgs, names);
	}

	@Override
	public List<Object> selectObject(String table, Class cl) {
		// TODO Auto-generated method stub
		return objectImpl.selectObject(dbRead, table, cl);
	}

	@Override
	public List<Object> selectObject(String table, List<String> names, Class cl) {
		// TODO Auto-generated method stub
		return objectImpl.selectObject(dbRead, table, names, cl);
	}

	@Override
	public List<Object> selectObject(String table, String whereClause,
			String[] whereArgs, Class cl) {
		// TODO Auto-generated method stub
		return objectImpl.selectObject(dbRead, table, whereClause, whereArgs,
				cl);
	}

	@Override
	public List<Object> selectObject(String table, String whereClause,
			String[] whereArgs, List<String> names, Class cl) {
		// TODO Auto-generated method stub
		return objectImpl.selectObject(dbRead, table, whereClause, whereArgs,
				names, cl);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		dbRead.close();
		dbWrit.close();
	}

}
