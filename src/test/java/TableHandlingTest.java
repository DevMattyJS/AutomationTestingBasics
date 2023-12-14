import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TableHandlingTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/tabulka.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void Test() {
        driver.get(BASE_URL);
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
        for (WebElement row : rows) {
            String lastName = row.findElement(By.xpath("./td[3]")).getText();
            Assert.assertFalse(lastName.isEmpty());
        }
    }

    @After
    public void tearDown() {}


}
