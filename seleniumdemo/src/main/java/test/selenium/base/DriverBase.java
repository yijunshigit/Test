package test.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverBase {

	public WebDriver driver;
	
	public DriverBase(String browser){
		SelectDriver selectDriver=new SelectDriver();
		this.driver=selectDriver.driverName(browser);
	}
	/**
	 * 封装Element方法
	 * */
	public WebElement findElement(By by){
		return driver.findElement(by);
	}
}
