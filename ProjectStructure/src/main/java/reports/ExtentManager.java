package reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	static ExtentReports reports;

	public static ExtentReports getReports() {
		if (reports == null) {
			// reports object is for generation of reports
			reports = new ExtentReports();
			Date d = new Date();
			System.out.println(d.toString().replaceAll(":", "-"));
			
			String reportsfolder = d.toString().replaceAll(":", "-")+"//ScreenShots//";
			String reportsfolderpath = System.getProperty("user.dir")+"//reports//"+reportsfolder;
			String ScreenShotfolderpath = System.getProperty("user.dir")+"//reports//"+ d.toString().replaceAll(":", "-")+"//ScreenShots";

			File f = new File (ScreenShotfolderpath);
		    f.mkdirs();
			
			
			// reporter object is used to format the reports
			ExtentSparkReporter sparkreporter = new ExtentSparkReporter(reportsfolderpath);
			sparkreporter.config().setReportName("production regereesion testing");
			sparkreporter.config().setDocumentTitle("automation reports");
			sparkreporter.config().setTheme(Theme.DARK);
			sparkreporter.config().setEncoding("utf-8");

			reports.attachReporter(sparkreporter);

		}
		return reports;
	}

}
