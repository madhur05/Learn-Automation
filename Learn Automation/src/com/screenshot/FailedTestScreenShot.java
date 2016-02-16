package com.screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Lib.Utility;

public class FailedTestScreenShot {
	
	WebDriver driver;
	
	@Test
	public void CaptureScreenShot()
	{
		driver=new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("emailer")).sendKeys("madhur");
					
	}
	@AfterMethod
	public void TearDown(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.ScreenShotCapture(driver, result.getName());
		}
		
		driver.quit();
	}

}
