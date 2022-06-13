package MyPackage;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLink {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.deadlinkcity.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));

		int brokenLinks = 0;
		for (WebElement element : links) {

			String url = element.getAttribute("href");
			if (url == null || url.isEmpty()) {
				System.out.println("url is empty");
				continue;
			}
			URL link = new URL(url);
			try {
				HttpURLConnection httpcon = (HttpURLConnection) link.openConnection();
				httpcon.connect();
				if (httpcon.getResponseCode() >= 400) {
					System.out.println(httpcon.getResponseCode() + url + " is " + " broken link ");
					brokenLinks++;

				} else {
					System.out.println(httpcon.getResponseCode() + url + " is  valid link");
				}
			}

			catch (Exception e) {

			}
		}

	}

}
