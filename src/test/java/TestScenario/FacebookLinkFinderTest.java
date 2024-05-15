package TestScenario;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FacebookLinkFinderTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @Test
    public void testFacebookLinks() {
        driver.get("https://www.facebook.com/");
        List<WebElement> lists = driver.findElements(By.tagName("a"));
        System.out.println("The total link text present: " + lists.size());

        ArrayList<String> linkTexts = new ArrayList<>();
        for (WebElement list : lists) {
            try {
                linkTexts.add(list.getAttribute("href"));
            } catch (Exception e) {
                System.err.println("Error getting link URL: " + e.getMessage());
            }
        }

        System.out.println("*********************************");
        System.out.println("Size of arrayList" + linkTexts.size());
        int i = 1;
        for (String linkText : linkTexts) {
            System.out.println(i + " ArrayList Text: " + linkText);
            i++;
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

