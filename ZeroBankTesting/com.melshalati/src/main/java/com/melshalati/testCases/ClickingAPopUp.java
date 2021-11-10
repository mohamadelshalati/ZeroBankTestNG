package com.melshalati.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClickingAPopUp {
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
	public void clickAPopUp() throws InterruptedException {
		driver.findElement(By.id("signin_button")).click();
		
		driver.findElement(By.id("user_login"))
		.sendKeys("username");
		
		driver.findElement(By.id("user_password"))
		.sendKeys("password");
				
		driver.findElement(By.name("submit")).click();
				
		driver.findElement(By.id("details-button")).click();
				
		driver.findElement(By.id("proceed-link")).click();
		
		driver.findElement(By
				.linkText("Pay Bills"))
				.click();
		
		driver.findElement(By
				.linkText("Purchase Foreign Currency"))
				.click();
		
		try {
			Thread.sleep(20);
			driver.findElement(By.id("purchase_cash")).click();
		}catch(Exception e) {
			System.out.println("here");
		}
		
		String str = driver.switchTo().alert().getText();
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.switchTo().alert().accept();
		
		System.out.println(str);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void closeAll() {
		driver.close();
		driver.quit();
	}
}
