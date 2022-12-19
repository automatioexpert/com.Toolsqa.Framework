package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperClass
{

	
	
	public static void scrollDown(WebDriver driver,int horizontal,int vertical)
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("scroll("+horizontal+","+vertical+")");
		
	}
	
	
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	
	public static void createAlert(WebDriver driver)
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("alert('Hi Welcome to Selenium')");
	}
	
	
	
	
}
