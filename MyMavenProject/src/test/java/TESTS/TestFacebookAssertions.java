package TESTS;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFacebookAssertions {
	@Test
	public void Testfacebook() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
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
		String expectedtext = "";
		String Actualtext = driver.findElement(By.name("email")).getAttribute("value");
		softAssert.assertEquals(Actualtext, expectedtext,"username text  is mismatched");
		
		Thread.sleep(5000);
		driver.quit();
		softAssert.assertAll(); //to catch all the recorded exceptions
	}

}
