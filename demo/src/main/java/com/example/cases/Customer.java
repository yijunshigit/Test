package com.example.cases;

import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.example.util.RequestMethod;

public class Customer {
	
	public CreateSession creat;
	public int id;
	public CookieStore cookiestore;
	
	@BeforeTest
	public void getsession() {
		cookiestore=creat.getSign();
	}
	
	@Test
	public void creatCustomer() throws ClientProtocolException, IOException {		
		ResourceBundle bundle = ResourceBundle.getBundle("properties");
		String uri = bundle.getString("bj01url");
		String url=uri+"/spa1/customers";
		String params="{\"customer\":{\"lang\":\"\",\"nick_name\":\"001\",\"cellphones\":[{\"content\":\"\"}],\"cellphones_attributes\":[],\"default_organization_id\":null,\"owner_id\":\"\",\"custom_fields\":{},\"owner_group_id\":\"\",\"from\":{},\"merging\":false,\"customerListSelected\":false,\"organizations\":[]},\"custom_fields\":{}}";
		String result=RequestMethod.postWithJson(url, params, cookiestore);
		JSONObject json=JSONObject.parseObject(result);
		id= (int) json.getJSONObject("customer").get("id");
		System.out.println(result);
		Assert.assertNotNull(id);
		}
	@Test
	public void customerInfo() {
		ResourceBundle bundle = ResourceBundle.getBundle("properties");
		String uri = bundle.getString("bj01url");
		String url=uri+"/spa1/customers/"+id;
		String result=RequestMethod.getWithCookie(url,cookiestore);
		JSONObject json=JSONObject.parseObject(result);
		Assert.assertNotNull(json.getJSONObject("customer").get("id"));		
	}
//	@Test
//	public void deleteCustomer() {
//		ResourceBundle bundle = ResourceBundle.getBundle("properties");
//		String uri = bundle.getString("bj01url");
//		
//		
//	}
	
	
	
	

}
