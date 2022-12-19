package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Pages.LoginPage;

public class LoginWordpress1 
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
	    
	    //home.loginToWordPress("admin","demo123");
	    
	    String username=DataProviderFactory.getExcel().getData(0, 0, 0);
	    
	    //String password=DataProviderFactory.getExcel().getData(0, 0, 1);
	    
	    home.loginToWordPress(username, DataProviderFactory.getExcel().getData(0, 0, 1));
	    
	    String Dashboard_title=driver.getTitle();
		
	    Assert.assertTrue(Dashboard_title.contains("Dashboard"));
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
			Utility.CaptureScreenshot.takeScreenshot(driver, result.getName());
		}
		
	}
	
	
	
}
