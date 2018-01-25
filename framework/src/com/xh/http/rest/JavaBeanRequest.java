package com.xh.http.rest;

import com.xh.http.Headers;
import com.xh.http.RequestMethod;
import com.xh.json.Json;
import com.xh.util.Json2Object;

public class JavaBeanRequest<T> extends RestRequest<T> {

	// Ҫ������JavaBean��class��
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
		// ����������ݸ�ʽ���󣬻��߽���ʧ�ܣ�����ʧ�ܵĻص������з��� ParseError �쳣��
		return json.fromJson(response, clazz);
	}
}