package MyPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) {

		// launching chrome
		// System.setProperty("WebDriver.Chrome.Driver", "C:\\Program
		// Files\\Google\\Chrome\\Application\\chrome.exe");
		// ChromeDriver driver = new ChromeDriver();
		// WebDriver driver = new ChromeDriver();
		// driver.get("https://www.facebook.com/");

		/* launching firefox browser
		 System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla
		 Firefox\\firefox.exe");
		 WebDriver driver = new FirefoxDriver();
		 driver.get("https://www.facebook.com/");*/

		// by using webdriver manager dependency
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	
	System.out.println("title of the webpage is" + driver.getTitle());// to get title of web page
	driver.getCurrentUrl();// to get current url to comapre with required url
	driver.getPageSource();// to get html page source
	
	
	}
	
	

}
