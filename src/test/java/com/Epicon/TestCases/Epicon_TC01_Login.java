package com.Epicon.TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Epicon.PageObject.HomePage;
import com.Epicon.PageObject.LoginWithPassPage;
import com.Epicon.PageObject.continueToLogin;
import com.Epicon.PageObject.indexPage;
import com.Epicon.PageObject.loginWithRegisterPage;


public class Epicon_TC01_Login extends Baseclass {
	
	@Test
	public void login() throws IOException, Exception   {
		
		indexPage indexpage=new indexPage(driver);
		indexpage.closePopup();
		logger.info("close popup");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		loginWithRegisterPage loginpage=new loginWithRegisterPage(driver);
		loginpage.clickOnLoginWithRegister();
		
		LoginWithPassPage loginwithpass=new LoginWithPassPage(driver);
		loginwithpass.clickOnloginWithPassButton();
		
		continueToLogin login=new continueToLogin(driver);
		login.EnterLogin(uname);
		login.EnterPass(pass);
		logger.info("entered username and pass");
		login.ClickOnLoginButton();
		HomePage homepage=new HomePage(driver);
		String actual=homepage.getHometext();
		//Assert.assertEquals("Homeee", actual);
		
		if(actual.equals("Home")) {
			
			Assert.assertTrue(true);
			
		}else {
			
			captureScreenShot(driver, "login");
			Assert.assertTrue(false);
			
		}
		
		logger.info("Test 01 pass");
	
	
	}

}
