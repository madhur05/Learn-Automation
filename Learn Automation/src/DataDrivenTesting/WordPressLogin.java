package DataDrivenTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WordPressLogin {

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
		
		Object[][] data=new Object[3][2];
		
		data[0][0]="admin1";
		data[0][1]="demo";
		
		data[1][0]="admin";
		data[1][1]="demo123";
		
		data[2][0]="admin2";
		data[2][1]="demo2";
		
		
		return data;
		
	}
	
	
}
