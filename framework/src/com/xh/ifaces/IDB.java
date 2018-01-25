package com.xh.ifaces;

import java.util.List;

import com.xh.save.DBTableEntity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * @version 创建时间：2017-12-26 下午12:24:00 项目：repair 包名：com.xh.ifaces 文件名：IDB.java
 *          作者：lhl 说明:
 */

public interface IDB {
	/**
	 * 
	 * lhl 2017-12-26 下午12:24:53 说明： 删除表格 void
	 */
	void deleteTable(SQLiteDatabase db, String tableName);

	/**
	 * 
	 * lhl 2017-12-26 下午12:26:59 说明：清空表格
	 * 
	 * @param db
	 * @param tableName
	 *            void
	 */
	void clear(SQLiteDatabase db, String tableName);

	/**
	 * 
	 * lhl 2017-12-26 下午12:28:07 说明：创建表格
	 * 
	 * @param db
	 * @param tableName
	 * @param entities
	 *            void
	 */
	void createTable(SQLiteDatabase db, String tableName,
			List<DBTableEntity> entities);

	/**
	 * 
	 * lhl 2017-12-26 下午12:34:16 说明：插入数据
	 * 
	 * @param db
	 * @param table
	 * @param values
	 * @return long
	 */
	long insert(SQLiteDatabase db, String table, ContentValues values);

	/**
	 * 
	 * lhl 2017-12-26 下午12:30:20 说明：删除数据 比如想删除 age<35 则whereClause="age < ?"
	 * whereArgs=new String[]{"35"}
	 * 
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 *            void
	 */
	int delete(SQLiteDatabase db, String table, String whereClause,
			String[] whereArgs);

	/**
	 * 
	 * lhl 2017-12-26 下午12:36:22 说明：更新数据 比如想更新 age<35 则whereClause="age < ?"
	 * whereArgs=new String[]{"35"}
	 * 
	 * @param table
	 * @param values
	 * @param whereClause
	 * @param whereArgs
	 * @return int
	 */
	int update(SQLiteDatabase db, String table, ContentValues values,
			String whereClause, String[] whereArgs);

	/**
	 * 
	 * lhl 2017-12-26 下午12:51:45 说明：查询
	 * 
	 * @param db
	 * @param table
	 * @return Cursor
	 */
	Cursor select(SQLiteDatabase db, String table);

	/**
	 * 
	 * lhl 2017-12-26 下午12:52:07 说明：查询 查询指定的列
	 * 
	 * @param db
	 * @param table
	 * @param names
	 * @return Cursor
	 */
	Cursor select(SQLiteDatabase db, String table, List<String> names);

	/**
	 * 
	 * lhl
	 * 2017-12-26 下午12:52:45
	 * 说明：查询 比如想查询 age<35 则whereClause="age < ?"
	 * @param db
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @return Cursor
	 */
	Cursor select(SQLiteDatabase db,String table, String whereClause,
			String[] whereArgs);
	/**
	 * 
	 * lhl
	 * 2017-12-26 下午12:52:45
	 * 说明：查询 查询指定的列比如想查询 age<35 则whereClause="age < ?"
	 * @param db
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @return Cursor
	 */
	Cursor select(SQLiteDatabase db,String table, String whereClause,
			String[] whereArgs,List<String> names);
}
