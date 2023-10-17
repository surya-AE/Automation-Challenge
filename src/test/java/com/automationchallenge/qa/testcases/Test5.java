package com.automationchallenge.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationchallenge.qa.base.BaseClass;

public class Test5 extends BaseClass{

public WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
		propertiesFile();
		driver = initializeBrowserAndOpenWebPage(prop.getProperty("browserName"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void waitForButtonDisplay() {
		//wait for the button to be displayed
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("test5-button"))).click();
		
		
		//clicked the button and asserted that a success message is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-success")));
		String actualsuccessmessage = driver.findElement(By.className("alert-success")).getText();
		String expectedsuccessmessage = "You clicked a button!";
		Assert.assertEquals(actualsuccessmessage, expectedsuccessmessage, "expected success message is not displayed");
		
	
		//Asserting that the button is now disabled
		WebElement button = driver.findElement(By.xpath("//button[@id='test5-button']"));
		Assert.assertTrue(button.isEnabled(),"button is not disabled");
	}
}
