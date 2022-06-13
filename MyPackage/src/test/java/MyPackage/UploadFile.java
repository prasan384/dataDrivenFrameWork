package MyPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.monsterindia.com/");
		
		driver.manage().window().maximize();
		 driver.findElement(By.xpath("//a[@class='btn block resume-btn btn-orange mt20']")).click();
		 
		 // using send keys
		 
		// driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\Hp\\OneDrive\\Desktop\\sachivalayam");
		
		 
		 // by using robot class method
		 
		WebElement button= driver.findElement(By.xpath("//input[@id='file-upload']"));   
		
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click;", button );// normal click function doesnt work
	
/*
	1) copy the path
	2)ctrl +v
	3)enter
	
 */
	
	Robot rb = new Robot();
	rb.delay(2000);
	
	// to put path of file to clipboard
	StringSelection ss = new StringSelection("C:\\Users\\Hp\\OneDrive\\Desktop\\sachivalayam\\vamsi8.pdf");
	
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	
	// CTRL+V
	rb.keyPress(KeyEvent.VK_CONTROL);// TO press ctrl key
	rb.keyPress(KeyEvent.VK_V);      // TO press 'v' key
	
	
	rb.keyRelease(KeyEvent.VK_CONTROL); // to release ctrl key
	rb.keyRelease(KeyEvent.VK_V);
	
	
	rb.keyPress(KeyEvent.VK_ENTER);
	rb.keyRelease(KeyEvent.VK_ENTER);


	}

}
