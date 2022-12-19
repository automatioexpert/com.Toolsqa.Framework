package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FacebookHomePage 
{

	WebDriver driver;
	
	public FacebookHomePage(WebDriver driver)
	{
		
		this.driver=driver;
	}
	
	@FindBy(name="q") WebElement search;
	
	@FindBy(xpath="//a[text()='Log into Facebook | Facebook']") WebElement facebook_link;
	
	@FindBy(id="email") WebElement username;
	
	@FindBy(id="pass") WebElement password1;
	
	@FindBy(id="loginbutton") WebElement login;
	
	@FindBy(xpath="//div[@id='sideNav']//ul[1]//li[1]//a//span[text()='Selenium Demo']") WebElement profile;
	
	
	
	
	
	public void search_Facebook() throws InterruptedException
	{
		search.sendKeys("facebook");
		
		Thread.sleep(2000);
		
		new Actions(driver).sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(2000);
		
	}
	
	
	public void click_result()
	{
		facebook_link.click();
	}
	
	public void facebook_login(String name,String password) throws InterruptedException
	{
		username.sendKeys(name);
		password1.sendKeys(password);
		login.click();
		
		Thread.sleep(5000);
		
	}
	
	
	public void verify_Login()
	{
	
		Assert.assertTrue(profile.getText().contains("Selenium"));
		
	}
	
	
	
}
