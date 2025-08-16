package AmazoneWebApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public WebDriver driver;
	
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		System.out.println("Browser launced successfully");
		driver.manage().window().maximize();
		System.out.println("Browser maximized successfully");
	}

	public void Logindetails() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//Clicked on Sign in button
			driver.findElement(By.xpath("//span[text()='Hello, sign in']")).click();
			System.out.println("Clicked on login button successfully");
			Thread.sleep(2000);

			//Enter phone number
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("8637556686");
			System.out.println("Ph No entered successfully");
			Thread.sleep(2000);

			//clicked on continue button 
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			System.out.println("Clicked on continue button successfully");
			Thread.sleep(2000);

			//Enter password
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sujan%2025");
			System.out.println("Password entered successfully");
			Thread.sleep(2000);

			//clicked on login button
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			System.out.println("Clicked on login button successfully");
			Thread.sleep(2000);
			System.out.println("Login test get successfull");
	}
		public void teardown() {
			
			
			driver.quit();
			System.out.println("Browser closed successfully");
			
		}
	}
	



