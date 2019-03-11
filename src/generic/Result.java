package generic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Result implements ITestListener{

	public static int pass=0,fail=0;
	public void onFinish(ITestContext arg0) {
		Reporter.log("Actitime tested successfully");
		
	}

	public void onStart(ITestContext arg0) {
		Reporter.log("Testing actitime application.....");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	public void onTestFailure(ITestResult arg0) {
		
		fail++;
	}

	public void onTestSkipped(ITestResult arg0) {
		
		
	}

	public void onTestStart(ITestResult arg0) {
		
		
	}

	public void onTestSuccess(ITestResult arg0) {
		pass++;
		
	}

}
