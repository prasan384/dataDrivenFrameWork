package suiteB;

import org.testng.annotations.Test;

import BaseTest.BaseTest;

public class TestB extends BaseTest {
	@Test(groups= {"regression"})
	public void testB() throws Exception {
		System.out.println("starting B");
		Thread.sleep(2000);
		System.out.println("ending B");
}
}
