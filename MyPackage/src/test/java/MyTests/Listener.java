package MyTests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtentReportsAndScreenShots.DriverBase;
import ExtentReportsAndScreenShots.ExtentReportsGeneration;

public class Listener implements ITestListener{
	public void onTestStart(ITestResult result) {
		ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("tests");
		test.log(Status.PASS, "Success Test Case name is  "+result.getName());
		test.log(Status.PASS, result.getMethod().getMethodName());
		}

		public void onTestFailure(ITestResult result) {
			ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("tests");
			test.log(Status.FAIL, result.getThrowable().getMessage());
			DriverBase.generateScreenshots(result.getMethod().getMethodName());
		}

		

		public void onStart(ITestContext context) {
		}

		
	
		  }


