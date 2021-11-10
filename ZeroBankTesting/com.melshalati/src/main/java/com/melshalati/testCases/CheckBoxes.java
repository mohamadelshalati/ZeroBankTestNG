package com.melshalati.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxes {
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
	public void checkBoxes() throws InterruptedException {
		
		driver.findElement(By.id("signin_button")).click();
		
		WebElement checkbox = driver
				.findElement(By.id("user_remember_me"));
		
		
		for(int i = 0; i < 6; i++) {
			if(checkbox.isSelected()) {
				
				System.out.println("Keep me signed in is toggled on");
				checkbox.click();
				System.out.println("Unchecked");
				Thread.sleep(2000);
			}
			
			else if(!checkbox.isSelected()) {
				System.out.println("Keep me signed in is toggled off");
				checkbox.click();
				System.out.println("checked");
				Thread.sleep(2000);
			}
		}
	}
	
	@AfterTest
	public void closeAll() {
		driver.close();
		driver.quit();
	}
}
