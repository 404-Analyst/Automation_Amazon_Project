package UI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.amazon.in/");
		        // Get all links on the page
		        List<WebElement> links = driver.findElements(By.tagName("a"));

		        for (WebElement link : links) {
		            String url = link.getAttribute("href");

		            // Skip null or empty hrefs
		            if (url == null || url.isEmpty()) continue;

		            try {
		            	URL url1= new URL(null);
		                HttpURLConnection conn = (HttpURLConnection) (url1.openConnection());
		                conn.setRequestMethod("HEAD");
		                conn.connect();
		                int statusCode = conn.getResponseCode();

		                if (statusCode >= 400) {
		                    System.out.println("❌ Broken Link: " + url + " | Status: " + statusCode);
		                } 

		            } catch (Exception e) {
		                System.out.println("⚠️ Error checking link: " + url + " | Exception: " + e.getMessage());
		            }
		        }

		        driver.quit();
		    }
		}

		//driver.close();
		
	
