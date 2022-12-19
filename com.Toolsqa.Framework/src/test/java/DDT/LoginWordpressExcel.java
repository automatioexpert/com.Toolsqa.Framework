package DDT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Pages.LoginPage;

public class LoginWordpressExcel 
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
	
	@AfterMethod
	public void teardown()
	{
		BrowserFactory.closeBrowser();
	}
	
	
	
	
	
	@DataProvider(name="WordpressData")
	public Object[][] getWordpressData()
	{
		
		int rowcount=DataProviderFactory.getExcel().getRowCount(0);
		
		Object [][] data=new Object[rowcount][2];
		
		
		
		for(int i=0;i<rowcount;i++)
		{
			
			data[i][0]=DataProviderFactory.getExcel().getData(0, i, 0);
			data[i][1]=DataProviderFactory.getExcel().getData(0, i, 1);
			
		}
		
		
		return data;
		
	}
	
	
	
	
}
