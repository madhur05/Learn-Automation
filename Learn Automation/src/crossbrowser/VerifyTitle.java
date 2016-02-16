package crossbrowser;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerifyTitle {

	
	WebDriver driver;
	@Test
	@Parameters("browser")
	public void verifyPageTitle(String browserName){
		
		
		if (browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();						
		}
		
		else if (browserName.equalsIgnoreCase("IE"))
		{
			//File file=new File("C:\\Users\\user\\workspace\\Learn Automation\\Lib\\IEDriverServer.exe");
			//System.setProperty("webdriver.ie.driver",file.getAbsolutePath());
			System.setProperty("webdriver.ie.driver","C:\\Users\\user\\Downloads\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();			
		}
		
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		String title=driver.getTitle();
		
		System.out.println(title);
		driver.quit();
		
	}
	
	
}
