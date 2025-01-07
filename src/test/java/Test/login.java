package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Epicon.BaseClass.Baseclass;

public class login extends Baseclass {
	
	WebDriver driver;
	
	
	
	@Test
	public void login() throws Exception {
	
	driver.findElement(By.cssSelector(".close-button.page-close")).click();
	driver.findElement(By.cssSelector("a[aria-label='login button'] svg")).click();  //
	
	//Login with password
	driver.findElement(By.xpath("(//button[@class='login-btn login-btn-pwd mt-0 bg-transparent text-white'])[1]")).click() ;     //
	driver.findElement(By.id("mobilenumber")).sendKeys("8459131377");
	driver.findElement(By.id("login_pwd")).sendKeys("Test@123");
	driver.findElement(By.xpath("//button[normalize-space()='Continue to Login']")).click();
	Thread.sleep(2000);
	
	
	}
	
	

}
