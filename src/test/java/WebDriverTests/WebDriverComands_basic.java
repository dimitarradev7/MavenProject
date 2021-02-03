package WebDriverTests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.JsonOutput;

import java.util.List;

/**
 * Created by dimitarrad
 * on 2/2/2021
 */
public class WebDriverComands_basic {

    public static void main(String[] args) {


        String driverExecutablePath = "C://WebDriver//bin//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        // Create a new instance of the FireFox driver

        // Storing the Application Url in the String variable
        //String url = "http://automationpractice.com/";
        String url = "C://Users//dimitarrad//IdeaProjects//Html//src//index.html";

        WebDriver driver = new ChromeDriver();

        //Launch the ToolsQA WebSite
            driver.get(url);
            try {
                WebElement element = driver.findElement(By.id("UserNamedfdf"));
            }catch (NullPointerException r){
                System.out.println(" NoSuchElementException catched ");
            }

        List<WebElement> elements = driver.findElements(By.tagName("input"));

        System.out.println("input elements found: "+elements.size());

        for (WebElement el:elements) {
            System.out.println( el.getAttribute("type"));
        }


        String t = driver.getTitle();
        String currUrl = driver.getCurrentUrl();

        System.out.println(t);
        System.out.println(currUrl);

        driver.close();
    }
}
