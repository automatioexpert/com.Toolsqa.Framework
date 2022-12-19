package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConfigDataProvider 
{
	
	Properties pro;

	
	public ConfigDataProvider()
	{
		
		File src=new File("C:\\Workspace8Aug\\com.toolsqa.Frameworknew\\Configuration\\config.properties");
		
		
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			
			pro=new Properties();
			
			pro.load(fis);
			
		} 
		catch (Exception e) {
			
		}
		
	}
	
	
	public String getUrl(){
		
		String appurl=pro.getProperty("url");
		
		return appurl;
	}
	
	
	
	public String getChromePath()
	{
		  
   	return pro.getProperty("ChromePath");
		
	}
	
	
	 public String getIEPath()
	 {
		 
		String ie_driver_path= pro.getProperty("IEpath");
		
		 return ie_driver_path;
	 }
	 
	 public List<String> getXMLFile()
	 {
		 
		  
		        String xmlfiles=pro.getProperty("XMLFiles");
		 
		        String []arr= xmlfiles.split(",");
		        
		        
		        List<String> xmllist=new ArrayList<String>();
		        
		        
		        for(int i=0;i<arr.length;i++)
		        {
		        	
		        	xmllist.add(arr[i]);
		        	
		        }
		        
		        
		 
		        return xmllist;
	 }
	
	
}


