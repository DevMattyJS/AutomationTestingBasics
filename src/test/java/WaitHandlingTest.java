import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHandlingTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/zjavenie.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get(BASE_URL);
        WebElement showButton = driver.findElement(By.id("showHim"));
        showButton.click();
        // wait until the selected element is visible on site, but max for 5 seconds
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//img[@class='brano']")));
       Assert.assertTrue(driver.findElement(By.xpath("//img[@class='brano']")).isDisplayed());
    }

    @After
    public void tearDown() {

    }
}
