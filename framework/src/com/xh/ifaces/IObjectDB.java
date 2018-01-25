package com.xh.ifaces;

import java.util.List;

import android.database.sqlite.SQLiteDatabase;

/**
 * @version 创建时间：2017-12-27 上午9:56:32 项目：repair 包名：com.xh.ifaces
 *          文件名：IObjectDB.java 作者：lhl 说明:
 */

public interface IObjectDB extends IDB {
	/**
	 * 
	 * lhl 2017-12-26 下午3:35:32 说明：创建表格
	 * 
	 * @param db
	 * @param tableName
	 *            void
	 */
	public void createTable(SQLiteDatabase db, String tableName, Class cl);

	/**
	 * 
	 * lhl 2017-12-27 上午9:57:00 说明：插入数据
	 * 
	 * @param db
	 * @param table
	 * @param object
	 * @return long
	 */
	public long insert(SQLiteDatabase db, String table, Object object);

	/**
	 * 
	 * lhl 2017-12-27 上午9:57:17 说明：删除数据
	 * 
	 * @param db
	 * @param table
	 * @param object
	 * @return int
	 */
	public int delete(SQLiteDatabase db, String table, Object object);

	/**
	 * 
	 * lhl 2017-12-27 上午9:57:30 说明：更新数据
	 * 
	 * @param db
	 * @param table
	 * @param newObject
	 * @param oldObject
	 * @return int
	 */
	public int update(SQLiteDatabase db, String table, Object newObject,
			Object oldObject);

	/**
	 * 
	 * lhl 2017-12-27 上午9:57:57 说明：更新数据 比如想更新 age<35 则whereClause="age < ?"
	 * whereArgs=new String[]{"35"}
	 * 
	 * @param db
	 * @param table
	 * @param object
	 * @param whereClause
	 * @param whereArgs
	 * @return int
	 */
	public int update(SQLiteDatabase db, String table, Object object,
			String whereClause, String[] whereArgs);

	/**
	 * 
	 * lhl 2017-12-27 上午9:58:13 说明：查询数据
	 * 
	 * @param db
	 * @param table
	 * @param cl
	 * @return List<Object>
	 */
	public List<Object> selectObject(SQLiteDatabase db, String table, Class cl);

	/**
	 * 
	 * lhl 2017-12-27 上午9:58:33 说明：查询数据
	 * 
	 * @param db
	 * @param table
	 * @param names
	 * @param cl
	 * @return List<Object>
	 */
	public List<Object> selectObject(SQLiteDatabase db, String table,
			List<String> names, Class cl);

	/**
	 * 
	 * lhl 2017-12-27 上午9:59:04 说明：查询数据
	 * 
	 * @param db
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @param cl
	 * @return List<Object>
	 */
	public List<Object> selectObject(SQLiteDatabase db, String table,
			String whereClause, String[] whereArgs, Class cl);

	/**
	 * 
	 * lhl 2017-12-27 上午9:59:21 说明：查询数据
	 * 
	 * @param db
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @param names
	 * @param cl
	 * @return List<Object>
	 */
	public List<Object> selectObject(SQLiteDatabase db, String table,
			String whereClause, String[] whereArgs, List<String> names, Class cl);
}
