package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	WebDriver driver;
	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/ul/li[5]/a")
	WebElement lnklogout;
	
	public void clickLogout()
	
	{
		lnklogout.click();
	}

}
