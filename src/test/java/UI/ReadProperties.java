package UI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadProperties {

	public static void main(String[] args) throws IOException {

		// Read Properties file 
		Properties properties = new Properties();
		 FileInputStream file= new FileInputStream("C:\\Users\\sujan\\eclipse-workspace\\SeleniumMavenProject\\src\\main\\resources\\properties\\testdata.properties");
		 
		 properties.load(file);
		System.out.println( properties.get("browser"));
		System.out.println( properties.get("url"));
		
		
		//Write properties file
		
		FileOutputStream outfile= new FileOutputStream("C:\\Users\\sujan\\eclipse-workspace\\SeleniumMavenProject\\src\\main\\resources\\properties\\testdata.properties");
		properties.setProperty("Name", "Sujan Dhali");
		properties.setProperty("Gamil", "sujandhali008@gmail.com ");
		properties.setProperty("Address", "Bhubaneswar City");
		properties.setProperty("Ph no", "8637556686");
		properties.store(outfile, "This is basic details");
		 
		

	}

}
