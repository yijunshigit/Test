package test.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import test.selenium.base.DriverBase;

public class LoginPage extends BasePage{

	public LoginPage(DriverBase driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement getUsername(){
		return findElement("name","user[email]");
		
	}
	
	public WebElement getPassword(){
		return findElement("name","user[password]");
		
	}
	
	public WebElement getButon(){
		return findElement("classname","btn-s-md");
		
	}
	
}
