package com.Epicon.BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Baseclass {
public WebDriver driver;
	
	@BeforeClass
	public void Setup() {
		
		String path="C:\\Users\\Rahul\\eclipse-workspace\\Epicon\\Configuration\\config.properties";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahul\\Desktop\\ChromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		 driver=new ChromeDriver();
		
		driver.get("https://www.epicon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterClass
	public void TearDown() {
		
		driver.close();
		driver.quit();
	}
}
