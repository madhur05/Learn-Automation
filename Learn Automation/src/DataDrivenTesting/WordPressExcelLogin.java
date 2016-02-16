package DataDrivenTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Lib.ReadExcelCofig;

public class WordPressExcelLogin {

	WebDriver driver;
	
	@Test(dataProvider="wordpressdata")
	public void loginToWordPress(String username,String password) throws Exception{
		
		driver = new FirefoxDriver();
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.id("wp-submit")).click();
		
		Thread.sleep(5000);
		
		// print assertion fail message
		Assert.assertTrue(driver.getTitle().contains("Dashboard"),"wrong credentials.....user cannot login");
		
		System.out.println("page title verified");
				
	}
	
	@AfterMethod
	
	public void tearDown(){
		driver.quit();
	}
	
	@DataProvider(name="wordpressdata")
	public Object[][] passData(){
		
		ReadExcelCofig config = new ReadExcelCofig("C:\\Users\\user\\Desktop\\filesforseleniumtest\\address.xlsx");
		int rows=config.getRowcount(2);
		
		
		Object[][] data=new Object[rows][2];
		
		for(int i=0;i<rows;i++)
		{
			data[i][0]=config.getData(2, i, 0);
			data[i][1]=config.getData(2, i, 1);
			
		}
		
		return data;
		
	}
	
	
}
