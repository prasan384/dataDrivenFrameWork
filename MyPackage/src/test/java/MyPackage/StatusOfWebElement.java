package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusOfWebElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		WebElement searchstore= driver.findElement(By.id("small-searchterms"));
		System.out.println("display status "+searchstore.isDisplayed());


		System.out.println("enable status "+searchstore.isEnabled());
	 
		WebElement male = driver.findElement(By.id("gender-male"));
		
		System.out.println("male slection status "+male.isSelected());
		male.click();
		System.out.println("male slection status "+male.isSelected());
	}

}
