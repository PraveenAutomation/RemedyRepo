package testNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.DependencyMap;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EcDashBoardTest1 {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\pk.mishra\\Desktop\\Shift Folder 5 April'16\\KP Fouram\\Jars\\geckodriver.exe");
		
		driver =new FirefoxDriver();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://cdn-qa.remedypartners.com");
	}
	@Test
	public void loginTest() throws InterruptedException
	{
		  driver.findElement(By.xpath("//input[@type='email']")).sendKeys("qa.admin@yopmail.com");
		  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Episode1!");
		  driver.findElement(By.xpath("//span[@class='auth0-label-submit']")).click();
		  Thread.sleep(2000);
		  String title=driver.getTitle();
		  System.out.println("Title of page "+title);
	}
	
	@Test(dependsOnMethods="loginTest")
	public void windowHandleTest()
	{
		driver.findElement(By.xpath("html/body/div[5]/div/div/div/div/div/div[2]/a/div[2]/p")).click();
		String winHandleBefore = driver.getWindowHandle();
		driver.switchTo().window(winHandleBefore);
		System.out.println("Title is "+driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
