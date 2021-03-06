package TestCases.rediff;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import KeyWords.ApplicationKeywords;
import TestBase.BaseTest;

public class session extends BaseTest {

	@Test
	public void doLogin(ITestContext context) throws Exception {
		app.log( "Logging in");

		app.openBrowser("chrome");
		app.navigate("url");// using key for url from properties file to get url 
		app.type("username_css", "prasan.charan@gmail.com");// using key(username) for locator(useremail)  from  properties file
		
		//app.reportFailure("First failure- non critical",false);// calling soft assert function from generickeywrd-->validation-->applicationkeywrd-->basetest
		app.type("password_xpath", "google384");
		app.click("login_submit_id");

 
        
	}

	@Test
	public void doLogout() throws Exception {
		test.log(Status.INFO, "Logging out");


	}
	@Test
	public void selectportfolio() {
		app.click("portselect_xpath");
		app.selectFromDown("portselect_xpath","portfolio");
	}
}
