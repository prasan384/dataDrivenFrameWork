package suiteA;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import BaseTest.BaseTest;
import DataProvider.TESTdataprovider;

public class TestA extends BaseTest {

	@Test(groups= {"sanity"},dataProviderClass= TESTdataprovider.class,dataProvider = "datasuiteA")
	public void testA(String username, String password) throws Exception {
		System.out.println("starting A");
		log("starting A");// we can directly pass msg, bcz we have created a method to pass msg in base
							// test class
		if (!"title1".equals("title"))
			softassert("Titles do not match");// softassert method in basetest
		if (!"text1".equals("text"))
			softassert("text do not match");
	//softassert.assertEquals("title1", "title");
    //softassert.assertEquals("text1", "text");
	//if assert fails listener will be called.
		Thread.sleep(2000);
		System.out.println("ending A");
		log( "ending A");
		log(username+"-----"+password);
		softassert.assertAll();

	}

}
