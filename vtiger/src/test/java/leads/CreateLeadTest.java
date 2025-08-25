package leads;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.ExcelUtility;
import genericUtility.FileUtility;
import genericUtility.JavaUtility;


public class CreateLeadTest {

	@Test
	public void createLead() throws IOException, InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		FileUtility file = new FileUtility();
		ExcelUtility excel = new ExcelUtility();
		JavaUtility jutil = new JavaUtility();
		
		driver.get(file.getURLFrmProperties());
		
		driver.findElement(By.name("user_name")).sendKeys(file.getUserNameFrmProperties());
		driver.findElement(By.name("user_password")).sendKeys(file.getPasswordFrmProperties());
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		
		String leadName =excel.getDataFromExcel("Lead",1,0)+jutil.randomNumb();
		driver.findElement(By.name("lastname")).sendKeys(leadName);
		String compName =excel.getDataFromExcel("Lead",1,1)+jutil.randomNumb();
		driver.findElement(By.name("company")).sendKeys(compName);
		
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
		    String leadMsg = driver.findElement(By.className("dvHeaderText")).getText();
			Thread.sleep(2000);
			if(leadMsg.contains(leadName))
				System.out.println("Lead created");
			else
				System.out.println("Lead not created");
			driver.quit();

System.out.println();
		//is this correct
		
		
	}
}
