package AmazoneWebApp;


import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HDFC_BanK_XPath {
    

	public static void main(String[] args) throws InterruptedException {
		try {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		
		
		WebElement invest=driver.findElement(By.xpath("//div[@class='navbar-collapse collapse']/ul/li[4]/a/span[2]"));
		
		Actions ac= new Actions(driver);
		ac.moveToElement(invest).perform();
		
		Thread.sleep(5000);
		
		WebElement hyp= driver.findElement(By.xpath("(//li[@class='level-3          '])[4]/a/span[3]"));
		hyp.click();
		System.out.println("HYP clicked Successfully");
		Thread.sleep(5000);
		
		driver.quit();
		}
		catch(NoSuchElementException e ){
			System.out.println(" Element was not intractable"+ e.getMessage());
			
		}

	}


    
}
