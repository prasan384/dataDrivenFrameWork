package suiteA;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import DataProvider.TESTdataprovider;

public class TestAA extends BaseTest{

	@Test(groups= {"sanity"},dataProviderClass= TESTdataprovider.class,dataProvider = "datasuiteA")
	public void testAA(String username, String password) throws Exception {
		System.out.println("starting AA");
		log("starting AA");
		Thread.sleep(2000);
		System.out.println("ending AA");
		log("ending AA");
		log(username+"-----"+password);
	}
}
