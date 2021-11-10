package com.melshalati.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownMenu {
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
	public void dropDownMenu() throws InterruptedException {
		driver.findElement(By.id("signin_button")).click();
		
		driver.findElement(By.id("user_login"))
		.sendKeys("username");
		
		driver.findElement(By.id("user_password"))
		.sendKeys("password");
		
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.id("details-button")).click();
		
		driver.findElement(By.id("proceed-link")).click();
		
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div"
				+ "[2]/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a"))
		.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Select account = new Select(driver.findElement(By.xpath("//*[@id=\"aa_accountId\"]")));
		
		account.selectByVisibleText("Checking");
		
		try {
			Thread.sleep(2000);
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
