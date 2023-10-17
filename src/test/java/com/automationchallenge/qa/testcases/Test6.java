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

public class Test6 extends BaseClass{
	
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
	public void findValueOfCell() {
		//Write a method that allows you to find the value of any cell on the grid
		//Use the method to find the value of the cell at coordinates 2, 2
		WebElement table = driver.findElement(By.className("table-dark"));
		List <WebElement> rows = table.findElements(By.xpath(".//tr"));
		int rowindex = 3;
		int colindex = 3;
		WebElement cell = rows.get(rowindex - 1).findElements(By.xpath(".//td")).get(colindex -1);
		String cellvalue = cell.getText();
		System.out.println("Cell value at 2,2: " + cellvalue);
	}
	
	@Test(priority=2)
	public void assertValueOfCell() {
		//Assert that the value of the cell is "Ventosanzap
		WebElement table = driver.findElement(By.className("table-dark"));
		List <WebElement> rows = table.findElements(By.xpath(".//tr"));
		int rowindex = 4;
		int colindex = 3;
		WebElement cell = rows.get(rowindex - 1).findElements(By.xpath(".//td")).get(colindex -1);
		String cellvalue = cell.getText();
		String expectedvalue = "Ventosanzap";
		Assert.assertEquals(cellvalue, expectedvalue, "cell value does not match the expected value");
	}
}
