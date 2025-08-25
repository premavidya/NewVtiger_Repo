package product;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.ExcelUtility;
import genericUtility.FileUtility;

public class CreateProductTest {

	@Test
	public void createProduct() throws IOException, InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		FileUtility file = new FileUtility();
		ExcelUtility excel = new ExcelUtility();
		
		driver.get(file.getURLFrmProperties());
		
		driver.findElement(By.name("user_name")).sendKeys(file.getUserNameFrmProperties());
		driver.findElement(By.name("user_password")).sendKeys(file.getPasswordFrmProperties());
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		String productName = excel.getDataFromExcel("Product",1, 0);
		driver.findElement(By.name("productname")).sendKeys(productName);
		
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
		    String productNameHeader = driver.findElement(By.className("lvtHeaderText")).getText();
			Thread.sleep(2000);
			if(productNameHeader.contains(productName))
				System.out.println("Product created");
			else
				System.out.println("Product not created");
			driver.quit();
		
	}
	
}
