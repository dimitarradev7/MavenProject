package WebDriverTests.LectureWebDriverCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by dimitarrad
 * on 2/8/2021
 */
public class LectureWebDriverCommands {
    public static void main(String[] args) {
        String driverExecutablePath = "C://WebDriver//bin//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        String url = "C:\\Users\\dimitarrad\\IdeaProjects\\Html\\src\\index.html";
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        Actions ac = new Actions(driver);
        ac.click();
        ac.doubleClick();

        Action actoin = ac.build();
        actoin.perform();

        Select sel = new Select(driver.findElement(By.id("colors")));

        List<WebElement> list = sel.getOptions();
        sel.selectByIndex(3);

    }
}
