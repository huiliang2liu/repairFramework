package com.entity;

/**
 * @version 创建时间：2017-12-26 下午3:56:12 项目：repairText 包名：com.entity
 *          文件名：DbEntity.java 作者：lhl 说明:
 */

public class DbEntity {
	String tex;
	double age;
	String sex;

	public DbEntity(String text, double age, String sex) {
		// TODO Auto-generated constructor stub
		this.tex = text;
		this.age = age;
		this.sex = sex;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "text=" + tex + " age=" + age + " sex=" + sex;
	}
}
