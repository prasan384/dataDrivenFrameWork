package MyPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDoubleClickAction {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://www.w3schools.com/tags/tryit-asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
         driver.findElement(By.xpath("")).clear();
         driver.findElement(By.xpath("")).sendKeys("Welcome To Selenium");
       WebElement button=   driver.findElement(By.xpath(""));
       
       
         Actions action = new Actions(driver);// we have to pass driver instance to actions class
         action.doubleClick(button).perform();// we have to pass webelement to clickfunction to perform
         

	}

}
