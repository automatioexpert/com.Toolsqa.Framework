package UnitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.ConfigDataProvider;
import DataProvider.ExcelDataProvider;

public class DataProviderTest 
{
	
	@Test
	public void testExcelDataProvider()
	{
	
		ExcelDataProvider excel=new ExcelDataProvider();
		
		String username=excel.getData(0, 0, 0);
		
		System.out.println(username);
		
		Assert.assertEquals(username, "admin");
		
	}
	
	
	@Test
	public void testConfigDataProvider()
	{
		
		ConfigDataProvider config=new ConfigDataProvider();
		
		String chromepath=config.getChromePath();
		
		System.out.println(chromepath);
		
		
		Assert.assertEquals(chromepath, "C:\\Selenium_Driver\\chromedriver.exe");
	}

}
