package com.Epicon.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginWithRegisterPage {

WebDriver ldriver;
	
	public loginWithRegisterPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this );	
	}
	
	@FindBy(css="a[aria-label='login button'] svg")
	WebElement loginWithRegisterPopup;
	
	public void clickOnLoginWithRegister() {
		loginWithRegisterPopup.click();;
		
	}
	
}
