package ExtentReportsAndScreenShots;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverBase {
	 public static WebDriver   driver;
	public static ExtentReports reporting;
	public static  ExtentTest t;

	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static String  generateScreenshots( String name )  {

		Date d = new Date();
		String filelocation = d.toString().replaceAll(":", "-")+"//"+name+".jpg";
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String path = ExtentReportsGeneration.reports+"//"+filelocation;
		File des = new File(path);
		
		try {
			FileUtils.copyFile(src, des);
 			t.log(Status.INFO, "Screenshot--> "+t.addScreenCaptureFromPath(path));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	return path;

	}

}
