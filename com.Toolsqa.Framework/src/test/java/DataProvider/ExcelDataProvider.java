package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{

	 XSSFWorkbook wb;
	 XSSFSheet sh1;
	 
	
	
	public ExcelDataProvider()
	{
		
		
		File src=new File("C:\\Workspace8Aug\\com.toolsqa.Frameworknew\\TestData\\Data.xlsx");
		
		
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			
			wb=new XSSFWorkbook(fis);
		}
		catch (Exception e) {
			
		}
		
	}
	
	
	
	public String getData(int sheetindex,int rownumber,int columnnumber)
	{
		
	 String data=wb.getSheetAt(sheetindex).getRow(rownumber).getCell(columnnumber).getStringCellValue();
		
	 
	 return data;
	}
	
	
	public int getRowCount(int sheetIndex)
	{
		
		int rowcount=wb.getSheetAt(sheetIndex).getLastRowNum();
	
		return rowcount+1;
	}
	
	
	public int getRowCount(String sheetname)
	{
		
		int rowcount=wb.getSheet(sheetname).getLastRowNum();
	
		return rowcount+1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
