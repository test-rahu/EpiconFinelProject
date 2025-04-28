package com.Epicon.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test4 {
	
	WebDriver driver;
	
	@Test
	public void openbrowser() {
	 driver =new ChromeDriver();
	 driver.get("Epicon.com");
		
	}
	

}
