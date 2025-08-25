package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContInfoPage {

	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	public ContInfoPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	//this is a verification msg
	
}
