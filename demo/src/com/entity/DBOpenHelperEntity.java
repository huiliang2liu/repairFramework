//package com.entity;
//
//import java.util.List;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.database.DatabaseErrorHandler;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteDatabase.CursorFactory;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import com.xh.save.DBObjectImpl;
//import com.xh.util.XhLog;
//
///**
// * @version 创建时间：2017-12-26 下午4:01:36 项目：repairText 包名：com.entity
// *          文件名：DBOpenHelperEntity.java 作者：lhl 说明:
// */
//
//public class DBOpenHelperEntity extends SQLiteOpenHelper {
//	private final static int VERSION = 1;
//	private static String dbName = "DBOpenHelper.db";// 数据库名 必须以.db结尾
//	private Context context;
//	private DBObjectImpl impl;
//	private SQLiteDatabase dbRead;
//	private SQLiteDatabase dbWrit;
//	private String tableName = "tableName";
//
//	public DBOpenHelperEntity(Context context, String name,
//			CursorFactory factory, int version) {
//		this(context, name, factory, version, null);
//		// TODO Auto-generated constructor stub
//	}
//
//	@SuppressLint("NewApi")
//	public DBOpenHelperEntity(Context context, String name,
//			CursorFactory factory, int version,
//			DatabaseErrorHandler errorHandler) {
//		super(context, name, factory, version, errorHandler);
//		init(context);
//		// TODO Auto-generated constructor stub
//	}
//
//	public DBOpenHelperEntity(Context context) {
//		// TODO Auto-generated constructor stub
//		this(context, dbName, null, VERSION);
//	}
//
//	private void init(Context context) {
//		// TODO Auto-generated method stub
//		this.context = context;
//		impl = new DBObjectImpl(DbEntity.class);
//		dbRead = getReadableDatabase();
//		dbWrit = getWritableDatabase();
//		try {
//			impl.deleteTable(dbWrit, tableName);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		impl.createTable(dbWrit, tableName);
//	}
//
//	@Override
//	public void onCreate(SQLiteDatabase arg0) {
//		// TODO Auto-generated method stub
//		// if (db == null) {
//		// this.db = arg0;
//		// XhLog.e("====", "onCreate");
//		// }
//		// String field =
//		// "id integer primary key autoincrement,name varchar(10),info text,food_category varchar(10),prices double,vip_prices double,category varchar(10),picture_path varchar(50), "
//		// + " is_best_seller varchar(2),is_recommend varchar(2)";// primary
//		// db.execSQL("CREATE TABLE tableName(field)".replace("field", field));
//		// impl.createTable(arg0, tableName, entities);
//		// impl.createTable(db, tableName);
//	}
//
//	public void createTable() {
//		// String field =
//		// "id integer primary key autoincrement,name varchar(10),info text,food_category varchar(10),prices double,vip_prices double,category varchar(10),picture_path varchar(50), "
//		// + " is_best_seller varchar(2),is_recommend varchar(2)";// primary
//		// getReadableDatabase().execSQL("CREATE TABLE tableName(field)".replace("field",
//		// field));
//
//	}
//
//	public void clean() {
//		impl.clear(dbWrit, tableName);
//	}
//
//	public long insert(Object object) {
//		return impl.insert(dbWrit, tableName, object);
//	}
//
//	public List<Object> select() {
//		return impl.selectObject(dbRead, tableName);
//	}
//
//	@Override
//	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
