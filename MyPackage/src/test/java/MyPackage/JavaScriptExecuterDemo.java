package MyPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecuterDemo {

	public static void main(String[] args) throws Exception {
	

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		// syntax
		//JavascriptExecutor js= (JavascriptExecutor) driver ;
		// if we use chrome driver instead of webdriver we need not typecast 
		//js.executeScript(script, args);
		
/*		// draw border and take screenshot
	WebElement logo= 	driver.findElement(By.xpath(" //img[@alt='nopCommerce demo store']"));
	JavaScriptUtil.drawBorder(logo, driver);
	
	TakesScreenshot ts= (TakesScreenshot) driver;
	File src= ts.getScreenshotAs(OutputType.FILE);
	File trgt= new File(".\\screenshot\\logo.png");
	FileUtils.copyFile(src, trgt);                   */
	  
	
	//  getting title of the page
	
	String title =JavaScriptUtil.getyTitleByJs(driver);
	System.out.println("title of the page is " + title);
		
		
		
		
		
		

	}

}
