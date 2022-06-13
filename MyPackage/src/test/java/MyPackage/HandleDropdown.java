package MyPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.opencart.com/index.php?route=account/register");
		WebElement drpcountryele = driver.findElement(By.id("input-country"));

		// we have to create object for "select class "

		Select drpcountry = new Select(drpcountryele);
		// now we have to select the web element option from the select class
		// method 1
		// drpcountry.selectByVisibleText("Brazil");
		// method 2
		// drpcountry.selectByValue("30");
		// method3
		// drpcountry.selectByIndex(30);// index is imaginary , it is not visible but
		// firstoption in dropdown will have
		// zeroth index and soo on
		// method 4--> we can select the dropbox option by using FOR LOOP

		List<WebElement> alloptions = drpcountry.getOptions();
		for (WebElement option : alloptions) {
			if (option.getText().equals("cuba")) {
				option.click();
				break;
			}

		}

	}

}
