package com.xh.save;

/**
 * @version 创建时间：2017-12-25 下午3:25:28 项目：repair 包名：com.xh.save
 *          文件名：DBContants.java 作者：lhl 说明:
 */

public class DBContants {
	public final static String CREATE_DATABASE = "CREATE DATABASE dbName";
	public final static String CREATE_TABLE = "CREATE TABLE tableName(fields)";
	public final static String INT = "int";
	public final static String INTEGER = "integer";
	public final static String SMALLINT = "smallint";
	public final static String TINYINT = "tinyint";
	public final static String DECIMAL = "decimal(size,b)";// (size,d)
	public final static String NUMERIC = "numeric(size,d)";// numeric(size,d)
	public final static String CHAR = "char(size)";// 容纳固定长度的字符串
	public final static String VARCHAR = "varchar(size)";// 容纳可变长度的字符串
	public final static String DATE = "date(yyyymmdd)";// date(yyyymmdd)
	/**
	 * 强制列不接受 NULL 值
	 */
	public final static String NOT_NULL = "NOT NULL";
	/**
	 * 唯一标识数据库表中的每条记录
	 */
	public final static String UNIQUE = "UNIQUE";
	public final static String ADD_CONSTRAINT_UNIQUE = "ALTER TABLE tableName CONSTRAINT ucName UNIQUE (columns)";
	public final static String DROP_CONSTRAINT = "ALTER TABLE tableName DROP CONSTRAINT ucName";
	/**
	 * 主键
	 */
	public final static String PRIMARY_KEY = "PRIMARY KEY";
	/**
	 * 主键 自增长
	 */
	public final static String PRIMARY_KEY_AUTOINCREMENT = "PRIMARY KEY AUTOINCREMENT";
	public final static String ADD_PRIMARY_KEY = "ALTER TABLE tableName ADD CONSTRAINT ucName PRIMARY KEY (columns)";
	public final static String FOREIGN_KEY = "CONSTRAINT tableName1 FOREIGN KEY (columns) REFERENCES tableName2(columns)";
	public final static String ADD_FOREIGN_KEY = "ALTER TABLE tableName1 ADD CONSTRAINT ucName FOREIGN KEY (columns) REFERENCES tableName2(columns)";
	public final static String CHECK = "CONSTRAINT ucName CHECK (columns)";
	public final static String ADD_CHECK = "ALTER TABLE tableName ADD CONSTRAINT ucName CHECK (columns)";
	public final static String DROP_TABLE = "DROP TABLE tableName";
	public final static String DROP_DATABASE = "DROP DATABASE dbName";
	public final static String TRUNCATE_TABLE = "TRUNCATE TABLE tableName";
	public final static String ADD_COLUMN = "ALTER TABLE tableName ADD column type";
	public final static String DROP_COLUMN = "ALTER TABLE tablename DROP COLUMN columname";
	public final static String ALTER_COLUMN = "ALTER TABLE tableName ALTER COLUMN column type";
	public final static String IDENTITY = "IDENTITY";
	public final static String SELECT = "SELECT * FROM tableName";
	public final static String SELECT_COLUMNS = "SELECT columns FROM tableName";
	public final static String WHERE = " WHERE columns";
	public final static String DESC = "DESC";// 逆序
	public final static String ASC = "ASC";// 顺序
	public final static String ORDER_BY = " ORDER BY ";
	public final static String INSERT_INTO = "INSERT INTO tableName (keys) VALUES (values)";
	public final static String UPDATE = "UPDATE tableName SET newValue  WHERE oldValue";
	public final static String DELETE = "DELETE FROM tableName WHERE column";
	public final static String SELECT_TOP = "SELECT TOP size columns FROM tableName";
	public final static String SELECT_PERCENT = "SELECT TOP percent PERCENT columns FROM tableName";
	public final static String LIKE = "LIKE pattern";
	public final static String IN = "IN (columns)";
}
