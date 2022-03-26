package com.store.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.store.utilities.BrowserFactory;
import com.store.utilities.ConfigDataProvider;
import com.store.utilities.ExcelDataProvider;
import com.store.utilities.Helper;


public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	
	@BeforeSuite
	public void setupSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
	}
	
	@BeforeClass
	public void setUP(){
		driver = BrowserFactory.openApplication(driver, config.getBrowser(), config.getUrl());		
	}
	
	@AfterClass	
	 public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	 }
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE) {
			Helper.captureScreenShot(driver);
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			Helper.captureScreenShot(driver);
		}
		
	}
	
}
