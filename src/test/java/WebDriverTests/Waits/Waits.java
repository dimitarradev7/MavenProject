package WebDriverTests.Waits;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by dimitarrad
 * on 2/9/2021
 */
public class Waits {

    WebDriver driver;
    String url;

    @Before
    public void setUp() {
        System.out.println("@Before method will execute before every JUnit4 test");
        String driverExecutablePath = "C://WebDriver//bin//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        url = "http://automationpractice.com/index.php";
        driver = new ChromeDriver();

    }

    @After
    public void tearDown() {
        System.out.println("@After method will execute after every JUnit4 test");
        driver.close();
    }

    @Test
    public void implicit() throws InterruptedException {

        url = "C:\\Users\\dimitarrad\\IdeaProjects\\Html\\src\\index.html";
        driver.manage().window().maximize();
        driver.get(url);

        //driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        WebElement el = driver.findElement(By.name("devNewName"));
    }
    @Test
    public void explicit() throws InterruptedException {
        url = "http://automationpractice.com/index.php";
        driver.manage().window().maximize();
        driver.get(url);

        //wait to load page
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        Actions actions = new Actions(driver);

        WebElement picture = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='homefeatured']/li[2]")));
        actions.moveToElement(picture).perform();

        Thread.sleep(2000);

        WebElement addToCard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='homefeatured']/li[2]//div[@class='button-container']/a[@title='Add to cart']")));
        addToCard.click();

        Thread.sleep(2000);
        WebElement price = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart_product_price")));

        Assert.assertEquals("$27.00",price.getText());

    }
}
