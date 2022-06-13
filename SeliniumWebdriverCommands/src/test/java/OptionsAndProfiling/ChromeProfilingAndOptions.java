package OptionsAndProfiling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ChromeProfilingAndOptions {
	// set binary profile
	// notifications
	// maximize the browser
	// certificate errors
	// work with proxy
	
	@Test
	public void chrome() {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
 System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,"logs\\chrome.logs");
		
		ChromeOptions options = new ChromeOptions ();
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		options.addArguments("ignore-certificate-errors");
		
		WebDriver cd = new ChromeDriver();
		cd.get("");
		
	}

}
