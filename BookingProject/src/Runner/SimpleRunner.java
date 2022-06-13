package Runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

public class SimpleRunner {
	public static void main(String[] args) {
		TestNG testng = new TestNG();

		// suite
		XmlSuite mySuite = new XmlSuite();
		mySuite.setParallel(ParallelMode.TESTS);// to run tests parallely
		mySuite.setName(" Booking Suite");
		List<XmlSuite> allSuites = new ArrayList<XmlSuite>();
		allSuites.add(mySuite);// adding mysuite to list of suites(allsuites)

		testng.setXmlSuites(allSuites);// testNG has list<xmlsuite>

		// test-1
		XmlTest createBookingTest = new XmlTest(mySuite); // creating object for xmltest and passing suite object to it
		createBookingTest.setName("CreateBookingTest-- Apply discount-pay@Hotel");

		// parameters
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("action", "pay@Hotel");
		createBookingTest.setParameters(parameters);

		// classes
		List<XmlClass> testclasses = new ArrayList<XmlClass>();// creating object for xmlclass
		
		
		//adding 1st testclass
		XmlClass testClass = new XmlClass("TestCases.BookingSearch");
		
		
		// methods
		List<XmlInclude> testMethods = new ArrayList<XmlInclude>();// creating object for xml method
		testMethods.add(new XmlInclude("searchHotel",1));
		testMethods.add(new XmlInclude("selectHotel",2));
		testMethods.add(new XmlInclude("entetGuestInfo",3));
		testClass.setIncludedMethods(testMethods);// including methods to testclass
		testclasses.add(testClass);// including testclass to list of classes(testclasses)
		
		
		// adding 2nd testclass
		testClass = new XmlClass("TestCases.PaymentManager");
	    testMethods = new ArrayList<XmlInclude>();// creating object for xml method
		testMethods.add(new XmlInclude("applyDiscount",1));
		testMethods.add(new XmlInclude("makePayment",2));
		testClass.setIncludedMethods(testMethods);// including methods to testclass
		testclasses.add(testClass);// including testclass to list of classes(testclasses)
		
		//adding3rd testclass
		testClass = new XmlClass("TestCases.CustomerCommunications");// methods are not inclided bcz it has only one method 
		
		createBookingTest.setClasses(testclasses);// adding list of classes(allclasses) to a test(createbookingtest)
		 
		
		// test-2
		XmlTest cbnd = new XmlTest(mySuite); // creating object for xmltest and passing suite object to it
		cbnd .setName("CreateBookingTest-- no discount-pay@Hotel");

		// parameters
		Map<String, String> parameterscbnd  = new HashMap<String, String>();
		parameterscbnd .put("action", "pay@Hotel");
		cbnd .setParameters(parameterscbnd );

		// classes
		List<XmlClass> testclasses_cbnd  = new ArrayList<XmlClass>();// creating object for xmlclass
		
		
		//adding 1st testclass
		XmlClass testClass_cbnd  = new XmlClass("TestCases.BookingSearch");
		
		
		// methods
		List<XmlInclude> testMethods_cbnd  = new ArrayList<XmlInclude>();// creating object for xml method
		testMethods_cbnd.add(new XmlInclude("searchHotel",1));
		testMethods_cbnd.add(new XmlInclude("selectHotel",2));
		testMethods_cbnd.add(new XmlInclude("entetGuestInfo",3));
		testClass_cbnd.setIncludedMethods(testMethods_cbnd);// including methods to testclass
		testclasses_cbnd.add(testClass_cbnd);// including testclass to list of classes(testclasses)
		
		
		// adding 2nd testclass
		testClass_cbnd = new XmlClass("TestCases.PaymentManager");
		testMethods_cbnd = new ArrayList<XmlInclude>();// creating object for xml method
		testMethods_cbnd.add(new XmlInclude("makePayment",2));
		testClass_cbnd.setIncludedMethods(testMethods_cbnd);// including methods to testclass
		testclasses_cbnd.add(testClass_cbnd);// including testclass to list of classes(testclasses)
		
		//adding3rd testclass
		testClass_cbnd = new XmlClass("TestCases.CustomerCommunications");// methods are not inclided bcz it has only one method 
		
		cbnd.setClasses(testclasses_cbnd);// adding list of classes(allclasses) to a test(createbookingtest)
		 
		
		testng.run();

	}
}