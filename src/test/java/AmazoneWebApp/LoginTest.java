package TestNG;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends TestBase  {
	
	public void login() {
		setup();// calling the TestBase class
		
	}
		
		public void Logindetails() throws InterruptedException {
			
			driver.findElement(By.xpath("//span[text()='Hello, sign in']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("8637556686");
			Thread.sleep(2000);
			//clicked on continue button 
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sujan%2025");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(7000);
		
			System.out.println("Login test get successfull");
		teardown();
		
			System.out.println("Browser closed");
		
	}

	
	public static void main(String[] arg) throws InterruptedException {
		
		LoginTest lg= new LoginTest();
		lg.login();
		lg.Logindetails();
		
	}
	
	
	

}
