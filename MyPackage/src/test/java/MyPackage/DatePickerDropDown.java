package MyPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='dob']")).click();// opens date picker

		WebElement mon = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//select[1]"));
		Select drpmon = new Select(mon);
		drpmon.selectByVisibleText("Jul");
		Select drpyear = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		drpyear.selectByVisibleText("1992");

		
		// date selection
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for (WebElement date : alldates) {
			String dt = date.getText();
			if (dt.equalsIgnoreCase("6")) {
				date.click();
				break;

			}
		}
	}

}
