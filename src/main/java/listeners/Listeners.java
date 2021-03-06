package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import library.Base;

public class Listeners implements ITestListener{
	
	public static ExtentReports report = new ExtentReports(".\\report\\ExtentReports.html");
	public static ExtentTest logger;
	
	@Override
	public void onTestStart(ITestResult result) {
		logger = report.startTest("Test "+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.log(LogStatus.PASS, result.getName());
		report.endTest(logger);
		report.flush();	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//String screenShotPath = Base.getScreenShot(result.getTestClass().getName()+"_"+result.getName());
		String screenShotPath = Base.getScreenShotBase64();
		logger.log(LogStatus.FAIL, result.getName()+" Failed", logger.addScreenCapture(screenShotPath));
		report.endTest(logger);
		report.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

}
