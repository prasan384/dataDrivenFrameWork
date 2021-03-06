package KeyWords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

public class ApplicationKeywords extends ValidationKeywords{
	
	
	// to read properties file
	public ApplicationKeywords() throws IOException {
		String path = "C:\\Eclipse\\Automation\\javaforselinium\\DataDrivenFrameWork\\src\\test\\resources\\env.Properties";
		 
		prop = new Properties();
		 envprop = new Properties();
			try {
				FileInputStream fs = new FileInputStream(path);
	 			envprop.load(fs);
	 			String env = envprop.getProperty("env")+".Properties";
	 			path = "C:\\Eclipse\\Automation\\javaforselinium\\DataDrivenFrameWork\\src\\test\\resources\\"+env;
	 			fs = new FileInputStream(path);
	 			prop.load(fs);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
			softassert= new SoftAssert();
	}
	
	
	
	

	public void verifyStockAdded() {
		
	}
	public void setReport(ExtentTest test) {
		this.test= test;
	}

	 public int findCurentStockQuantity(String company) {
		int row = selectDataFromTable("stock_xpath",company);
		if(row==-1) {
			log("Data Not Found");
			return 0;
		}
			String data = driver.findElement(By.xpath(prop.getProperty("stock_xpath")+"//tr["+row+"]//td[4]")).getText();
			log("Stock Quantity  "+data);
			return Integer.parseInt(data);
	}
	
	public void clickOnCompany(String company) {
		action = new Actions(driver);
		int row = selectDataFromTable("stock_xpath", company);
		if(row==-1){
			log("Unable to click on the company");
		}
		WebElement click = driver.findElement(By.xpath("//table[@id='stock']//tr["+row+"]//td[1]"));
		action.moveToElement(click).click().perform();
		click.click(); 
	}  
	
	public void buyTheStock(String company) {
		log("Buy the stocks in Reliance Company");
		int row = selectDataFromTable("stock_xpath", company);
		//driver.findElement(By.xpath("//table[@id='stock']//tr["+row+"]//td[1]")).click();
		driver.findElement(By.xpath("//table[@id='stock']//tr["+row+"]//td//input[@name='Buy / Sell']")).click();
		wait(3);
	}
	
	public void quantitybeforeModification(String company) {
		log("Quantity before Modification");
		int row = selectDataFromTable("stock_xpath", company);
		String quantity = driver.findElement(By.xpath("//table[@id='stock']//tr["+row+"]//td[4]")).getText();
		log("Quantity  after entering into the row  "+quantity);
		//return Integer.parseInt(quantity);
	}
	
	public void sellTheStock(String company) {
		log("Sell the Stocks in Reliance Company");
		int row = selectDataFromTable("stock_xpath", company);
		driver.findElement(By.xpath("//table[@id=\"stock\"]//tr["+row+"]//td//input[@name='Buy / Sell']")).click();
		wait(2);

	}
	
	public void transaction(String company) {
		log("Click on Transaction History");
		action = new Actions(driver);
		int row = selectDataFromTable("stock_xpath", company);
		WebElement ele= driver.findElement(By.xpath("//table[@id=\"stock\"]//tr["+row+"]//td//input[@name='Transaction History']"));
		action.moveToElement(ele).click().perform();
		ele.click();
		wait(2);
	}
	
	public void transactionTable(String locator,String data) {
		int row= selectDataFromTable("trns_xpath", data);
		driver.findElement(By.xpath("//table[@class='dataTable']//tr["+row+"]//td[1]")).click();
		String select = driver.findElement(By.xpath("//table[@class='dataTable']//tr[\"+row+\"]//td[2]")).getText();
		log("Trasaction Date   "+select);
		wait(2);
	}
   
	
}
