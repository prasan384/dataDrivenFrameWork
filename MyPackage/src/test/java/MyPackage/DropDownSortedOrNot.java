package MyPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSortedOrNot {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.twoplugs.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Live Posting')]")).click();
		WebElement drpelement= driver.findElement(By.id("category_id"));
		Select drpselect = new Select (drpelement);
	List<WebElement> options =	drpselect.getOptions(); 
	 
	ArrayList originallist= new ArrayList();
	ArrayList templist= new ArrayList();
	
	for(WebElement option : options) {
		originallist.add(option.getText());
		templist.add(option.getText());
		
	}
		Collections.sort(templist);
		if(originallist.equals(templist)) {
			System.out.println("dropdownsorted");
		}
		else {
			System.out.println("dropdown not sorted");
			
		}
		

	}

}
