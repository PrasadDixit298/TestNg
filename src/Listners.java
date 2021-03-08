import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class Listners implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" test has Sucessfully tested *****");
	}

	@Override
	public void onTestFailure(ITestResult result) {

    	System.out.println("***** Error "+result.getName()+" test has failed *****");
		TakesScreenshot ts = (TakesScreenshot)Automationpractice.driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"/screenshot/AutomationPractice.com"+result.getName()+".jpg");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName()+" test has Skipped *****");
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
	System.out.println("Testing STArted");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Testing finish");
	}


}
