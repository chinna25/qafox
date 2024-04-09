package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnLogin;
	
	@FindBy(xpath="//h2[contains(text(),'My Account')]")
	WebElement msgHeading;
	
	public void Setnemail(String email)
	{
		txtEmailAddress.sendKeys(email);
	}
	public void Setpassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void clickloginbutton()
	
	{
		btnLogin.click();
	}
	
	public boolean isMyAccountPageExists()
	{
		try
		{
			return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return (false);
		}
	}
	
}
