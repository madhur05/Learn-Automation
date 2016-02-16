package com.frames;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertWindow {
	
	@Test
	public void HandleAlert() throws Exception
	{
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.ksrtc.in");
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/form/div[8]/a")).click();
		
		//to handle alerts in selenium we have to use alert interface
		//switchto() can be used with alerts, windows and frames
		Thread.sleep(2000);
		
		//to capture the text of alert window
		
		String actual_msg=driver.switchTo().alert().getText();
		System.out.println(actual_msg);
		Alert alt= driver.switchTo().alert();
		alt.accept();
		 //it can also be written as
		//driver.switchTo().alert().accept();
		
		String expected_msg="'From' place is required enter place.";
		
		Assert.assertEquals(actual_msg, expected_msg);
		driver.quit();
		
		
		
	}

}
