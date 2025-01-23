package com.Epicon.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginEpic {
    WebDriver driver;

    @Test
    public void test() throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahul\\eclipse-workspace\\EpiconFinal\\drivers\\chromedriver.exe");

        // Initialize WebDriver (e.g., ChromeDriver)
        driver = new ChromeDriver();

        // Navigate to your page
        driver.get("https://www.epicon.in/");
        driver.manage().window().maximize();

        // Create an implicit wait (also consider using WebDriverWait for specific conditions)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Close any popups (if any)
        driver.findElement(By.cssSelector(".close-button.page-close")).click();

        // Click the login button
        driver.findElement(By.cssSelector("a[aria-label='login button'] svg")).click();  

        // Login with credentials
        driver.findElement(By.xpath("(//button[@class='login-btn login-btn-pwd mt-0 bg-transparent text-white'])[1]")).click();
        driver.findElement(By.id("mobilenumber")).sendKeys("test8980@yopmail.com");
        driver.findElement(By.id("login_pwd")).sendKeys("Test@123");
        driver.findElement(By.xpath("//button[normalize-space()='Continue to Login']")).click();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down the page (to the bottom)
        js.executeScript("window.scrollBy(0, 100);");
        Thread.sleep(3000);
        System.out.println("scroll page");
        driver.findElement(By.xpath("(//button[normalize-space()='1'])[1]")).click();
        System.out.println("scroll page and click on 1st ");

        try {
            // Array of video locators (update these locators as necessary)
            String[] videoLocators = {
                "(//a[@class='big-play'])[3]", // Locator for video 1
                "(//a[@class='big-play'])[4]", // Locator for video 2
                "(//a[@class='big-play'])[5]"  // Locator for video 3
            };

            // Loop through all video thumbnails using the locators
            for (int i = 0; i < videoLocators.length; i++) {
                // Find and click the video thumbnail using the locator from the array
                WebElement videoThumbnail = driver.findElement(By.xpath(videoLocators[i]));
                videoThumbnail.click();
                js.executeScript("window.scrollBy(0, 100);");

               
                WebElement settingsButton = driver.findElement(By.xpath("(//button[@class='plyr__control setting-first-btn'])[1]"));
                // Verify if the settings button is visible (indicating the video is playing)
                if (settingsButton.isDisplayed()) {
                    System.out.println("Video " + (i + 1) + " is playing.");
                } else {
                    // If the video is not playing, print the URL of the video page
                    String currentUrl = driver.getCurrentUrl();
                    System.out.println("Video " + (i + 1) + " is NOT playing. URL: " + currentUrl);
                }

                
                driver.navigate().back();

               
                try {
                    WebElement nextArrow = driver.findElement(By.xpath("//button[@class='slide-m-next slick-arrow']"));
                    nextArrow.click();
                } catch (Exception e) {
                    // Handle case where next-arrow is not found or not clickable
                    System.out.println("Next arrow not found or not clickable.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser after testing
            driver.quit();
        }
    }
}
