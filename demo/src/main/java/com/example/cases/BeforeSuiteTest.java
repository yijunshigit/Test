package com.example.cases;

import org.apache.http.client.CookieStore;
import org.testng.annotations.BeforeSuite;

public class BeforeSuiteTest {

	@BeforeSuite
	public void login() {		
		CookieStore cookies=CreateSession.getSign();
	}
}
