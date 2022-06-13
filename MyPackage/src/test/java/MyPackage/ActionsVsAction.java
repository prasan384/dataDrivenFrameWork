package MyPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsVsAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		 WebElement features= driver.findElement(By.xpath(" //a[@title='Women']"));
		// Actions action = new Actions(driver);
	//	 action.moveToElement(features).perform();// perform mouse hover action
		 
		 Action action = new Actions(driver).build();
		 action.perform();
		 

	}

}
