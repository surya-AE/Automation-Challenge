package com.automationchallenge.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	WebDriver driver;
	public Properties prop;
	
	public void propertiesFile() {
		
		prop = new Properties();
		File propfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\automationchallenge\\qa\\config\\config.properties");
		try {
		FileInputStream fis = new FileInputStream(propfile);
		prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public WebDriver initializeBrowserAndOpenWebPage (String browsername) {
		
		if(browsername.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browsername.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));
		return driver;
	}
}
