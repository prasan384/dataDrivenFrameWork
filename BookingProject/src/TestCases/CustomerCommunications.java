package TestCases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CustomerCommunications {
	

	@Test
	public void checkEmail(ITestContext context) {
		
		String BookingID =	(String) context.getAttribute("BOOKING NUM");

		System.out.println("----   checking email for confirmation ----  " +BookingID );
	}
	

}
