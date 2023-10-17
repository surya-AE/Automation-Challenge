package com.automationchallenge.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationchallenge.qa.base.BaseClass;

public class Test2 extends BaseClass{
	
public WebDriver driver;
WebElement listGroup;
	
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
	public void listGroup() {
		//assert that there are three values in the list group
		listGroup = driver.findElement(By.xpath("//ul[@class='list-group']"));
		List <WebElement> listvalues = listGroup.findElements(By.tagName("li"));
		System.out.println("Total number of values in the list group: " + "3");
		Assert.assertEquals(listvalues.size(),3, "expected 3 listvalues but found more than 3");
		
		
		//Assert that the second list item's value is set to "List Item 2"
		String secondlistvalue = null;
		if (listvalues.size() >=3) {
			secondlistvalue = listvalues.get(1).getText();
			System.out.println("Value of the the second list item: " + secondlistvalue);
		}else {
			System.out.println("There are less than three list values");
		}
		String expectedsecondlistvalue = "List Item 2";
		Assert.assertTrue(secondlistvalue.contains(expectedsecondlistvalue),"Expected second list item value is not equal to List Item 2");
		
		
		//Assert that the second list item's badge value is 6
		List <WebElement> listitembadgevalue = listGroup.findElements(By.tagName("span"));
		String secondlistitembadge = null;
		if (listvalues.size() >=3) {
			secondlistitembadge = listitembadgevalue.get(1).getText();
			System.out.println("second list item's badge value: " + secondlistitembadge);
		}else {
			System.out.println("There are less than three list values");
		}
		String expectedsecondlistitembadgevalue = "6";
		Assert.assertTrue(secondlistitembadge.contains(expectedsecondlistitembadgevalue), "Expected second list item's badge value is not equal to 6");
	}
}
