package ExtentReportsAndScreenShots;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCases extends  BaseClass  {

	@Test
	public void TestGoogle() throws Exception {
		launchBrowser();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("HYR tutorials", Keys.ENTER);
		String expectedtitle = "HYR tutorials - Google Search";
		String actualtitle = driver.getTitle();
		assertEquals(actualtitle, expectedtitle, "title is mismatched");
		System.out.println(driver.getTitle());
	}
	@Test
	public void TestOrangehrm() {
		launchBrowser();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin1234");
		driver.findElement(By.id("btnLogin")).click();
		Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());

	}
	@Test
	public void Testfacebook() {
		launchBrowser();
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("prasan.charan@gmail.com");
		driver.findElement(By.id("passs")).sendKeys("google8419");
		driver.findElement(By.name("login")).click();
		

	
		
	}
}


