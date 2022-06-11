package TestBase;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import KeyWords.ApplicationKeywords;
import reports.ExtentManager;

public class BaseTest {

	public ApplicationKeywords app;
	public ExtentReports reports;
	public ExtentTest test;

	@BeforeTest(alwaysRun = true)
	public void beforeTest(ITestContext context) throws Exception {
		System.out.println("-----before test------");
		app = new ApplicationKeywords();// one application keyword object for entire test

		context.setAttribute("app", app);

		// initialise the reporrting for the test

		reports = ExtentManager.generateReports();
		test = reports.createTest(context.getCurrentXmlTest().getName());// to get report with that testcase name
		test.log(Status.INFO, "Starting test  " + context.getCurrentXmlTest().getName());

		app.setReport(test);
		context.setAttribute("report", reports);
		context.setAttribute("test", test);

	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(ITestContext context) {
		System.out.println("-----before method------");
		
		
		test = (ExtentTest) context.getAttribute("test");// instead of creating a new object every time for extent test
		
		// we are getting test object at test level for every method
		
	
		
		
		String criticalFailure	=(String) context.getAttribute("criticalFailure");
		if(criticalFailure!=null && criticalFailure.equals("Y")) {
			test.log(Status.SKIP, "Critical failure in previous test");// skip in extent reports
			throw new SkipException("Critical failure in previous test");// skip in testNG
		}
		
		
		
		
		app = (ApplicationKeywords) context.getAttribute("app");

		reports = (ExtentReports) context.getAttribute("report");// getting the same reports object every time before
																	// method
	
	
	}

	@AfterTest
	public void quiT() {
		if (reports != null) {
			reports.flush();
		}
	}

}
