package TestCases;


import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import TestBase.BaseClass;
import Utiities.XLUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData")
	
	public void test_LoginDDT(String email, String pwd, String exp)
	{
		logger.info("Starting TC003_LoginDDT");
		try
		{
			
			driver.get(rb.getString("appURL"));
			logger.info("Home Page displayed");
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			hp.clickmyAcount();
			logger.info("clicked on myAccount");
			hp.clicklogin();
			logger.info("clicked on Login");
			
			LoginPage lp = new LoginPage(driver);
			
			lp.Setnemail(email);
			logger.info("Provided Email");
			
			lp.Setpassword(pwd);
			logger.info("Provided password");
			
			lp.clickloginbutton();
			logger.info("clicked on Login");
			
			boolean targetpage = lp.isMyAccountPageExists();
			if(exp.equals("Valid"))
			{
				if(targetpage==true)
					
				{
					logger.info("Login Success");
					
					MyAccountPage myaccpage=new MyAccountPage(driver);
							myaccpage.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					logger.error("Login Failed");
					Assert.assertTrue(false);
				}
			}
			if(exp.equals("Invalid"))
			{
				if(targetpage==true)
				{
					MyAccountPage myaccpage=new MyAccountPage(driver);
					myaccpage.clickLogout();	
					Assert.assertTrue(false);
				}
				else
				{
					logger.error("Login Failed");
					Assert.assertTrue(true);
			
				}
			}
		}
		catch(Exception e)
		{
			logger.fatal("login failed");
			Assert.fail();
		}
		logger.info("Finished TC003_LoginDDT");
	}
		
		
		@DataProvider(name="LoginData")
		public String [][] getData() throws IOException
		{
			String path=".\\testData\\Qafox_LoginData.xlsx";
			XLUtility xlutil= new XLUtility(path);
			
			int totalrows=xlutil.getRowCount("Sheet1");
			int totalcols=xlutil.getCellCount("Sheet1", 1);
			
			String logindata[][]=new String[totalrows] [totalcols];
			
			for(int i=1;i<=totalrows;i++)
			{
				for(int j=0; j<=totalcols;j++)
				{
					logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
				}
			}
			return logindata;
			
		}
	}
	
	


