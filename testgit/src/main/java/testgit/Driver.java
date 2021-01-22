package testgit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Driver {
	
	//public WebDriver driver;
	@Test
	public void start() {
		System.setProperty("webdriver.chrome.driver", "D:\\program\\eclipse\\eclipse\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		String url="https://baidu.com";
		driver.get(url);
	}

}
