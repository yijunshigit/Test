package test.seleniumdemo;

import org.testng.annotations.Test;

import test.selenium.base.DriverBase;
import test.selenium.handle.LoginPageHandle;

public class LoginTest {
	
	public  DriverBase driver;
	public LoginPageHandle lph;
	public LoginTest(){
		this.driver= new DriverBase("chrome");
		lph=new LoginPageHandle(driver);
	}


	@Test
	public void login(){
	lph.sendLogin("bai@udesk.cn", "udesk123");
	lph.clickLoginButton();
	}
	
	public static void main(String args[]){
		LoginTest lt=new LoginTest();
		lt.login();
	}
}
