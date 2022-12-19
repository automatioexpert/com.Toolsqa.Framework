/*package AppiumDemo;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class ApkDemo 
{

	
	@Test
	public void testAPK() throws MalformedURLException
	{
		
		
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setCapability("platformName","Android");
		
		cap.setCapability("deviceName", "Toolsqa");
		
		cap.setCapability(CapabilityType.VERSION,"4.4.4");
		
		cap.setCapability("appPackage", "io.selendroid.testapp");
		
		cap.setCapability("appActivity", ".HomeScreenActivity");

		WebDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4727/wd/hub"), cap);
		
		driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys("Selenium Online training");
		
		driver.findElement(By.id("io.selendroid.testapp:id/visibleButtonTest")).click();
		
		System.out.println(driver.findElement(By.id("io.selendroid.testapp:id/visibleTextView")).getText());
		
	}
	
}
*/