package MyPackage;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PermissionPopUpNotifications {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		HashMap<String,Object> contentsettings= new HashMap<String, Object>();
		HashMap<String,Object> profile = new HashMap<String, Object>();
		HashMap<String,Object> prefs = new HashMap<String, Object>();
		 contentsettings.put("notifications", 1);// 1---> allow
		                                         // 2----> block
		                                         // 0---> ask
		 
		 
		 profile.put("managed_default_content_settings", contentsettings);
		 prefs.put("profile",profile);
		 options.setExperimentalOption("prefs", prefs);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	//	options.addArguments("--disable-notifications");// to disable browser notifications
	//	options.addArguments("disable-geolocation");// to disable location permissions
	//	options.addArguments("disable-media-stream");// to diable microphone or camera permissions
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.redbus.in/");
		
	}

}
