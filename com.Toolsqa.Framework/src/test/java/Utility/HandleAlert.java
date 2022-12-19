package Utility;

import org.openqa.selenium.WebDriver;

public class HandleAlert
{

	public static void acceptAlert(WebDriver driver)
	{
		
		driver.switchTo().alert().accept();
	}
	
	public static void dismissAlert(WebDriver driver)
	{
		
		driver.switchTo().alert().dismiss();
	}
	
	public static String getTextFromAlert(WebDriver driver)
	{
		
		return driver.switchTo().alert().getText();
	}
	
}
