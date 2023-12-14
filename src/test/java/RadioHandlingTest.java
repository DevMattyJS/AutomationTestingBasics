import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioHandlingTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/zenaalebomuz.php";

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get(BASE_URL);
        WebElement maleRadioButton = driver.findElement(By.xpath("//input[@value='wurst']"));
        WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@value='conchita']"));
        maleRadioButton.click();
        Assert.assertTrue(maleRadioButton.isSelected());
        Assert.assertFalse(femaleRadioButton.isSelected());
    }

    @After
    public void tearDown() {
        driver.close();
    }
 }
