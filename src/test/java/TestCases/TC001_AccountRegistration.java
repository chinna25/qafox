package TestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AccountRegistrationpage;
import PageObject.HomePage;
import TestBase.BaseClass;



public class TC001_AccountRegistration extends BaseClass{
	
	
    @Test(groups= {"Regression","Master"})
	public void test_Account_Registration() 
	{
    	try
    	{
		//driver.get(rb.getString("appURL"));
    	logger.info("Starting TC001_AccountRegistration");
		driver.get(rb.getString("appURL"));
		logger.info("Home Page displayed");
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		hp.clickmyAcount();
		logger.info("click on my  Acount");
		hp.clickRegister();
		logger.info("click on Register");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		AccountRegistrationpage ar = new AccountRegistrationpage(driver);
		ar.setFirstname("sureshbabu");
		logger.info("provided First name");
		ar.setLastname("venkata");
		logger.info("provided Last name");
		ar.setEmail(randomstring()+"@gmail.com");
		logger.info("provided Email");
		ar.setTelepohonenumber("8965232589");
		logger.info("provided Telephonenumber");
		ar.setpasswordr("Sureshkvis@1994");
		logger.info("provided password");
		ar.setcnfpasswordr("Sureshkvis@1994");
		logger.info("provided cnf password");
		ar.setPrivacyPolicy();
		ar.clickContinue();
		logger.info("clicked on continue");
		//captureScreen(driver,"test_Account_Registration");
		String cnfmsg=ar.getCnfMsg();
		if(cnfmsg.equals("Your Account Has Been Created!"))
		{
			
			//captureScreen(driver,"test_Account_Registration");
			logger.info("Account Registration Success");
			Assert.assertTrue(true);
		}
		else
		{
			
			captureScreen(driver,"test_Account_Registration");
			logger.error("Account Registration Failed");
			Assert.assertTrue(false);
		}
    	}
    	catch(Exception e)
    	{
    		logger.error("Account Registration Failed");
			Assert.fail();
    	}
		logger.info("Finished TC001_AccountRegistration");
	}
	
	
	

}
