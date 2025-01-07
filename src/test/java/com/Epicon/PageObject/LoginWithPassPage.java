package com.Epicon.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWithPassPage {

	
WebDriver ldriver;
	
	public LoginWithPassPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this );	
	}
	//driver.findElement(By.xpath("(//button[@class='login-btn login-btn-pwd mt-0 bg-transparent text-white'])[1]")).click() ; 
	
	@FindBy(xpath="(//button[@class='login-btn login-btn-pwd mt-0 bg-transparent text-white'])[1]")
	WebElement loginWithPassButton;
	
	public void clickOnloginWithPassButton() {
		loginWithPassButton.click();
	}
}
