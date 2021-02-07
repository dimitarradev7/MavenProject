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
    public static void main(String[] args) {

        String driverExecutablePath = "C://WebDriver//bin//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        // Create a new instance of the FireFox driver

        // Storing the Application Url in the String variable
        String url = "https://google.com";

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("incognito");
        //options.addArguments("start-maximized");
        //options.addArguments("user-data-dir=" + "C:/Users/dimitarrad/AppData/Local/Google/Chrome/User Data/Default");

        // String url = "C://Users//dimitarrad//IdeaProjects//Html//src//index.html";

        WebDriver driver = new ChromeDriver(options);



        driver.get(url);
        Cookie cookie = new Cookie("CONSENT", "YES+BG.bg+V9+BX");
        driver.manage().addCookie(cookie);
        Cookie cookie2 = new Cookie("UULE", "a+cm9sZTogMQpwcm9kdWNlcjogMTIKdGltZXN0YW1wOiAxNjEyNzIzOTUxODQyMDAwCmxhdGxuZyB7CiAgbGF0aXR1ZGVfZTc6IDQyNjMxNDczMAogIGxvbmdpdHVkZV9lNzogMjMzODM5NzUzCn0KcmFkaXVzOiAxNTQ3NTIwCnByb3ZlbmFuY2U6IDYK");
        driver.manage().addCookie(cookie);
        Cookie cookie3 = new Cookie("NID", "208=X-2t6RBZfDZkGDkH-Ph9UgWElt5X7QjewC2EZytAT4gQiE2LWOzJX9oJwM6N5eDNvkD8XpY6ZIv0eeGWEFmaFAePkAN_XfuniZBJRDkkS46ELGtNeAloKQknbO8kVwSzKennlxv7Vs9gt-y97ufcX8A7gcuS2RcO0oya0NGzq20");
        driver.manage().addCookie(cookie);


        Set<Cookie> d = driver.manage().getCookies();

        driver.navigate().refresh();
        Set<Cookie> d2 = driver.manage().getCookies();
        //Launch the ToolsQA WebSite

/*            try {

                element.sendKeys("dsdsd");
                driver.findElement(By.id("UserName")).sendKeys(Keys.ENTER);

            }catch (NullPointerException r){
                System.out.println(" NoSuchElementException catched ");
            }*/

        WebElement element = driver.findElement(By.cssSelector("input[name='q']"));

        element.sendKeys("https://www.selenium.dev/");
        element.sendKeys(Keys.ENTER);

        WebElement link = driver.findElement(By.xpath("//div[@class='yuRUbf']/a[@href='https://www.selenium.dev/']"));

        link.click();

        String t = driver.getTitle();

        System.out.println(t);
        driver.close();;
    }
}
