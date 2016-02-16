package com.frames;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Popups {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("http://www.hdfcbank.com");
		driver.manage().window().maximize();
		String homePage=driver.getWindowHandle();
		System.out.println(homePage);
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='loginsubmit']")).click();
		
		Set<String> handles =driver.getWindowHandles();
		System.out.println(handles.size());
		
		Iterator iterator=handles.iterator();
		
		String currentWindowID;
		
		while(iterator.hasNext())
		{
			currentWindowID=iterator.next().toString();
			System.out.println(currentWindowID);
			
			if(!currentWindowID.equals(homePage))
			{
				driver.switchTo().window(homePage);
				Thread.sleep(50000);
				driver.close();
			}
		}

	}

}
