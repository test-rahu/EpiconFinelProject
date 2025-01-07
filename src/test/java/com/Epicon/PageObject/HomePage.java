package com.Epicon.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
WebDriver ldriver;
	
	public HomePage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this );	
	}

	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement Homepage;
	
	public String getHometext() {
		String hometext=Homepage.getText();
		return hometext;
	}
	
}
