package com.automationchallenge.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationchallenge.qa.base.BaseClass;

public class Test4 extends BaseClass{

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
	public void verifyButtonEnabledandDisabled() {
		//Assert that the first button is enabled
		WebElement firstButton = driver.findElement(By.className("btn-primary"));
		Assert.assertTrue(firstButton.isEnabled(),"first button is not enabled");
		
		//Assert that the second button is disabled
		WebElement secondButton = driver.findElement(By.className("btn-secondary"));
		Assert.assertTrue(secondButton.isEnabled(),"second button is not disabled");
	}
}
