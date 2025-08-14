package UI;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBrokenLinks {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		List<WebElement> links= driver.findElements(By.tagName("a"));
		System.out.println("Total No of links "+links.size());
		
		
		List<String> urllist= new ArrayList<String>();
		for(WebElement e: links) {
			@SuppressWarnings("deprecation")
			String url= e.getAttribute("href");
			urllist.add(url);
			//CheckBrokenLink(url);
		}
		
		urllist.parallelStream().forEach(e-> {
			try {
				CheckBrokenLink(e);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		driver.quit();
		
	}
	
	public static void CheckBrokenLink(String BrLink) throws MalformedURLException {
		
		try {
			URL url=new URL(BrLink);
			HttpURLConnection httpConn= (HttpURLConnection) url.openConnection();
			httpConn.setConnectTimeout(5000);
			httpConn.connect();
			if(httpConn.getResponseCode()>=400) {
				System.err.println("⚠️  Broken ->"+ BrLink +" Broken"+ httpConn.getResponseMessage());
			}
			else {
				System.out.println( BrLink+ "Ok "+ httpConn.getResponseMessage());
			}
		}
		catch(Exception e){
			
		}
		
	}
	 
}

