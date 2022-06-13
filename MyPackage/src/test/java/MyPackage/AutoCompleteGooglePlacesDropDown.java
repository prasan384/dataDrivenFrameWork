package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteGooglePlacesDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		 driver.get("https://www.twoplugs.com/");
		 driver.manage().window().maximize();
		 driver.findElement(By.xpath("//nav[@class='nav navbar-nav']//ul/li[2]//a")).click();
		 
		 WebElement searchbox= driver.findElement(By.id("autocomplete"));
		 searchbox.clear();
		 searchbox.sendKeys("Toronto");
		  String text;
		  do {
			  searchbox.sendKeys(Keys.ARROW_DOWN);
			text=  searchbox.getAttribute("value");
			  if(text.equals("Toronto, OH, USA")) {
				  searchbox.sendKeys(Keys.ENTER);
				  break;
				  
			  }
			 
		  }while(!text.isEmpty());

	}
}
