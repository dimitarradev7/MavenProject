package WebDriverTests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        String url = "http://automationpractice.com/";
        //String url = "C://Users//dimitarrad//IdeaProjects//Html//src//index.html";

        WebDriver driver = new ChromeDriver();

        //Launch the ToolsQA WebSite
            driver.get(url);
            try {
                WebElement element = driver.findElement(By.id("UserName"));
            }catch (NoSuchElementException r){
                System.out.println(" NoSuchElementException catched ");
            }

        WebElement element = driver.findElement(By.id("UserName"));
        if(element != null) {
            System.out.println("Element found by ID");
        }

        String t = driver.getTitle();
        String currUrl = driver.getCurrentUrl();

        System.out.println(t);
        System.out.println(currUrl);

        driver.close();
    }
}
