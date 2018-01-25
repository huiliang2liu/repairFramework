package com.xh.http;

import java.util.Map;

import com.xh.encryption.IEncryption;

/**
 * @version ����ʱ�䣺2017-11-15 ����4:51:39 ��Ŀ��XhlackAD-eclipse ������com.Xhlack.tv.http
 *          �ļ�����XhHttpManager.java ���ߣ�lhl ˵��: �������������
 */

public interface IHttpManager {
	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ��������get����
	 * 
	 * @param path
	 *            ·�� void
	 */
	void stream(String path);

	void stream(String path, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ��������get����
	 * 
	 * @param path
	 *            ·��
	 * @param listenStream
	 *            ���������� void
	 */
	void stream(String path, XhHttpLoadListenStream listenStream);

	void stream(String path, XhHttpLoadListenStream listenStream,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ��������get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ� void
	 */
	void stream(String path, Map<String, Object> params);

	void stream(String path, Map<String, Object> params, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ��������get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            ���������� void
	 */
	void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream);

	void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ��������get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            ����������
	 * @param handler
	 *            ����ص� void
	 */
	void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler);

	void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ��������get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            ����������
	 * @param handler
	 *            ����ص�
	 * @param time
	 *            �ӳ�ʱ�� void
	 */
	void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time);

	void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time, IEncryption encryption);


	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ��������post����
	 * 
	 * @param path
	 *            ·�� void
	 */
	void streamPost(String path);

	void streamPost(String path, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ��������post����
	 * 
	 * @param path
	 *            ·��
	 * @param listenStream
	 *            ���������� void
	 */
	void streamPost(String path, XhHttpLoadListenStream listenStream);

	void streamPost(String path, XhHttpLoadListenStream listenStream,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ��������post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ� void
	 */
	void streamPost(String path, Map<String, Object> params);

	void streamPost(String path, Map<String, Object> params,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ��������post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            ���������� void
	 */
	void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream);

	void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ��������post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            ����������
	 * @param handler
	 *            ����ص� void
	 */
	void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler);

	void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ��������post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            ����������
	 * @param handler
	 *            ����ص�
	 * @param time
	 *            �ӳ�ʱ�� void
	 */
	void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time);

	void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���get����
	 * 
	 * @param path
	 *            ·�� void
	 */
	void string(String path);

	void string(String path, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param listenStream
	 *            �ַ������� void
	 */
	void string(String path, XhHttpLoadListenString listenString);

	void string(String path, XhHttpLoadListenString listenString,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ� void
	 */
	void string(String path, Map<String, Object> params);

	void string(String path, Map<String, Object> params, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �ַ������� void
	 */
	void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString);

	void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �ַ�������
	 * @param handler
	 *            ����ص� void
	 */
	void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler);

	void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �ַ�������
	 * @param handler
	 *            ����ص�
	 * @param time
	 *            �ӳ�ʱ�� void
	 */
	void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time);

	void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���get����
	 * 
	 * @param path
	 *            ·�� void
	 */
	void stringAsyn(String path);

	void stringAsyn(String path, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param listenStream
	 *            �ַ������� void
	 */
	void stringAsyn(String path, XhHttpLoadListenString listenString);

	void stringAsyn(String path, XhHttpLoadListenString listenString,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ� void
	 */
	void stringAsyn(String path, Map<String, Object> params);

	void stringAsyn(String path, Map<String, Object> params,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �ַ������� void
	 */
	void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString);

	void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �ַ�������
	 * @param handler
	 *            ����ص� void
	 */
	void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler);

	void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �ַ�������
	 * @param handler
	 *            ����ص�
	 * @param time
	 *            �ӳ�ʱ�� void
	 */
	void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time);

	void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���post����
	 * 
	 * @param path
	 *            ·�� void
	 */
	void stringPost(String path);

	void stringPost(String path, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param listenStream
	 *            �ַ������� void
	 */
	void stringPost(String path, XhHttpLoadListenString listenString);

	void stringPost(String path, XhHttpLoadListenString listenString,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ� void
	 */
	void stringPost(String path, Map<String, Object> params);

	void stringPost(String path, Map<String, Object> params,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �ַ������� void
	 */
	void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString);

	void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �ַ�������
	 * @param handler
	 *            ����ص� void
	 */
	void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler);

	void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �ַ�������
	 * @param handler
	 *            ����ص�
	 * @param time
	 *            �ӳ�ʱ�� void
	 */
	void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time);

	void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���post����
	 * 
	 * @param path
	 *            ·�� void
	 */
	void stringPostAsyn(String path);

	void stringPostAsyn(String path, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param listenStream
	 *            �ַ������� void
	 */
	void stringPostAsyn(String path, XhHttpLoadListenString listenString);

	void stringPostAsyn(String path, XhHttpLoadListenString listenString,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ� void
	 */
	void stringPostAsyn(String path, Map<String, Object> params);

	void stringPostAsyn(String path, Map<String, Object> params,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �ַ������� void
	 */
	void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString);

	void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �ַ�������
	 * @param handler
	 *            ����ص� void
	 */
	void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler);

	void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �ַ�������
	 * @param handler
	 *            ����ص�
	 * @param time
	 *            �ӳ�ʱ�� void
	 */
	void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time);

	void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param c
	 *            ���ն��� void
	 */
	void object(String path, Class c);

	void object(String path, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param listenStream
	 *            �������
	 * @param c
	 *            ���ն��� void
	 */
	void object(String path, XhHttpLoadListenObject listenObject, Class c);

	void object(String path, XhHttpLoadListenObject listenObject, Class c,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param c
	 *            ���ն��� void
	 */
	void object(String path, Map<String, Object> params, Class c);

	void object(String path, Map<String, Object> params, Class c,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �������
	 * @param c
	 *            ���ն��� void
	 */
	void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c);

	void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �������
	 * @param handler
	 *            ����ص�
	 * @param c
	 *            ���ն��� void
	 */
	void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler, Class c);

	void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            ����������
	 * @param handler
	 *            ����ص�
	 * @param time
	 *            �ӳ�ʱ��
	 * @param c
	 *            ���ն��� void
	 */
	void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c);

	void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param c
	 *            ���ն��� void
	 */
	void objectAsyn(String path, Class c);

	void objectAsyn(String path, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param listenStream
	 *            �������
	 * @param c
	 *            ���ն��� void
	 */
	void objectAsyn(String path, XhHttpLoadListenObject listenObject, Class c);

	void objectAsyn(String path, XhHttpLoadListenObject listenObject, Class c,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param c
	 *            ���ն��� void
	 */
	void objectAsyn(String path, Map<String, Object> params, Class c);

	void objectAsyn(String path, Map<String, Object> params, Class c,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �������
	 * @param c
	 *            ���ն��� void
	 */
	void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c);

	void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �������
	 * @param handler
	 *            ����ص�
	 * @param c
	 *            ���ն��� void
	 */
	void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler, Class c);

	void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���get����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �������
	 * @param handler
	 *            ����ص�
	 * @param time
	 *            �ӳ�ʱ��
	 * @param c
	 *            ���ն��� void
	 */
	void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c);

	void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param c
	 *            ���ն��� void
	 */
	void objectPost(String path, Class c);

	void objectPost(String path, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param listenStream
	 *            �������
	 * @param c
	 *            ���ն��� void
	 */
	void objectPost(String path, XhHttpLoadListenObject listenObject, Class c);

	void objectPost(String path, XhHttpLoadListenObject listenObject, Class c,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param c
	 *            ���ն��� void
	 */
	void objectPost(String path, Map<String, Object> params, Class c);

	void objectPost(String path, Map<String, Object> params, Class c,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �������
	 * @param c
	 *            ���ն��� void
	 */
	void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c);

	void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �������
	 * @param handler
	 *            ����ص�
	 * @param c
	 *            ���ն��� void
	 */
	void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler, Class c);

	void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵����ͬ���ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �������
	 * @param handler
	 *            ����ص�
	 * @param time
	 *            �ӳ�ʱ��
	 * @param c
	 *            ���ն��� void
	 */
	void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c);

	void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param c
	 *            ���ն��� void
	 */
	void objectPostAsyn(String path, Class c);

	void objectPostAsyn(String path, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param listenStream
	 *            �������
	 * @param c
	 *            ���ն��� void
	 */
	void objectPostAsyn(String path, XhHttpLoadListenObject listenObject,
			Class c);

	void objectPostAsyn(String path, XhHttpLoadListenObject listenObject,
			Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param c
	 *            ���ն��� void
	 */
	void objectPostAsyn(String path, Map<String, Object> params, Class c);

	void objectPostAsyn(String path, Map<String, Object> params, Class c,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �������
	 * @param c
	 *            ���ն��� void
	 */
	void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c);

	void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �������
	 * @param handler
	 *            ����ص�
	 * @param c
	 *            ���ն��� void
	 */
	void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler, Class c);

	void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 ����10:36:15 ˵�����첽�ַ���post����
	 * 
	 * @param path
	 *            ·��
	 * @param params
	 *            �ֶ�
	 * @param listenStream
	 *            �������
	 * @param handler
	 *            ����ص�
	 * @param time
	 *            �ӳ�ʱ��
	 * @param c
	 *            ���ն��� void
	 */
	void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c);

	void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c, IEncryption encryption);

}
