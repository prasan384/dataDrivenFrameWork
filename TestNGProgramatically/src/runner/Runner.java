package runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Runner {

	public static void main(String[] args) {
		TestNG testng = new TestNG();

		XmlSuite mySuite = new XmlSuite();// creating object for xml suite
		mySuite.setName(" MY Suite");
		List<XmlSuite> allSuites = new ArrayList<XmlSuite>();
		allSuites.add(mySuite);
		
		
		testng.setXmlSuites(allSuites);// testNG has list<xmlsuite>

		XmlTest mytest = new XmlTest(mySuite); // creating object for xmltest and passing suite object to it 
		mytest.setName("Login Test");

		List<XmlClass> allclasses = new ArrayList<XmlClass>();// creating object for xmlclass
		allclasses.add(new XmlClass("TestCases.Login"));
		mytest.setClasses(allclasses);// passing all classes to xmltest object
		
		testng.run();

		
	
	}

}
