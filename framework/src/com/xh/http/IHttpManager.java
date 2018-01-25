package com.xh.http;

import java.util.Map;

import com.xh.encryption.IEncryption;

/**
 * @version 创建时间：2017-11-15 下午4:51:39 项目：XhlackAD-eclipse 包名：com.Xhlack.tv.http
 *          文件名：XhHttpManager.java 作者：lhl 说明: 网络请求管理类
 */

public interface IHttpManager {
	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步数据流get请求
	 * 
	 * @param path
	 *            路径 void
	 */
	void stream(String path);

	void stream(String path, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步数据流get请求
	 * 
	 * @param path
	 *            路径
	 * @param listenStream
	 *            数据流监听 void
	 */
	void stream(String path, XhHttpLoadListenStream listenStream);

	void stream(String path, XhHttpLoadListenStream listenStream,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步数据流get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段 void
	 */
	void stream(String path, Map<String, Object> params);

	void stream(String path, Map<String, Object> params, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步数据流get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            数据流监听 void
	 */
	void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream);

	void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步数据流get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            数据流监听
	 * @param handler
	 *            处理回调 void
	 */
	void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler);

	void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步数据流get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            数据流监听
	 * @param handler
	 *            处理回调
	 * @param time
	 *            延迟时间 void
	 */
	void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time);

