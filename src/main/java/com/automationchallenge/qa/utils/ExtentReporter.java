package com.automationchallenge.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() throws IOException {
		
		ExtentReports extentReport = new ExtentReports();
		File extentReportfile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter spark =  new ExtentSparkReporter(extentReportfile);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Automation Challenge Results");
		spark.config().setDocumentTitle("Automation Report");
		
		extentReport.attachReporter(spark);
		
		Properties prop = new Properties();
		File configfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\automationchallenge\\qa\\config\\config.properties");
		FileInputStream fis = new FileInputStream(configfile);
		prop.load(fis);
		
		extentReport.setSystemInfo("Application URL", prop.getProperty("url"));
		extentReport.setSystemInfo("Browser name", prop.getProperty("browserName"));
		extentReport.setSystemInfo("Java version", System.getProperty("java.version"));
		return extentReport;
	}
}
