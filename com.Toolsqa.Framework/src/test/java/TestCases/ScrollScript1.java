package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Factory.BrowserFactory;
import Utility.CaptureScreenshot;
import Utility.HelperClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ScrollScript1 
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
		
	  	
	  logger= report.startTest("Scroll into view feature", "This will scroll down untill element is not found");
		
	  driver=BrowserFactory.getBrowser("Firefox");
	  
	  logger.log(LogStatus.INFO, "Browser is up and running");
	  
	  driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
	  
	  logger.log(LogStatus.INFO, "Application is loding");
	  
	  String path=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
	  
	  logger.log(LogStatus.INFO, path);
	  
	  
	  HelperClass.scrollIntoView(driver, driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/p[3]")));	
	 
	  
      String path2=logger.addScreenCapture(CaptureScreenshot.takeScreenshot(driver, "Application"));
	  
	  logger.log(LogStatus.INFO, path2);
	    
	 // report.endTest(logger);
	  
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
