package WebDriverTests.LectureWebDriverCommands;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by dimitarrad
 * on 2/8/2021
 */
public class LectureTests {
    WebDriver driver;
    String url;
    @Before
    public void setUp() {
        System.out.println("@Before method will execute before every JUnit4 test");
        String driverExecutablePath = "C://WebDriver//bin//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        url = "http://automationpractice.com/index.php";
        driver= new ChromeDriver();

    }

    @After
    public void tearDown() {
        System.out.println("@After method will execute after every JUnit4 test");
        driver.close();
    }
    @Ignore
    @Test
    public void  test() throws InterruptedException {
        driver.get(url);
        WebElement search = null;
        try {
             search= driver.findElement(By.id("search_query_top"));
        }catch (WebDriverException ex){
            System.out.println(ex.getMessage());

        }
        Actions actions = new Actions(driver);

        actions.keyDown(search, Keys.SHIFT)
                .sendKeys("new search for shoes")
                .keyUp(Keys.SHIFT)
                .perform();

       int x = search.getLocation().getX();
        int y = search.getLocation().getY();

        System.out.println("X: "+ x + "Y: "+y);
        Action action = actions.build();
        action.perform();


        String text = search.getText();
        Thread.sleep(4000L);
        System.out.println("text"+ text);
        Assert.assertEquals(text,"new search for shoes");


    }

    @Ignore
    @Test
    public void clickBnt() throws InterruptedException {
        url = "https://demoqa.com/buttons";
        driver.get(url);
        driver.manage().window().maximize();
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        WebElement dynamicClickBtn = driver.findElement(By.xpath("//button[text()='Click Me']"));

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();
        Thread.sleep(1000L);
        WebElement doubleliCckTex = driver.findElement(By.id("doubleClickMessage"));
        Assert.assertTrue(doubleliCckTex.isDisplayed());
        System.out.println(doubleliCckTex.getText());

        actions.contextClick(rightClickBtn).perform();
        Thread.sleep(1000L);
        WebElement rightliCckTex = driver.findElement(By.id("rightClickMessage"));
        Assert.assertTrue(rightliCckTex.isDisplayed());
        System.out.println(rightliCckTex.getText());

        actions.click(dynamicClickBtn).perform();
        Thread.sleep(1000L);
        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertTrue(dynamicClickMessage.isDisplayed());
        System.out.println(dynamicClickMessage.getText());

       Assert.assertEquals("You have done a double click",doubleliCckTex.getText());


    }

    @Ignore
    @Test
    public void dragAndDrop() throws InterruptedException {
        url = "https://demoqa.com/droppable/";
        driver.get(url);
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        int x = source.getLocation().getX();
        int y = source.getLocation().getY();
        //actions.dragAndDrop(source,target).perform();
        Thread.sleep(2000L);
        actions.dragAndDropBy(source,0,100).perform();
        Thread.sleep(3000L);
        WebElement label = driver.findElement(By.cssSelector("div#droppable>p"));
        Assert.assertEquals("Dropped!",label.getText());
    }

    @Ignore
    @Test
    public void hoverMenu() throws InterruptedException {
        url = "https://demoqa.com/menu/";
        driver.manage().window().maximize();
        driver.get(url);


        Actions actions = new Actions(driver);
        //Retrieve WebElement 'Music' to perform mouse hover
        WebElement menuOption = driver.findElement(By.xpath("//ul[@id='nav']/li/a[contains(text(),'Item 2')]"));
        //Mouse hover menuOption 'Music'
        actions.moveToElement(menuOption).perform();
        Thread.sleep(2000L);
        WebElement menuOptionSub = driver.findElement(By.xpath("//ul[@id='nav']/li/ul/li/a[contains(text(),'SUB SUB')]"));
        actions.moveToElement(menuOptionSub).perform();
        Thread.sleep(2000L);
        WebElement menuOptionSubsub = driver.findElement(By.linkText("Sub Sub Item 1"));
        actions.moveToElement(menuOptionSubsub).perform();
        Thread.sleep(4000L);

    }

    @Test
    public void makeScreenShot() throws IOException {

        url = "C:\\Users\\dimitarrad\\IdeaProjects\\Html\\src\\index.html";
        driver.manage().window().maximize();
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        WebElement el = driver.findElement(By.id("btn"));

/*

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenshotFile , new File("C:\\WebDriver\\screenshot.png"));*/



    }
}
