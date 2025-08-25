package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrgPage {

	@FindBy(name="accountname")
	private WebElement orgNameField;
	
	@FindBy(id="phone")
	private WebElement phoneField;
	
	@FindBy(name = "industry")
	private WebElement industryDD;
	
	@FindBy(name = "accounttype")
	private WebElement accounttypeDD;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewOrgPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}

	public WebElement getOrgNameField() {
		return orgNameField;
	}

	public WebElement getPhoneField() {
		return phoneField;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getAccounttypeDD() {
		return accounttypeDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
}
