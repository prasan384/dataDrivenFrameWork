package TestCases;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PaymentManager {
	
	@Parameters({"action"})
	@Test
	public void makePayment(String paymentType,ITestContext context ) {
		if(paymentType.equals("instantPay"))
			
		System.out.println(" making instant payment");
		else 
			System.out.println("pay@Hotel Booking");
		
		// booking NUMBER
		String bookingID= "abcd1234";
		context.setAttribute("BOOKING NUM", bookingID);
	}
	
	@Test
	public void applyDiscount() {
		System.out.println(" applying discount");
	}
	


}
