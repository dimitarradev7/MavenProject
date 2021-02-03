package WebDriverTests.BrowserCommandsPractice_1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by dimitarrad
 * on 2/3/2021
 */
public class Practice1 {

    WebDriver driver;
    String url;
    @Before
    public void setUp() {
        String driverExecutablePath = "C://WebDriver//bin//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        url = "http://automationpractice.com/index.php";
        driver = new ChromeDriver();

    }
    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void practice1(){
        driver.get(url);
        driver.manage().window().maximize();
        String title =driver.getTitle();
        System.out.println("title: "+title + " length: "+title.length());
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(url,currentUrl);
        String source =driver.getPageSource();
        System.out.println("Page source length: "+ source.length());
    }

    @Test
    public void practice2() throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();


       WebElement we= driver.findElement(By.xpath("//div[@id='contact-link']/a[@title='Contact Us']"));
       Assert.assertNotNull(we);
       we.click();

       Thread.sleep(2000L);
        WebElement email= driver.findElement(By.id("email"));
        Assert.assertNotNull(email);
        System.out.println("back");
       driver.navigate().back();
        Thread.sleep(2000L);
        System.out.println("forward");
        driver.navigate().forward();
        Thread.sleep(2000L);
        System.out.println("back");
        driver.navigate().back();
        Thread.sleep(2000L);

        driver.navigate().refresh();
    }

}

/*Launch new Browser
        Open http://automationpractice.com website
        Click on Contact us link using “driver.findElement(By.xpath(“.//div[@id=’contact-link′]/a”)).click();“
        Come back to Home page (Use ‘Back’ command)
        Again go back to Registration page (This time use ‘Forward’ command)
        Again come back to Home page (This time use ‘To’ command)
        Refresh the Browser (Use ‘Refresh’ command)
        Close the Browser*/