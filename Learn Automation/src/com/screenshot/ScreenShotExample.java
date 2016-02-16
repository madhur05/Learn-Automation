package com.screenshot;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ScreenShotExample {
	
	@Test
	public void CaptureScreenShot() throws Exception
	{
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("madhur");
		
		//TakesScreenshot is an interface so can't create object of it directly
		TakesScreenshot ts=(TakesScreenshot)driver;
		//this will capture screenshot and keep it in memory 
		//ts.getScreenshotAs(OutputType.FILE);
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		//new File(".ScreenShots")..this will create a new file in screenshots folder
		//.  refers to current working directory and go to screenshot folder and give file name
		FileUtils.copyFile(source,new File("./ScreenShots/fbPage.png"));
		driver.quit();
		
				
	}
	
	
}

