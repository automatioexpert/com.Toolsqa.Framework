package UnitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.ConfigDataProvider;
import DataProvider.ExcelDataProvider;
import Factory.DataProviderFactory;

public class DataProviderFactoryTest 
{

	@Test
	public void getConfigObject()
	{
		
	ConfigDataProvider config=DataProviderFactory.getConfig();
	
	Assert.assertTrue(config!=null);
		
	}
	
	@Test
	public void getExcelObject()
	{
		
	ExcelDataProvider excel=DataProviderFactory.getExcel();
		
	Assert.assertTrue(excel!=null);
	}
	
	
}
