package TestCases.rediff;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import KeyWords.ApplicationKeywords;
import TestBase.BaseTest;

public class portfolioManagement extends BaseTest {

	@Test
	public void CreatePortfolio(ITestContext context) {
		test.log(Status.INFO, "creating portfolio");
		
		
		
		
		
		
		
		
		

		app.reportFailure("some non critical failure",false);
		app.assertAll();
	}

	@Test
	public void deletePortfolio() {
		test.log(Status.INFO, "deleting portfolio");

	}

	@Test
	public void selectPortfolio() {
		
		
		
		
	}
}
