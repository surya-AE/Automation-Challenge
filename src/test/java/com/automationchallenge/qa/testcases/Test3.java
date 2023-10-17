package com.automationchallenge.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationchallenge.qa.base.BaseClass;

public class Test3 extends BaseClass{

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
		public void defaultSelectedValue() {
			//assert that "Option 1" is the default selected value
			String defaultSelectedValue = driver.findElement(By.id("dropdownMenuButton")).getText();
			String expectedDefaultValue = 	"Option 1";
			Assert.assertEquals(defaultSelectedValue,expectedDefaultValue, "The default selected value is not Option 1");
			
			
			//Select "Option 3" from the select list
			driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).click(); //not a select dropdown
			driver.findElement(By.xpath("//a[contains(text(),'Option 3')]")).click();
			}
}

