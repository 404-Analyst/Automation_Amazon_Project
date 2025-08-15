package UI;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

  public static void main(String[] args) {
        // TODO Auto-generated method stub

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File dest= new File("C:\\Users\\sujan\\eclipse-workspace\\JavaCodingquestionforInterview\\TestResult\\screenshot.png");
        try {
            FileUtils.copyFile(src, dest);
                System.out.println("Screenshot taken: " + dest.getAbsolutePath());
            } catch (Exception e) {
                System.err.println("Failed to save screenshot: " + e.getMessage());
       
            }
            driver.quit();
    }
    
}
