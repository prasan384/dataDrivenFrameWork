package Runner.custom;

import java.util.ArrayList;
import java.util.List;

public class RUNNER {
		public static void main(String[] args) {
			TestNGRunner runner = new TestNGRunner(1);
			runner.createSuite("Booking Suite", false);
			runner.addTest("CreateBookingTest-- Apply discount-pay@Hotel");
			runner.addParameters("action", "pay@Hotel");
			
			 List<String> addMethods = new ArrayList<String>();
			 addMethods.add("searchHotel");
			 addMethods.add("selectHotel");
			 addMethods.add("entetGuestInfo");
			 runner.addClasses("TestCases.BookingSearch", addMethods);
			 
			 addMethods = new ArrayList<String>();
			 addMethods.add("applyDiscount");
			 addMethods.add("makePayment");
			 runner.addClasses("TestCases.PaymentManager", addMethods);
			 
			 addMethods = new ArrayList<String>();
			 runner.addClasses("TestCases.CustomerCommunications", addMethods);


			 runner.run();
		}
	}


