package com.xh.http;

import java.util.Map;

import com.xh.encryption.IEncryption;
import com.xh.http.XhHttp.Type;
import com.xh.thread.IRunnableManager;

/**
 * @version 创建时间：2017-12-21 下午7:01:19 项目：repair 包名：com.xh.http
 *          文件名：XhHttpManagerImpl.java 作者：lhl 说明:
 */

public class XhHttpManagerImpl implements IHttpManager {
	private IRunnableManager manager;

	public XhHttpManagerImpl(IRunnableManager manager) {
		// TODO Auto-generated constructor stub
		this.manager = manager;
	}

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：数据流get请求
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
	 * @param isAsyn
	 *            是否为异步 void
	 */
	private void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time, boolean isAsyn) {
		streamM(path, params, listenStream, handler, time, isAsyn, Type.GET);
	}

	private void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time, boolean isAsyn, IEncryption encryption) {
		streamM(path, params, listenStream, handler, time, isAsyn, Type.GET,
				encryption);
	}

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：数据流post请求
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
	 * @param isAsyn
	 *            是否为异步 void
	 */
	private void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time, boolean isAsyn) {
		streamM(path, params, listenStream, handler, time, isAsyn, Type.POST);
	}

	private void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time, boolean isAsyn, IEncryption encryption) {
		streamM(path, params, listenStream, handler, time, isAsyn, Type.POST,
				encryption);
	}

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：数据流请求
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
	 * @param isAsyn
	 *            是否为异步
	 * @param type
	 *            请求类型 void
	 */
	private void streamM(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time, boolean isAsyn, Type type) {
		streamM(path, params, listenStream, handler, time, isAsyn, type, null);
	}

	private void streamM(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time, boolean isAsyn, Type type, IEncryption encryption) {
		XhHttpStream http = new XhHttpStream(handler);
		set(http, path, params, isAsyn, type, encryption);
		http.setListemStream(listenStream);
		submitHttp(http, time);
	}

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：字符串get请求
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
	 *            延迟时间
	 * @param isAsyn
	 *            是否为异步 void
	 */
	private void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenStream, XhHttpCallback handler,
			long time, boolean isAsyn) {
		stringM(path, params, listenStream, handler, time, isAsyn, Type.GET);
	}

	private void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenStream, XhHttpCallback handler,
			long time, boolean isAsyn, IEncryption encryption) {
		stringM(path, params, listenStream, handler, time, isAsyn, Type.GET,
				encryption);
	}

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：字符串post请求
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
	 *            延迟时间
	 * @param isAsyn
	 *            是否为异步 void
	 */
	private void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenStream, XhHttpCallback handler,
			long time, boolean isAsyn) {
		stringM(path, params, listenStream, handler, time, isAsyn, Type.POST);
	}

	private void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenStream, XhHttpCallback handler,
			long time, boolean isAsyn, IEncryption encryption) {
		stringM(path, params, listenStream, handler, time, isAsyn, Type.POST,
				encryption);
	}

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：字符串请求
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
	 *            延迟时间
	 * @param isAsyn
	 *            是否为异步
	 * @param type
	 *            请求类型 void
	 */
	private void stringM(String path, Map<String, Object> params,
			XhHttpLoadListenString listenStream, XhHttpCallback handler,
			long time, boolean isAsyn, Type type) {
		stringM(path, params, listenStream, handler, time, isAsyn, type, null);
	}

	private void stringM(String path, Map<String, Object> params,
			XhHttpLoadListenString listenStream, XhHttpCallback handler,
			long time, boolean isAsyn, Type type, IEncryption encryption) {
		XhHttpString http = new XhHttpString(handler);
		set(http, path, params, isAsyn, type, encryption);
		http.setListemString(listenStream);
		submitHttp(http, time);
	}

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：字符串get请求
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
	 * @param isAsyn
	 *            是否为异步
	 * @param c
	 *            接收对象 void
	 */
	private void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenStream, XhHttpCallback handler,
			long time, boolean isAsyn, Class c) {
		objectM(path, params, listenStream, handler, time, isAsyn, Type.GET, c);
	}

	private void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenStream, XhHttpCallback handler,
			long time, boolean isAsyn, Class c, IEncryption encryption) {
		objectM(path, params, listenStream, handler, time, isAsyn, Type.GET, c,
				encryption);
	}

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：字符串post请求
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
	 * @param isAsyn
	 *            是否为异步
	 * @param c
	 *            接收对象 void
	 */
	private void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenStream, XhHttpCallback handler,
			long time, boolean isAsyn, Class c) {
		objectM(path, params, listenStream, handler, time, isAsyn, Type.POST, c);
	}

	private void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenStream, XhHttpCallback handler,
			long time, boolean isAsyn, Class c, IEncryption encryption) {
		objectM(path, params, listenStream, handler, time, isAsyn, Type.POST,
				c, encryption);
	}

	/**
	 * 
	 * lhl 2017-11-16 上午10:36:15 说明：字符串请求
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
	 * @param isAsyn
	 *            是否为异步
	 * @param type
	 *            请求类型
	 * @param c
	 *            接收对象 void
	 */
	private void objectM(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, boolean isAsyn, Type type, Class c) {
		objectM(path, params, listenObject, handler, time, isAsyn, type, c,
				null);
	}

	private void objectM(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, boolean isAsyn, Type type, Class c,
			IEncryption encryption) {
		XhHttpObject http = new XhHttpObject(handler, c);
		set(http, path, params, isAsyn, type, encryption);
		http.setListenObject(listenObject);
		submitHttp(http, time);
	}

	/**
	 * 
	 * lhl 2017-11-16 上午11:04:04 说明：设置请求参数
	 * 
	 * @param http
	 * @param path
	 * @param params
	 *            void
	 */
	private void set(XhHttp http, String path, Map<String, Object> params,
			boolean isAsyn, Type type, IEncryption encryption) {
		http.setParams(params);
		http.setPath(path);
		http.setManager(manager);
		http.setAsyn(isAsyn);
		http.setType(type);
		http.setEncryption(encryption);
	}

	/**
	 * 
	 * lhl 2017-11-15 下午6:06:17 说明：提交任务
	 * 
	 * @param http
	 *            void
	 */
	void submitHttp(XhHttp http) {
		manager.submit(http);
	}

	/**
	 * 
	 * lhl 2017-11-15 下午6:07:23 说明：延迟提交任务，如果延迟时间小于等于0则马上提交
	 * 
	 * @param http
	 * @param time
	 *            延迟时间 void
	 */
	void submitHttp(XhHttp http, long time) {
		manager.submit(http, time);
	}

	@Override
	public void stream(String path) {
		// TODO Auto-generated method stub
		stream(path, null, null, new XhHttpCallback());
	}

	@Override
	public void stream(String path, IEncryption encryption) {
		// TODO Auto-generated method stub
		stream(path, null, null, new XhHttpCallback(), encryption);
	}

	@Override
	public void stream(String path, XhHttpLoadListenStream listenStream) {
		// TODO Auto-generated method stub
		stream(path, null, listenStream, new XhHttpCallback());
	}

	@Override
	public void stream(String path, XhHttpLoadListenStream listenStream,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		stream(path, null, listenStream, new XhHttpCallback(), encryption);
	}

	@Override
	public void stream(String path, Map<String, Object> params) {
		// TODO Auto-generated method stub
		stream(path, params, null, new XhHttpCallback());
	}

	@Override
	public void stream(String path, Map<String, Object> params,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		stream(path, params, null, new XhHttpCallback(), encryption);
	}

	@Override
	public void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream) {
		// TODO Auto-generated method stub
		stream(path, params, listenStream, new XhHttpCallback());
	}

	@Override
	public void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, IEncryption encryption) {
		// TODO Auto-generated method stub
		stream(path, params, listenStream, new XhHttpCallback(), encryption);
	}

	@Override
	public void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler) {
		// TODO Auto-generated method stub
		stream(path, params, listenStream, handler, 0);
	}

	@Override
	public void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		stream(path, params, listenStream, handler, 0, encryption);
	}

	@Override
	public void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time) {
		// TODO Auto-generated method stub
		stream(path, params, listenStream, handler, time, false);
	}

	@Override
	public void stream(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time, IEncryption encryption) {
		// TODO Auto-generated method stub
		stream(path, params, listenStream, handler, time, false, encryption);
	}

	@Override
	public void streamPost(String path) {
		// TODO Auto-generated method stub
		streamPost(path, null, null, new XhHttpCallback());
	}

	@Override
	public void streamPost(String path, IEncryption encryption) {
		// TODO Auto-generated method stub
		streamPost(path, null, null, new XhHttpCallback(), encryption);
	}

	@Override
	public void streamPost(String path, XhHttpLoadListenStream listenStream) {
		// TODO Auto-generated method stub
		streamPost(path, null, listenStream, new XhHttpCallback());
	}

	@Override
	public void streamPost(String path, XhHttpLoadListenStream listenStream,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		streamPost(path, null, listenStream, new XhHttpCallback(), encryption);
	}

	@Override
	public void streamPost(String path, Map<String, Object> params) {
		// TODO Auto-generated method stub
		streamPost(path, params, null, new XhHttpCallback());
	}

	@Override
	public void streamPost(String path, Map<String, Object> params,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		streamPost(path, params, null, new XhHttpCallback(), encryption);
	}

	@Override
	public void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream) {
		// TODO Auto-generated method stub
		streamPost(path, params, listenStream, new XhHttpCallback());
	}

	@Override
	public void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, IEncryption encryption) {
		// TODO Auto-generated method stub
		streamPost(path, params, listenStream, new XhHttpCallback(), encryption);
	}

	@Override
	public void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler) {
		// TODO Auto-generated method stub
		streamPost(path, params, listenStream, handler, 0);
	}

	@Override
	public void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		streamPost(path, params, listenStream, handler, 0, encryption);
	}

	@Override
	public void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time) {
		// TODO Auto-generated method stub
		streamPost(path, params, listenStream, handler, time, false);
	}

	@Override
	public void streamPost(String path, Map<String, Object> params,
			XhHttpLoadListenStream listenStream, XhHttpCallback handler,
			long time, IEncryption encryption) {
		// TODO Auto-generated method stub
		streamPost(path, params, listenStream, handler, time, false, encryption);

	}

	@Override
	public void string(String path) {
		// TODO Auto-generated method stub
		string(path, null, null, new XhHttpCallback());
	}

	@Override
	public void string(String path, IEncryption encryption) {
		// TODO Auto-generated method stub
		string(path, null, null, new XhHttpCallback(), encryption);
	}

	@Override
	public void string(String path, XhHttpLoadListenString listenString) {
		// TODO Auto-generated method stub
		string(path, null, listenString, new XhHttpCallback());
	}

	@Override
	public void string(String path, XhHttpLoadListenString listenString,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		string(path, null, listenString, new XhHttpCallback(), encryption);
	}

	@Override
	public void string(String path, Map<String, Object> params) {
		// TODO Auto-generated method stub
		string(path, params, null, new XhHttpCallback());
	}

	@Override
	public void string(String path, Map<String, Object> params,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		string(path, params, null, new XhHttpCallback(), encryption);
	}

	@Override
	public void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString) {
		// TODO Auto-generated method stub
		string(path, params, listenString, new XhHttpCallback());
	}

	@Override
	public void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, IEncryption encryption) {
		// TODO Auto-generated method stub
		string(path, params, listenString, new XhHttpCallback(), encryption);
	}

	@Override
	public void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler) {
		// TODO Auto-generated method stub
		string(path, params, listenString, handler, 0);
	}

	@Override
	public void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		string(path, params, listenString, handler, 0, encryption);
	}

	@Override
	public void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time) {
		// TODO Auto-generated method stub
		string(path, params, listenString, handler, time, false);
	}

	@Override
	public void string(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time, IEncryption encryption) {
		// TODO Auto-generated method stub
		string(path, params, listenString, handler, time, false, encryption);
	}

	@Override
	public void stringAsyn(String path) {
		// TODO Auto-generated method stub
		stringAsyn(path, null, null, new XhHttpCallback());
	}

	@Override
	public void stringAsyn(String path, IEncryption encryption) {
		// TODO Auto-generated method stub
		stringAsyn(path, null, null, new XhHttpCallback(), encryption);
	}

	@Override
	public void stringAsyn(String path, XhHttpLoadListenString listenString) {
		// TODO Auto-generated method stub
		stringAsyn(path, null, listenString, new XhHttpCallback());
	}

	@Override
	public void stringAsyn(String path, XhHttpLoadListenString listenString,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		stringAsyn(path, null, listenString, new XhHttpCallback(), encryption);
	}

	@Override
	public void stringAsyn(String path, Map<String, Object> params) {
		// TODO Auto-generated method stub
		stringAsyn(path, params, null, new XhHttpCallback());
	}

	@Override
	public void stringAsyn(String path, Map<String, Object> params,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		stringAsyn(path, params, null, new XhHttpCallback(), encryption);
	}

	@Override
	public void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString) {
		// TODO Auto-generated method stub
		stringAsyn(path, params, listenString, new XhHttpCallback());
	}

	@Override
	public void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, IEncryption encryption) {
		// TODO Auto-generated method stub
		stringAsyn(path, params, listenString, new XhHttpCallback(), encryption);
	}

	@Override
	public void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler) {
		// TODO Auto-generated method stub
		stringAsyn(path, params, listenString, handler, 0);
	}

	@Override
	public void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		stringAsyn(path, params, listenString, handler, 0, encryption);
	}

	@Override
	public void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time) {
		// TODO Auto-generated method stub
		string(path, params, listenString, handler, time, true);
	}

	@Override
	public void stringAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time, IEncryption encryption) {
		// TODO Auto-generated method stub
		string(path, params, listenString, handler, time, true, encryption);
	}

	@Override
	public void stringPost(String path) {
		// TODO Auto-generated method stub
		stringPost(path, null, null, new XhHttpCallback());
	}

	@Override
	public void stringPost(String path, IEncryption encryption) {
		// TODO Auto-generated method stub
		stringPost(path, null, null, new XhHttpCallback(), encryption);
	}

	@Override
	public void stringPost(String path, XhHttpLoadListenString listenString) {
		// TODO Auto-generated method stub
		stringPost(path, null, listenString, new XhHttpCallback());
	}

	@Override
	public void stringPost(String path, XhHttpLoadListenString listenString,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		stringPost(path, null, listenString, new XhHttpCallback(), encryption);
	}

	@Override
	public void stringPost(String path, Map<String, Object> params) {
		// TODO Auto-generated method stub
		stringPost(path, params, null, new XhHttpCallback());
	}

	@Override
	public void stringPost(String path, Map<String, Object> params,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		stringPost(path, params, null, new XhHttpCallback(), encryption);
	}

	@Override
	public void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString) {
		// TODO Auto-generated method stub
		stringPost(path, params, listenString, new XhHttpCallback());
	}

	@Override
	public void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, IEncryption encryption) {
		// TODO Auto-generated method stub
		stringPost(path, params, listenString, new XhHttpCallback(), encryption);
	}

	@Override
	public void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler) {
		// TODO Auto-generated method stub
		stringPost(path, params, listenString, handler, 0);
	}

	@Override
	public void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		stringPost(path, params, listenString, handler, 0, encryption);
	}

	@Override
	public void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time) {
		// TODO Auto-generated method stub
		stringPost(path, params, listenString, handler, time, false);
	}

	@Override
	public void stringPost(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time, IEncryption encryption) {
		// TODO Auto-generated method stub
		stringPost(path, params, listenString, handler, time, false, encryption);
	}

	@Override
	public void stringPostAsyn(String path) {
		// TODO Auto-generated method stub
		stringPostAsyn(path, null, null, new XhHttpCallback());
	}

	@Override
	public void stringPostAsyn(String path, IEncryption encryption) {
		// TODO Auto-generated method stub
		stringPostAsyn(path, null, null, new XhHttpCallback(), encryption);
	}

	@Override
	public void stringPostAsyn(String path, XhHttpLoadListenString listenString) {
		// TODO Auto-generated method stub
		stringPostAsyn(path, null, listenString, new XhHttpCallback());
	}

	@Override
	public void stringPostAsyn(String path,
			XhHttpLoadListenString listenString, IEncryption encryption) {
		// TODO Auto-generated method stub
		stringPostAsyn(path, null, listenString, new XhHttpCallback(),
				encryption);
	}

	@Override
	public void stringPostAsyn(String path, Map<String, Object> params) {
		// TODO Auto-generated method stub
		stringPostAsyn(path, params, null, new XhHttpCallback());
	}

	@Override
	public void stringPostAsyn(String path, Map<String, Object> params,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		stringPostAsyn(path, params, null, new XhHttpCallback(), encryption);
	}

	@Override
	public void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString) {
		// TODO Auto-generated method stub
		stringPostAsyn(path, params, listenString, new XhHttpCallback());
	}

	@Override
	public void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, IEncryption encryption) {
		// TODO Auto-generated method stub
		stringPostAsyn(path, params, listenString, new XhHttpCallback(),
				encryption);
	}

	@Override
	public void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler) {
		// TODO Auto-generated method stub
		stringPostAsyn(path, params, listenString, handler, 0);
	}

	@Override
	public void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		stringPostAsyn(path, params, listenString, handler, 0, encryption);
	}

	@Override
	public void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time) {
		// TODO Auto-generated method stub
		stringPost(path, params, listenString, handler, time, false);
	}

	@Override
	public void stringPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenString listenString, XhHttpCallback handler,
			long time, IEncryption encryption) {
		// TODO Auto-generated method stub
		stringPost(path, params, listenString, handler, time, true, encryption);
	}

	@Override
	public void object(String path, Class c) {
		// TODO Auto-generated method stub
		object(path, null, null, new XhHttpCallback(), c);
	}

	@Override
	public void object(String path, Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		object(path, null, null, new XhHttpCallback(), c, encryption);
	}

	@Override
	public void object(String path, XhHttpLoadListenObject listenObject, Class c) {
		// TODO Auto-generated method stub
		object(path, null, listenObject, new XhHttpCallback(), c);
	}

	@Override
	public void object(String path, XhHttpLoadListenObject listenObject,
			Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		object(path, null, listenObject, new XhHttpCallback(), c, encryption);
	}

	@Override
	public void object(String path, Map<String, Object> params, Class c) {
		// TODO Auto-generated method stub
		object(path, params, null, new XhHttpCallback(), c);
	}

	@Override
	public void object(String path, Map<String, Object> params, Class c,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		object(path, params, null, new XhHttpCallback(), c, encryption);
	}

	@Override
	public void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c) {
		// TODO Auto-generated method stub
		object(path, params, listenObject, new XhHttpCallback(), c);
	}

	@Override
	public void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		object(path, params, listenObject, new XhHttpCallback(), c, encryption);
	}

	@Override
	public void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler, Class c) {
		// TODO Auto-generated method stub
		object(path, params, listenObject, handler, 0, c);
	}

	@Override
	public void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		object(path, params, listenObject, handler, 0, c, encryption);
	}

	@Override
	public void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c) {
		// TODO Auto-generated method stub
		object(path, params, listenObject, handler, time, false, c);
	}

	@Override
	public void object(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		object(path, params, listenObject, handler, time, false, c, encryption);
	}

	@Override
	public void objectAsyn(String path, Class c) {
		// TODO Auto-generated method stub
		objectAsyn(path, null, null, new XhHttpCallback(), c);
	}

	@Override
	public void objectAsyn(String path, Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		objectAsyn(path, null, null, new XhHttpCallback(), c, encryption);
	}

	@Override
	public void objectAsyn(String path, XhHttpLoadListenObject listenObject,
			Class c) {
		// TODO Auto-generated method stub
		objectAsyn(path, null, listenObject, new XhHttpCallback(), c);
	}

	@Override
	public void objectAsyn(String path, XhHttpLoadListenObject listenObject,
			Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		objectAsyn(path, null, listenObject, new XhHttpCallback(), c,
				encryption);
	}

	@Override
	public void objectAsyn(String path, Map<String, Object> params, Class c) {
		// TODO Auto-generated method stub
		objectAsyn(path, params, null, new XhHttpCallback(), c);
	}

	@Override
	public void objectAsyn(String path, Map<String, Object> params, Class c,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		objectAsyn(path, params, null, new XhHttpCallback(), c, encryption);
	}

	@Override
	public void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c) {
		// TODO Auto-generated method stub
		objectAsyn(path, params, listenObject, new XhHttpCallback(), c);
	}

	@Override
	public void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		objectAsyn(path, params, listenObject, new XhHttpCallback(), c,
				encryption);
	}

	@Override
	public void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler, Class c) {
		// TODO Auto-generated method stub
		objectAsyn(path, params, listenObject, handler, 0, c);
	}

	@Override
	public void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		objectAsyn(path, params, listenObject, handler, 0, c, encryption);
	}

	@Override
	public void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c) {
		// TODO Auto-generated method stub
		object(path, params, listenObject, handler, time, true, c);
	}

	@Override
	public void objectAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		object(path, params, listenObject, handler, time, true, c, encryption);
	}

	@Override
	public void objectPost(String path, Class c) {
		// TODO Auto-generated method stub
		objectPost(path, null, null, new XhHttpCallback(), c);
	}

	@Override
	public void objectPost(String path, Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		objectPost(path, null, null, new XhHttpCallback(), c);
	}

	@Override
	public void objectPost(String path, XhHttpLoadListenObject listenObject,
			Class c) {
		// TODO Auto-generated method stub
		objectPost(path, null, listenObject, new XhHttpCallback(), c);
	}

	@Override
	public void objectPost(String path, XhHttpLoadListenObject listenObject,
			Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		objectPost(path, null, listenObject, new XhHttpCallback(), c,
				encryption);
	}

	@Override
	public void objectPost(String path, Map<String, Object> params, Class c) {
		// TODO Auto-generated method stub
		objectPost(path, params, null, new XhHttpCallback(), c);
	}

	@Override
	public void objectPost(String path, Map<String, Object> params, Class c,
			IEncryption encryption) {
		// TODO Auto-generated method stub
		objectPost(path, params, null, new XhHttpCallback(), c, encryption);
	}

	@Override
	public void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c) {
		// TODO Auto-generated method stub
		objectPost(path, params, listenObject, new XhHttpCallback(), c);
	}

	@Override
	public void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		objectPost(path, params, listenObject, new XhHttpCallback(), c,
				encryption);
	}

	@Override
	public void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler, Class c) {
		// TODO Auto-generated method stub
		objectPost(path, params, listenObject, handler, 0, c);
	}

	@Override
	public void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		objectPost(path, params, listenObject, handler, 0, c, encryption);
	}

	@Override
	public void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c) {
		// TODO Auto-generated method stub
		objectPost(path, params, listenObject, handler, time, false, c);
	}

	@Override
	public void objectPost(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		objectPost(path, params, listenObject, handler, time, false, c,
				encryption);
	}

	@Override
	public void objectPostAsyn(String path, Class c) {
		// TODO Auto-generated method stub
		objectPostAsyn(path, null, null, new XhHttpCallback(), c);
	}

	@Override
	public void objectPostAsyn(String path, Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		objectPostAsyn(path, null, null, new XhHttpCallback(), c);
	}

	@Override
	public void objectPostAsyn(String path,
			XhHttpLoadListenObject listenObject, Class c) {
		// TODO Auto-generated method stub
		objectPostAsyn(path, null, listenObject, new XhHttpCallback(), c);
	}

	@Override
	public void objectPostAsyn(String path,
			XhHttpLoadListenObject listenObject, Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		objectPostAsyn(path, null, listenObject, c, encryption);
	}

	@Override
	public void objectPostAsyn(String path, Map<String, Object> params, Class c) {
		// TODO Auto-generated method stub
		objectPostAsyn(path, null, null, c);
	}

	@Override
	public void objectPostAsyn(String path, Map<String, Object> params,
			Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		objectPostAsyn(path, params, null, c, encryption);
	}

	@Override
	public void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c) {
		// TODO Auto-generated method stub
		objectPostAsyn(path, params, listenObject, new XhHttpCallback(), c);
	}

	@Override
	public void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		objectPostAsyn(path, params, listenObject, new XhHttpCallback(), c,
				encryption);
	}

	@Override
	public void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler, Class c) {
		// TODO Auto-generated method stub
		objectPostAsyn(path, params, listenObject, handler, 0, c);
	}

	@Override
	public void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		objectPostAsyn(path, params, listenObject, handler, 0, c, encryption);
	}

	@Override
	public void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c) {
		// TODO Auto-generated method stub
		objectPost(path, params, listenObject, handler, time, true, c);
	}

	@Override
	public void objectPostAsyn(String path, Map<String, Object> params,
			XhHttpLoadListenObject listenObject, XhHttpCallback handler,
			long time, Class c, IEncryption encryption) {
		// TODO Auto-generated method stub
		objectPost(path, params, listenObject, handler, time, true, c,
				encryption);
	}
}
