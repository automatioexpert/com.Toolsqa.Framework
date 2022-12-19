package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Pages.LoginPage;
import Pages.Post;

public class ValidateWordpress1 
{
    
	 
	 WebDriver driver;
	
	@Test
	public void publish_article()
	{
		
	  driver=BrowserFactory.getBrowser("Firefox");
	  
	  driver.get(DataProviderFactory.getConfig().getUrl());
	  
	  LoginPage home_page=PageFactory.initElements(driver, LoginPage.class);
	  
	  Post post_page=PageFactory.initElements(driver, Post.class);
	  
	  home_page.loginToWordPress("admin", "demo123");
		
	  post_page.publish_article_on_wordpress();
	  
	  post_page.validate_post();
	  
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	 
		Utility.CaptureScreenshot.takeScreenshot(driver, result.getName());
		
	}
	
}
