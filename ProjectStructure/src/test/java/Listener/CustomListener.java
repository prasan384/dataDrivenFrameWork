package Listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class CustomListener implements ITestListener {

	public void onTestFailure(ITestResult result) {
		System.out.println("-----test failed----- ");
		System.out.println(" failed test name " + result.getName());
		System.out.println(result.getStatus());
		System.out.println(result.getThrowable().getMessage());// throws error message when test fails
		ExtentTest test = (ExtentTest) result.getAttribute("reporter");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("----test passed----");
		ExtentTest test = (ExtentTest) result.getAttribute("reporter");
          test.log(Status.PASS, "test passed"+result.getName());

	}
}