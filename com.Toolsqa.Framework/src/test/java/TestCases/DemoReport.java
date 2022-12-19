package TestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoReport 
{

	ExtentReports report;
	ExtentTest logger;
	
	
	@BeforeTest
	public void setUp()
	{
		report=new ExtentReports("C:\\ToolsqaReports\\Report.html", true);
	}
	
	
	@Test
	public void testAdvanceReport()
	{
		logger=report.startTest("validate Post publish", "Verify post published or not");
		
		logger.log(LogStatus.INFO, "This is testing");
		
		report.endTest(logger);
	}
	
	@Test
	public void testAdvanceReportFailed()
	{
	    logger=report.startTest("validate Post deleted", "Verify post deleted or not");
		
		logger.log(LogStatus.FAIL, "This is testing 2");
		
	    String path=logger.addScreenCapture("C:\\Workspace8Aug\\com.toolsqa.Frameworknew\\Screenshots\\screenshotname1443890014688.png");
		
	    logger.log(LogStatus.INFO, path);
	    
		report.endTest(logger);
		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		report.flush();
		//report.close();
	}
	
}
