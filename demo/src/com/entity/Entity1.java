package com.entity;

import java.util.List;

import com.xh.util.Object2Json;

/**
 * @version 创建时间：2017-12-21 下午3:02:49 项目：repairText 包名：com.entity
 *          文件名：Entity1.java 作者：lhl 说明:
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
