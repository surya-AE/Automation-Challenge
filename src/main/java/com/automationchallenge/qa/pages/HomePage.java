package com.automationchallenge.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//Test1
	@FindBy(xpath="//input[@type='email']")
	WebElement emailInputField;
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement passwordInputField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
	
	//Test2
	@FindBy(xpath="//ul[@class='list-group']")
	private WebElement listGroup;
	
	@FindBy(tagName="li")
	private List <WebElement> listGroupValues;
	
	
	
	
	
	
	
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Test1
	public boolean getEnabledStatusofEmailInputField() {
		boolean emailEnabledStatus = emailInputField.isEnabled();
		return emailEnabledStatus;
	}
	
	public boolean getEnabledStatusofPasswordInputField() {
		boolean passwordEnabledStatus = passwordInputField.isEnabled();
		return passwordEnabledStatus;
	}
	
	public boolean getEnabledStatusofLoginBtn() {
		boolean loginBtnEnabledStatus = passwordInputField.isEnabled();
		return loginBtnEnabledStatus;
	}
	
	public void loginBtnClick() {
		loginBtn.click();
	}
	
	//Test2
	public int listGroupSize1() {
		return listGroupValues.size();
	}
	
	
	
	
	
	
	
	
	
}