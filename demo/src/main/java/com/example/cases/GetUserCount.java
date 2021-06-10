package com.example.cases;

import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.example.util.DatabaseUtil;
import com.example.util.RequestMethod;

public class GetUserCount {
	
	//@Test
//	public void getUserCount() throws IOException {
//		
//		SqlSession sqlSession=DatabaseUtil.getSqlSession();
//		int i=sqlSession.selectOne("getUserCount");
//		System.out.println("************"+i+"*************");
//	}
//	
	public CookieStore cookiestore;

	@BeforeTest
	public void login() {		
		CreateSession creat=new CreateSession();
		cookiestore=creat.getSign();

	}
	
	
	
	@Test
	public void getNoteTemple() throws ClientProtocolException, IOException {

		ResourceBundle bundle = ResourceBundle.getBundle("properties");

		String uri = bundle.getString("bj01url");

		String url = uri + "/spa1/agent_note_templates?category=call";
		System.out.println(url);
		String result = RequestMethod.getWithCookie(url, cookiestore);
		
     	SqlSession sqlSession=DatabaseUtil.getSqlSession();
		String expected=sqlSession.selectOne("getNotetemp");
		
		Assert.assertEquals(result, expected);
		
		//System.out.println(result);

	}
	
	@Test
	public void getCalloutTask() {
		
		ResourceBundle bundle = ResourceBundle.getBundle("properties");

		String uri = bundle.getString("bj01url");

		String url = uri + "/spa1/callcenter_callout_tasks?only_own=true&page=1";
		System.out.println(url);
		String result = RequestMethod.getWithCookie(url, cookiestore);
		
		System.out.println(result);
		
		//Assert.assertEquals(result, "aaaa");

	}
	
	
	public static void main(String args[]) {
		

	}
	
	
}
