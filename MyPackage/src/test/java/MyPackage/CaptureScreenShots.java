package MyPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenShots {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
	/*	// full page screen shot
	  
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File trgt= new File(".\\screenshot\\homepage.png");
		FileUtils.copyFile(src, trgt);     */
		
/*		// screenshot of section/portion of the page
  
	WebElement section= 	driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File src= section.getScreenshotAs(OutputType.FILE);
		File trgt= new File(".\\screenshot\\featuredproducts.png");
		FileUtils.copyFile(src, trgt);      */
		
		// screenshot of specific web element
		
		WebElement section= 	driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File src= section.getScreenshotAs(OutputType.FILE);
		File trgt= new File(".\\screenshot\\logo.png");
		FileUtils.copyFile(src, trgt);
		
		driver.close();

		

	}

}
