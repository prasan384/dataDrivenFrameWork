package suiteC;

import org.testng.annotations.Test;

import BaseTest.BaseTest;

public class TestCC extends BaseTest {
	@Test(groups = { "unit ,sanity" })
	public void testCC() throws Exception {
		System.out.println("starting CC");
		Thread.sleep(2000);
		System.out.println("ending CC");
	}
}
