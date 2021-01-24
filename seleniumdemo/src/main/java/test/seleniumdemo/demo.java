package test.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class demo {
	public WebDriver driver;
	
	public  void init(){
			System.setProperty("webdriver.chrome.driver", "E:\\soft\\eclipse\\driver\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize();
	}
	@BeforeMethod
	public void open() throws Exception{		
		//String 
		String user_email ="user_eamil";
		
		driver.get("https://udesk-rd-bj-01.udesk.cn/");
		driver.findElement(By.id("user_email")).sendKeys("bai@udesk.cn");
		driver.findElement(By.cssSelector("selector"));
        driver.findElement(By.id("user_password")).sendKeys("udesk123");
        driver.findElement(byStr("id","user_email"));
        findElement(byStr("id",user_email)).click();;
        
        WebElement rember=driver.findElement(By.id("user_remember_me"));
        if(rember.isSelected()==true){
        	driver.findElement(By.name("commit"));
        }else{
        	rember.click();
        	driver.findElement(By.name("commit")).click();
        	Thread.sleep(5000);

        }
        driver.get("https://udesk-rd-bj-01.udesk.cn/entry/call/editable/current");
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[2]/div[1]/ul[1]/li[2]")).click();
      
	}
	
	@Test
	public void radio(){
		
	}
	public  By byStr(String by,String locator){
		if(by.equals("id")){
			return 	By.id(locator);
		}else if(by.equals("classname")){
			return By.className(locator);
		}else if(by.equals("xpath")){
			return By.xpath(locator);
		}else if(by.equals("classname")){
			return By.cssSelector(locator);
		}else{
			return By.name(locator);
		}
	}
	
	public WebElement findElement(By by){
		WebElement ele= driver.findElement(by);
		return ele;
	}
}
