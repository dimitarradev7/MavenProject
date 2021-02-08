package WebDriverTests.LectureWebDriverCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by dimitarrad
 * on 2/8/2021
 */
public class LectureWebDriverCommands {
    public static void main(String[] args) {
        String driverExecutablePath = "C://WebDriver//bin//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        String url = "https://abv.bg";
        WebDriver driver = new ChromeDriver();
        driver.get(url);
    }
}
