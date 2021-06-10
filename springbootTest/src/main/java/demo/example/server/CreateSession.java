package demo.example.server;

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

	private CookieStore cookieStore;
	
	public ResourceBundle bundle;
	
	public CloseableHttpClient httpclient;
	
	public String auth;
	
	public String companyid;

	public CookieStore getSign() {

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

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cookieStore;
	}

	public String getWithCookie(String url, CookieStore cookieStore) {

		HttpGet get = new HttpGet(url);

		String result = null;

		CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

		try {
			
			get.addHeader("Accept","*/*");
			
			CloseableHttpResponse response = client.execute(get);			
			
			result = EntityUtils.toString(response.getEntity());

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public String postWithCookieForm(String url, CookieStore cookieStore, Map<String, String> param) {

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
	
	public void getPro() {
		
		
	}
}