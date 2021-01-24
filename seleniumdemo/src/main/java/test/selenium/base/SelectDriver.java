package test.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SelectDriver {

	public WebDriver driverName(String browser){
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\soft\\eclipse\\driver\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://udesk-rd-bj-01.udesk.cn");
			return driver;
		}else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("","");
			return new InternetExplorerDriver();
		}else{
			System.setProperty("","");
			return new FirefoxDriver();		
		}
	}
}
