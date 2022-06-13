package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class gettextVSgetattribute {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login");
		
		WebElement emailinputbox = driver.findElement(By.id("Email"));
		emailinputbox.clear();
		emailinputbox.sendKeys("adm123@gmail.com");
		// capturing text from input box 
		System.out.println("result of get attribute method " +emailinputbox.getAttribute("value"));
		
		// get attribute method  returns the value of any attribute 
		// get text method returns the inner text of webelement
		
		System.out.println("result of get text method " +emailinputbox.getText());
		
		// login button 
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
    	System.out.println(	button.getAttribute("type"));
    	System.out.println(	button.getAttribute("class"));

    	System.out.println(button.getText());
		
	}

}
