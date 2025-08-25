package genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class WebDriverUtility {

	
	public void switchToChildWindow(WebDriver driver,String expUrl)
	{
	
		Set<String> allIds = driver.getWindowHandles();
		for(String id:allIds)
		{
			driver.switchTo().window(id);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(expUrl))
				break;
		}
	}
	
	public void selectByVisibleText(WebElement ele,String text)
	{
		Select s = new Select(ele);
		 s.selectByVisibleText(text);
	}
	
	public void selectByValue(WebElement ele,String text)
	{
		Select s = new Select(ele);
		 s.selectByValue(text);
	}
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
}
