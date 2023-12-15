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

public class RefreshTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/clickmebaby.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get(BASE_URL);

        int numOfClicks = 6;
        WebElement clickButton = driver.findElement(By.id("clickMe"));
        // click on the button 6 times
        for (int i = 0; i < numOfClicks; i++) {
            clickButton.click();
        }

        // check if the clicks label shows 6 clicks
        Assert.assertEquals(numOfClicks, Integer.parseInt(driver.findElement(By.id("clicks")).getText()));
        // refresh the page, wait until the clicks label is present (accessible) and check if its text was reset to 0
        driver.navigate().refresh();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("clicks")));
        Assert.assertEquals("0", driver.findElement(By.id("clicks")).getText());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
