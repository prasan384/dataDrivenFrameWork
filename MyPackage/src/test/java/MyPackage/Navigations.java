package MyPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigations {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.get("http://www.snapdeal.com");
	//	driver.get("https://www.amazon.in");
		// we can use navigate.to() insted of get() method
		 driver.navigate().to("http://www.snapdeal.com");
		 driver.navigate().to("https://www.amazon.in");
		
		driver.navigate().back();// to snapdeal 
		driver.navigate().forward();// to amazon 
		driver.navigate().refresh();// to refresh the page
	    
		
		
	}

}
