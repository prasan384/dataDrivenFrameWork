package MyPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_CheckBox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://itera-qa.azurewebsites.net/home/automation");

		//1) select specific checkbox
		// driver.findElement(By.xpath(" //input[@id='monday']")).click();// monday
		
		
		

		//2) select all the checkboxes
		List<WebElement> checkboxes = driver
				.findElements(By.xpath("//input[@type='checkbox'and contains (@id,'day')]"));

		System.out.println("total no of checkboxes" + checkboxes.size());

		/*
		 * for (int i = 0; i <= checkboxes.size(); i++) { checkboxes.get(i).click();
		 * 
		 * }
		 */

		/*for (WebElement chkbox : checkboxes) {
			chkbox.click();

		}*/
		
		

		//3) to select monday and sunday

	/*	for (WebElement chkbox : checkboxes) {

			String checkboxname = chkbox.getAttribute("id");
			if (checkboxname.equals("monday") || checkboxname.equals("sunday")) {
				chkbox.click();
			}
		}*/
		
		
		
		// 4) select last two checkboxes
		
		// total no of checkboxes- no of checkboxes want to select = starting index
		// 7-2=5
	/*	int totalcheckboxes= checkboxes.size();
		for(int i= totalcheckboxes-2;i<checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}*/
		
		
		
		// 5) select first two checkboxes
		
		for(int i =0;i<checkboxes.size();i++) {
			if(i<2) {
				checkboxes.get(i).click();
			}
		}

	}
	

}
