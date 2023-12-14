import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandlingTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/redalert.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get(BASE_URL);
        // Handling first alert
        driver.findElement(By.id("alert1")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement label = driver.findElement(By.xpath("//div[@class='result']/h1"));

        Assert.assertEquals("Kirov Reporting", label.getText());

        // Handling another alert
        driver.findElement(By.id("alert3")).click();

        Alert anotherAlert = driver.switchTo().alert();
        anotherAlert.sendKeys("Matko");
        anotherAlert.accept();
        label = driver.findElement(By.xpath("//div[@class='result']/h1"));
        Assert.assertTrue(label.getText().contains("Matko"));
    }

    @After
    public void tearDown() {

    }
}
