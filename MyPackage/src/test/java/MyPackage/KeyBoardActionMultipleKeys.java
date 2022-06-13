package MyPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardActionMultipleKeys {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		WebElement input1 = driver.findElement(By.xpath(" //textarea[@id='inputText1']"));
		input1.sendKeys("welcome to selenium");
		WebElement input2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));

		Actions action = new Actions(driver);
		

		// control + A ---> to select text
		action.keyDown(Keys.CONTROL);// to hold control key
		action.sendKeys("a");
		action.keyUp(Keys.CONTROL);
		action.perform();

		// control+C ----> to copy selected text
		action.keyDown(Keys.CONTROL);// to hold control key
		action.sendKeys("c");
		action.keyUp(Keys.CONTROL);
		action.perform();

		// tab---> to shift to input2 box
		action.sendKeys(Keys.TAB).perform();

		// control +v----> to paste text
		action.keyDown(Keys.CONTROL);// to hold control key
		action.sendKeys("v");
		action.keyUp(Keys.CONTROL);
		action.perform();

		if (input1.getAttribute("value").equals(input2.getAttribute("value")))
			System.out.println(" text coppied");
		else
			System.out.println(" text  not coppied");

	}

}
