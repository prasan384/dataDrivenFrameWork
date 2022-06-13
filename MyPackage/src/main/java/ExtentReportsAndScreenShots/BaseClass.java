package ExtentReportsAndScreenShots;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import reports.ExtentManager;

public class BaseClass extends DriverBase {
	 public ExtentReports report;
	public ExtentTest test;
	
	public DriverBase base;
	
	//public ApplicationKeyword application; 
	
	@BeforeTest(alwaysRun = true)
	public void beforeTest(ITestContext context ) {
		System.out.println("----------Before Test----------");
		base = new DriverBase();
		context.setAttribute("b", base);
		 report = ExtentReportsGeneration.generateReports();
		 test = report.createTest(context.getCurrentXmlTest().getName());
		 test.log(Status.INFO, "Starting the  "+context.getCurrentXmlTest().getName());
	//	 application.setReport(test);
		 context.setAttribute("rep", report);
		 context.setAttribute("tests", test);
		 
		 
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(ITestContext context) {
		System.out.println("Before Method*");
		
		base=(DriverBase) context.getAttribute("b");
		report = (ExtentReports) context.getAttribute("rep");
		test = (ExtentTest) context.getAttribute("tests");
		
		String critical = (String)context.getAttribute("crtiticalfailure");
		if(critical !=null && critical.equals("Y")) {
			test.log(Status.SKIP, "Skipped");
			throw new SkipException("Skipped Exception");
		
		}
	}
	
	@AfterTest
	public void afterTest() {
		if(report!=null)
			report.flush();
		
		
	}
	
	
	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
}