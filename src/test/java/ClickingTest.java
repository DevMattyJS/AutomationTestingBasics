import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickingTest {

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
        WebElement description = driver.findElement(By.className("description"));

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(String.valueOf(i), driver.findElement(By.id("clicks")).getText());
            if (i == 1) {
                Assert.assertEquals("klik", description.getText());
            } else if (i > 1 && i < 5) {
                Assert.assertEquals("kliky", description.getText());
            } else {
                Assert.assertEquals("klikov", description.getText());
            }

            driver.findElement(By.id("clickMe")).click();
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
