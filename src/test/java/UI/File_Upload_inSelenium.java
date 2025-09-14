package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class File_Upload_inSelenium {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // ...your code...
        driver.get("https://www.w3schools.com/howto/howto_html_file_upload_button.asp");

        driver.manage().window().maximize();
        driver.findElement(org.openqa.selenium.By.xpath("//input[@id='myFile']")).sendKeys("C:\\Users\\sujan\\Downloads\\Suta.pdf");
        System.out.println("File Uploaded Successfully");
        Thread.sleep(5000);
        driver.quit();
    }
}
