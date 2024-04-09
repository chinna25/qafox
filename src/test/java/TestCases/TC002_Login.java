package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import TestBase.BaseClass;

public class TC002_Login extends BaseClass{
	
	
@Test(groups= {"Sanity","Master"})
public void test_login()
{
	logger.info("Starting TC002_Login");
	try
	{
		driver.get(rb.getString("appURL"));
		logger.info("Home Page displayed");
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		hp.clickmyAcount();
		logger.info("click on my  Acount");
		hp.clicklogin();
		logger.info("clickd on login");
				
		LoginPage lp=new LoginPage(driver);
		lp.Setnemail(rb.getString("email"));
		logger.info("provided email");
		lp.Setpassword(rb.getString("password"));
		logger.info("provided password");
		lp.clickloginbutton();
		logger.info("click login successfully");
		
		boolean targetpage=lp.isMyAccountPageExists();
		if(targetpage) 
		{
			logger.info("login success");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("login Failed");
			captureScreen(driver,"test_login");
			Assert.assertTrue(false);
		}
		
	}
	catch (Exception e)
	{
		logger.fatal("login Failed");
		Assert.fail();
	}
	
	logger.info("finished TC002_Login");
}
}
