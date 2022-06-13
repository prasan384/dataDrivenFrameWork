package TESTCASES;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reports.ExtentManager;

public class LoginTest {
	ExtentTest test;
	ExtentReports reports;

	@BeforeMethod
	public void initialise() {
		// calling reports object from getreports method of extentmanager class
		 reports =	ExtentManager.getReports();
		test = reports.createTest("loginTest");

	}

	@AfterMethod
	public void quit() {
		// finalises and generates the reports

		reports.flush();

	}

	@Test
	public void login() {

		test.log(Status.INFO, "start testcase login");
		test.log(Status.FAIL, "404 error");
		Assert.fail("404 error");
		test.log(Status.INFO, "opening browser");
		test.log(Status.INFO, "logging in");
		test.log(Status.PASS, "login test is passed");

	}

}
