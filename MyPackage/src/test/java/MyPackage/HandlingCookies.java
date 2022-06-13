package MyPackage;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		// how to capture cookies from browser
		Set<Cookie> cookies= driver.manage().getCookies();
		System.out.println("size of cookies" + cookies.size());
		
		// how to print cookies from browser
		
		for( Cookie cookie:cookies) {
			System.out.println("name of cookies" + cookie.getName());
			System.out.println("value of cookies" + cookie.getValue());

			// how to add cookie to browser
			Cookie cokieobj= new Cookie("mycookie","12345");// have to give name and value of the cookie
			driver.manage().addCookie(cokieobj);
			Set<Cookie> cookies1= driver.manage().getCookies();
			System.out.println("size of cookies" + cookies1.size());
			
			// delete a specific cookie
		//	driver.manage().deleteCookie(cokieobj);// have to pass cookie object which should be deleted
			driver.manage().getCookieNamed("mycookie");
			
			// delete all cookies 
			 driver.manage().deleteAllCookies();
			
			driver.quit();
			
		}
		

	}

}
