package MyPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();

		String year = "2022";
		String month = "july";
		String date = "10";
		driver.findElement(By.xpath(
				"//body/section[@id='rh_main']/div[@id='mBWrapper']/main[1]/section[1]/div[1]/div[2]/section[1]/div[1]/div[3]/span[1]"))
				.click();// opens date picker

		while (true) {
			String monthyear = driver
					.findElement(By.xpath("//body/div[@id='rb-calendar_onward_cal']/table[1]//td[@class='monthTitle']"))
					.getText();
			String arr[] = monthyear.split(" ");
			if (arr[0].equalsIgnoreCase(month) && arr[1].equalsIgnoreCase(year))
				break;
			else
				driver.findElement(By.xpath("//body/div[@id='rb-calendar_onward_cal']/table[1]//td[@class='next']"))
						.click();

		}

		// date selection

		List<WebElement> alldates = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']//tr/td"));

		for (WebElement ele : alldates) {
			String dt = ele.getText();
			if (dt.equals(date)) {
				ele.click();
				break;
			}

		}

	}

}
