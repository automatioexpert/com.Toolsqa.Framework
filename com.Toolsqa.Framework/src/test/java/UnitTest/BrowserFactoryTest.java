package UnitTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Factory.BrowserFactory;

public class BrowserFactoryTest
{

	

	@Test
	public void testChromeBrowser()
	{
		
	WebDriver driver=BrowserFactory.getBrowser("chrome");
		
	Assert.assertTrue(driver!=null);
	
	BrowserFactory.closeBrowser();
	
	}
	

	@Test
	public void testFirefoxBrowser()
	{
		
	WebDriver driver=BrowserFactory.getBrowser("Firefox");
		
	Assert.assertTrue(driver!=null);
	
	BrowserFactory.closeBrowser();
	
	}
	
}
