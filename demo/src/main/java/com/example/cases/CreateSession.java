package com.example.cases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CreateSession {

	private static CookieStore cookieStore;
	
	public static ResourceBundle bundle;
	
	public static CloseableHttpClient httpclient;
	
	public static String auth;
	
	public static String companyid;

	public  static CookieStore getSign() {

		bundle = ResourceBundle.getBundle("properties");

		String url = bundle.getString("bj01url") + "/users/sign_in";

		cookieStore = new BasicCookieStore();

		HttpGet getSign = new HttpGet(url);

		httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

		try {
			CloseableHttpResponse response = httpclient.execute(getSign);

			String result = EntityUtils.toString(response.getEntity());

			Document doc = Jsoup.parse(result);

			String authcss = "input[name=\"authenticity_token\"]";

			String companycss = "input[name=\"user[company_id]\"]";

			auth = doc.select(authcss).val();

			companyid = doc.select(companycss).val();

			HttpPost post = new HttpPost(url);

			List<BasicNameValuePair> param = new ArrayList<BasicNameValuePair>();
			param.add(new BasicNameValuePair("authenticity_token", auth));
			param.add(new BasicNameValuePair("user[company_id]", companyid));
			param.add(new BasicNameValuePair("user[password]", bundle.getString("password")));
			param.add(new BasicNameValuePair("user[email]", bundle.getString("username")));

			post.setEntity(new UrlEncodedFormEntity(param, "utf-8"));

			CloseableHttpResponse response2 = httpclient.execute(post);
			
			System.out.println(response2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cookieStore;
	}

	
	
	public void getPro() {
		
		
	}
}