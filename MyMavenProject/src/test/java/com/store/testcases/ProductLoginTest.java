package com.store.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductLoginTest {
	@Test
	public static void loginTest() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		
		driver.get("https://www.demoblaze.com/");
		
		driver.findElement(By.id("login2")).click();
		driver.findElement(By.id("loginusername")).sendKeys("Moazzem3013");
		driver.findElement(By.id("loginpassword")).sendKeys("RukuMH2103MH");
		driver.findElement(By.xpath("//button[contains(text(),'Log in')] ")).click();
		
		WebElement welcome = driver.findElement(By.xpath("//a[contains(text(),'Welcome Moazzem3013')]"));
		String actualText = welcome.getText();
		String expectedText = "Welcome Moazzem3013";
		
		Assert.assertEquals(actualText, expectedText, "Login failed");
		
		driver.quit();
	
		
	}

}

 