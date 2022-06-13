package MyPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaAllerts {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		 
	/*	// alert window with 'ok' button
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
	     Thread.sleep(3000);
		driver.switchTo().alert().accept();  */
		
		// alert window with OK and CANCEL button
		
	/*	driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		Thread.sleep(3000);
		//driver.switchTo().alert().accept();// close alert with ok button
		driver.switchTo().alert().dismiss();//close with cancel button            */
		
		// alert window with INPUTBOX,OK and CANCEL buttons
		
		driver.findElement(By.xpath(" //button[contains(text(),'Click for JS Prompt')]")).click();
		Thread.sleep(3000);
		Alert alertwindow= driver.switchTo().alert();
		
		System.out.println("display msg on alert window " + alertwindow.getText());
		
		alertwindow.sendKeys("welcome");
		
		alertwindow.accept();
		

	}

}
