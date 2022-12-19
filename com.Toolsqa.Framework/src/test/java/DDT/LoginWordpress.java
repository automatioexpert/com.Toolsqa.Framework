package DDT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Factory.BrowserFactory;
import Pages.LoginPage;

public class LoginWordpress 
{

	
	WebDriver driver;
	
	@Test(dataProvider="WordpressData")
	public void login_to_Wordpress(String username,String password)
	{
		
	   driver=BrowserFactory.getBrowser("firefox");
		
	   driver.get("http://demosite.center/wordpress/wp-login.php");
	   
	   LoginPage homepage=PageFactory.initElements(driver, LoginPage.class);
	   
	   homepage.loginToWordPress(username, password);
	   
	   String Dashboard_title=driver.getTitle();
		
	   Assert.assertTrue(Dashboard_title.contains("Dashboard"));
		
	}
	
	
	
	
	
	@DataProvider(name="WordpressData")
	public Object[][] getWordpressData()
	{
		
		Object [][] data=new Object[3][2];
		
		data[0][0]="admin1";
		
		data[0][1]="demo1";
		
        data[1][0]="admin2";
		
		data[1][1]="demo2";
		
        data[2][0]="admin";
		
		data[2][1]="demo123";
		
		
		return data;
		
	}
	
	
	
	
}
