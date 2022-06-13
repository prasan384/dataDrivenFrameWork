 package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleIframe {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		driver.manage().window().maximize();
		
		//1st iframe
		 driver.switchTo().frame("packageListFrame");
		 driver.findElement(By.xpath(" //body/main[1]/ul[1]/li[1]/a[1]")).click();//org.openqa.selenium
		 driver.switchTo().defaultContent();// go back to main page
		 Thread.sleep(3000);
		 
		 // 2nd iframe
		 driver.switchTo().frame("packageFrame");
		 driver.findElement(By.xpath("//body[1]/main[1]/ul[1]/li[715]/a[1]/span[1]")).click();//webdriver
		 driver.switchTo().defaultContent();// go back to main page
		 Thread.sleep(3000);
		 
		 
		 // 3rd iframe
		 
		 driver.switchTo().frame("classFrame");
		 
		 driver.findElement(By.xpath("//header/nav[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();//help

		 

	}

}
