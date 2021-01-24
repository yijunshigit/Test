package test.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import test.selenium.base.DriverBase;
import test.selenium.page.BasePage;

public class test {

	public DriverBase driver;
	public BasePage bp;
	
	@Test
	public void startup(){
		driver=new DriverBase("chrome");
		bp=new BasePage(driver);
		bp.findElement("id", "user_email").sendKeys("bai@udesk.cn");
		bp.findElement("id","user_password").sendKeys("udesk123");
		bp.findElement("name", "commit").click();
		
	}
}
