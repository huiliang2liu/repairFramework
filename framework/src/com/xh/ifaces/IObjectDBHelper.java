package com.xh.ifaces;

import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;

import com.xh.save.DBTableEntity;

/**
 * @version 创建时间：2017-12-27 上午10:31:30 项目：repair 包名：com.xh.ifaces 文件名：a.java
 *          作者：lhl 说明:
 */

public interface IObjectDBHelper {
	/**
	 * 
	 * lhl 2017-12-27 上午10:35:52 说明：刪除
	 * 
	 * @param tableName
	 *            void
	 */
	public void deleteTable(String tableName);

	/**
	 * 
	 * lhl 2017-12-27 上午10:36:02 说明：清空
	 * 
	 * @param tableName
	 *            void
	 */
	public void clear(String tableName);

	/**
	 * 
	 * lhl 2017-12-27 上午10:36:14 说明：创建
	 * 
	 * @param tableName
	 * @param entities
	 *            void
	 */
	public void createTable(String tableName, List<DBTableEntity> entities);

	/**
	 * 
	 * lhl 2017-12-27 上午10:36:50 说明：创建
	 * 
	 * @param tableName
	 * @param cl
	 *            void
	 */
	public void createTable(String tableName, Class cl);

	/**
	 * 
	 * lhl 2017-12-27 上午10:37:00 说明：插入
	 * 
	 * @param table
	 * @param values
	 * @return long
	 */
	public long insert(String table, ContentValues values);

	/**
	 * 
	 * lhl 2017-12-27 上午10:37:17 说明：插入
	 * 
	 * @param table
	 * @param object
	 * @return long
	 */
	public long insert(String table, Object object);

	/**
	 * 
	 * lhl 2017-12-27 上午10:37:29 说明：删除
	 * 
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @return int
	 */
	public int delete(String table, String whereClause, String[] whereArgs);

	/**
	 * 
	 * lhl 2017-12-27 上午10:37:45 说明：删除
	 * 
	 * @param table
	 * @param object
	 * @return int
	 */
	public int delete(String table, Object object);

	/**
	 * 
	 * lhl 2017-12-27 上午10:37:55 说明：更新
	 * 
	 * @param db
	 * @param table
	 * @param values
	 * @param whereClause
	 * @param whereArgs
	 * @return int
	 */
	public int update( String table, ContentValues values,
			String whereClause, String[] whereArgs);

	/**
	 * 
	 * lhl 2017-12-27 上午10:38:16 说明：更新
	 * 
	 * @param table
	 * @param newObject
	 * @param oldObject
	 * @return int
	 */
	public int update(String table, Object newObject, Object oldObject);

	/**
	 * 
	 * lhl 2017-12-27 上午10:38:24 说明：更新
	 * 
	 * @param table
	 * @param object
	 * @param whereClause
	 * @param whereArgs
	 * @return int
	 */
	public int update(String table, Object object, String whereClause,
			String[] whereArgs);

	/**
	 * 
	 * lhl 2017-12-27 上午10:38:37 说明：查找
	 * 
	 * @param table
	 * @return Cursor
	 */
	public Cursor select(String table);

	/**
	 * 
	 * lhl 2017-12-27 上午10:38:44 说明：查找
	 * 
	 * @param db
	 * @param table
	 * @param names
	 * @return Cursor
	 */
	public Cursor select( String table, List<String> names);

	/**
	 * 
	 * lhl 2017-12-27 上午10:38:49 说明：查找
	 * 
	 * @param db
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @return Cursor
	 */
	public Cursor select(String table, String whereClause,
			String[] whereArgs);

	/**
	 * 
	 * lhl 2017-12-27 上午10:38:53 说明：查找
	 * 
	 * @param db
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @param names
	 * @return Cursor
	 */
	public Cursor select( String table, String whereClause,
			String[] whereArgs, List<String> names);

	/**
	 * 
	 * lhl 2017-12-27 上午10:39:08 说明：查找
	 * 
	 * @param table
	 * @param cl
	 * @return List<Object>
	 */
	public List<Object> selectObject(String table, Class cl);

	/**
	 * 
	 * lhl 2017-12-27 上午10:39:12 说明：查找
	 * 
	 * @param table
	 * @param names
	 * @param cl
	 * @return List<Object>
	 */
	public List<Object> selectObject(String table, List<String> names, Class cl);

	/**
	 * 
	 * lhl 2017-12-27 上午10:39:16 说明：查找
	 * 
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @param cl
	 * @return List<Object>
	 */
	public List<Object> selectObject(String table, String whereClause,
			String[] whereArgs, Class cl);

	/**
	 * 
	 * lhl 2017-12-27 上午10:39:20 说明：查找
	 * 
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @param names
	 * @param cl
	 * @return List<Object>
	 */
	public List<Object> selectObject(String table, String whereClause,
			String[] whereArgs, List<String> names, Class cl);
	/**
	 * 
	 * lhl
	 * 2017-12-27 下午5:46:45
	 * 说明： 关闭
	 * void
	 */
	public void close();
}
