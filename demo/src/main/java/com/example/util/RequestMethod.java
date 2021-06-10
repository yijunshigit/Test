package com.example.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;





public class RequestMethod {
	
	public static String getWithCookie(String url, CookieStore cookieStore) {

		HttpGet get = new HttpGet(url);

		String result = null;

		CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

		try {
			
			get.addHeader("Accept","*/*");
			
			CloseableHttpResponse response = client.execute(get);			
			
			result = EntityUtils.toString(response.getEntity());
			
			System.out.println(result);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public static String postWithCookieForm(String url, CookieStore cookieStore, Map<String, String> param) {

		HttpPost post = new HttpPost(url);
		String result = null;
		CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		List<BasicNameValuePair> paramlist = new ArrayList<BasicNameValuePair>();
		try {
			for (String key : param.keySet()) {
				paramlist.add(new BasicNameValuePair(key, param.get(key)));
			}
			post.setEntity(new UrlEncodedFormEntity(paramlist, "utf-8"));
			CloseableHttpResponse response = client.execute(post);
			result = EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public  static String postWithJson(String url,String params,CookieStore cookieStore) throws ClientProtocolException, IOException {
		
		JSONObject jsonstr=JSONObject.parseObject(params);
		HttpPost post=new HttpPost(url);
		CloseableHttpClient client=HttpClients.custom().setDefaultCookieStore(cookieStore).build();		
		HttpEntity entity=new StringEntity(jsonstr.toString(),"utf-8");
		post.setHeader("Content-Type","application/json");
		post.setEntity(entity);
		CloseableHttpResponse response=client.execute(post);
		String result=EntityUtils.toString(response.getEntity());		
		return result;
	}
	
}
