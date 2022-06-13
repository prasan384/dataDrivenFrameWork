package MyPackage;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadPdfFile {

	public static void main(String[] args) {

		String location = System.getProperty("user.dir") + "\\Downloads\\"; // 1) location
		// chrome

		HashMap preferences = new HashMap(); // 2) set preferences
		preferences.put("plugins.always_open_pdf_externally", true);// for pdf download // key- location name, value-
																	// location
		preferences.put("download.default_directory", location); // in hashmap

		/*
		 * ChromeOptions options = new ChromeOptions(); // passing preferences in chrome
		 * options options.setExperimentalOption("prefs", preferences);
		 * 
		 * 
		 * WebDriverManager.chromedriver().setup(); //3) passing options to webbrowser
		 * WebDriver driver = new ChromeDriver(options); driver.get(
		 * "https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/"
		 * ); driver.manage().window().maximize();
		 */

		// edge browser

		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-notifications");// to disable browser notifications

		WebDriverManager.edgedriver().setup(); // passing options to webbrowser
		WebDriver driver = new EdgeDriver(options);
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		driver.manage().window().maximize();

		/*
		 * // firefox browser
		 * 
		 * FirefoxProfile profile= new FirefoxProfile();
		 * profile.setPreference("pdfjs.disabled",true);// only for pdf
		 * profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
		 * "application/pdf"); // we have to specify mime type of file we want to
		 * download profile.setPreference("browser.download.folderList", 2); //0-
		 * desktop //1-downloads //2-specified location
		 * profile.setPreference("browser.download.dir", location);
		 * 
		 * 
		 * FirefoxOptions options = new FirefoxOptions(); options.setProfile(profile);
		 * 
		 * WebDriverManager.firefoxdriver().setup(); // passing options to webbrowser
		 * WebDriver driver = new FirefoxDriver(options); driver.get(
		 * "https://file-examples.com/index.php/sample-documents-download/sample-doc-download/"
		 * ); driver.manage().window().maximize();
		 */

		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();

	}

}
