package ExtentReportsAndScreenShots;

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

    public class ExtentReportsGeneration {
	public static ExtentReports extentReports;
	static ExtentTest extentTest;
	public static String reports;
	public static String filelocation;
	
	
	
	public static ExtentReports generateReports() {
		if(extentReports==null) {
			extentReports = new ExtentReports();
			Date d = new Date();
			String reportsFolder = d.toString().replaceAll(":", "-")+"//Screenshots";
			
			reports = "C:\\Eclipse\\Automation\\javaforselinium\\MyPackage\\Reports\\"+reportsFolder;	//Screenshots Saving Folder
			String path = 	"C:\\Eclipse\\Automation\\javaforselinium\\MyPackage\\Reports\\"+d.toString().replaceAll(":", "-");	//extentReports Saving Folder
			File file = new File(reports);
			file.mkdirs();
			ExtentSparkReporter spark = new ExtentSparkReporter(path);
			
			spark.config().setDocumentTitle("Extent Reports");
			spark.config().setReportName("Automation");
			spark.config().setTheme(Theme.DARK);
			extentReports.attachReporter(spark);
		}
		
		return extentReports;
		
	}
	
	
	
	/*public static String  generateScreenshots( String name )  {

		Date d = new Date();
		String filelocation = d.toString().replaceAll(":", "-")+"//"+name+".jpg";
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String path = ExtentReportsGeneration.reports+"//"+filelocation;
		File des = new File(path);
		
		try {
			FileUtils.copyFile(src, des);
			extentTest.log(Status.INFO, "Screenshot--> "+extentTest.addScreenCaptureFromPath(path));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	return path; */

//	}
}


