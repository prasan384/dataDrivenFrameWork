package MyPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		 driver.get("https://www.hdfcbank.com/");
		 
		 // product type
		 driver.findElement(By.xpath("//div[@class='drp1']/div[@class='dropdown']")).click();
		 List<WebElement> producttypes = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']"));
		 System.out.println("no of options "+ producttypes.size());
		 
		 for (WebElement ptype : producttypes) {
			 if(ptype.getText().equals("accounts"));
			 ptype.click();
			 break;
			 
		 }
		 // select product
		  driver.findElement(By.xpath("//div[@class='drp2']/div[@class='dropdown']")).click();
		 List<WebElement> products= driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));
		 System.out.println("no of products "+products.size());
		 
		 for(WebElement product:products) {
			 
			 if (product.getText().equals("Salary Accounts"))
				 product.click();
				 break;
		 }
		  
			 
		 

	}

}
