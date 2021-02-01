package SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by dimitarrad
 * on 1/27/2021
 */
public class Tast1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C://WebDriver//bin//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://abv.bg");

    }
}
