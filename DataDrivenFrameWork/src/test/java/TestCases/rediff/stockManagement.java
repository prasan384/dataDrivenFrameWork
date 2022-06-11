package TestCases.rediff;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import TestBase.BaseTest;

public class stockManagement extends BaseTest{
	
	


		 @Test
		public void addStock(ITestContext context) {
			 String date= "01-05-2022";
		    app.click("addstock_xpath");
			test.log(Status.INFO, context.getName());
			//.click("stockname_css");
			app.type("stockname_css", "ICICI Ltd");
			app.wait(2);
			app.clickEnterButton();
			//app.click("add_id");
			app.click("stockpurchasedate_xpath");
			app.wait(3);
			app.selectDateFromCalendar(date);
			app.type("addstockqnty_css","100");
			app.type("addstockprice_xpath", "200");
			app.click("addstockbutton_css");
			app.wait(5);    
		}
		
		@Test
		public void goToCompany() {
			String company =  "Reliance Inds.";
			//app.clickOnCompany(company);
			app.log("Successfully clicked on Reliance Industries"); 
		
		}
		
		@Test
		public void buyTheStock() {
			String date= "1-05-2023";
			String company=  "ICICI Bank";
			app.clickOnCompany(company);
			//app.quantitybeforeModification(company);
			app.buyTheStock(company);
			app.wait(2);
			app.log("Click on Buy Stocks");
			app.click("opencalendar_css");
			app.selectDateFromCalendar(date);
			app.wait(3);
			app.type("quantity_css","50");
			app.type("price_css","200" );
			app.click("submit_css");
			app.wait(3);
			
		}
		
		@Test
		public void quantityAfterModification() {
			String company=  "Reliance Inds.";
			app.quantitybeforeModification(company);
			app.log("Quantity AfterModification   ");
		}
		
		
		@Test
		public void sellTheStock() {
			String date= "1-05-2022";
			String company=  "Reliance Inds.";
			app.clickOnCompany(company);
			app.wait(2);
			app.sellTheStock(company);
			app.selectFromDown("selectionAction_xpath", "selli");
			app.wait(3);
			app.click("opencalendar_css");
			app.selectDateFromCalendar(date);
			app.wait(5);
			app.type("quantitysell_css", "quanitysell");
			app.type("sellprice_css", "sellingprice");
			app.click("submit_css");
			app.wait(3);
					
		}
		
		
		public void transactionHistory() {
			String company=  "Reliance Inds.";
			String com = "	22-AUG-22";
			app.wait(3);
			app.transaction(company);
			app.wait(2);
			app.click("transaction_css");
			app.transactionTable("trns_xpath", com);
			app.click("edit_css");
			app.wait(2);
		}
		
	
		
		
		
		
		
		
		
		
		
		
		
		

	
	
	
	@Test
	public void modifyStock() {
		System.out.println(" "  );

	
	}

	@Test
	public void verifyStockInList() {
		System.out.println(" "  );

	
	}
	@Test
	public void verifyQuantity() {
		System.out.println(" "  );

	
	}
	@Test
	public void verifyTransactionHistory() {
		System.out.println(" "  );

	
	}
}
