package AmazoneWebApp;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_Find_All_Broken_Links extends TestBase  {
        // This class extends the TestBase class to inherit WebDriver setup and login functionality
        // It contains methods to perform login operation on the web application

        //Date----> 25-06-2024

    //Author---->
        // Sujan Dhali -> Automation Test Engineer( QA Analyst)

        public void login() throws InterruptedException{
            // This method will set up the WebDriver and perform the login operation
            //Calling the setup method from TestBase class
            // setup();
            // Logic to perform login can be added here 
            setup();
            //calling the Logindetails method from TestBase class
            // Logindetails();
            Logindetails();

            // find all the url
            List<WebElement> links= driver.findElements(By.tagName("a"));
            System.out.println("Total links are "+ links.size());
            
            List<String> urlList= new ArrayList<>();
            for(WebElement e: links) {
            	String url=e.getAttribute("href");
            	urlList.add(url);
            }
            urlList.parallelStream().forEach(e -> {
                try {
                    CheckBrLink(e);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            });
    
}
public static void CheckBrLink(String BrLink) throws InterruptedException{
    TC_Find_All_Broken_Links br= new TC_Find_All_Broken_Links();
    br.setup();
    br.Logindetails();
    try {
        URL url= new URL(BrLink);
        HttpURLConnection ht = (HttpURLConnection)url.openConnection();
        ht.setConnectTimeout(5000);
        ht.connect();
        if(ht.getResponseCode()>=400) {
        	System.err.println("⚠️  Broken ->"+ BrLink +" Broken"+ ht.getResponseMessage());
        }
        else {
        	System.out.println( BrLink+ "Ok "+ ht.getResponseMessage());
        }
        
        
    } catch (Exception e) {
        // TODO: handle exception
        System.out.println("Some exception occured");
    }

}
}
