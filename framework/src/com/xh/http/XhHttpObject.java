package com.xh.http;

import com.xh.util.Json2Object;

/**
 * @version 创建时间：2017-11-16 上午10:04:00 项目：TvBlackAD-eclipse
 *          包名：com.tvblack.tv.http 文件名：TVBHttpObject.java 作者：lhl 说明: 同步对象请求
 */

public class XhHttpObject extends XhHttpString {
	private XhHttpLoadListenObject listenObject;
	private Class class1;

	public XhHttpObject(XhHttpCallback handler, Class c) {
		super(handler);
		class1 = c;
		// TODO Auto-generated constructor stub
		setListemString(new XhHttpLoadListenString() {

			@Override
			public void starting() {
				// TODO Auto-generated method stub
				if (listenObject != null)
					listenObject.starting();
			}

			@Override
			public void loadDeafalt(String deafalt) {
				// TODO Auto-generated method stub
				if (listenObject != null)
					listenObject.loadDeafalt(deafalt);
			}

			@Override
			public void loaded(String string) {
				// TODO Auto-generated method stub
				if (listenObject != null)
					listenObject.loaded(Json2Object.string2object(class1,
							string));
			}
		});
	}

	public void setListenObject(XhHttpLoadListenObject listenObject) {
		this.listenObject = listenObject;
	}

}
