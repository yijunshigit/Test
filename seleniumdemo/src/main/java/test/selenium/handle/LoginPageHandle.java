package test.selenium.handle;

import test.selenium.base.DriverBase;
import test.selenium.page.LoginPage;

public class LoginPageHandle {

	public DriverBase driver;
	public LoginPage lp;
	
	public LoginPageHandle(DriverBase driver){
		this.driver=driver;
		lp=new LoginPage(driver);
	}
	
	public void sendLogin(String username,String password){
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
	}
	
	public void clickLoginButton(){
		lp.getButon().click();
	}

}
