package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utility.HighLighter;

public class LoginPage 
{

	
	WebDriver driver;
	
	 public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	
	// Another way to located webelement using @FindBy
	@FindBy(id="user_login") 
	WebElement username;
	
	
	@FindBy(xpath=".//*[@id='user_pass']")
	WebElement password;
	
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement loginButton;
	
	
	public void typeUserName()
	{
		
		username.sendKeys("admin");	
	}
	
	public void typePassword()
	{
		password.sendKeys("demo123");
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	
	public void loginToWordPress(String user,String pass)
	{
		HighLighter.elementHighLight(driver, username);
		username.sendKeys(user);
		
		HighLighter.elementHighLight(driver, password);
		password.sendKeys(pass);
		
		HighLighter.elementHighLight(driver, loginButton);
		loginButton.click();
	}
	
	
	
	
}
