package MyPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		// getWindowHandle()

		String windowId = driver.getWindowHandle();// returns id of the single browser window
		System.out.println(windowId);

		// getWindowHandles()

		driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();
		Set<String> windowIds = driver.getWindowHandles();// returns ID's of multiple browser windows

		// by using iterator
		/*
		 * Iterator<String> it = windowIds.iterator(); 
		 * String parentwindowid = it.next();
		 *  String childwindowid= it.next();
		 * System.out.println("parent window ID"+parentwindowid);
		 * System.out.println("child window ID"+childwindowid);
		 * 
		 */

		// by using arraylist

	/*	List<String> windowIDslist = new ArrayList(windowIds);// to convert set into list
		String parentwindowid = windowIDslist.get(0);
		String childwindowid = windowIDslist.get(1);
		System.out.println("parent window ID"+parentwindowid);
		 System.out.println("child window ID"+childwindowid);

		 
		 // how to window ID'S for switching
		 
		 driver.switchTo().window(parentwindowid );
		 System.out.println(driver.getTitle());
		 driver.switchTo().window(childwindowid);
		 System.out.println(driver.getTitle());
	*/
		
		 // by using for loop 
		  for (String winID:windowIds) {
			String title=   driver.switchTo().window(winID).getTitle();
			  System.out.println(title);
			  
		  }
		  driver.close();// closes single browser window
		  driver.quit();//
	}

}
