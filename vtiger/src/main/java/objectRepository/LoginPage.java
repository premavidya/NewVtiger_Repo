package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.FileUtility;

public class LoginPage {

	
	 public WebDriver driver;
	FileUtility file=new FileUtility();
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")
	private WebElement usernameTF;
	
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	
	

//	public void loginToApp(WebDriver driver,String username, String password)
//	{
//		
//		driver.manage().window().maximize();
//		usernameTF.sendKeys(username);
////		passwordTF.sendKeys(password);
////		loginBtn.click();
//	}

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}	
}
