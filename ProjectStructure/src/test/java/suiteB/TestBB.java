package suiteB;

import org.testng.annotations.Test;

import BaseTest.BaseTest;

public class TestBB extends BaseTest{
	@Test
	public void testBB() throws Exception {
		System.out.println("starting BB");
		Thread.sleep(2000);
		System.out.println("ending BB");
}
}
