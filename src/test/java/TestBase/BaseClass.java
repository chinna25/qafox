package TestBase;

import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger; //for logging
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"Sanity","Master","Regression"})
	@Parameters({"browser"})
	public void setUp(String br)
	{
		logger=LogManager.getLogger(this.getClass()); //for logging
		rb=ResourceBundle.getBundle("config");
		//System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver-win64\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		//Load config.priperties
		
		
		
		//Drivers
		if(br.equals("chrome"))
		{
		//System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver-win64\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		logger.info("launcherd chrome browser");
		}
		else if(br.equals("edge"))
		{
			//System.setProperty("webdriver.edge.driver", "F:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			logger.info("launcherd edge browser");
		}
		else if(br.equals("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver","F:\\Drivers\\geckodriver-v0.33.0-win64\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			logger.info("launcherd firefox browser");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	
	
	
	public String randomstring()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	public int randomNumber()
	{
		String generatedString2=RandomStringUtils.randomNumeric(5);
		return (Integer.parseInt(generatedString2));
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"\\screenshots\\"+tname+ ".png");
		FileUtils.copyFile(source, target);
	}

}