	void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time, IEncryption encryption);


	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步数据流post请求
	 * 
	 * @param path
	 *            路径 void
	 */
	void streamPost(String path);

	void streamPost(String path, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步数据流post请求
	 * 
	 * @param path
	 *            路径
	 * @param listenStream
	 *            数据流监听 void
	 */
	void streamPost(String path, XhHttpLoadListenStream listenStream);

	void streamPost(String path, XhHttpLoadListenStream listenStream,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步数据流post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段 void
	 */
	void streamPost(String path, Map<String, Object> params);

	void streamPost(String path, Map<String, Object> params,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步数据流post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            数据流监听 void
	 */
	void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream);

	void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步数据流post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            数据流监听
	 * @param handler
	 *            处理回调 void
	 */
	void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler);

	void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步数据流post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            数据流监听
	 * @param handler
	 *            处理回调
	 * @param time
	 *            延迟时间 void
	 */
	void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time);

	void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串get请求
	 * 
	 * @param path
	 *            路径 void
	 */
	void string(String path);

	void string(String path, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param listenStream
	 *            字符串监听 void
	 */
	void string(String path, XhHttpLoadListenString listenString);

	void string(String path, XhHttpLoadListenString listenString,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段 void
	 */
	void string(String path, Map<String, Object> params);

	void string(String path, Map<String, Object> params, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            字符串监听 void
	 */
	void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString);

	void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            字符串监听
	 * @param handler
	 *            处理回调 void
	 */
	void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler);

	void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            字符串监听
	 * @param handler
	 *            处理回调
	 * @param time
	 *            延迟时间 void
	 */
	void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time);

	void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串get请求
	 * 
	 * @param path
	 *            路径 void
	 */
	void stringAsyn(String path);

	void stringAsyn(String path, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param listenStream
	 *            字符串监听 void
	 */
	void stringAsyn(String path, XhHttpLoadListenString listenString);

	void stringAsyn(String path, XhHttpLoadListenString listenString,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段 void
	 */
	void stringAsyn(String path, Map<String, Object> params);

	void stringAsyn(String path, Map<String, Object> params,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            字符串监听 void
	 */
	void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString);

	void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            字符串监听
	 * @param handler
	 *            处理回调 void
	 */
	void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler);

	void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            字符串监听
	 * @param handler
	 *            处理回调
	 * @param time
	 *            延迟时间 void
	 */
	void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time);

	void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串post请求
	 * 
	 * @param path
	 *            路径 void
	 */
	void stringPost(String path);

	void stringPost(String path, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param listenStream
	 *            字符串监听 void
	 */
	void stringPost(String path, XhHttpLoadListenString listenString);

	void stringPost(String path, XhHttpLoadListenString listenString,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段 void
	 */
	void stringPost(String path, Map<String, Object> params);

	void stringPost(String path, Map<String, Object> params,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            字符串监听 void
	 */
	void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString);

	void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            字符串监听
	 * @param handler
	 *            处理回调 void
	 */
	void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler);

	void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            字符串监听
	 * @param handler
	 *            处理回调
	 * @param time
	 *            延迟时间 void
	 */
	void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time);

	void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串post请求
	 * 
	 * @param path
	 *            路径 void
	 */
	void stringPostAsyn(String path);

	void stringPostAsyn(String path, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param listenStream
	 *            字符串监听 void
	 */
	void stringPostAsyn(String path, XhHttpLoadListenString listenString);

	void stringPostAsyn(String path, XhHttpLoadListenString listenString,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段 void
	 */
	void stringPostAsyn(String path, Map<String, Object> params);

	void stringPostAsyn(String path, Map<String, Object> params,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            字符串监听 void
	 */
	void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString);

	void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            字符串监听
	 * @param handler
	 *            处理回调 void
	 */
	void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler);

	void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            字符串监听
	 * @param handler
	 *            处理回调
	 * @param time
	 *            延迟时间 void
	 */
	void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time);

	void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param c
	 *            接收对象 void
	 */
	void object(String path, Class c);

	void object(String path, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param listenStream
	 *            对象监听
	 * @param c
	 *            接收对象 void
	 */
	void object(String path, XhHttpLoadListenObject listenObject, Class c);

	void object(String path, XhHttpLoadListenObject listenObject, Class c,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param c
	 *            接收对象 void
	 */
	void object(String path, Map<String, Object> params, Class c);

	void object(String path, Map<String, Object> params, Class c,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            对象监听
	 * @param c
	 *            接收对象 void
	 */
	void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c);

	void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            对象监听
	 * @param handler
	 *            处理回调
	 * @param c
	 *            接收对象 void
	 */
	void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler, Class c);

	void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            数据流监听
	 * @param handler
	 *            处理回调
	 * @param time
	 *            延迟时间
	 * @param c
	 *            接收对象 void
	 */
	void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c);

	void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param c
	 *            接收对象 void
	 */
	void objectAsyn(String path, Class c);

	void objectAsyn(String path, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param listenStream
	 *            对象监听
	 * @param c
	 *            接收对象 void
	 */
	void objectAsyn(String path, XhHttpLoadListenObject listenObject, Class c);

	void objectAsyn(String path, XhHttpLoadListenObject listenObject, Class c,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param c
	 *            接收对象 void
	 */
	void objectAsyn(String path, Map<String, Object> params, Class c);

	void objectAsyn(String path, Map<String, Object> params, Class c,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            对象监听
	 * @param c
	 *            接收对象 void
	 */
	void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c);

	void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            对象监听
	 * @param handler
	 *            处理回调
	 * @param c
	 *            接收对象 void
	 */
	void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler, Class c);

	void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串get请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            对象监听
	 * @param handler
	 *            处理回调
	 * @param time
	 *            延迟时间
	 * @param c
	 *            接收对象 void
	 */
	void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c);

	void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param c
	 *            接收对象 void
	 */
	void objectPost(String path, Class c);

	void objectPost(String path, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param listenStream
	 *            对象监听
	 * @param c
	 *            接收对象 void
	 */
	void objectPost(String path, XhHttpLoadListenObject listenObject, Class c);

	void objectPost(String path, XhHttpLoadListenObject listenObject, Class c,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param c
	 *            接收对象 void
	 */
	void objectPost(String path, Map<String, Object> params, Class c);

	void objectPost(String path, Map<String, Object> params, Class c,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            对象监听
	 * @param c
	 *            接收对象 void
	 */
	void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c);

	void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            对象监听
	 * @param handler
	 *            处理回调
	 * @param c
	 *            接收对象 void
	 */
	void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler, Class c);

	void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：同步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            对象监听
	 * @param handler
	 *            处理回调
	 * @param time
	 *            延迟时间
	 * @param c
	 *            接收对象 void
	 */
	void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c);

	void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param c
	 *            接收对象 void
	 */
	void objectPostAsyn(String path, Class c);

	void objectPostAsyn(String path, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param listenStream
	 *            对象监听
	 * @param c
	 *            接收对象 void
	 */
	void objectPostAsyn(String path, XhHttpLoadListenObject listenObject,
			Class c);

	void objectPostAsyn(String path, XhHttpLoadListenObject listenObject,
			Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param c
	 *            接收对象 void
	 */
	void objectPostAsyn(String path, Map<String, Object> params, Class c);

	void objectPostAsyn(String path, Map<String, Object> params, Class c,
			IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            对象监听
	 * @param c
	 *            接收对象 void
	 */
	void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c);

	void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            对象监听
	 * @param handler
	 *            处理回调
	 * @param c
	 *            接收对象 void
	 */
	void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler, Class c);

	void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			Class c, IEncryption encryption);

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：异步字符串post请求
	 * 
	 * @param path
	 *            路径
	 * @param params
	 *            字段
	 * @param listenStream
	 *            对象监听
	 * @param handler
	 *            处理回调
	 * @param time
	 *            延迟时间
	 * @param c
	 *            接收对象 void
	 */
	void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c);

	void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c, IEncryption encryption);

}
