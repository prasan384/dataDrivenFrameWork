package MyPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropdowns {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	    driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
	  WebElement noofemply=   driver.findElement(By.name("NoOfEmployees"));
	  selectoptionfromdropdown(noofemply,"16-20" );
	  
	  
	   WebElement industryele=  driver.findElement(By.name("Industry"));
	  selectoptionfromdropdown(industryele,"Healthcare");
	  
	  WebElement countryele=  driver.findElement(By.name("Country"));
	  selectoptionfromdropdown(countryele,"Brazil");

	    
	    

	}
	
	public static void selectoptionfromdropdown(WebElement ele, String value ) {
		
		Select drp = new Select (ele);
		List<WebElement> alloptions = drp.getOptions();
		for (WebElement option : alloptions) {
			if (option.getText().equals("value")) {
				option.click();
				break;
			}

		}
		
	}

}

