package com.melshalati.testCases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwitchWindows {
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
	public void switchWindows() throws InterruptedException {
		driver.get("http://zero.webappsecurity.com/");
			
		driver.findElement(By.linkText("https://www.microfocus."
				+ "com/about/"
				+ "legal/#privacy"))
				.click();
		
		Set <String> handles = driver.getWindowHandles();
				
		System.out.println(handles);
					
		for (String h : handles) {
			System.out.println(h);	
			driver.switchTo().window(h);			
			Thread.sleep(4000);
		}
		
	}
	
	@AfterTest
	public void closeAll() {
		driver.close();
		driver.quit();
	}
}
