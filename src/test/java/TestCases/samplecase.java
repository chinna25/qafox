package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class samplecase {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

	}

}
