package TestScenario;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

//import TestScenario.ReadExcelTest;
public class ScreenshotExample {

    public static void main(String[] args) throws IOException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        
        String url=ReadExcelTest.readExcelTest(0, 0, 3);
        
        driver.get(url); // Replace with your desired URL

        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File screenshotFile = scrShot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFile, new File("screenshot4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
