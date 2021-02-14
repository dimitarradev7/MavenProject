package WebDriverTests.JavaScriptTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by dimitarrad
 * on 2/14/2021
 */
public class JSTests {

    WebDriver driver;
    String url;

    @Before
    public void setUp() {
        System.out.println("@Before method will execute before every test");
        String driverExecutablePath = "C://WebDriver//bin//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        //url = "C:\\Users\\dimitarrad\\IdeaProjects\\Html\\src\\HtmlAndCss\\Alerts.html";

        driver = new ChromeDriver();

    }

    @After
    public void tearDown() {
        System.out.println("@After method will execute after every test");
        driver.quit();
    }

    @Test
    public void simpleAlerts() throws InterruptedException {
        url = "http://automationpractice.com/index.php";
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        // WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("simpleAlert")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(" prompt(\"Please enter your name:\", \"Name:\");");

        // button.click();
        Thread.sleep(2000);

        driver.switchTo().alert().accept();
    }
}
