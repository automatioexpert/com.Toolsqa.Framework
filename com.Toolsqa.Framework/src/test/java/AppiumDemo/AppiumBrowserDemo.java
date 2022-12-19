/*package AppiumDemo;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class AppiumBrowserDemo 
{

	
	@Test
	public void testAPK() throws MalformedURLException
	{
		
		
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setCapability(CapabilityType.BROWSER_NAME, "Browser");
		
		cap.setCapability("platformName","Android");
		
		cap.setCapability("deviceName", "Toolsqa");
		
		cap.setCapability(CapabilityType.VERSION,"4.4.4");
		
		WebDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4727/wd/hub"), cap);
		
		driver.get("http://www.toolsqa.com");
		
		System.out.println(driver.getTitle());
		
		driver.quit();
		
		
	}
	
}
*/