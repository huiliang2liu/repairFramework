package com.entity;

import java.util.List;

import com.xh.util.Object2Json;

/**
 * @version ����ʱ�䣺2017-12-21 ����3:02:49 ��Ŀ��repairText ������com.entity
 *          �ļ�����Entity1.java ���ߣ�lhl ˵��:
 */

public class Entity1 {
	String name;
	int id;
	float fl;
	double dou;
	boolean boo;
	List<String> strings;
	List<Double> doubles;
	List<Entity2> entitys;
	Entity3 entity;

	public Entity1(String name, int id, float fl, double dou,
			List<String> strings, List<Double> doubles, List<Entity2> entitys,
			Entity3 entity,boolean boo) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.id = id;
		this.fl = fl;
		this.dou = dou;
		this.strings = strings;
		this.doubles = doubles;
		this.entitys = entitys;
		this.entity = entity;
		this.boo=boo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Object2Json.object_2_json(this);
	}
}
