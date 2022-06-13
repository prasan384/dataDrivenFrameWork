package TESTS.Groups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dataprovider { 
  @Test(dataProvider = "LoginTestData")
  public void Testlogin(String Username,String Password) throws Exception {
	  WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(Username);
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		driver.findElement(By.id("btnLogin")).click();
		Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
		Thread.sleep(5000);
		driver.quit();
  }
  
	 @DataProvider(name="LoginTestData")
	 public Object[][] LoginData (){
		 Object[][] data = new Object[2][2];
		 data[0][0]= "Admin";
		 data[0][1]="admin123";
		 data[1][0]="Admin";
		 data[1][1]="test123";
		return data; 
		 
	 }
}
