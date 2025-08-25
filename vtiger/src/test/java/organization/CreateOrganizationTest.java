package organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import genericUtility.BaseClass;
import objectRepository.CreateNewOrgPage;
import objectRepository.HomePage;
import objectRepository.OrgInfoPage;
import objectRepository.OrganizationPage;

public class CreateOrganizationTest extends BaseClass{

	@Test
	public void createOrg() throws IOException
	{
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgBtn().click();

		String orgname = excel.getDataFromExcel("Org",1,1)+jutil.randomNumb();

		CreateNewOrgPage cno = new CreateNewOrgPage(driver);
		cno.getOrgNameField().sendKeys(orgname);
		cno.getSaveBtn().click();

		OrgInfoPage oinfo = new OrgInfoPage(driver);
		String orgCreatedMsg = oinfo.getHeaderMsg().getText();

		if(orgCreatedMsg.contains(orgname))
			System.out.println("Organization created");
		else
			System.out.println("Organization not created");
		
	}
	
	@Test
	public void createOrgWithIndType() throws IOException
	{
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgBtn().click();
		
		String orgname = excel.getDataFromExcel("Org",1,1)+jutil.randomNumb();
		
		CreateNewOrgPage cno = new CreateNewOrgPage(driver);
		cno.getOrgNameField().sendKeys(orgname);
		
		WebElement industry = cno.getIndustryDD();
		WebElement type = cno.getAccounttypeDD();
		
		wutil.selectByVisibleText(industry, excel.getDataFromExcel("Org", 1, 2));
		wutil.selectByVisibleText(type, excel.getDataFromExcel("Org", 1, 3));
		
		cno.getSaveBtn().click();
		
		OrgInfoPage oinfo = new OrgInfoPage(driver);
		String orgCreatedMsg = oinfo.getHeaderMsg().getText();
		if(orgCreatedMsg.contains(orgname))
			System.out.println("Organization created");
		else
			System.out.println("Organization not created");
		

	}
	@Test
	public void createOrgWithPhone() throws EncryptedDocumentException, IOException
	{
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgBtn().click();
		
        String orgname = excel.getDataFromExcel("Org",1,1)+jutil.randomNumb();
		
		CreateNewOrgPage cno = new CreateNewOrgPage(driver);
		cno.getOrgNameField().sendKeys(orgname);
		cno.getPhoneField().sendKeys(excel.getDataFromExcel("Org",1, 4));
		cno.getSaveBtn().click();
		
		OrgInfoPage oinfo = new OrgInfoPage(driver);
		
		String orgCreatedMsg = oinfo.getHeaderMsg().getText();
		if(orgCreatedMsg.contains(orgname))
			System.out.println("Organization created");
		else
			System.out.println("Organization not created");
	}

}
