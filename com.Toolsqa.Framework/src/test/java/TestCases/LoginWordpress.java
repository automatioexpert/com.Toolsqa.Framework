package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Pages.LoginPage;

public class LoginWordpress 
{

	
	WebDriver driver;
	
	@Test
	public void validLogin()
	{
		
		driver=BrowserFactory.getBrowser("firefox");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(DataProviderFactory.getConfig().getUrl());
		
	    LoginPage home=PageFactory.initElements(driver, LoginPage.class);
	    
	    String home_page_title=driver.getTitle();
	    
	    Assert.assertTrue(home_page_title.contains("Log In"));
	    
	    home.typeUserName();
	    
	    Reporter.log("Tying username", true);
	    
	    home.typePassword();
	    
	    Reporter.log("Tying Password", true);
	    
	    home.clickOnLoginButton();
	    
	    Reporter.log("Login to Application", true);
	    
	    String Dashboard_title=driver.getTitle();
		
	    Assert.assertTrue(Dashboard_title.contains("Dashboard"));
	}
	
	
	
}
