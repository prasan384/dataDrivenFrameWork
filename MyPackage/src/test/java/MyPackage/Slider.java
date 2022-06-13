package MyPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI");
		driver.manage().window().maximize();
		
		 WebElement minslider= driver.findElement(By.xpath(" //span[1]"));
		 
		 System.out.println("location of minslider " +minslider.getLocation());// (59, 250)
		System.out.println("height and width of the element" +minslider.getSize()) ;
		
		 Actions action = new Actions(driver);
		 action.dragAndDropBy(minslider, 100, 250).perform();
		 
		 System.out.println("location of minslider " +minslider.getLocation());//(158, 250)
			System.out.println("height and width of the element" +minslider.getSize());
		 
		WebElement maxslider=	driver.findElement(By.xpath("//span[2]"));
		
		System.out.println("location of maxslider " +maxslider.getLocation());//(510, 250)
		
		action.dragAndDropBy(maxslider, -100, 250).perform();
			
	}

}
