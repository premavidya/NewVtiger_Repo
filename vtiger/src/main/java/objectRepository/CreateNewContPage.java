package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContPage {

	@FindBy(name="lastname")
	private WebElement lastnameTF;
	
	@FindBy(name="support_start_date")
	private WebElement suppStrtDate;
	
	@FindBy(name = "support_end_date")
	private WebElement suppEndDate;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement addOrgBt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBt;
	
	public CreateNewContPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnameTF() {
		return lastnameTF;
	}

	public WebElement getSuppStrtDate() {
		return suppStrtDate;
	}

	public WebElement getSuppEndDate() {
		return suppEndDate;
	}

	public WebElement getAddOrgBt() {
		return addOrgBt;
	}

	public WebElement getSaveBt() {
		return saveBt;
	}
	
}
