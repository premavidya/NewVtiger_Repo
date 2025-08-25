package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgBtn;
	
	@FindBy(name="search_text")
	private WebElement searchTxtField;
	
	@FindBy(id = "bas_searchfield")
	private WebElement searchDD;
	
	@FindBy(name = "submit")
	private WebElement searchBtn;
	
	public OrganizationPage(WebDriver driver) {
	 PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}

	public WebElement getSearchTxtField() {
		return searchTxtField;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
}
