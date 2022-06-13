package screenshots;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListner extends Testclass implements ITestListener{
	@Override
	public void onTestFailure(ITestResult result) {
		capturescreenshot(result.getMethod().getMethodName()+".jpg");
	    
	  }
}
