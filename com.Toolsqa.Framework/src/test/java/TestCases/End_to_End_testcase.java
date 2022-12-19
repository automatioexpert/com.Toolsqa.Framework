package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Pages.FacebookHomePage;

public class End_to_End_testcase
{
	WebDriver driver;
	
	@Test
	public void search_Login() throws Throwable
	{
		driver=BrowserFactory.getBrowser("firefox");
		
		ExtentReports report=new ExtentReports("C:\\Report\\Demo.html");
		
	     ExtentTest logger=report.startTest("Search_Login");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		logger.log(LogStatus.INFO, "Session is up and running");
		
		driver.get("http://www.google.com");
			
		logger.log(LogStatus.INFO, "Application Loaded");
		
		FacebookHomePage Search=PageFactory.initElements(driver, FacebookHomePage.class);
		
		Search.search_Facebook();
	
		logger.log(LogStatus.INFO, "Click on search result");
		
		Search.click_result();
		
		Search.facebook_login("mukeshotwani@learn-automation.com", "demo@123");
		
		logger.log(LogStatus.INFO, "Login to facebook ");
		
		Search.verify_Login();
		
		logger.log(LogStatus.INFO, "User verified");
		
		report.endTest(logger);
		
		report.flush();
	   
		driver.quit();
		
		
	}
	

}
