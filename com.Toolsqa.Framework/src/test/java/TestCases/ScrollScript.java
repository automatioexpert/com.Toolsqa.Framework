package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Factory.BrowserFactory;
import Pages.LoginPage;

import Utility.CaptureScreenshot;
import Utility.HelperClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ScrollScript 
{
    
	 
	 WebDriver driver;
	 ExtentReports report;
	 ExtentTest logger;
	 String reportPath;
	 
	 @BeforeMethod
	 public void setUp()
	 {
		 reportPath="C:\\Workspace8Aug\\com.toolsqa.Frameworknew\\Reports\\ToolsQA"+System.currentTimeMillis()+".html";
		 report=new ExtentReports(reportPath, true);
		 
	 }
	 

	 
	@Test
	public void scrollDown()
	{
		
	  	
	  logger= report.startTest("Scroll feature", "This will scroll down the page");
		
	  driver=BrowserFactory.getBrowser("Firefox");
	  
	  logger.log(LogStatus.INFO, "Browser is up and running");
	  
	  driver.get("http://demosite.center/wordpress/wp-login.php");
	  
	  logger.log(LogStatus.INFO, "Application is loding");
	  
	  String path=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
	  
	  logger.log(LogStatus.INFO, path);
	  
	  LoginPage home_page=PageFactory.initElements(driver, LoginPage.class);
	  
	  
	  
	  home_page.loginToWordPress("admin", "demo123");
	  
      String path1=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
	  
	  logger.log(LogStatus.INFO, path1);
		
	  HelperClass.scrollDown(driver, 0, 500);
	  
      String path2=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
	  
	  logger.log(LogStatus.INFO, path2);
	    
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
