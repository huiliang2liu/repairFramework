package com.xh.http.rest;

import com.xh.http.Headers;
import com.xh.http.RequestMethod;
import com.xh.json.Json;
import com.xh.util.Json2Object;

public class JavaBeanRequest<T> extends RestRequest<T> {

	// 要解析的JavaBean的class。
	private Class<T> clazz;

	public JavaBeanRequest(String url, Class<T> clazz) {
		this(url, RequestMethod.GET, clazz);
	}

	public JavaBeanRequest(String url, RequestMethod requestMethod,
			Class<T> clazz) {
		super(url, requestMethod);
		this.clazz = clazz;
	}

	@Override
	public T parseResponse(Headers responseHeaders, byte[] responseBody) {
		String response = StringRequest.parseResponseString(responseHeaders,
				responseBody);
		Json json = new Json();
		// 这里如果数据格式错误，或者解析失败，会在失败的回调方法中返回 ParseError 异常。
		return json.fromJson(response, clazz);
	}
}