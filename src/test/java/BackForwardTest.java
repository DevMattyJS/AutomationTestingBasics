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

public class BackForwardTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/registracia.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get(BASE_URL);

        String email = "matko@email.com";
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys(email);

        driver.findElement(By.xpath("//a[@href='kalkulacka.php']")).click();
        driver.navigate().back();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
        Assert.assertEquals(email, emailField.getAttribute("value"));

        driver.navigate().forward();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("firstInput")));
        Assert.assertTrue(driver.findElement(By.id("firstInput")).isDisplayed());

    }

    @After
    public void tearDown() {
        driver.close();
    }
}
