package com.automationchallenge.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationchallenge.qa.base.BaseClass;
import com.automationchallenge.qa.pages.HomePage;

public class Test1 extends BaseClass {
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
	
	
	@Test(priority=1)
	public void verifyLoginAssertion() {
		HomePage homePage = new HomePage(driver);
		
		WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@type='email']"));
	
		//Assertions for email, password, login button
		Assert.assertTrue(homePage.getEnabledStatusofEmailInputField(), "Email input field is not present on the webpage.");
		Assert.assertTrue(homePage.getEnabledStatusofPasswordInputField(), "password input field is not present on the webpage.");
		Assert.assertTrue(homePage.getEnabledStatusofLoginBtn(), "Login button is not present on the webpage.");
	
	
		//enter an email address and password combination into the respective fields
		emailField.sendKeys(prop.getProperty("email"));
		passwordField.sendKeys(prop.getProperty("password"));
		homePage.loginBtnClick();
		}
}
