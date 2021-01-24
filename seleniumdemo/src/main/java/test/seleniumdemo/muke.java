package test.seleniumdemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class muke {
	
	public WebDriver driver;
	
	public void init(){
		System.setProperty("webdriver.chrome.driver", "E:\\soft\\eclipse\\driver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get("https://www.imooc.com/");
	}
	
	public void login(){
		driver.findElement(By.id("js-signin-btn")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("email")).sendKeys("15210925799");
		driver.findElement(By.name("password")).sendKeys("woaidamk1");
		driver.findElement(By.className("moco-btn-red")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void edituser(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get("https://www.imooc.com/user/setprofile");
		driver.findElement(By.className("pull-right")).click();	
		//driver.findElement(By.xpath("//*[@id='profile']/div[4]/div/label[1]/input"));
		List<WebElement> elements=driver.findElements(By.xpath("//*[@id='profile']/div[4]/div/label//input"));
//		System.out.println();
		
		for(WebElement radio:elements){
			if(radio.isSelected()==false){
				radio.click();
				break;
			}else{
				System.out.println(radio.getAttribute("value")+radio.isSelected());
			}
			
		}
		
	}
	
	public void upload(){
		driver.get("https://www.imooc.com/user/setprofile");
		String jsscript="document.getElementsByClassName('update-avator')[0].style.bottom='0'";
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(jsscript);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		driver.findElement(By.className("js-avator-link")).click();		
	}
	
	public void downlist(){
		
		driver.get("https://www.imooc.com/user/setprofile");
		driver.findElement(By.className("pull-right")).click();
		driver.findElement(By.id("job")).click();
		
	}

	
	public void quit(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 
		 * 
		 * */
		muke mk=new muke();
		mk.init();
		mk.login();
//		mk.edituser();
//		mk.upload();
		mk.downlist();
		mk.quit();
		

	}

}
