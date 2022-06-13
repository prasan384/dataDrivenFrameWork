package MyPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SizeAndLocationOfElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	WebElement logo=	driver.findElement(By.xpath(" //div[@id='divLogo']//img"));
		
		// location method -1
		
		System.out.println("Location(x,y): "+ logo.getLocation());
		System.out.println("Location(x): "+ logo.getLocation().getX());
		System.out.println("Location(y): "+ logo.getLocation().getY());
		
		//location method 2
		System.out.println("Location(x): "+ logo.getRect().getX());
		System.out.println("Location(y): "+ logo.getRect().getY());
		
		// size method -1
		System.out.println("size(width,height): "+ logo.getSize());
		System.out.println("size(height): "+ logo.getSize().getHeight());
		System.out.println("size(width): "+ logo.getSize().getWidth());
		
		// size method-2
		System.out.println("size(width): "+ logo.getRect().getDimension().getWidth());
		System.out.println("size(height): "+ logo.getRect().getDimension().getHeight());




		

		

		

		

	}

}
