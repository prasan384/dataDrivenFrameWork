package KeyWords;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import reports.ExtentManager;

public class GenericKeyWords {

	public WebDriver driver;
	public Properties prop;
	public Properties envprop;
	public ExtentTest test;
	public SoftAssert softassert;
	public Select select;
	public Alert alert;
	public String date;
	public Actions action;

	public void openBrowser(String browser) {
		log(" opening the browser " + browser);

		/*
		 * if (browser.equals("chrome")){
		 * 
		 * WebDriverManager.chromedriver().setup(); driver = (WebDriver) new
		 * ChromeDriver();
		 * 
		 * }else if ( browser.equals("firefox")){
		 * WebDriverManager.firefoxdriver().setup(); driver = (WebDriver)
		 * newFirefoxDriver();
		 * 
		 * }else if (browser.equals("edge")) { WebDriverManager.edgedriver().setup();
		 * driver = (WebDriver) new EdgeDriver();
		 */

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = (WebDriver) new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = (WebDriver) new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = (WebDriver) new EdgeDriver();
			break;
		default:
			System.out.println("Browsername is invalid");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	public void navigate(String urlkey) {
		log("navigating to url" + urlkey);

		driver.get(prop.getProperty(urlkey));
	}

	public void click(String Locatorkey) {
		log("clicking on locator" + Locatorkey);
		getelement(Locatorkey).click();

	}

	public void type(String Locatorkey, String data) {
		log("typing in " + Locatorkey + " data " + data);
		getelement(Locatorkey).sendKeys(data);

	}

	public void select(String Locator, String data) {

	}

	public void getText(String Locator) {

	}

	// central function to extract element
	public WebElement getelement(String Locatorkey) {

		// check presence of element

		if (!isElementPresent(Locatorkey)) {
			// report a failure
			test.log(Status.INFO, " element not present " + Locatorkey);
		}

		// check visibility of element

		if (!isElementVisible(Locatorkey)) {
			// report a failure
			test.log(Status.INFO, " element not visible " + Locatorkey);
		}
		WebElement e = driver.findElement(getLocator(Locatorkey));// calls get locator method
		return e;
	}

	// true--> element present
	// false ---> element not present
	public boolean isElementPresent(String Locatorkey) {
		test.log(Status.INFO, " checking presence of " + Locatorkey);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(Locatorkey)));

		} catch (Exception e) {
			return false;
		}
		return true;

	}
	// true--> visible
	// false ---> not visible

	public boolean isElementVisible(String Locatorkey) {
		test.log(Status.INFO, " checking visibility of " + Locatorkey);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(Locatorkey)));

		} catch (Exception e) {
			return false;
		}
		return true;

	}

	public By getLocator(String Locatorkey) {
		By by = null;
		if (Locatorkey.endsWith("_id"))
			by = By.id(prop.getProperty(Locatorkey));
		else if (Locatorkey.endsWith("_xpath"))
			by = By.xpath(prop.getProperty(Locatorkey));
		else if (Locatorkey.endsWith("_css"))
			by = By.cssSelector(prop.getProperty(Locatorkey));
		else if (Locatorkey.endsWith("_name"))
			by = By.name(prop.getProperty(Locatorkey));
		return by;

	}

	public void log(String msg) {
		test.log(Status.INFO, msg);

	}

	public void reportFailure(String failureMsg, boolean stopOnFailure) {
		System.out.println(failureMsg);
		test.log(Status.FAIL, failureMsg);// failure in extent reports
		takeScreenshot();// puts screenshot in reports
		softassert.fail(failureMsg);// failure in testng i.e execution

		if (stopOnFailure)// if failure is critical it should stop execution
			Reporter.getCurrentTestResult().getTestContext().setAttribute("criticalFailure", "Y");

			assertAll();
	}

	public void assertAll() {

		softassert.assertAll();
	}

	public void takeScreenshot()  {
        // file name of screen shot (with date )
		Date d = new Date();
		String screenshotFile = d.toString().replaceAll(":", "-")+".jpg";
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		
		// to take screenshot
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String path = ExtentManager.ScreenshotsFolderPath+"//"+screenshotFile;
 	    File file = new File(path);
		
		try {
			
		// get a dynamic folder name 
			FileUtils.copyFile(src, file);// to copy the screen shot ie src to a folder in specified path
			
			// put screenshot file in reports
 			test.log(Status.INFO, "Screenshot--> "+test.addScreenCaptureFromPath(path));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void waitForPageLoad() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i =0;
		while(i!=10) {
			String ajaxStatus = (String) js.executeScript("return document.readyState;");
			if(ajaxStatus.equals("complete")) {
				break;
			}else {
				wait(2);
			}
			i++;
		}
		i=0;
		while(i!=10) {
			Long jQueryStatus = (Long) js.executeScript("return jQuery.active;");
			if(jQueryStatus.longValue()==0) {
				break;
			}else {
				wait(2);
			}
			i++;
		}
		
	}
	public void clear(String locator) {
		getelement(locator).clear();
	}
	public void wait(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickEnterButton() {
		
		 action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		
	}
		public void selectFromDown(String locator, String option) {
			
			select = new Select(getelement(locator));
			select.selectByVisibleText(prop.getProperty(option));
			
			
		}
		
		public void selectValueInDropDown(String locator) {
			select = new Select(getelement(locator));
			select.getFirstSelectedOption().getText();
		}
		
		public void acceptAlert() {
			alert = driver.switchTo().alert();
			alert.accept();
		
		}
		
		public void selectDateFromCalendar(String date) {
			Date d = new Date();
			try {
				Date sdf = new SimpleDateFormat("dd-MM-yyyy").parse(date);
				String day = new SimpleDateFormat("dd").format(sdf);
				String month = new SimpleDateFormat("MMMM").format(sdf);
				String year = new SimpleDateFormat("yyyy").format(sdf);
				String monthyear = month+" "+year;
				String displayedMonth = getelement("monthyear_css").getText();
				while(!monthyear.equals(displayedMonth)) {
					click("forward_xpath");
					displayedMonth= getelement("monthyear_css").getText();
				}
				WebElement e =  driver.findElement(By.xpath("//td[text()='"+day+"']"));
				wait(3);
				e.click();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		public int selectDataFromTable(String locator, String data) {
			WebElement table = driver.findElement(getLocator(locator));
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			for(int row=0;row<rows.size();row++) {
				WebElement rnum = rows.get(row);
				List<WebElement> cells = rnum.findElements(By.tagName("td"));
				for(int col=0; col<cells.size();col++) {
					WebElement cell= cells.get(col);
					if(!cell.getText().trim().equals(" ")) 
						if(data.startsWith(cell.getText())) 
							return (row+1);
				}
			}
			return -1;
			
		}
		
	}
	
	


	
