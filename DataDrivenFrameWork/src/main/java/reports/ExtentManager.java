package reports;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

    public class ExtentManager {
	public static ExtentReports extentReports;
	static ExtentTest extentTest;
	public static String ScreenshotsFolderPath;
	public static String filelocation;
	
	
	
	public static ExtentReports generateReports() {
		if(extentReports==null) {
			extentReports = new ExtentReports();
			Date d = new Date();
			String reportsFolder = d.toString().replaceAll(":", "-")+"//Screenshots";
			
			ScreenshotsFolderPath =System.getProperty("user.dir")+" //reports//"+reportsFolder;	//Screenshots Saving Folder
			String ReportsFolderPath = 	System.getProperty("user.dir")+"//reports//"+d.toString().replaceAll(":", "-");	//extentReports Saving Folder
			File file = new File(ScreenshotsFolderPath);
			file.mkdirs(); // to create dynamic reports folder name + screenshots
			ExtentSparkReporter spark = new ExtentSparkReporter(ReportsFolderPath);
			
			spark.config().setDocumentTitle("Extent Reports");
			spark.config().setReportName("Automation");
			spark.config().setTheme(Theme.DARK);
			extentReports.attachReporter(spark);
		}
		
		return extentReports;
		
	}
}


