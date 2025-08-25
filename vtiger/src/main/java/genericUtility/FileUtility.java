package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.testng.annotations.Test;

public class FileUtility {

	FileInputStream fis;
	Properties prop;
	
	@Test
	public String getURLFrmProperties() throws IOException
	{
		fis = new FileInputStream("./src/test/resources/TestData/commonData.properties");
		prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty("url");
		return data;
		
	}
	
	@Test
	public String getUserNameFrmProperties() throws IOException
	{
		fis = new FileInputStream("./src/test/resources/TestData/commonData.properties");
		prop = new Properties();
		prop.load(fis);
		String username = prop.getProperty("username");
		return(username);
		
	}
	
	@Test
	public String getPasswordFrmProperties() throws IOException
	{
		fis = new FileInputStream("./src/test/resources/TestData/commonData.properties");
		prop = new Properties();
		prop.load(fis);
		String password = prop.getProperty("password");
		return(password);
	}
	
	@Test
	public String getBrowser() throws IOException
	{
		fis = new FileInputStream("./src/test/resources/TestData/commonData.properties");
		prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty("browser");
		return data;
	}
}
