package com.Epicon.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Epicon.Utilities.ReadConfig;

public class Baseclass extends ReadConfig {
public WebDriver driver;

ReadConfig read=new ReadConfig();
String URL=read.getBaseURL();
String uname=read.getUserName();
String pass=read.getPass();
String Browser=read.getBrowserL();
public static Logger logger =LogManager.getLogger("EpiconFinel");

	@BeforeClass
	public void Setup() {	
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahul\\eclipse-workspace\\EpiconFinal\\drivers\\chromedriver.exe");
		
		switch(Browser.toLowerCase()) {
		
		case "chrome":
			driver=new ChromeDriver();
			break;
			
		case "edge":
			driver=new EdgeDriver();
			break;
			
		case "firefox":
			driver=new FirefoxDriver();
			break;
			
		default:
			driver=null;
			break;
		}
		 //driver=new ChromeDriver();
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterClass
	public void TearDown() {
		
		driver.close();
		driver.quit();
	}
	
	
	
	
	public void captureScreenShot(WebDriver driver, String testName) throws IOException {
		//convert webdriver object to Takesscreenshot interface
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		
		//call getsScreenshot method to create image file
		
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+ "//Screenshots//"+testName + ".png");
		
		FileUtils.copyFile(src, dest);
	
		
	}
	
	
}
