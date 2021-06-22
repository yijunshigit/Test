package com.example.cases;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class TestCookie {
	
	public static void main(String args[]) throws ClientProtocolException, IOException {
		
//		String url="http://demo.cat.tryudesk.com/users/sign_in";
//		
//		HttpGet getSign = new HttpGet(url);
//		
//		CookieStore cookieStore=new BasicCookieStore();		
//		
//		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
//
//
//			CloseableHttpResponse response = httpclient.execute(getSign);
//
//			String result = EntityUtils.toString(response.getEntity());
//			
//			System.out.println(result);
		
		CreateSession creat=new CreateSession();
		CookieStore cookies=creat.getSign();

}
}