package com.Epicon.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class continueToLogin {

WebDriver ldriver;
	
	public continueToLogin(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this );	
	}
	
	
	@FindBy(id="mobilenumber")
	WebElement userID;
	
	@FindBy(xpath="//input[@id='login_pwd']")
	WebElement Pass;
	
	@FindBy(xpath="//button[normalize-space()='Continue to Login']")
	WebElement clickOnLogin;
	
	public void EnterLogin(String userid) {
		userID.sendKeys(userid);
	}
	
	public void EnterPass(String pass) {
		Pass.sendKeys(pass);
	}
	
	public void ClickOnLoginButton() {
		clickOnLogin.click();
	}
	
}
