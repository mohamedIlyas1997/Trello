package com.utilities;

import java.io.IOException;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.base.Baseclass;





public class TestListeners extends Baseclass implements ITestListener {

	
	public ExtentTest test;
	public ExtentReports report;

	public static ExtentReports extent= ExtentManager.createInstance();
	public static ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();


	public void onTestStart(ITestResult result) {
	

		ExtentTest test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);

	}


	public void onTestSuccess(ITestResult result) {
		String logText="<b>Test Method " + result.getMethod().getMethodName() + " Successful</b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m); //get() access from thread local



	}


	public void onTestFailure(ITestResult result)  {

		String methodName= result.getMethod().getMethodName();
	//	String exceptiomessage=Arrays.toString(result.getThrowable().getStackTrace());
		
		extentTest.get().fail(result.getThrowable());



		try {
			//	String path = TakeScreenshot(Baseclass.driver, result.getMethod().getMethodName());
			extentTest.get().fail("<b><font color =red>" + "Screenshot of Failure" + "</font></b>",
			//		MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenshot(driver, result.getMethod()
			//				.getMethodName())).build());
			MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenshot(Baseclass.driver)).build());
		}
		catch (IOException exp) {
			exp.printStackTrace();
			extentTest.get().fail("Test failed, cannot attach screenshot");
		}

		String logText="<b>Test Method " + methodName + " Failed</b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m);

	}	



	public void onTestSkipped(ITestResult result) {
		String logText="<b>Test Method " + result.getMethod().getMethodName() + " Skipped</b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		extentTest.get().log(Status.SKIP, m); //get() access from thread local

	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}


	public void onStart(ITestContext context) {


	}


	public void onFinish(ITestContext context) {
		if (extent !=null) {
			extent.flush();		
		}

	}

	/*public String takeScreenshot(WebDriver driver , String methodName) {
		String fileName= getscreenshotName(methodName);
		String directory= System.getProperty("user.dir") + "\\Screenshots\\";
		new File(directory).mkdirs();
		String path= directory + fileName;

		try {
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyDirectory(screenshot, new File(path));
			System.out.println("**************");

			System.out.println("Screenshot stored at: " + path);
			System.out.println("**************");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}*/


	public static String getscreenshotName(String methodName) {
		Date d =new Date();
		String fileName= methodName + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
		return fileName;

	}

//	public static String TakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
//
//		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
//		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + TimeStamp() + ".png";
//		//	File finalDestination = new File(destination);
//		FileUtils.copyFile(source,  new File(destination));
//		return destination;
//	}






}
