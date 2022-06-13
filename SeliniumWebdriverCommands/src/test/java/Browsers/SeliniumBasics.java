package Browsers;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeliniumBasics {
	@Test 
	public void testApp() throws Exception {
	System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
	WebDriver cd = new ChromeDriver();
	cd.get("https://www.amazon.in/");
	
	
	//System.setProperty("webdriver.gecko.driver","C:\\Users\\Hp\\OneDrive\\Desktop\\browser drivers\\geckodriver.exe");
	//FirefoxDriver fd = new FirefoxDriver();
	//fd.get("https://www.facebook.com");
	
	//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
	//	driver.manage().window().maximize();
	//	driver.get("https://www.facebook.com");
	//	
		
	}

}
