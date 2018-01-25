package com.xh.save;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBOpenHelper extends SQLiteOpenHelper {
	private final static String TAG = "com.example.saveData.DBOpenHelper";
	private final static int VERSION = 1;
	private static String dbName = "DBOpenHelper.db";// 数据库名 必须以.db结尾
	private final static String CREAT_TABLE = "CREATE  TABLE ";
	private final static String INSERT_INTO = "INSERT INTO ";
	private final static String DROP_TABLE = "DROP TABLE ";
	private final static String ALTER = "ALTER TABLE ";
	private final static String ADD = " ADD ";
	private final static String DROP_COLUMN = " DROP COLUMN ";
	private final static String TYPE = "varchar(20)";
	private final static String LEFT_BRACKET = "(";
	private final static String RIGHT_BRACKET = ")";
	private final static String ALTER_COLUMN = "ALTER COLUMN ";
	public String name = "DBOpenHelper";
	private String field = "id integer primary key autoincrement,name varchar(10),info text,food_category varchar(10),prices double,vip_prices double,category varchar(10),picture_path varchar(50), "
			+ " is_best_seller varchar(2),is_recommend varchar(2)";// primary
	private SQLiteDatabase db;
	private Context context;

	public String getName() {
		return name;
	}

	public DBOpenHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		init(context);
	}

	@SuppressLint("NewApi")
	public DBOpenHelper(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
		init(context);
		// TODO Auto-generated constructor stub
	}

	public DBOpenHelper(Context context) {
		// TODO Auto-generated constructor stub
		this(context, dbName, null, VERSION);
		init(context);
	}

	public DBOpenHelper(Context context, String dbName) {
		// TODO Auto-generated constructor stub
		this(context, dbName, null, VERSION);
		init(context);
		this.dbName = dbName;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		createTable(db);
	}

	private void init(Context context) {
		// TODO Auto-generated method stub
		this.context = context;
	}

	/**
	 * 创建表格
	 */
	public void createTable() {
		if (db == null) {
			Log.e(TAG, "db is null");
			this.db = this.getReadableDatabase();
			return;
		}
		db.execSQL(CREAT_TABLE + name + LEFT_BRACKET + field + RIGHT_BRACKET);
		Log.e(TAG, "creat table name=" + name + "field=" + field);
	}

	/**
	 * 创建表格
	 * 
	 * @param db
	 */
	public void createTable(SQLiteDatabase db) {
		this.db = db;
		createTable();
	}

	/**
	 * 创建表格
	 * 
	 * @param name
	 *            表名
	 */
	public void createTable(String name) {
		this.name = name;
		createTable();
	}

	/**
	 * 创建表格
	 * 
	 * @param db
	 * @param name
	 *            表名
	 */
	public void createTable(SQLiteDatabase db, String name) {
		this.db = db;
		this.name = name;
		createTable();
	}

	/**
	 * 创建表格
	 * 
	 * @param name
	 *            表名
	 * @param field
	 *            字段
	 */
	public void createTable(String name, String field) {
		this.name = name;
		this.field = field;
		createTable();
	}

	/**
	 * 创建表格
	 * 
	 * @param db
	 * @param name
	 *            表名
	 * @param field
	 *            字段
	 */
	public void createTable(SQLiteDatabase db, String name, String field) {
		this.db = db;
		this.name = name;
		this.field = field;
		createTable();
	}

	/**
	 * 删除表格
	 */
	public void dropTable() {
		db.execSQL(DROP_TABLE + name);
		Log.e(TAG, "drop table " + name);
	}

	/**
	 * 删除表格
	 * 
	 * @param name
	 */
	public void dropTable(String name) {
		db.execSQL(DROP_TABLE + name);
		Log.e(TAG, "drop table " + name);
	}

	/**
	 * 添加一列
	 * 
	 * @param fieldName
	 */
	public void alterAdd(String fieldName) {
		db.execSQL(ALTER + name + ADD + fieldName + TYPE);
		Log.e(TAG, "alter table name=" + name + "fieldName=" + fieldName
				+ "type=" + TYPE);
	}

	/**
	 * 添加一列
	 * 
	 * @param tableName
	 * @param fieldName
	 */
	public void alterAdd(String tableName, String fieldName) {
		db.execSQL(ALTER + tableName + ADD + fieldName + TYPE);
		Log.e(TAG, "alter table name=" + tableName + "fieldName=" + fieldName
				+ "type=" + TYPE);
	}

	/**
	 * 添加一列
	 * 
	 * @param tableName
	 * @param fieldName
	 * @param type
	 */
	public void alterAdd(String tableName, String fieldName, String type) {
		db.execSQL(ALTER + tableName + ADD + fieldName + TYPE);
		Log.e(TAG, "alter table name=" + tableName + "fieldName=" + fieldName
				+ "type=" + type);
	}

	/**
	 * 修改一列的字段
	 * 
	 * @param fieldName
	 */
	public void alterColumn(String fieldName) {
		db.execSQL(ALTER + name + ALTER_COLUMN + fieldName + TYPE);
		Log.e(TAG, "alter column name=" + name + "fieldName=" + fieldName
				+ "type=" + TYPE);
	}

	/**
	 * 修改一列的字段
	 * 
	 * @param fieldName
	 * @param type
	 */
	public void alterColumn(String fieldName, String type) {
		db.execSQL(ALTER + name + ALTER_COLUMN + fieldName + type);
		Log.e(TAG, "alter column name=" + name + "fieldName=" + fieldName
				+ "type=" + type);
	}

	/**
	 * 修改一列的字段
	 * 
	 * @param tableName
	 * @param fieldName
	 * @param type
	 */
	public void alterColumn(String tableName, String fieldName, String type) {
		db.execSQL(ALTER + tableName + ALTER_COLUMN + fieldName + type);
		Log.e(TAG, "alter column name=" + tableName + "fieldName=" + fieldName
				+ "type=" + type);
	}

	/**
	 * 删除一列删除一列
	 * 
	 * @param fieldName
	 */
	public void alterDrop(String fieldName) {
		db.execSQL(ALTER + name + DROP_COLUMN + fieldName + fieldName);
		Log.e(TAG, "alter drop name=" + name + "fieldName=" + fieldName);
	}

	/**
	 * 删除一列删除一列
	 * 
	 * @param tableName
	 * @param fieldName
	 */
	public void alterDrop(String tableName, String fieldName) {
		db.execSQL(ALTER + tableName + DROP_COLUMN + fieldName + fieldName);
		Log.e(TAG, "alter drop name=" + tableName + "fieldName=" + fieldName);
	}

	/**
	 * 添加一行
	 * 
	 * @param key
	 * @param value
	 */
	public void insert(List<String> key, List<Object> value) {
		String sql = INSERT_INTO + name + " " + LEFT_BRACKET;
		for (int i = 0; i < key.size(); i++) {
			sql += key.get(i);
		}
		sql += RIGHT_BRACKET + " " + "VALUES " + LEFT_BRACKET;
		for (int i = 0; i < value.size(); i++) {
			sql += value.get(i);
		}
		sql += RIGHT_BRACKET;
		db.execSQL(sql);
	}

	/**
	 * 添加一行
	 * 
	 * @param tableName
	 * @param key
	 * @param value
	 */
	public void insert(String tableName, List<String> key, List<Object> value) {
		String sql = INSERT_INTO + tableName + " " + LEFT_BRACKET;
		for (int i = 0; i < key.size(); i++) {
			sql += key.get(i);
		}
		sql += RIGHT_BRACKET + " " + "VALUES " + LEFT_BRACKET;
		for (int i = 0; i < value.size(); i++) {
			sql += value.get(i);
		}
		sql += RIGHT_BRACKET;
		db.execSQL(sql);
	}

	/**
	 * 更新一行
	 * 
	 * @param upDateKey
	 * @param upDateValue
	 * @param upDateConditionsKey
	 * @param upDateConditionsValue
	 */
	public void upDateAnd(List<String> upDateKey, List<Object> upDateValue,
			List<String> upDateConditionsKey, List<Object> upDateConditionsValue) {
		String sql = "UPDATE " + name + " SET ";
		int len = upDateKey.size() > upDateValue.size() ? upDateValue.size()
				: upDateKey.size();
		if (len > 0)
			sql += upDateKey.get(0) + "=" + upDateValue.get(0);
		else
			return;
		for (int i = 1; i < len; i++) {
			sql += ", " + upDateKey.get(i) + "=" + upDateValue.get(i);
		}
		int conditionsLen = upDateConditionsKey.size() > upDateConditionsValue
				.size() ? upDateConditionsValue.size() : upDateConditionsKey
				.size();
		if (conditionsLen > 0)
			sql += "WHERE " + upDateConditionsKey.get(0) + "="
					+ upDateConditionsValue.get(0);
		else
			return;
		for (int i = 1; i < conditionsLen; i++) {
			sql += " AND " + upDateConditionsKey.get(i) + "="
					+ upDateConditionsValue.get(i);
		}
		db.execSQL(sql);
	}

	/**
	 * 更新一行
	 * 
	 * @param tableName
	 * @param upDateKey
	 * @param upDateValue
	 * @param upDateConditionsKey
	 * @param upDateConditionsValue
	 */
	public void upDateAnd(String tableName, List<String> upDateKey,
			List<Object> upDateValue, List<String> upDateConditionsKey,
			List<Object> upDateConditionsValue) {
		String sql = "UPDATE " + tableName + " SET ";
		int len = upDateKey.size() > upDateValue.size() ? upDateValue.size()
				: upDateKey.size();
		if (len > 0)
			sql += upDateKey.get(0) + "=" + upDateValue.get(0);
		else
			return;
		for (int i = 1; i < len; i++) {
			sql += ", " + upDateKey.get(i) + "=" + upDateValue.get(i);
		}
		int conditionsLen = upDateConditionsKey.size() > upDateConditionsValue
				.size() ? upDateConditionsValue.size() : upDateConditionsKey
				.size();
		if (conditionsLen > 0)
			sql += "WHERE " + upDateConditionsKey.get(0) + "="
					+ upDateConditionsValue.get(0);
		else
			return;
		for (int i = 1; i < conditionsLen; i++) {
			sql += " AND " + upDateConditionsKey.get(i) + "="
					+ upDateConditionsValue.get(i);
		}
		db.execSQL(sql);
	}

	/**
	 * 更新一行
	 * 
	 * @param upDateKey
	 * @param upDateValue
	 * @param upDateConditionsKey
	 * @param upDateConditionsValue
	 */
	public void upDateOr(List<String> upDateKey, List<Object> upDateValue,
			List<String> upDateConditionsKey, List<Object> upDateConditionsValue) {
		String sql = "UPDATE " + name + " SET ";
		int len = upDateKey.size() > upDateValue.size() ? upDateValue.size()
				: upDateKey.size();
		if (len > 0)
			sql += upDateKey.get(0) + "=" + upDateValue.get(0);
		else
			return;
		for (int i = 1; i < len; i++) {
			sql += ", " + upDateKey.get(i) + "=" + upDateValue.get(i);
		}
		int conditionsLen = upDateConditionsKey.size() > upDateConditionsValue
				.size() ? upDateConditionsValue.size() : upDateConditionsKey
				.size();
		if (conditionsLen > 0)
			sql += "WHERE " + upDateConditionsKey.get(0) + "="
					+ upDateConditionsValue.get(0);
		else
			return;
		for (int i = 1; i < conditionsLen; i++) {
			sql += " OR " + upDateConditionsKey.get(i) + "="
					+ upDateConditionsValue.get(i);
		}
		db.execSQL(sql);
	}

	/**
	 * 更新一行
	 * 
	 * @param tableName
	 * @param upDateKey
	 * @param upDateValue
	 * @param upDateConditionsKey
	 * @param upDateConditionsValue
	 */
	public void upDateOr(String tableName, List<String> upDateKey,
			List<Object> upDateValue, List<String> upDateConditionsKey,
			List<Object> upDateConditionsValue) {
		String sql = "UPDATE " + tableName + " SET ";
		int len = upDateKey.size() > upDateValue.size() ? upDateValue.size()
				: upDateKey.size();
		if (len > 0)
			sql += upDateKey.get(0) + "=" + upDateValue.get(0);
		else
			return;
		for (int i = 1; i < len; i++) {
			sql += ", " + upDateKey.get(i) + "=" + upDateValue.get(i);
		}
		int conditionsLen = upDateConditionsKey.size() > upDateConditionsValue
				.size() ? upDateConditionsValue.size() : upDateConditionsKey
				.size();
		if (conditionsLen > 0)
			sql += "WHERE " + upDateConditionsKey.get(0) + "="
					+ upDateConditionsValue.get(0);
		else
			return;
		for (int i = 1; i < conditionsLen; i++) {
			sql += " OR " + upDateConditionsKey.get(i) + "="
					+ upDateConditionsValue.get(i);
		}
		db.execSQL(sql);
	}

	/**
	 * 删除一行
	 * 
	 * @param key
	 * @param value
	 */
	public void deleteAnd(List<String> key, List<Object> value) {
		String sql = "DELETE FROM " + name + " WHERE ";
		int len = key.size() > value.size() ? value.size() : key.size();
		if (len > 0) {
			sql += key.get(0) + "=" + value.get(0);
		} else
			return;
		for (int i = 1; i < len; i++) {
			sql += "AND " + key.get(i) + "=" + value.get(i);
		}
		db.execSQL(sql);
	}

	/**
	 * 删除一行
	 * 
	 * @param tableName
	 * @param key
	 * @param value
	 */
	public void deleteOr(String tableName, List<String> key, List<Object> value) {
		String sql = "DELETE FROM " + tableName + " WHERE ";
		int len = key.size() > value.size() ? value.size() : key.size();
		if (len > 0) {
			sql += key.get(0) + "=" + value.get(0);
		} else
			return;
		for (int i = 1; i < len; i++) {
			sql += "OR " + key.get(i) + "=" + value.get(i);
		}
		db.execSQL(sql);
	}

	/**
	 * 清空表格
	 */
	public void empty() {
		String sql = "DELETE FROM " + name;
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
