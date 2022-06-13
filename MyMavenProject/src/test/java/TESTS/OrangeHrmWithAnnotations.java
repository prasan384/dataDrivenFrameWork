package TESTS;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmWithAnnotations {
	WebDriver driver;
	
	@Parameters("browserName")
	@BeforeTest
	public void initialiseBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			default :
				System.out.println("Browsername is invalid");
		}
		
		driver.manage().window().maximize();
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	@Parameters("url")
	@Test
	
	public void LaunchApp(String url) {
		driver.get(url);
	}
	@Test
	public void EnterLoginDetails() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}
	@Test
	public void NavigateToMyInfo() {
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		
	}
	  @Test
	  public void VerifyMyLogin() {
		  boolean actualvalue= driver.findElement(By.id("employee-details")).isDisplayed();
		  assertTrue(actualvalue);
	  }
	  @Test
		  public void VerifyLogin() {
			  WebElement element = driver.findElement(By.id("Welcome"));
			  System.out.println(element.isDisplayed());
			  System.out.println(element.getText());
	}

}



