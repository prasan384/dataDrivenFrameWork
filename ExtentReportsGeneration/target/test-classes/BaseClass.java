
public class BaseClass {
 public ExtentReports report;
	public ExtentTest test;
	
	
	
	//public ApplicationKeyword application; 
	
	@BeforeTest(alwaysRun = true)
	public void beforeTest(ITestContext context ) {
		System.out.println("----------Before Test----------");
		application = new ApplicationKeyword();
		 context.setAttribute("app", application);
		 report = ExtentManager.generateReports();
		 test = report.createTest(context.getCurrentXmlTest().getName());
		 test.log(Status.INFO, "Starting the  "+context.getCurrentXmlTest().getName());
		 application.setReport(test);
		 context.setAttribute("rep", report);
		 context.setAttribute("tests", test);
		 
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(ITestContext context) {
		System.out.println("****Before Method***");
		
		//application = (ApplicationKeyword) context.getAttribute("app");	
		report = (ExtentReports) context.getAttribute("rep");
		test = (ExtentTest) context.getAttribute("tests");
		
		String critical = (String)context.getAttribute("crtiticalfailure");
		if(critical !=null && critical.equals("Y")) {
			test.log(Status.SKIP, "Skipped");
			throw new SkipException("Skipped Exception");
		
		}
	}
	
	@AfterTest
	public void afterTest() {
		if(report!=null)
			report.flush();

	}
	
	
	@AfterSuite
	public void afterSuite() {
		GenericKeyword.quit();
	}
	
}

}
