package com.screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Lib.Utility;

public class ScreenShotUsingUtility {
	
	
	
	@Test
	public void CaptureScreenShot()
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("madhur");
		
		Utility.ScreenShotCapture(driver,"userentered");
		driver.quit();
		
		
		
		
	}

}
