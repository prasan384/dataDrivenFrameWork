package screenshots;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testclass extends BaseTest {
	@Test
	public void TestGoogle() throws Exception {
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("HYR tutorials", Keys.ENTER);
		String expectedtitle = "HYR tutorials - Google Search";
		String actualtitle = driver.getTitle();
		assertEquals(actualtitle, expectedtitle, "title is mismatched");
		System.out.println(driver.getTitle());
	}
	@Test
	public void TestOrangehrm() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin1234");
		driver.findElement(By.id("btnLogin")).click();
		Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());

	}
	@Test
	public void Testfacebook() {
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("HYR tutorials",Keys.ENTER);
		
		SoftAssert softAssert= new SoftAssert();
		// bcz softassert doesnt have static methods. so we have to create objectb to call it
		
		
		//title assertion
		String expectedTitle = "Log in to Facebook";
		String ActualTitle = driver.getTitle();
		softAssert.assertEquals(ActualTitle, expectedTitle,"title is mismatched");
		
		// url assestion
		String expectedUrl = "https://www.facebook.com/";
		String ActualUrl = driver.getCurrentUrl();
		softAssert.assertEquals(ActualUrl, expectedUrl,"url is mismatched");
		
		// text assertion
		String expectedtext = "hello";
		String Actualtext = driver.findElement(By.name("email")).getAttribute("value");
		softAssert.assertEquals(Actualtext, expectedtext,"username text  is mismatched");
		
	}
}
