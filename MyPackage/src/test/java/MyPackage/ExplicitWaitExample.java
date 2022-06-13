package MyPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitExample {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		//WebDriverWait mywait= new WebDriverWait(driver,5);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
	//WebElement element= mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //a[contains(text(),'WebDriver')]")));
		
	//element.click();
		
		By elelocator= By.xpath(" //a[contains(text(),'WebDriver')]");
		
		WaitForElementPresent( driver,elelocator,5).click();
		
	}
	
	public static WebElement WaitForElementPresent(WebDriver driver,By locator,int timeout) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
		
		return driver.findElement(locator);
		
	}

}
