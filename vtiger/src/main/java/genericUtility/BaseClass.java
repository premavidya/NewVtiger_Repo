package genericUtility;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import objectRepository.HomePage;
import objectRepository.LoginPage;
public class BaseClass {
	
	public static WebDriver driver;
	public DatabaseUtility dbUtil = new DatabaseUtility();
	public FileUtility file = new FileUtility();
	public ExcelUtility excel = new ExcelUtility();
	public JavaUtility jutil = new JavaUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	
	@BeforeSuite
	public void dbConnection() 
	{
		dbUtil.getDBConnection();
		System.out.println("==DB connected==");
	}
	
	@AfterSuite
	public void closeDb()
	{
		dbUtil.closeDB();
		System.out.println("==DB closed==");
	}
	//@Parameters("BROWSER")
	@BeforeClass
	public void openBrowser() throws IOException
	{
		String BROWSER=file.getBrowser();
		if(BROWSER.equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		wutil.waitForPageLoad(driver);
		driver.manage().window().maximize();
		driver.get(file.getURLFrmProperties());
		System.out.println("==Browser opened==");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("==Browser close==");
	}
	
	@BeforeMethod
	public void login() throws IOException 
	{
		LoginPage lp = new LoginPage(driver);
		System.out.println("==Logged in==");
		lp.getUsernameTF().sendKeys(file.getUserNameFrmProperties());
		lp.getPasswordTF().sendKeys(file.getPasswordFrmProperties());
		lp.getLoginBtn().click();
	}
	
	@AfterMethod
	public void logout()
	{
		HomePage hp = new HomePage(driver);
		hp.getUserbutton().click();
		hp.getSignoutBtn().click();
		//driver.quit();
		System.out.println("==Logged out==");
	}
	
}
