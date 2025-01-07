package com.Epicon.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListnerClass implements ITestListener {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void ConfigureReport() {
		
		
		String timestamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName="EpiconTestReport-"+ timestamp+".html";
		
		htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+reportName);
	    reports=new ExtentReports();
	    reports.attachReporter(htmlReporter);
	    
	    //Add system information/envirenment info to reports
	    reports.setSystemInfo("Machine", "Test1");
	    reports.setSystemInfo("OS", "Windows 11");
	    reports.setSystemInfo("browser", "chrome");
	    reports.setSystemInfo("User name", "Rahul Rathod");
	    
	    
	    htmlReporter.config().setDocumentTitle("ExtentListnerReportForEpicon");
	    htmlReporter.config().setReportName("This is My Epicon Test Report");
	    htmlReporter.config().setTheme(Theme.DARK);
	    
	}

	
	@Override
	public void onStart(ITestContext context) {
		ConfigureReport();
		System.out.println("On Start Method Envoke....");
	}
	
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Finish Method envoke.....");
		reports.flush();  // its mandetory to call flush method to ensure info witten to the started report
	}
	

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of test method Failed:"+ result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the Failed Test case is:"+ result.getName(), ExtentColor.RED));
		
		//Below code is for to capture SS 
		String screenShotpath=System.getProperty("user.dir")+"\\ScreenShots\\"+ result.getName()+ ".png";
		File screenShotFle=new File(screenShotpath);
		
		if(screenShotFle.exists()) {
			test.fail("CaptureScrennshot is below: "+ test.addScreenCaptureFromPath(screenShotpath));
		}
		
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of test method Skip:"+ result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skip Test case is:"+ result.getName(), ExtentColor.YELLOW));
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Name of the Test method Started:"+ result.getName());
	}


	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of test method Pass:"+ result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Pass Test case is:"+ result.getName(), ExtentColor.GREEN));
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	

}
