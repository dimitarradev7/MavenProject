package WebDriverTests.Cookies;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

/**
 * Created by dimitarrad
 * on 2/7/2021
 */
public class ManageCookies {
    public static void main(String[] args) throws InterruptedException {

        String driverExecutablePath = "C://WebDriver//bin//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        // Create a new instance of the FireFox driver

        // Storing the Application Url in the String variable
        String url = "https://google.com";

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("incognito");
        options.addArguments("start-maximized");
        //options.addArguments("headless");
        options.addArguments("disable-infobars");

        WebDriver driver = new ChromeDriver(options);

        driver.get(url);

        Cookie cookie = new Cookie("CONSENT", "YES+BG.bg+V9+BX");
        driver.manage().addCookie(cookie);
        Cookie cookie2 = new Cookie("UULE", "a+cm9sZTogMQpwcm9kdWNlcjogMTIKdGltZXN0YW1wOiAxNjEyNzIzOTUxODQyMDAwCmxhdGxuZyB7CiAgbGF0aXR1ZGVfZTc6IDQyNjMxNDczMAogIGxvbmdpdHVkZV9lNzogMjMzODM5NzUzCn0KcmFkaXVzOiAxNTQ3NTIwCnByb3ZlbmFuY2U6IDYK");
        driver.manage().addCookie(cookie);
        Cookie cookie3 = new Cookie("NID", "208=X-2t6RBZfDZkGDkH-Ph9UgWElt5X7QjewC2EZytAT4gQiE2LWOzJX9oJwM6N5eDNvkD8XpY6ZIv0eeGWEFmaFAePkAN_XfuniZBJRDkkS46ELGtNeAloKQknbO8kVwSzKennlxv7Vs9gt-y97ufcX8A7gcuS2RcO0oya0NGzq20");
        driver.manage().addCookie(cookie);


        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("cookies size: "+cookies.size());
        //driver.navigate().refresh();

        WebElement element = driver.findElement(By.cssSelector("input[name='q']"));

        element.sendKeys("https://www.selenium.dev/");
        element.sendKeys(Keys.ENTER);

        WebElement link = driver.findElement(By.xpath("//div[@class='yuRUbf']/a[@href='https://www.selenium.dev/']"));

        link.click();

        Thread.sleep(2000);
        String t = driver.getTitle();

        driver.manage().deleteCookieNamed("CONSENT");
        driver.manage().deleteCookieNamed("UULE");
        driver.manage().deleteCookieNamed("NID");

        driver.navigate().to(url);



        Thread.sleep(3000);

        System.out.println(t);
        //driver.close();
    }

}


