package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginEC2 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://qa.remedypartners.com");
		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/form/div/div/div[2]/span/div/div/div/div/div/div/div/div/div/div[1]/div/input")).sendKeys("qa.admin@yopmail.com");
		driver.findElement(By.xpath("//*[@id='auth0-lock-container-1']/div/div[2]/form/div/div/div[2]/span/div/div/div/div/div/div/div/div/div/div[2]/div/div/input")).sendKeys("Episode1!");
		driver.findElement(By.xpath("//*[@id='auth0-lock-container-1']/div/div[2]/form/div/div/button")).click();
		driver.findElement(By.xpath("html/body/div[5]/div/div/div/div/div/div[6]/a/div[2]/p")).click();
		System.out.println(driver.getTitle());
	}

}
