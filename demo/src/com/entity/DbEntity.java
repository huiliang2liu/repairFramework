package com.entity;

/**
 * @version ����ʱ�䣺2017-12-26 ����3:56:12 ��Ŀ��repairText ������com.entity
 *          �ļ�����DbEntity.java ���ߣ�lhl ˵��:
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
