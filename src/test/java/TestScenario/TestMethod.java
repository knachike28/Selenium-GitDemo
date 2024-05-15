package TestScenario;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethod {
	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahulshettyacademy@gmail.com");
		
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("#chkboxTwo")).click();
		driver.findElement(By.cssSelector(".signInBtn")).click();
		String data1= driver.findElement(By.xpath("//h2")).getText();
		String data2= driver.findElement(By.xpath("//h1")).getText();
		//System.out.println(data1 + "\n" +data2);
		driver.quit();
	}
}
