package UI;

import javax.swing.text.Document;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {
    public static void main(String[] arg){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.amazon.in/");

        //print the title of the page

        JavaScriptExecutor js= new JavaScriptExecutor();

        String title = ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return document.title;").toString(); 

        System.out.println("Page title is: " + title);

        driver.quit();

    }

    public void executeScript(String string, WebElement cart) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executeScript'");
    }
}
