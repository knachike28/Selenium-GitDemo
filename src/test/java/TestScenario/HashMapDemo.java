package TestScenario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;

public class HashMapDemo {
   public static void main(String[] args) throws InterruptedException {
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.get("https://classic.crmpro.com/index.html");
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();

       String customer_cred = getCredentailsMap().get("customer");

       //driver.findElement(By.name("username")).sendKeys(customer_cred.split(":")[0]);
       //driver.findElement(By.name("password")).sendKeys(customer_cred.split(":")[1]);
       driver.findElement(By.name("username")).sendKeys(getUserName("customer"));
       driver.findElement(By.name("password")).sendKeys(getPassword("customer"));
       Thread.sleep(3000);
       driver.findElement(By.xpath("//input[@type='submit']")).click();

       Thread.sleep(4000);
       System.out.println("Sucess........");
       driver.quit();
   }

    public static HashMap<String, String > getCredentailsMap(){
        HashMap <String, String> userCred = new HashMap<>();
        userCred.put("customer", "naveenautomation:Test@123");
        userCred.put("admin", "Jack: jack@123");
        userCred.put("seller", "Shall: shall@123");
        userCred.put("deliveryBoy", "ankit: ankit@123");
        //map.put("password", "admin");
        return userCred;
    }

    public static String getUserName(String role){
       String credenatials=getCredentailsMap().get(role);
       return credenatials.split(":")[0];
    }
    public static String getPassword(String role){
        String credenatials=getCredentailsMap().get(role);
        return credenatials.split(":")[1];
    }
}
