package com.melshalati.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckingStatements {
		
	public String baseUrl = "http://zero.webappsecurity.com/";
		final String  driverPath = "F:\\Selenium\\SeleniumDrivers"
				+ "\\chromedriver_win32\\chromedriver.exe";
		public WebDriver driver;
		
		@BeforeTest
		public void openBrowser() {
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.get(baseUrl);
		}
		
		@Test
		public void checkingDifferentStatements() throws InterruptedException {
			
			driver.findElement(By.id("signin_button")).click();
				
			driver.findElement(By.id("user_login"))
			.sendKeys("username");
			
			driver.findElement(By.id("user_password"))
			.sendKeys("password");
					
			driver.findElement(By.name("submit")).click();
						
			driver.findElement(By.id("details-button")).click();
					
			driver.findElement(By.id("proceed-link")).click();
			
			driver.findElement(By.linkText("Online Statements")).click();
			
			Thread.sleep(50);
			
			driver.findElement(By.linkText("2012")).click();
			Thread.sleep(1500);
			
			driver.findElement(By.linkText("2011")).click();
			Thread.sleep(1500);
			
			driver.findElement(By.linkText("2010")).click();
			Thread.sleep(1500);
			
			driver.findElement(By.linkText("2009")).click();
			Thread.sleep(1500);
		}
		
		@AfterTest
		public void closeAll() {
			driver.close();
			driver.quit();
		}
	

	
}
