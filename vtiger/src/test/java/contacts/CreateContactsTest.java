package contacts;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtility.BaseClass;
import genericUtility.ListenerUtility;
import objectRepository.ContInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContPage;
import objectRepository.HomePage;

public class CreateContactsTest extends BaseClass {

	@Test
	public void createContactTest(Method mtd) throws IOException
	{
		
		//Reporter.log(mtd.getName()+" Test started",true);
		HomePage hp = new HomePage(driver);
		
		hp.getContactsLink().click();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactBtn().click();
		
		String conName = excel.getDataFromExcel("Contacts",1,1)+jutil.randomNumb();
			
		CreateNewContPage newcp = new CreateNewContPage(driver);
		newcp.getLastnameTF().sendKeys(conName);
		newcp.getSaveBt().click();
		
		ContInfoPage cinfo = new ContInfoPage(driver);
		String contactMsg =cinfo.getHeaderMsg().getText();
		System.out.println(contactMsg);
		boolean status=contactMsg.contains(conName);
		Assert.assertEquals(status,true,"Contact not created");
		ListenerUtility.test.log(Status.PASS, "Contact created");
	}
	
	@Test
	public void createContactwithDateTest(Method mtd) throws IOException, InterruptedException
	{
		Reporter.log(mtd.getName()+" Test started",true);
		HomePage hp = new HomePage(driver);
		
		hp.getContactsLink().click();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactBtn().click();
		
		String conName = excel.getDataFromExcel("Contacts",1,1)+jutil.randomNumb();
		
		CreateNewContPage newcp = new CreateNewContPage(driver);
		newcp.getLastnameTF().sendKeys(conName);
		
		WebElement startDate = newcp.getSuppStrtDate();
		startDate.clear();
		startDate.sendKeys(jutil.startDate());
		
		WebElement endDate=newcp.getSuppEndDate();
		endDate.clear();
		endDate.sendKeys(jutil.endDate());
		
		String BeforeStDt = jutil.startDate();
		System.out.println(BeforeStDt);
		String BeforeEndDt = jutil.endDate();
		System.out.println(BeforeStDt);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String afterStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		System.out.println(afterStartDate);
		String afterEndDate=driver.findElement(By.id("dtlview_Support End Date")).getText();
		System.out.println(afterEndDate);
		
		Assert.assertEquals(afterStartDate, BeforeStDt, "Dates are not Matching.. Fail");
		ListenerUtility.test.log(Status.PASS, "Dates are Matching");
		//Reporter.log("Dates are Matching",true);
		Assert.assertEquals(afterEndDate, BeforeEndDt, "Dates are not Matching.. Fail");
		//Reporter.log("Dates are Matching",true);
		ListenerUtility.test.log(Status.PASS, "Dates are Matching");
		
	    String contactMsg = driver.findElement(By.className("dvHeaderText")).getText();
		//Thread.sleep(2000);
	    boolean staus=contactMsg.contains(conName);
	    Assert.assertEquals(staus,true,"Contact not created");
	    //Reporter.log("Contact created successfully");
	    ListenerUtility.test.log(Status.PASS, "Contact created successfully");
	}
	
	@Test
	public void createContWithOrgTest(Method mtd) throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log(mtd.getName()+" Test started",true);
		HomePage hp = new HomePage(driver);
		
		hp.getContactsLink().click();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactBtn().click();
		
		String conName = excel.getDataFromExcel("Contacts",1,1)+jutil.randomNumb();
		CreateNewContPage newcp = new CreateNewContPage(driver);
		newcp.getLastnameTF().sendKeys(conName);
		newcp.getAddOrgBt().click();
	
		wutil.switchToChildWindow(driver, "Accounts&action");
		WebElement	orgName=driver.findElement(By.xpath("//a[contains(text(),'Amazon')]"));
		driver.findElement(By.name("search_text")).sendKeys(orgName.getText());
		driver.findElement(By.name("search")).click();
		wutil.switchToChildWindow(driver, "Contacts&action");
		
        newcp.getSaveBt().click();
		
        ContInfoPage cinfo = new ContInfoPage(driver);
	    String contactMsg = cinfo.getHeaderMsg().getText();
	  boolean status= contactMsg.contains(conName);
		Assert.assertEquals(status, true,"Contact not created");
		//Reporter.log("Contact created Successfully",true);
		ListenerUtility.test.log(Status.PASS, "Contact created successfully");
	}
}
