import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
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

    }

    @After
    public void tearDown() {

    }
 }
