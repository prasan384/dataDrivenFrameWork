package TESTCASES;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reports.ExtentManager;

public class RegistrationTEST {
	public class LoginTest {
		ExtentTest test;
		ExtentReports reports;

		@BeforeMethod
		public void initialise() {
			// calling reports object from getreports method of extentmanager class
			reports=	ExtentManager.getReports();
			test = reports.createTest("RegistrationTEST");

		}

		@AfterMethod
		public void quit() {
			// finalises and generates the reports

			reports.flush();

		}

		@Test
		public void Registration() {

			test.log(Status.INFO, "registered test started");
			test.log(Status.PASS, "registered test is passed");

		}

	}

}
