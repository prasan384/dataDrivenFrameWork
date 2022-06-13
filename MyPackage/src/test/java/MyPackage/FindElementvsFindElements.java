package MyPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementvsFindElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.nopcommerce.com/");

		// findelement-----> single web element
		// 1
		WebElement searchbox = driver.findElement(By.id("small-searchterms"));
		searchbox.sendKeys("xyz");
		// 2
		// if there are multiple elements , if we use findelement method it returns
		// first element in the list
		WebElement ele = driver.findElement(By.className("footer-upper"));
		System.out.println(ele.getText());
		
		// findelememts----> returns multiple web elements 
	List<WebElement> links =  driver.findElements(By.id("footer-upper"));
	System.out.println("number of webelements  "+links.size());
	
	}

}
