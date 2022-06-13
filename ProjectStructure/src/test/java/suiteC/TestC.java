package suiteC;

import org.testng.annotations.Test;

import BaseTest.BaseTest;

public class TestC extends BaseTest {
	@Test(groups= {"regression,smoke"})
	public void testC() throws Exception {
		System.out.println("starting C");
		Thread.sleep(2000);
		System.out.println("ending C");
}
}
