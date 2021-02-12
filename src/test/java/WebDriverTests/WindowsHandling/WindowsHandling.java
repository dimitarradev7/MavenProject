package WebDriverTests.WindowsHandling;

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

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by dimitarrad
 * on 2/9/2021
 */
public class WindowsHandling {
    WebDriver driver;
    String url;

    @Before
    public void setUp() {
        System.out.println("@Before method will execute before every test");
        String driverExecutablePath = "C://WebDriver//bin//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        url = "C:\\Users\\dimitarrad\\IdeaProjects\\Html\\src\\index.html";
        driver = new ChromeDriver();

    }

    @After
    public void tearDown() {
        System.out.println("@After method will execute after every test");
        //driver.quit();
    }

    @Test
    public void notHandleNewWindow() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("openNew")));
        Thread.sleep(1000);
        button.click();
        Thread.sleep(2000);
        WebElement newWindow = wait.until(ExpectedConditions.elementToBeClickable(By.id("done")));
    }

    @Test
    public void handleNewWindow() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

        String mainWinId = driver.getWindowHandle();
        WebElement openWin = new WebDriverWait(driver, 5).until(
                ExpectedConditions.elementToBeClickable(By.id("openTab")));
        Thread.sleep(1000);
        WebElement openTab = new WebDriverWait(driver, 5).until(
                ExpectedConditions.elementToBeClickable(By.id("openTab")));
        Thread.sleep(1000);
        openWin.click();
        openTab.click();

        System.out.println("Main window id: " + mainWinId);

        Set<String> winids = driver.getWindowHandles();

        String childId = null;
        for (String window : winids) {
            if (!window.equals(mainWinId)){
               List<WebElement> webEls = driver.findElements(By.id("done"));
               if (webEls.size()!=0){
                   childId = window;
                   break;
               }

            }

        }
        Assert.assertNotNull(childId);
        System.out.println("ChildId :" + childId);
        driver.switchTo().window(childId);

        Thread.sleep(2000);
        WebElement doneBtn = new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("done")));

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("Dimitar Radev");
        Thread.sleep(2000);
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("123454356");
        Thread.sleep(2000);
        doneBtn.click();

        driver.close();
        Thread.sleep(1000);
        driver.switchTo().window(mainWinId).close();
    }
}
