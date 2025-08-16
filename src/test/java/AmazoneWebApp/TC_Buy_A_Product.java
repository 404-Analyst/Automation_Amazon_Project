package AmazoneWebApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_Buy_A_Product extends TestBase {

    
    //Author---->
        // Sujan Dhali -> Automation Test Engineer( AQ Analyst)

    // This class is intended to implement the test case for buying a product on Amazon
    // It will include methods for searching a product, adding it to the cart, and completing the purchase
    // The implementation details will depend on the specific requirements and flow of the application
        
       public void login() throws InterruptedException{
        // This method will set up the WebDriver and perform the login operation
        //Calling the setup method from TestBase class
        setup();
        // Logic to perform login can be added here
        //calling the Logindetails method from TestBase class
        Logindetails();
       }
    // Placeholder for methods and logic to be implemented
    public void searchProduct(String productName) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
        //Enter text on search input field
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productName);
        System.out.println("Product searched input text successfully: " + productName);
        Thread.sleep(2000);
        //Clicked on search button
        driver.findElement(By.id("nav-search-submit-button")).click();
        System.out.println("Search button clicked successfully ");
        Thread.sleep(2000);

        
        // Logic to search for a product
    }

    public void addToCart() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Logic to add the searched product to the cart
        //Clicked on Add to cart
        driver.findElement(By.xpath("(//button[@name='submit.addToCart'])[3]")).click();
        System.out.println("Product added to cart successfully");
         Thread.sleep(2000);
        //clicked on cart
        //Using JavaScriptExecutor to for clicking on cart
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        //Finding the cart element
        WebElement cart=driver.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']"));
        js.executeScript("arguments[0].click();", cart);
        System.out.println("Cart opened successfully");
        Thread.sleep(2000);
    }

    public void completePurchase() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Logic to complete the purchase process
        //Clicked on Proceed to checkout
        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
        System.out.println("Clicked on Proceed to checkout successfully");
         Thread.sleep(2000);
        //Clicked on COD
        driver.findElement(By.xpath("(//input[@name='ppw-instrumentRowSelection'])[7]")).click();
        System.out.println("Clicked on COD button successfully");
         Thread.sleep(2000);

         //clicked on Use this payment button
         driver.findElement(By.xpath("(//input[@class='a-button-input'])[4]")).click();
            System.out.println("Clicked on Use this payment button successfully");
            Thread.sleep(2000);
        //Clicked on Place your order button
        driver.findElement(By.xpath("(//input[@id='placeOrder'])[1]")).click();
        System.out.println("Clicked on Place your order button successfully");
        System.out.println("Product purchased successfully");
         Thread.sleep(2000);    

         //Print the confirmation message
          org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
         String confirmationMessage= driver.findElement(By.xpath("//h4[@class='a-alert-heading']")).getText();
            System.out.println("Confirmation Message: " + confirmationMessage);

            teardown(); // Close the browser after completing the purchase
            System.out.println("Browser closed successfully after purchase");
            System.out.println("Thanks For the Shopping");
        }

    public static void main(String[] args) throws InterruptedException {

    
        TC_Buy_A_Product testCase = new TC_Buy_A_Product();
        testCase.login();
        testCase.searchProduct("smart watch");
        testCase.addToCart();
        testCase.completePurchase();
        // Additional methods to search for a product, add it to the cart, and complete the purchase can be called here
    }
}
