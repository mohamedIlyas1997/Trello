package com.utilities;


import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager extends TestListeners implements ITestListener
{
	

	public static ExtentReports extent;
	
	
	public static ExtentReports createInstance() {
	
		
		ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter(System
				.getProperty("user.dir") + "/reports/Test-Report"+TimeStamp()+".html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent= new ExtentReports();
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Mohamed Ilyas");
		extent.attachReporter(htmlReporter);
	
		return extent;
		
	}
	
	
		
	

	}
	




