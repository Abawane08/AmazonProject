package listeners;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Utils.BaseClass;



public class ListenerTest extends BaseClass implements ITestListener{

	private static Logger logger = LogManager.getLogger(ListenerTest.class);
	
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		logger.debug("I am in onTestStart test folder named " + result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub		
		extentTest.log(Status.PASS, result.getMethod().getMethodName());
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\DELL\\eclipse-workspace\\AmazonAssignment\\test-output\\ScreenshotFolder\\AmazonProjectScreenshot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
		extentTest.log(Status.FAIL, result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.log(Status.SKIP, result.getMethod().getMethodName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		logger.debug("I am in onStart test folder named " + context.getName());
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		logger.debug("I am in onFinish test folder named " + context.getName());
		
	}

}
