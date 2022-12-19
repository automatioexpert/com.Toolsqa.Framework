package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Pages.LoginPage;
import Pages.Post;
import Utility.CaptureScreenshot;

public class ValidateWordpress2 
{
    
	 
	 WebDriver driver;
	 ExtentReports report;
	 ExtentTest logger;
	 String reportPath;
	 
	 @BeforeMethod
	 public void setUp()
	 {
		 reportPath="C:\\Workspace8Aug\\com.toolsqa.Frameworknew\\Reports\\ToolsQA"+System.currentTimeMillis()+".html";
		 report=new ExtentReports(reportPath, false);
		 
	 }
	 
/*	 @Test
	 public void wordpressWelcome()
	 {
		 logger= report.startTest("Publis Wordpress article", "This will publish article on wordpress");
		 
		  logger.log(LogStatus.INFO, "Browser is up and running");
		  
		  report.endTest(logger);
		  
	 }*/
	 
	 
	@Test
	public void publish_article()
	{
		
	  	
	  logger= report.startTest("Publis Wordpress article", "This will publish article on wordpress");
		
	  driver=BrowserFactory.getBrowser("Firefox");
	  
	  logger.log(LogStatus.INFO, "Browser is up and running");
	  
	  driver.get(DataProviderFactory.getConfig().getUrl());
	  
	  logger.log(LogStatus.INFO, "Application is loding");
	  
	  String path=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
	  
	  logger.log(LogStatus.INFO, path);
	  
	  LoginPage home_page=PageFactory.initElements(driver, LoginPage.class);
	  
	  Post post_page=PageFactory.initElements(driver, Post.class);
	  
	  home_page.loginToWordPress("admin", "demo123");
	  
      String path1=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
	  
	  logger.log(LogStatus.INFO, path1);
		
	  post_page.publish_article_on_wordpress();
	  
      String path2=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
	  
	  logger.log(LogStatus.INFO, path2);
	  
	  post_page.validate_post();
	    
	  report.endTest(logger);
	  
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		
		if(result.getStatus()==ITestResult.FAILURE)	
		{
			
			  String path4=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver,result.getName() ));
			  
			  logger.log(LogStatus.FAIL, path4);
			
		}

		report.endTest(logger);
		report.flush();
		driver.get(reportPath);
		
	}
	
}
