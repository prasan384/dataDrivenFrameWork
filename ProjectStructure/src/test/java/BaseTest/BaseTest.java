package BaseTest;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reports.ExtentManager;

public class BaseTest {
	public ExtentReports rep;
	public ExtentTest test;
	public SoftAssert softassert;
	public String Browser;

	@BeforeMethod
	public void inti(ITestContext con ,ITestResult result) {
		
		// to get the current method name whic is exexcuted
		System.out.println(result.getMethod().getMethodName().toUpperCase());
		rep = ExtentManager.getReports();
		
		test = rep.createTest(result.getMethod().getMethodName().toUpperCase());
		result.setAttribute("reporter", test);
         softassert = new SoftAssert();
         Browser= con.getCurrentXmlTest().getParameter("Chrome");// to get in which browser the test case is executed from xml file 
         System.out.println(Browser);
	}
   
	@AfterMethod
	public void quit() {
		rep.flush();

	}
	public void log(String msg) {
		System.out.println(msg);
		test.log(Status.INFO, msg);
		
	}
	public void logFailure(String msg) {// fails only on extent 
		System.out.println(msg);
		test.log(Status.FAIL, msg);
		
	}
	public void FailAndStopTest(String msg) {// fails in testng and extent but stops further
		
	logFailure(msg);
	softassert.fail(msg);
	softassert.assertAll();
	}
	
	public void softassert(String msg) {// fails in testng and extent but continue
		logFailure(msg);
		softassert.fail(msg);
		
	}


}
