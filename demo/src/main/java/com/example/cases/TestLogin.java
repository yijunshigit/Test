package com.example.cases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.http.client.ClientProtocolException;
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
import org.testng.annotations.Test;

public class TestLogin {
	
	@Test
	public static  void main(String args[]) throws ClientProtocolException, IOException{
		String url = "http://demo.cat.tryudesk.com/users/sign_in";	

		CookieStore cookieStore = new BasicCookieStore();

		HttpGet getSign = new HttpGet(url);

		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

		try {
			CloseableHttpResponse response = httpclient.execute(getSign);

			String result = EntityUtils.toString(response.getEntity());

			Document doc = Jsoup.parse(result);

			String authcss = "input[name=\"authenticity_token\"]";

			String companycss = "input[name=\"user[company_id]\"]";

			String auth = doc.select(authcss).val();

			String companyid = doc.select(companycss).val();

			HttpPost post = new HttpPost(url);

			List<BasicNameValuePair> param = new ArrayList<BasicNameValuePair>();
			param.add(new BasicNameValuePair("authenticity_token", auth));
			param.add(new BasicNameValuePair("user[company_id]", companyid));
			param.add(new BasicNameValuePair("user[password]", "udesk123"));
			param.add(new BasicNameValuePair("user[email]", "bai@udesk.cn"));

			post.setEntity(new UrlEncodedFormEntity(param, "utf-8"));

			CloseableHttpResponse response2 = httpclient.execute(post);
			
			//System.out.println(response2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		String getnoteurl="http://demo.cat.tryudesk.com/spa1/agent_note_templates?category=call";
		
		HttpGet getnote=new HttpGet(getnoteurl);
		
		CloseableHttpClient httpclient2=HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		
		CloseableHttpResponse response3=httpclient2.execute(getnote);		
		
		String noteresult=EntityUtils.toString(response3.getEntity());
		

		System.out.println(noteresult);
		
		
	}
}