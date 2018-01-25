package com.xh.http;

import com.xh.util.Json2Object;

/**
 * @version ����ʱ�䣺2017-11-16 ����10:04:00 ��Ŀ��TvBlackAD-eclipse
 *          ������com.tvblack.tv.http �ļ�����TVBHttpObject.java ���ߣ�lhl ˵��: ͬ����������
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
