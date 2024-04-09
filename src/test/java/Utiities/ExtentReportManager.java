package Utiities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	public ExtentSparkReporter SparkReporter;
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest test;
	public ExtentReports report;
	
	String repName;
	public void onTestStart(ITestContext testContext)
	{
		extent = new ExtentReports();

		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
		extent.attachReporter(spark);
		extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
		         extent.setSystemInfo("Environment", "Production");
		extent.setSystemInfo("User Name", "Rajkumar SM");
		spark.config().setDocumentTitle("Title of the Report Comes here ");
		                // Name of the report
		spark.config().setReportName("Name of the Report Comes here ");
		                // Dark Theme
		spark.config().setTheme(Theme.STANDARD);
		//String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		//repName="Test-Report-"+timeStamp+".html";
		/*SparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);
		
		SparkReporter.config().setDocumentTitle("qafox Automation Report");
		SparkReporter.config().setReportName("qafox Functional Testing");
		SparkReporter.config().setTheme(Theme.DARK);
		
		
		extent = new ExtentReports();
		extent.attachReporter(SparkReporter);
		extent.setSystemInfo("Application", "Qafox");
		extent.setSystemInfo("Module", "Frontend");
		extent.setSystemInfo("SubModule", "Customers");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Suresh"); */
		

		//String path =System.getProperty("C:\\Users\\acer\\eclipse-workspace\\SeleniumTestNG\\reportsone\\index.html");
		/*String path =System.getProperty("user.dir")+"\\reportsone\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Automation Results");

		reporter.config().setDocumentTitle("Test Results");

		extent =new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "suresh babu"); */
		
	}
	
		
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.PASS, " test case PASSED is...."+result.getName());
		
	}
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, " Test  FAILED "	);
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
		try
		{
			String screenshotPath=System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png";
			test.addScreenCaptureFromPath(screenshotPath);	
		}
		catch(Exception e)	
		{
			e.printStackTrace();
		}
		
	}
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		//test.createNode(result.getName());
		//test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.SKIP, " test skipped...."	);
		test.log(Status.SKIP,  result.getThrowable().getMessage());
		
	}
	public void onFinish(ITestContext testContet	)
	{
		//extent.flush();
	}
	
		
		
		
		
		
		
		
		
		
		
		
		

}
