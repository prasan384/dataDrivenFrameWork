package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import KeyWords.ApplicationKeywords;

public class CreatePortfolioTest {

	public ApplicationKeywords app;

	@Test
	public void CreatePortfolioTest() throws Exception {
		// login
		// create
		// verify
		app = new ApplicationKeywords();// inti properties constructor

		app.openBrowser("chrome");
		app.navigate("url");// using key for url from properties file to get url 
		app.type("username_css", "prasan.charan@gmail.com");// using key(username) for locator(useremail)  from  properties file
		app.type("password_xpath", "google384");
		app.click("login_submit_id");

	}

}
