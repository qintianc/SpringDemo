package com.mudi.util;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static final int SMALL_TIME = 3000;
	public static final int BIG_TIME = 8000;

	/**
	 * get请求
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		HttpGet httpget = new HttpGet(url);
		// 配置请求的超时设置
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(SMALL_TIME).setConnectTimeout(SMALL_TIME).setSocketTimeout(SMALL_TIME).build();
		httpget.setConfig(requestConfig);
		CloseableHttpResponse response = httpclient.execute(httpget);
		try {
			if (200 == response.getStatusLine().getStatusCode()) {
				HttpEntity entity = response.getEntity();
				String string = EntityUtils.toString(entity, "utf-8");
				return string;
			}
		} finally {
			response.close();
		}
		return null;
	}

	/**
	 * GET请求得到JSON字符串
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String getJson(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		HttpGet httpget = new HttpGet(url);
		httpget.setHeader("accept", "json");

		// 配置请求的超时设置
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(SMALL_TIME).setConnectTimeout(SMALL_TIME).setSocketTimeout(SMALL_TIME).build();
		httpget.setConfig(requestConfig);
		CloseableHttpResponse response = httpclient.execute(httpget);
		try {
			if (200 == response.getStatusLine().getStatusCode()) {
				HttpEntity entity = response.getEntity();
				String string = EntityUtils.toString(entity, "utf-8");
				return string;
			}
		} finally {
			response.close();
		}

		return null;
	}

	/**
	 * post请求
	 * @param url
	 * @param params
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String postJson(String url, List<NameValuePair> params) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(SMALL_TIME).setConnectTimeout(SMALL_TIME).setSocketTimeout(SMALL_TIME).build();
		HttpPost httppost = new HttpPost(url);
		httppost.setConfig(requestConfig);
		httppost.setEntity(new UrlEncodedFormEntity(params));
		CloseableHttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();
		String jsonStr = EntityUtils.toString(entity, "utf-8");
		httppost.releaseConnection();
		return jsonStr;
	}
}
