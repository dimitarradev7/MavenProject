package WebDriverTests.NavigationCommandsPractice_1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by dimitarrad
 * on 2/2/2021
 */
public class PracticeExercises1 {
    public static void main(String[] args) throws InterruptedException {
        String driverExecutablePath = "C://WebDriver//bin//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();

        // Open ToolsQA web site
        String appUrl = "http://automationpractice.com";
        driver.get(appUrl);

        // Click on Registration link
        driver.findElement(By.xpath("//div[@id='contact-link']/a")).click();

        Thread.sleep(2000L);
        // Go back to Home Page
        driver.navigate().back();

        Thread.sleep(2000L);
        // Go forward to Registration page
        driver.navigate().forward();

        // Go back to Home page
        driver.navigate().to(appUrl);



        WebElement element = driver.findElement(By.id("UserName"));
        element.sendKeys(Keys.BACK_SPACE);

        element.clear();

        // Refresh browser
        driver.navigate().refresh();

        // Close browser
        driver.close();
    }
}
