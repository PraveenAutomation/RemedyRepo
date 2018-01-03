package testNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgBasics {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\pk.mishra\\Desktop\\Shift Folder 5 April'16\\KP Fouram\\Jars\\geckodriver.exe");
		
		driver =new FirefoxDriver();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.remedypartners.com/");
	}
	
	@Test
	public void remedyTest()
	{
		String title=driver.getTitle();
		System.out.println(title);
	}
	
	@Test
	public void linkTest()
	{
		boolean b=driver.findElement(By.xpath("//a[text()='Get Started']")).isDisplayed();
		System.out.println(b);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
