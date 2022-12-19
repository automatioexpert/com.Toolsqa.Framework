package TestRunner;

import org.testng.TestNG;

import Factory.DataProviderFactory;

public class TestEngine {

	public static void main(String[] args) 
	{
	
		
		TestNG runner=new TestNG();
		
		runner.setTestSuites(DataProviderFactory.getConfig().getXMLFile());
		
		runner.run();
		

	}

}
