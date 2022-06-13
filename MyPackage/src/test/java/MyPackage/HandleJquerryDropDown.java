package MyPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.domstorage.model.Item;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleJquerryDropDown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.xpath(" //input[@id='justAnInputBox'")).click();
		
		//selectchoicevalues(driver,"choice1")
		
		//selectchoicevalues(driver,"choice1","choice2","choice 1 2")
		
		//selectchoicevalues(driver,"all")

		
		
		
	}
 
	public static void selectchoicevalues(WebDriver driver,String...value){
		List <WebElement> choicelist= driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		
		if(!value[0].equalsIgnoreCase("all")) {
			for(WebElement choice:choicelist) {
				String text= choice.getText();
				for(String val :value) {
					if(text.equals(val)){
					choice.click();
					break;
						
					}
				}
			}
		}
		else {
		      for(WebElement choice:choicelist) {
		    	  choice.click();
		    	  
		      }
		}
	}
}
