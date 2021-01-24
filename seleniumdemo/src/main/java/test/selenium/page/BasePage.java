package test.selenium.page;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import test.selenium.base.DriverBase;

public class BasePage {

	public DriverBase driver;
	public ResourceBundle bundle;
	
	public BasePage(DriverBase driver){
		this.driver=driver;
	}
	
	/**
	 * 
	 * 定位Element方法
	 * */
	public WebElement findElement(String by,String local){
		WebElement element=driver.findElement(byStr(by,local));
		return element;
	}
	
	/**
	 * 封装by
	 * */
	public By byStr(String by,String local){
		if(by.equals("id")){
		return By.id(local);			
		}else if(by.equals("name")){
			return By.name(local);
		}else if(by.equals("classname")){
			return By.className(local);
		}else{
			return By.xpath(local);
		}
	}
	/**
	 * 封装点击方法
	 * */
	public void click(WebElement element){
		if(element != null){
			element.click();			
		}else{
			System.out.println("元素Element:"+element+"没有找到，点击失败");
		}
	}
	
	/**
	 * 封装输入方法
	 * */
	public void sendKeys(WebElement element,String value){
		if(element != null){
			element.sendKeys(value);;			
		}else{
			System.out.println("元素Element:"+element+"没有找到，输入value:"+value+"失败");
		}
	}


}
