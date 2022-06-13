package MyPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverAction {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		WebElement desktopmenu= driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		
		WebElement macmenuitem= driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		 Actions action = new Actions(driver);
		 // to perform mousehover action
		 action.moveToElement(desktopmenu).moveToElement(macmenuitem).click().perform();// perform method should be done bcz these actions are performed by actions class
	}

}
