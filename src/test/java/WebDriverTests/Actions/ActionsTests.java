package WebDriverTests.Actions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

/**
 * Created by dimitarrad
 * on 2/7/2021
 */
public class ActionsTests {
    public static void main(String[] args) throws InterruptedException {

        String driverExecutablePath = "C://WebDriver//bin//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        String url = "https://demoqa.com/menu/";

        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.manage().window().maximize();

       Thread.sleep(2000L);


/*
        actions.keyDown(element, Keys.SHIFT);

        actions.sendKeys("tessyysdd");

        actions.keyUp(Keys.SHIFT);

        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();

        Actions actionsOtherWay = new Actions(driver);
        Action action = actionsOtherWay.build();
        action.perform();

        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("id"));

        WebElement target = driver.findElement(By.id("id"));
        actions.dragAndDrop(source,target).perform();*/

        Actions actions = new Actions(driver);
        //Retrieve WebElement 'Music' to perform mouse hover
        WebElement menuOption = driver.findElement(By.xpath(".//ul[@id='nav']/li/a[contains(text(),'2')]"));
        //Mouse hover menuOption 'Music'
        actions.moveToElement(menuOption).perform();

        WebElement menuOptionSub = driver.findElement(By.xpath(".//ul[@id='nav']/li/ul/li/a[contains(text(),'SUB SUB')]"));
        actions.moveToElement(menuOptionSub).perform();

    }
}
