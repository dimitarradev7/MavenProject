package WebDriverTests.Alerts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by dimitarrad
 * on 2/10/2021
 */
public class AlertsHandling {

    WebDriver driver;
    String url;

    @Before
    public void setUp() {
        System.out.println("@Before method will execute before every test");
        String driverExecutablePath = "C://WebDriver//bin//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        url = "C:\\Users\\dimitarrad\\IdeaProjects\\Html\\src\\HtmlAndCss\\Alerts.html";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        //options.addArguments("headless");
        options.addArguments("disable-infobars");
        options.addArguments("disable-popup-blocking");

        driver = new ChromeDriver(options);

    }

    @After
    public void tearDown() {
        System.out.println("@After method will execute after every test");
        driver.quit();
    }

    @Test
    public void simpleAlerts() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 5);
       // WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("simpleAlert")));

        JavascriptExecutor js =(JavascriptExecutor) driver ;
        js.executeScript("alert('Come from JS call');");
       // button.click();
        Thread.sleep(2000);

        driver.switchTo().alert().accept();

        //  Alert simpleAlert = wait.until(ExpectedConditions.alertIsPresent());

       // System.out.println(simpleAlert.getText());
        //simpleAlert.accept();
        Thread.sleep(1000);
        System.out.println("simpleAlert closed");

    }
    @Test
    public void confirmAlerts() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmAlert")));
        btn.click();
        Thread.sleep(2000);
        Alert cA = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(cA.getText());
        cA.accept();
        System.out.println("accept");
        Thread.sleep(1000);
        btn.click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
        System.out.println("dismiss");

    }

    @Test
    public void promptAlerts() throws InterruptedException {

        String value = "Dimitar";

        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.id("promptAlert")));
        btn.click();
        Thread.sleep(2000);
        Alert cA = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(cA.getText());
        Thread.sleep(2000);
        cA.sendKeys(value);
        Thread.sleep(2000);
        cA.accept();

        System.out.println("accept");
        WebElement demo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo")));
        System.out.println(demo.getText());
        Assert.assertTrue(demo.getText().contains(value));
    }

}
