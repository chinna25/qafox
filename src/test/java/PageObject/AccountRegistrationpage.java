package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationpage {
	
WebDriver driver;
	
	public AccountRegistrationpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	

}
	@FindBy(id="input-firstname")
	WebElement txtFirstName;
	
	@FindBy(id="input-lastname")
	WebElement txtlastname;
	
	@FindBy(id="input-email")
	WebElement txtMail;
	
	@FindBy(id="input-telephone")
	WebElement txtTelephone;
	
	@FindBy(id="input-password")
	WebElement tstpassword;
	
	@FindBy(id="input-confirm")
	WebElement txtconfpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement Agreecheckbox;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continuebutton;
	
	@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
	WebElement cnfmsg;
	
	public void setFirstname(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	public void setLastname(String lname)
	{
		txtlastname.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		txtMail.sendKeys(email);
	}
	public void setTelepohonenumber(String ph)
	{
		txtTelephone.sendKeys(ph);
	}
	public void setpasswordr(String password)
	{
		tstpassword.sendKeys(password);
	}
	public void setcnfpasswordr(String cnfpassword)
	{
		txtconfpassword.sendKeys(cnfpassword);
	}
	public void setPrivacyPolicy()
	{
		Agreecheckbox.click();
	}
	
	
	public void clickContinue()
	{
		continuebutton.click();
	}
	public String getCnfMsg()
	{
		try
		{
			return(cnfmsg.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	

}
